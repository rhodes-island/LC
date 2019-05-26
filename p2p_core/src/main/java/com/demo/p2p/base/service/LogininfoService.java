package com.demo.p2p.base.service;

/**
 * 登录相关服务
 *
 * @author 李畅
 * @date 2019/5/26
 */
public interface LogininfoService {
    /**
     * 用户注册
     * @param username  用户名
     * @param password  密码
     */
    void reqister(String username,String password);
}
