package com.lionrockws.temp.platform.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/system" )
public class SystemController {
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		String message=String.format("Service is running at %s", (new Date().toLocaleString()));
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
}
