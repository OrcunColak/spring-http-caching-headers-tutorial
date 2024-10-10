package com.colak.springtutorial.controller.ifnonematch;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class IfNoneMatchController {

    // http://localhost:8080/if-none-match
    @GetMapping(value = "/if-none-match", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getIfNoneMatch(ServerHttpResponse response,
                                       @RequestHeader(value = HttpHeaders.IF_NONE_MATCH, required = false) String ifNoneMatch) {
        String etag = "123456"; // Assume this is dynamically generated

        if (etag.equals(ifNoneMatch)) {
            // Return 304 Not Modified if ETags match
            return Mono.empty(); // Represents a 304 response
        }

        return Mono.just("{\"message\":\"Hello, If-None-Match!\"}")
                .doOnNext(data -> response.getHeaders().setETag(etag));
    }
}
