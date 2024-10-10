package com.colak.springtutorial.controller.contentdispositon;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ContentDispositionController {

    // http://localhost:8080/download
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Mono<String> downloadFile(ServerHttpResponse response) {
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file.txt\"");
        return Mono.just("This is a downloadable file content.");
    }
}
