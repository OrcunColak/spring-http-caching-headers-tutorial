package com.colak.springtutorial.controller.ifmodifiedsince;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
public class IfModifiedSinceController {

    // http://localhost:8080/if-modified-since
    @GetMapping(value = "/if-modified-since", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getIfModifiedSince(ServerHttpResponse response,
                                           @RequestHeader(value = HttpHeaders.IF_MODIFIED_SINCE, required = false) Long ifModifiedSince) {
        Instant lastModified = Instant.now();

        if (ifModifiedSince != null && lastModified.toEpochMilli() <= ifModifiedSince) {
            // Return 304 Not Modified if resource is unchanged
            return Mono.empty(); // Represents a 304 response
        }

        return Mono.just("{\"message\":\"Hello, If-Modified-Since!\"}")
                .doOnNext(data -> response.getHeaders().setLastModified(lastModified.toEpochMilli()));
    }
}
