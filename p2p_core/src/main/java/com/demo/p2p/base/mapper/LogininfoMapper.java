package com.demo.p2p.base.mapper;

import com.demo.p2p.base.pojo.Logininfo;
import com.demo.p2p.base.pojo.LogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogininfoMapper {
	long countByExample(LogininfoExample example);

	int deleteByExample(LogininfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Logininfo record);

	int insertSelective(Logininfo record);

	List<Logininfo> selectByExample(LogininfoExample example);

	Logininfo selectByPrimaryKey(Long id);

	// 两个参数必须要加注解
	int updateByExampleSelective(@Param("record") Logininfo record, @Param("example") LogininfoExample example);

	int updateByExample(@Param("record") Logininfo record, @Param("example") LogininfoExample example);

	int updateByPrimaryKeySelective(Logininfo record);

	int updateByPrimaryKey(Logininfo record);
}