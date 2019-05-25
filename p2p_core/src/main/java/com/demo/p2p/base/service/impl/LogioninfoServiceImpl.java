package com.demo.p2p.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.p2p.base.mapper.LogininfoMapper;
import com.demo.p2p.base.pojo.Logininfo;
import com.demo.p2p.base.pojo.LogininfoExample;
import com.demo.p2p.base.pojo.LogininfoExample.Criteria;
import com.demo.p2p.base.service.LogininfoService;
import com.demo.p2p.base.util.MD5;

@Service
public class LogioninfoServiceImpl implements LogininfoService {
    @Autowired
    private LogininfoMapper logininfoMapper;


    @Override
    public Logininfo selectByPrimaryKey(Long id) {

        return logininfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 注册方法
     * 通过uesrname检测是否有该用户名
     *
     * @param username
     * @return
     */
    @Override
    public boolean checkUsername(String username) {
        LogininfoExample logininfoExample = new LogininfoExample();
        logininfoExample.createCriteria().andUsernameEqualTo(username);
        List<Logininfo> logininfos = logininfoMapper.selectByExample(logininfoExample);
        return  logininfos.size() > 0;
    }

    @Override
    public void selectByUnamePwd(String username, String password) {
        //判断用户名是否存在
        LogininfoExample example = new LogininfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Logininfo> count = this.logininfoMapper.selectByExample(example);

        //如果不存在，设置并保存这个对象
        if (count.size() <= 0) {
            Logininfo li = new Logininfo();
            li.setUsername(username);
            li.setPassword(MD5.encode(password));
            li.setState(Logininfo.STATE_NORMAL);
            this.logininfoMapper.insert(li);
        } else {
            //如果存在，抛出错误
            throw new RuntimeException("用户名已经存在！");
        }
    }


}
