package br.com.sample.restapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sample.restapi.models.CheckPoint;
import br.com.sample.restapi.services.CheckPointService;

@RunWith(SpringRunner.class)
@WebMvcTest(CheckPointController.class)
public class CheckPointControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CheckPointService service;
	
	
	@Test
	public void givenACheckPointListWhenGetItThenShowTheFirstOne() {
		List<CheckPoint> list = Arrays.asList(
				 new CheckPoint(1, 1, 10000000000000L, true)
				,new CheckPoint(2, 1, 10000000000001L, false)
				,new CheckPoint(3, 2, 10000000000000L, true)
				,new CheckPoint(4, 2, 10000000000001L, false)
			);
		
		when(service.getAll()).thenReturn(list);
		
		try {
			CheckPoint checkPoint = list.get(0);
			mvc.perform(get("/app/checkpoints")
					.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(Matchers.equalTo(list.size()))))
			.andExpect(jsonPath("$[0].date", is(checkPoint.getDate())));
			;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenAUserIdGetAListOfUsersCheckpoints() {
		List<CheckPoint> list = Arrays.asList(
				 new CheckPoint(1, 1, 10000000000000L, true)
				,new CheckPoint(2, 1, 10000000000001L, false)
				,new CheckPoint(3, 2, 10000000000000L, true)
				,new CheckPoint(4, 2, 10000000000001L, false)
			);
		
		int userId = 1;
		List<CheckPoint> filtered = list.stream()
				.filter( it -> it.getUserId() == userId)
				.collect(Collectors.toList());
		when(service.getByUserId(userId)).thenReturn(filtered);
		
		try {
			CheckPoint checkPoint = filtered.get(0);
			mvc.perform(get("/app/checkpoints")
					.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(Matchers.equalTo(filtered.size()))))
			.andExpect(jsonPath("$[0].userId", is(checkPoint.getUserId())));
			;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
