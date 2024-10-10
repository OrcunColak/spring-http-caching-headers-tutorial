package com.colak.springtutorial.controller.cacherevalidation;

import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@RestController
public class CacheRevalidationController {

    // http://localhost:8080/cache-revalidate
    @GetMapping(value = "/cache-revalidate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getCacheRevalidate(ServerHttpResponse response) {
        String data = "{\"message\":\"Hello, Cache Revalidation!\"}";

        // Set Cache-Control to must-revalidate
        CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.HOURS)
                .mustRevalidate();
        response.getHeaders().setCacheControl(cacheControl.getHeaderValue());

        return Mono.just(data);
    }
}
