package com.demo.p2p.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("s")
@Controller
public class MainController {
	//首页
	@RequestMapping("/index.do")
	public String index() {
		System.out.println("跳转main.ftl");
		return "main";
	}
	//我要投资
	@RequestMapping("/invest.do")
	public String invest() {
		System.out.println("跳转invest.ftl");
		return "invest";
	}
	//我要借款
	@RequestMapping("/borrow.do")
	public String borrow() {
		System.out.println("跳转borrow.ftl");
		return "borrow";
	}
	// 借贷项目
	// 投资列表
	@RequestMapping("bid_list.do")
	public String bid_list() {
		System.out.println("跳转invest.ftl");
		return "invest";
	}

	// 借款项目
	@RequestMapping("borrow_list.do")
	public String borrow_list() {
		System.out.println("跳转borrow.ftl");
		return "borrow";
	}

	// 还款明细
	@RequestMapping("borrowBidReturn_list.do")
	public String borrowBidReturn_list() {
		System.out.println("跳转borrowBidReturn_list.ftl");
		return "borrowBidReturn";
	}

	// 我的账户
	// 跳转个人中心
	@RequestMapping("/personal.do")
	public String personal() {
		System.out.println("跳转personal.ftl");
		return "personal";
	}

	// 实名认证
	@RequestMapping("/realAuth.do")
	public String realAuth() {
		System.out.println("跳转realAuth.ftl");
		return "realAuth";
	}

	// 跳转个人中心
	@RequestMapping("/userFile.do")
	public String userFiles() {
		System.out.println("跳转userFiles.ftl");
		return "userFiles";
	}

	// 银行卡管理
	@RequestMapping("bankInfo.do")
	public String userFile() {
		System.out.println("跳转bankInfo.ftl");
		return "bankInfo";
	}

	// 登录记录
	@RequestMapping("/ipLog.do")
	public String ipLog() {
		System.out.println("跳转iplog_list.ftl");
		return "iplog_list";
	}

	// 登录记录
	@RequestMapping("main")
	public String basicInfo() {
		System.out.println("main.ftl");
		return "main";
	}

	// 账户流水

	// 充值明细
	@RequestMapping("/recharge_list.do")
	public String recharge_list() {
		System.out.println("recharge.ftl");
		return "recharge_list";
	}

	// 提现申请
	@RequestMapping("/moneyWithdraw.do")
	public String moneyWithdraw() {
		System.out.println("moneyWithdraw_apply.ftl");
		return "moneyWithdraw_apply";
	}
}
