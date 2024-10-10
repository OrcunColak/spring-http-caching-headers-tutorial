package com.colak.springtutorial.controller.vary;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VaryController {

    @GetMapping(value = "/vary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getVary(ServerHttpResponse response) {
        String data = "{\"message\":\"Hello, Vary!\"}";

        response.getHeaders().set(HttpHeaders.VARY, "User-Agent");
        return Mono.just(data);
    }
}