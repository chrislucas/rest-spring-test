package br.com.sample.restapi.repositories;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sample.restapi.models.User;
import br.com.sample.restapi.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private UserRepository repository;
	
	
	@Test
	public void givenAUserDataWhenUpdateNameThenNameChange() {
		User user = new User("chrislucas", "123.123.123-14", "chrislucas@gmail.com", 10000000000000L);
		testEntityManager.persist(user);
		testEntityManager.flush();
		
		User newUser = new User("chrisluccas"
				, user.getDocument()
				, user.getEmailAddress()
				, user.getRegisterDate());
		
		repository.updateById(1, newUser.getName(), user.getDocument(), user.getEmailAddress());
		User userUpdated = repository.findById(1L).get();
		assertTrue(userUpdated.getName().equals(newUser.getName()));

	}
	
}
