package cn.x;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by 136187300@qq.com on 2018年5月20日.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@Configuration
@ComponentScan(basePackages = {"cn.x.config","cn.x.services","cn.x.controller","cn.x"})
public class Test1 {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void clearMsg() throws Exception {
		logger.info("Test1 clearMsg...");
		//this.mockMvc.perform(get("/clearMessage")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("Hello, World!"));
		//this.mockMvc.perform(get("/clearMessage"));
		
	}

}
