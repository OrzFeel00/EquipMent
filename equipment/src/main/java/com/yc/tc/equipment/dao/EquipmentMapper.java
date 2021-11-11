package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;




public interface EquipmentMapper {
	
		//添加设备
		//新增后返回主键keyPropertyjava对象属性名 ，  keyColumn数据库主键
		@Insert("insert into equipment values (null"
				+ ",#{equipmentCode},#{equipmentName},#{equipmentUser}"
				+ ",#{equipmentPwd},#{equipmentType},#{associatedId},#{storageId}"
				+ ",#{baseEquipmentId})")
		@Options(useGeneratedKeys = true, keyProperty = "equipmentId", keyColumn = "equipment_id")
		public int insertEquipment(Equipment e);
		
       
    	
	   //根据equipmentName 验证是否重名
	    @Select("select count(*) from equipment where equipment_name=#{ename}")
	   public int  countByeName(String ename );
	    
	    //根据equipmentName 验证是否重名
	    @Select("select count(*) from equipment where equipment_code=#{equipmentCode}")
	   public int  countByecode(String equipmentCode );

	  ///根据设备id放入BaseEquipmentid
	    @Update("update equipment set base_equipment_id=#{beid} where equipment_id=#{equetid}")
		public void insertBeidByEid(Integer equetid, Integer beid);
	    
	  ///根据设备id放入storageId
	    @Update("update equipment set storage_id=#{stid} where equipment_id=#{equetid}")
		public void insertStidByEid(Integer equetid, Integer stid);
	    
	  ///根据设备id放入associatedId
	    @Update("update equipment set associated_id=#{asid} where equipment_id=#{equetid}")
		public void insertAsidByEid(Integer equetid, Integer asid);

	  //根据equipmentName 返回id
	    @Select("select equipment_id from equipment  where  equipment_name=#{equipmentName}")
		public int selecteqidByname(String equipmentName);
	    
	    // 查找所有的设备名称信息
	    @Select("select equipment_name from equipment  order by equipment_id asc")
		public List<String> selectAllEquNames();
	    
	
	
}
