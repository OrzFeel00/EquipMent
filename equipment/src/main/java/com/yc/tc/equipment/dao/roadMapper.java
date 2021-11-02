package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.BaseEquipment;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.road;




public interface roadMapper {
	
	
		
       //添加道路信息
        @Insert("insert into road values (null"
				+ ",#{administrativeRegion},#{departmentRegion},#{streetName}"
				+ ",#{roadName},#{roadGrade},#{roadCode}"
				+ ",#{roadSpeed})")
        @Options(useGeneratedKeys = true, keyProperty = "roadId", keyColumn = "road_id")
	   public  void insertroad(road roa);
        
      //根据roadCode 验证是否重名
	    @Select("select count(*) from road where road_code=#{roadCode}")
	   public int  countByeCode(String roadCode);

		
	    

		
		
	 
		
	
}
