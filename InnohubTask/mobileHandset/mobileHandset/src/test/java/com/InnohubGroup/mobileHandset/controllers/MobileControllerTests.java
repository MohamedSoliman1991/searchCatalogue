package com.InnohubGroup.mobileHandset.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.InnohubGroup.mobileHandset.controllers.MobileController;
import com.InnohubGroup.mobileHandset.models.MobileHandset;
import com.InnohubGroup.mobileHandset.services.MobileCatalougeService;

@WebMvcTest(MobileController.class)
public class MobileControllerTests {
	
	 @Autowired
	    protected WebApplicationContext wac;

	    @Autowired
	    MobileController mobileController;

	    @MockBean
	    MobileCatalougeService mobileCatalougeService;

		@Autowired
		private MockMvc mockMvc;
		
	
		@Test
		public void search() throws Exception {
			mockMvc.perform(get("http://localhost:8081/mobile/search")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"));
			

}
		@Test
		public void search(String sim) throws Exception {
			sim="esim";
			mockMvc.perform(get("http://localhost:8081/mobile/search?sim="+sim)).andExpect(status().isOk())
			.andExpect(jsonPath("$.sim").value(sim));
			

}
		}
	

