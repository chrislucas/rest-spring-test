package br.com.sample.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sample.restapi.models.CheckPoint;

@Repository
public interface CheckPointRepository extends JpaRepository<CheckPoint, Long> {
	

	public List<CheckPoint> findByUserId(long id);
	
}
