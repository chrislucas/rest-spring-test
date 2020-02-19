package br.com.sample.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@GetMapping(path="/log")
	public String log() {
		return getClass().getSimpleName();
	}
	
}
