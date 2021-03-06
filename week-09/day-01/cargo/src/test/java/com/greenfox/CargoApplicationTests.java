package com.greenfox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CargoApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class CargoApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
					MediaType.APPLICATION_JSON.getSubtype(),
					Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getShipStatus() throws Exception {
		mockMvc.perform(get("/rocket"))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.ready").value(false))
						.andExpect(jsonPath("$.shipstatus").value("empty"));
	}

	@Test
	public void filledShipStatus() throws Exception {
		mockMvc.perform(get("/rocket/fill?caliber=.25&amount=5000"))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.received").value(".25"))
						.andExpect(jsonPath("$.amount").value("5000"))
						.andExpect(jsonPath("$.ready").value(false));
	}


	@Test
	public void testShipStatus() throws Exception {
		mockMvc.perform(get("/rocket/fill?caliber=.25&amount=12500"))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.ready").value(true))
						.andExpect(jsonPath("$.shipstatus").value("full"));
	}
	@Test
	public void testShipStatusIsNotOK() throws Exception {
		mockMvc.perform(get("/rocket/fill?caliber=.25"))
						.andExpect(status().is4xxClientError());
	}
}
