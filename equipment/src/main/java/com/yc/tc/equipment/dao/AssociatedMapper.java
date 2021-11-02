package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Associated;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;




public interface AssociatedMapper {
	
	
		
       //添加关联存储信息
        @Insert("insert into associated values (null"
				+ ",#{fillProperties},#{functionType},#{orientation}"
				+ ",#{positionType},#{pickup},#{securityMode}"
				+ ",#{regMethod},#{confiAttribute})")
        @Options(useGeneratedKeys = true, keyProperty = "associatedId", keyColumn = "associated_id")
	   public  int insertAssociated(Associated a);
    	
	 
		
	
}
