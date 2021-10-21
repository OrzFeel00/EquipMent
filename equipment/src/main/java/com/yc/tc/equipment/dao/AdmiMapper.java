package com.yc.tc.equipment.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.tc.equipment.bean.Admin;

public interface AdmiMapper {

	//查找管理员
	@Select("select * from admin where adm=#{adm} and pwd=#{pwd}")
	public Admin selectAdminLogined(Admin adm);
}
