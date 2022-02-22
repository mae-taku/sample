package com.example.demo.hello.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
class TopControllerTest {
	
	@Autowired 
	MockMvc mockMvc;
	
	@WithMockUser(value = "user") // インメモリ認証の「user」をモック化
	@Test
	void Top画面出力() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/top"))
			// status200(ok)が出るか？　
			.andExpect(status().isOk());
		
	}

}
