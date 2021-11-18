package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Law;
import com.yc.tc.equipment.bean.PointPosition;




public interface LawMapper {
	
	//根据点位名称 name 查询 全表  ；返回PointPosition列表
		@Select("select * from point_position where point_name=#{pointName} ")
		public List<PointPosition> selectPointByName(PointPosition pop);
		
    //添加点位
		@Insert("insert into law values (null"
				+ ",#{equipmentName},#{coding},#{platformCode},#{filingCode},#{publictyDate},#{downTime}"
				+ ",#{shutdownReason},#{speedLimit},#{enableDate},#{addressCode},#{monitoringOrientation},#{intervalCoding}"
				+ ",#{measurementPoint},#{functionEnabled},#{lawAddress},#{bayonetPurpose}"
				+ ",#{llegalCode},#{directionCoding})")
		@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	   public  int insertLaw(Law law);
		
		 //根据PointCode 验证是否重名
	    @Select("select count(*) from point_position where point_code=#{code}")
	   public int  countByCode(String code );
		 //根据equipmentName 验证是否重名
	    @Select("select count(*) from point_position where point_name=#{code}")
	   public int  countByPname (String pname );
		
	    //根据id删除点位
		@Delete("delete from law where id=#{id}")
		public void delectLawById(int lawid);
		//根据id查询点位
		@Select("select * from point_position where point_id=#{pointId}")
		public PointPosition selectPointById(Integer pointId);
		
		
		//根据不同条件查询设备信息  if版 动态sql     concat('%',#{linkName},'%')   concat('%',#{string},'%')
		        @Select({"<script> "
					    + "select * from law "
		        		+"<where>"
						+ "<if test = 'equipmentName != null and equipmentName !=&apos;&apos;   '> "
						+" and equipment_name like concat('%',#{equipmentName},'%') "
						+"</if>"
						+ "<if test = 'coding != null  and coding !=&apos;&apos;  '> "
						+"  and coding like concat('%',#{coding},'%') "
						+"</if>"	
						+ "<if test = 'bayonetPurpose != null  and bayonetPurpose !=&apos;&apos;  '> "
						+" and  bayonet_purpose like concat('%',#{bayonetPurpose},'%') "
						+"</if>"			
						+ "<if test = 'lawAddress != null  and lawAddress !=&apos;&apos;  '> "
						+"  and law_address like concat('%',#{lawAddress},'%') "
						+"</if>"
						+ "<if test = 'llegalCode != null  and llegalCode !=&apos;&apos;  '> "
						+" and  llegal_code like concat('%',#{llegalCode},'%') "
						+"</if>"
						+"</where>"
						+"  order by id asc;"
						+"</script>"})
				public List<Law> selectLawBymor(Law law);
		
		
	//根据id修改设备信息  if版 动态sql
		@Update({"<script> "
			    + "update law set "
				+" equipment_name=#{equipmentName},"
				+" coding=#{coding},"
				+" platform_code=#{platformCode},"
				+" filing_code=#{filingCode},"
				+" publicty_date=#{publictyDate},"
				+" downtime=#{downTime},"
				+" shutdown_reason=#{shutdownReason},"
				+" speed_limit=#{speedLimit},"
				+" enable_date=#{enableDate},"
				+" address_code=#{addressCode},"
				+" monitoring_orientation=#{monitoringOrientation},"
				+" interval_coding=#{intervalCoding},"
				+" measurement_point=#{measurementPoint},"
				+" function_enabled=#{functionEnabled},"
				+" law_address=#{lawAddress},"
				+" bayonet_purpose=#{bayonetPurpose},"
				+" llegal_code=#{llegalCode},"
				+" direction_coding=#{directionCoding}"
				+"  where id=#{id};"
				+"</script>"})
		public void updateLawById(Law law);

		  //根据点位id放入roadid
	    @Update("update point_position set road_id=#{roadId} where point_id=#{ponintid}")
		public void insertRoidByPid(Integer roadId, Integer ponintid);
	    
	    //根据pointName 返回id
	    @Select("select point_id from point_position  where  point_name=#{pointName}")
		public int selectpoidByPname(String pointName);
	    
	    //根据id 返回pointName
	    @Select("select  point_name from point_position  where  point_id=#{id}")
		public String selectnameByid(int id);
	    
	    // 查找所有的点位名称信息
	    @Select("select point_name from point_position  order by point_id asc")
		public List<String> selectAllPointNames();
	    
	    // 查找所有的点位所有信息
	    @Select("select * from law  order by id asc")
		public List<Law> selectALLLaws();

		


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
