package com.colak.springtutorial.controller.cachecontrol;

import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@RestController
public class CacheControlController {

    // http://localhost:8080/cache-control
    @GetMapping(value = "/cache-control", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getCacheControl(ServerHttpResponse response) {
        return Mono.just("{\"message\":\"Hello, World!\"}")
                .doOnNext(data -> {
                    CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.HOURS)
                            .cachePublic();
                    response.getHeaders().setCacheControl(cacheControl.getHeaderValue());
                });
    }
}
