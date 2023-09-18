package com.fibonacci.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fibonacci.api.service.AppService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Tag(name ="FibonacciController", description = "fibonacci result")
@RestController
@RequiredArgsConstructor
@Slf4j
public class FibonacciController {
	
	private final AppService appService;

	@GetMapping(value = "fibonacci")
	public ResponseEntity<?> getFibonacci(@RequestParam Integer n) {
		System.out.println("Request: " + n);
		log.info("RequestApi :",n);
		Map<String,Object> body = new HashMap<>();
		body.put("result", appService.executeFibonacci(n));
		log.info("ResponseApi :",body);
		return ResponseEntity.ok(body);
	}
}
