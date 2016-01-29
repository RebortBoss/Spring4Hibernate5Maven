package com.anxpp.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anxpp.demo.core.entity.User;
import com.anxpp.demo.core.service.DemoService;

@Controller
@RequestMapping("/")
public class DemoConreoller {
	
	@Autowired
	DemoService demoService;

	private static final Logger logger = LogManager.getLogger(DemoConreoller.class);

	@RequestMapping("/")
	public String index(){
		logger.trace("index");
		return "index";
	}

	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> testRerutnString(){
		logger.trace("testRerutnString");
//		int i = 30000;
//		while(i-->0){
//			logger.trace("trace" + i);
//			logger.debug("debug" + i);
//			logger.info("info" + i);
//			logger.warn("warn" + i);
//			logger.error("error" + i);
//			logger.fatal("fatal" + i);
//		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("¹þà¶", "Word");
		map.put("entity", new User("anxpp.com"));
		return map;
	}

	@RequestMapping(value="/save",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(String name){
		return "save" + demoService.save(name).toString();
	}

	@RequestMapping(value="/del",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(int id){
		return "del:" + demoService.delete(id);
	}

	@RequestMapping(value="/find",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findAll(){
		return "find:" + demoService.findAll();
	}
}
