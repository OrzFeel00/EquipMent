package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.BaseEquipment;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;




public interface BaseEquipmentMapper {
	
	
		
       //添加设备存储信息
        @Insert("insert into base_equipment values (null"
				+ ",#{sn},#{modelNumber},#{diskNumber}"
				+ ",#{frameRate},#{brand},#{resolvingPower}"
				+ ",#{functionType},#{versionNumber},#{hostchannelsNumber},#{height},#{length})")
	   public  int insertBaseEquipment(BaseEquipment b);
        
      //根据sn 验证是否重名
	    @Select("select count(*) from base_equipment where sn=#{sn}")
	   public int  countByeSN(String sn);
		
	 
		
	
}
