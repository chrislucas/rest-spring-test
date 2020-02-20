package br.com.sample.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sample.restapi.models.CheckPoint;
import br.com.sample.restapi.repositories.CheckPointRepository;

@Service
public class CheckPointService implements ISimpleService<CheckPoint> {

	@Autowired
	private CheckPointRepository repository;

	public CheckPointService(CheckPointRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<CheckPoint> getAll() {
		return this.repository.findAll();
	}
	
	@Override
	public void save(CheckPoint model) {
		this.repository.save(model);
	}
}
