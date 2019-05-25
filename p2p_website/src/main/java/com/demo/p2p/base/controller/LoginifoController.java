package com.demo.p2p.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.p2p.base.pojo.Logininfo;
import com.demo.p2p.base.service.LogininfoService;
import com.demo.p2p.base.util.JSONResult;

@Controller
public class LoginifoController {
	
	@Autowired
	private LogininfoService logininfoService;
	
	//
	@RequestMapping("showLogininfo")
	public String selectByPrimaryKey(Model model) {
		Logininfo selectByPrimaryKey = logininfoService.selectByPrimaryKey(10L);
		System.out.println(selectByPrimaryKey.toString());
		model.addAttribute("showLogininfo", logininfoService.selectByPrimaryKey(10L));
		return "showLogininfo";
	}

	@RequestMapping("register")
	@ResponseBody
	public JSONResult register(String username,String password) {
		System.out.println("register");
		JSONResult json = new JSONResult();
		//有可能service抛出已经有这个用户的异常
		try {
			logininfoService.selectByUnamePwd(username, password);
		} catch (RuntimeException re) {
			
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}

	@RequestMapping("checkUsername")
	@ResponseBody
	public Boolean checkUsername(String username) {
		System.out.println("验证用户名");
		return !this.logininfoService.checkUsername(username);
	}
	
}
 