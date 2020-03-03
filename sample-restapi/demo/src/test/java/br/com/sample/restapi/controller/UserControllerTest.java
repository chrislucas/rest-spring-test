package br.com.sample.restapi.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sample.restapi.models.User;
import br.com.sample.restapi.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	
	@Test
	public void givenUserWhenGetUsersThenReturnJsonArrayUsers() {
		
		User userTest = new User(1
				, "test"
				, "333.333.333-11"
				, "test@gmail.com"
				, 1583234274);
		
		List<User> users = Arrays.asList(userTest);
		when(userService.getAll()).thenReturn(users);
		
		try {
			mvc.perform(get("/app/users")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			//andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(userTest.getName())));
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	
		
	}
	
}
