package br.com.sample.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sample.restapi.models.User;
import br.com.sample.restapi.models.UserRepository;


@Service
public class UserService implements IService<User> {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User get(long id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public void save(User model) {
		this.userRepository.save(model);
	}

	@Override
	public void delete(long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public void update(User model) {
		this.userRepository.save(model);
	}
	
	

}
