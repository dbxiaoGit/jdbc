package cn.x.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.x.services.MsgService;

/**
* Created by 136187300@qq.com on 2018Äê5ÔÂ20ÈÕ.
*/

@RestController
public class MsgController {

	@Autowired
	private MsgService msgService;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/clearMessage")
	public void clearMessage() {
		logger.info("recoverMessage");
		msgService.clearMessage();
	}
	
	@RequestMapping("/recoverMessage")
	public void recoverMessage() {
		logger.info("recoverMessage");
		msgService.recoverMessage();

	}
}
