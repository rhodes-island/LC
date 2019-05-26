package com.demo.p2p.base.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 李畅
 * @date 2019/5/26
 */
@Setter
@Getter
public class Logininfo extends BasePojo{
    /**
     * 0是正常 1是锁定
     */
    public static final int STATE_NORMAL = 0;
    public static final int STATE_LOCK = 1;

    /**
     * username
     * password
     * state
     */
    private String userName;
    private String password;
    private int state;

}
