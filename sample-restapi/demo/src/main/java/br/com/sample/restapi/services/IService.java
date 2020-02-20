package br.com.sample.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<T> {

	public List<T> getAll();
	
	public T get(long id);
	
	public void save(T model);
	
	public void delete(long id);
	
	public void update(T model);
	
	public T updateById(long id, T model);
}
