package com.colak.springtutorial.controller.expires;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
public class ExpiresController {

    // http://localhost:8080/expires
    @GetMapping(value = "/expires", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getExpires(ServerHttpResponse response) {
        String data = "{\"message\":\"Hello, Expires!\"}";

        // Set Expires to 1 hour from now
        Date expires = new Date(System.currentTimeMillis() + 3600 * 1000);
        response.getHeaders().set(HttpHeaders.EXPIRES, expires.toString());

        return Mono.just(data);
    }
}
