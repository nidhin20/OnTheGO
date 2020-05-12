package com.project.onthego;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.onthego.DTO.UserSignInDto;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnthegoApplication.class)
@EnableWebMvc
@AutoConfigureMockMvc
public class Buscontrollertest {
	@Autowired
	private MockMvc mvc;

	private UserSignInDto userinfo;

	private String Autherizationheader;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void Bustaptincontroltest() throws Exception {
		userinfo = new UserSignInDto();
		userinfo.setEmail("nidhin@gmail.com");
		userinfo.setPassword("test");

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(userinfo);

		MvcResult result=mvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk()).andReturn(); 
		Autherizationheader="Bearer " +result.getResponse().getContentAsString();
		
		mvc.perform(post("/api/bus/Tapin/1/1/STU89567402").contentType(MediaType.APPLICATION_JSON).content(jsonString).header("Authorization",Autherizationheader))
				.andExpect(status().isOk());
	}

	
}
