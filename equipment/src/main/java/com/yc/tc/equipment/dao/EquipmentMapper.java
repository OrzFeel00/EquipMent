package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;




public interface EquipmentMapper {
	
	
		
       //添加设备
        @Insert("insert into equipment values (null"
				+ ",#{equipmentCode},#{equipmentName},#{equipmentUser}"
				+ ",#{equipmentPwd},#{equipmentType},#{associatedId},#{storageId}"
				+ ",#{baseEquipmentId})")
	   public  int insertEquipment(Equipment e);
    	
	   //根据equipmentName 验证是否重名
	    @Select("select count(*) from equipment where equipment_name=#{ename}")
	   public int  countByeName(String ename );
		
	
}
