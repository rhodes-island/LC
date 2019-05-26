package com.demo.p2p.base.controller;

import com.demo.p2p.base.service.LogininfoService;
import com.demo.p2p.base.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册相关
 *
 * @author 李畅
 * @date 2019/5/26
 */
@Controller
public class RegisterController {
    @Autowired
    private LogininfoService logininfoService;

    @RequestMapping("/register")
    @ResponseBody
    public JSONResult register(String username, String password) {
        JSONResult json = new JSONResult();
        try{
            logininfoService.reqister(username,password);
        }catch (RuntimeException re){
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }

}
