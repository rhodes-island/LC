package com.demo.p2p.base.mapper;


import com.demo.p2p.base.pojo.Logininfo;


import java.util.List;

public interface LogininfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);

    List<Logininfo> selectAll();

    int updateByPrimaryKey(Logininfo record);

    /**
     * 判断是否有该用户名
     * @param username
     * @return
     */
    int getCountByUsername(String username);

}