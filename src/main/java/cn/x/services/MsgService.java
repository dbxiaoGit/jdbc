package cn.x.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
* Created by 136187300@qq.com on 2018年5月20日.
*/

@Service
public class MsgService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public String clearMessage() {
		logger.info("MsgService clearMessage");
		int changedLines = jdbcTemplate.update("update t_user set age = age + 10 where age > ?", 33);
		logger.info("changedLines:{}",changedLines);
		return String.format("%d行已更新！", changedLines);
	}
	
	public String recoverMessage() {
		logger.info("MsgService recoverMessage");
		int changedLines = jdbcTemplate.update("update t_user set age = age - 10 where age > ?", 33);
		logger.info("changedLines:{}",changedLines);
		return String.format("%d行已更新", changedLines);
	}
}
