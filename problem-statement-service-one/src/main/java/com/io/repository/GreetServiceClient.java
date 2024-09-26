package com.io.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "greetService", url = "http://13.60.179.0:8080")
public interface GreetServiceClient {

    @GetMapping("/api/greet")
    ResponseEntity<String> getGreetings(@RequestHeader("traceID") String traceID);
}