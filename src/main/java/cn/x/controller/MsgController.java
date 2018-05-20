package cn.x.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import cn.x.services.MsgService;

/**
* Created by 136187300@qq.com on 2018年5月20日。
*/

@Controller
public class MsgController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MsgService msgService;
	
	@GetMapping("/clearMessage")
	public String clearMessage(ModelMap map) {
		logger.info("MsgController clearMessage");
		String resultMessage = msgService.clearMessage();
		map.addAttribute("message", resultMessage);
		return "result";
	}
	
	@GetMapping("/recoverMessage")
	public String recoverMessage(ModelMap map) {
		logger.info("MsgController recoverMessage");
		String resultMessage = msgService.recoverMessage();
		map.addAttribute("message", resultMessage);
		return "result";
	}
}
