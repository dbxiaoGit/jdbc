package cn.x.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
* Created by 136187300@qq.com on 2018Äê5ÔÂ20ÈÕ.
*/

@Service
public class MsgService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public void clearMessage() {
		
	}
	
	public void recoverMessage() {
		
	}
}
