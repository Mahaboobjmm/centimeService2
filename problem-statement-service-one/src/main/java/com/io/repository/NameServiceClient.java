package com.io.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.io.entity.Customer;

@FeignClient(name = "nameService", url = "http://13.60.98.119:8080")
public interface NameServiceClient {

    @PostMapping("/api/name")
    ResponseEntity<String> postName(@RequestBody Customer customer);
}
