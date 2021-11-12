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
        
      //根据roadName 验证是否重名
	    @Select("select count(*) from road where road_name=#{roadName}")
	   public int  countByrName(String roadName);
       // 查找所有的街道名称信息
	    @Select("select road_name from road  order by road_id asc")
		public List<String> selectAllRdNames();
	    //根据roadname 返回id
	    @Select("select road_id from road  where  road_name=#{roadName}")
	  		public int selectRidByname(String roadName);

	    // 查找所有的道路所有信息
	    @Select("select * from road order by road_id asc")
		public List<road> selectAllRoad();
		
		 //根据id删除road
		@Delete("delete from road where road_id=#{roadId}")
		public void delectRoadById(road r );
				
		
		//根据条件模糊查询road 动态sql  if版 动态sql     concat('%',#{linkName},'%')   concat('%',#{string},'%')
        @Select({"<script> "
			    + "select * from road "
        		+"<where>"
				+ "<if test = 'administrativeRegion != null and administrativeRegion !=&apos;&apos;   '> "
				+" and administrative_region like concat('%',#{administrativeRegion},'%') "
				+"</if>"
				+ "<if test = 'departmentRegion != null  and departmentRegion !=&apos;&apos;  '> "
				+"  and department_region like concat('%',#{departmentRegion},'%') "
				+"</if>"	
				+ "<if test = 'streetName != null  and streetName !=&apos;&apos;  '> "
				+" and  street_name like concat('%',#{streetName},'%') "
				+"</if>"			
				+ "<if test = 'roadName != null  and roadName !=&apos;&apos;  '> "
				+"  and road_name like concat('%',#{roadName},'%') "
				+"</if>"
				+ "<if test = 'roadGrade != null  and roadGrade !=&apos;&apos;  '> "
				+" and  road_grade like concat('%',#{roadGrade},'%') "
				+"</if>"
				+ "<if test = 'roadSpeed != null  and roadSpeed !=&apos;&apos;  '> "
				+" and  road_speed like concat('%',#{roadSpeed},'%') "
				+"</if>"
				+"</where>"
				+"  order by road_id asc;"
				+"</script>"})
		public List<road> selectroadBymore(road road);
	 
		
		//根据id修改街道
				@Update({"<script> "
					    + "update road set "
						+" administrative_region=#{administrativeRegion},"
						+" department_region=#{departmentRegion},"
						+" street_name=#{streetName},"
						+" road_name=#{roadName},"
						+" road_grade=#{roadGrade},"
						+" road_code=#{roadCode},"
						+" road_speed=#{roadSpeed}"
						+"  where road_id=#{roadId};"
						+"</script>"})
				public void updateRoadById(road ro);
		
	
}
