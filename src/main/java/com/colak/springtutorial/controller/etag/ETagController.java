package com.colak.springtutorial.controller.etag;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ETagController {

    // http://localhost:8080/etag
    @GetMapping(value = "/etag", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getETag(ServerHttpResponse response) {
        String data = "{\"message\":\"Hello, ETag!\"}";
        String etag = "123456"; // Generate based on resource version

        response.getHeaders().setETag(etag);
        return Mono.just(data);
    }
}
