package br.com.sample.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.restapi.models.CheckPoint;
import br.com.sample.restapi.services.CheckPointService;

@RestController
public class CheckPointController {

	@Autowired
	private CheckPointService checkPointService;
	
	public CheckPointController(CheckPointService checkPointService) {
		this.checkPointService = checkPointService;
	}

	@GetMapping("/app/checkpoints")
	public List<CheckPoint> getCheckPoints() {
		return this.checkPointService.getAll();
	}
	
	@GetMapping("/app/checkpoints/{id}")
	public List<CheckPoint> getCheckpointByUserId(@PathVariable(name="id") long userId) {
		return this.checkPointService.getByUserId(userId);
	}
	
	@PostMapping("/app/checkpoint/save")
	public void saveUser(@RequestBody CheckPoint checkPoint) {
		this.checkPointService.save(checkPoint);
	}	
}
