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

	//testDemo
	@RequestMapping("showLogininfo")
	public String selectByPrimaryKey(Model model) {
		Logininfo selectByPrimaryKey = logininfoService.selectByPrimaryKey(10L);
		System.out.println(selectByPrimaryKey.toString());
		model.addAttribute("showLogininfo", logininfoService.selectByPrimaryKey(10L));
		return "showLogininfo";
	}

	// 用于检查username的ajax
	@RequestMapping("checkUserName.do")
	@ResponseBody
	public Boolean checkUserName(String username) {

		return !this.logininfoService.checkUserName(username);
	}
	
	//用户名的检查和注册
	@RequestMapping("register.do")
	@ResponseBody
	public JSONResult register(String username, String password) {
		JSONResult json = new JSONResult();
		// 有可能service抛出已经有这个用户的异常
		try {
			logininfoService.selectByUnamePwd(username, password);
		} catch (RuntimeException re) {

			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}
	
	//用户登录验证
	//如果是Json格式返回一定要加注解否则404s
	@RequestMapping("/login.do")
	@ResponseBody
	public JSONResult login(String username,String password) {
		JSONResult json = new JSONResult();
		// 有可能service抛出已经有这个用户的异常
		try {
			logininfoService.login(username,password);
		} catch (RuntimeException re) {
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
		
	}
	// 借贷项目

	// 跳转个人中心
	@RequestMapping("personal.do")
	public String personal() {
		System.out.println("跳转personal.ftl");
		return "personal";
	}

	// realAuth
	@RequestMapping("/realAuth.do")
	public String realAuth() {
		System.out.println("跳转realAuth.ftl");
		return "realAuth";
	}

	// userFile
	@RequestMapping("/userFile.do")
	public String userFile() {
		System.out.println("跳转userFile.ftl");
		return "userFile";
	}

	@RequestMapping("bankInfo")
	public String bankInfo() {
		System.out.println("跳转bankInfo.ftl");
		return "bankInfo";
	}
}
