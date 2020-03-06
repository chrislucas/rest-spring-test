package br.com.sample.restapi.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sample.restapi.models.CheckPoint;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckPointRepositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CheckPointRepository repository;
	
	
	@Test
	public void givenCheckPointsFindByUserId() {
		List<CheckPoint> list = Arrays.asList(
				 new CheckPoint(1, 10000000000000L, true)
				,new CheckPoint(1, 10000000000001L, false)
				,new CheckPoint(2, 10000000000000L, true)
				,new CheckPoint(2, 10000000000001L, false)
			);
		
		list.forEach(it -> testEntityManager.persist(it));
		
		;
		testEntityManager.flush();
	
		CheckPoint c = repository.findByUserId(1L).get(0);
		
		assertTrue(c.isEntrance());
		
	}
}
