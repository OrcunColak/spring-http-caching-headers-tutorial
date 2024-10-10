package com.colak.springtutorial.controller.lastmodified;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
public class LastModifiedController {

    // http://localhost:8080/last-modified
    @GetMapping(value = "/last-modified", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getLastModified(ServerHttpResponse response) {
        String data = "{\"message\":\"Hello, Last-Modified!\"}";
        Instant lastModified = Instant.now();

        response.getHeaders().setLastModified(lastModified.toEpochMilli());
        return Mono.just(data);
    }
}
