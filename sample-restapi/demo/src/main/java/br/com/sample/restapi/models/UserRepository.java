package br.com.sample.restapi.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	//public User findByName(String name);
}
