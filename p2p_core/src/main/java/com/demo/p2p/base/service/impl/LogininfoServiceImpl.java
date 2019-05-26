package com.demo.p2p.base.service.impl;

import com.demo.p2p.base.mapper.LogininfoMapper;
import com.demo.p2p.base.pojo.Logininfo;
import com.demo.p2p.base.service.LogininfoService;
import com.demo.p2p.base.util.MD5;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李畅
 * @date 2019/5/26
 */
@Service
public class LogininfoServiceImpl implements LogininfoService {
    @Autowired
    private LogininfoMapper logininfoMapper;
    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void reqister(String username, String password) {
        /**
         * 判断哟用户名是否存在
         * 如果不存在，保存这个对象
         * 如果存在，直接抛出
         */
        int count = this.logininfoMapper.getCountByUsername(username);
        if (count<=0){
            Logininfo logininfo = new Logininfo();
            logininfo.setUserName(username);
            logininfo.setPassword(MD5.encode(password));
            logininfo.setState(Logininfo.STATE_NORMAL);
            this.logininfoMapper.insert(logininfo);
        }else {
            throw new RuntimeException("用户名已经存在");
        }

    }
}
