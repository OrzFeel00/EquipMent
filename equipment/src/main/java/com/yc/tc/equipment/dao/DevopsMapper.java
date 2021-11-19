package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Devops;
import com.yc.tc.equipment.bean.PointPosition;




public interface DevopsMapper {
	
	//根据点位名称 name 查询 全表  ；返回PointPosition列表
		@Select("select * from point_position where point_name=#{pointName} ")
		public List<PointPosition> selectPointByName(PointPosition pop);
		
    //添加点位
		@Insert("insert into devops values (null"
				+ ",#{ownership},#{devopsNature},#{devopsUnit}"
				+ ",#{devopsStatus},#{onlineTimingStatus},#{warrantyPeriod},#{cameraReplacementTime}"
				+ ",#{devopsLiable},#{devopsPhone},#{projectName},#{equipmentName},#{pointName})")
		@Options(useGeneratedKeys = true, keyProperty = "devopsId", keyColumn = "devops_id")
	   public  int insertDevop(Devops dep);
		
		 //根据PointCode 验证是否重名
	    @Select("select count(*) from point_position where point_code=#{code}")
	   public int  countByCode(String code );
		 //根据equipmentName 验证是否重名
	    @Select("select count(*) from point_position where point_name=#{code}")
	   public int  countByPname (String pname );
		
	    //根据id删除点位
		@Delete("delete from devops where devops_id=#{devopsId}")
		public void delectdepById(int devopsId);
		//根据id查询点位
		@Select("select * from point_position where point_id=#{pointId}")
		public PointPosition selectPointById(Integer pointId);
		
		
		//根据不同条件查询设备信息  if版 动态sql     concat('%',#{linkName},'%')   concat('%',#{string},'%')
		        @Select({"<script> "
					    + "select * from devops "
		        		+"<where>"
						+ "<if test = 'ownership != null and ownership !=&apos;&apos;   '> "
						+" and ownership like concat('%',#{ownership},'%') "
						+"</if>"
						+ "<if test = 'devopsUnit != null  and devopsUnit !=&apos;&apos;  '> "
						+"  and devops_unit like concat('%',#{devopsUnit},'%') "
						+"</if>"	
						+ "<if test = 'devopsLiable != null  and devopsLiable !=&apos;&apos;  '> "
						+" and  devops_liable like concat('%',#{devopsLiable},'%') "
						+"</if>"			
						+ "<if test = 'projectName != null  and projectName !=&apos;&apos;  '> "
						+"  and project_name like concat('%',#{projectName},'%') "
						+"</if>"
						+ "<if test = 'equipmentName != null  and equipmentName !=&apos;&apos;  '> "
						+" and  equipment_name like concat('%',#{equipmentName},'%') "
						+"</if>"
						+ "<if test = 'pointName != null  and pointName !=&apos;&apos;  '> "
						+" and  point_name like concat('%',#{pointName},'%') "
						+"</if>"
						+"</where>"
						+"  order by devops_id asc;"
						+"</script>"})
				public List<Devops> selectDevopBymore(Devops dep);
		
		
	//根据id修改设备信息  if版 动态sql
		@Update({"<script> "
			    + "update devops set "
				+" ownership=#{ownership},"
				+" devops_nature=#{devopsNature},"
				+" devops_unit=#{devopsUnit},"
				+" devops_status=#{devopsStatus},"
				+" online_timing_status=#{onlineTimingStatus},"
				+" warranty_period=#{warrantyPeriod},"
				+" camera_replacement_time=#{cameraReplacementTime},"
				+" devops_liable=#{devopsLiable},"
				+" devops_phone=#{devopsPhone},"
				+" project_name=#{projectName},"
				+" equipment_name=#{equipmentName},"
				+" point_name=#{pointName}"
				+"  where devops_id=#{devopsId};"
				+"</script>"})
		public void updateDevopsById(Devops dep);

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
	    @Select("select * from devops  order by devops_id asc")
		public List<Devops> selectAllDevop();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
