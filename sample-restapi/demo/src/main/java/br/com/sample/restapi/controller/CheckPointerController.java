package br.com.sample.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.restapi.models.CheckPoint;
import br.com.sample.restapi.services.CheckPointService;

@RestController
public class CheckPointerController {

	@Autowired
	private CheckPointService checkPointService;
	
	public CheckPointerController(CheckPointService checkPointService) {
		this.checkPointService = checkPointService;
	}

	@GetMapping("/app/checkpoints")
	public List<CheckPoint> getUsers() {
		return this.checkPointService.getAll();
	}
	
	@PostMapping("/app/checkpoint/save")
	public void saveUser(@RequestBody CheckPoint checkPoint) {
		this.checkPointService.save(checkPoint);
	}	
}
