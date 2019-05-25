package com.demo.p2p.base.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class MainController {
		@RequestMapping("/login.do")
		public String login() {
			System.out.println("后台主页面");
			return "main";
		}
}
