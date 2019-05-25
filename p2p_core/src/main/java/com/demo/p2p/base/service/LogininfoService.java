package com.demo.p2p.base.service;

import com.demo.p2p.base.pojo.Logininfo;

/**
 * //先从接口开始写
 * @ClassName:  LogininfoService   
 * @Description:TODO(登录相关服务)   
 * @author: 583165647@qq.com 
 * @date:   2019年5月23日 上午11:28:20   
 *
 */
public interface LogininfoService {
	
	
	Logininfo selectByPrimaryKey(Long id);

	/**
	 * 注册方法
	 * 通过username和password查询 Logininfo用户表
	 * 查看是否已经存在相同用户名
	 * @param username
	 * @param password
	 * @return
	 */
	void selectByUnamePwd(String username,String password);

	/**
	 * 注册方法
	 * 通过uesrname检测是否有该用户名
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);
}
