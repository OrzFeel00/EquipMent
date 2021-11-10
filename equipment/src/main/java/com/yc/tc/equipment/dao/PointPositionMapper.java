package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.PointPosition;




public interface PointPositionMapper {
	
	//根据点位名称 name 查询 全表  ；返回PointPosition列表
		@Select("select * from point_position where point_name=#{pointName} ")
		public List<PointPosition> selectPointByName(PointPosition pop);
		
    //添加点位
		@Insert("insert into point_position values (null"
				+ ",#{pointName},#{sectionCode},#{longitude}"
				+ ",#{latitude},#{pointCode},#{shape},#{LaneNumber}"
				+ ",#{pointType},#{roadName})")
		@Options(useGeneratedKeys = true, keyProperty = "pointId", keyColumn = "point_id")
	   public  int insertPoint(PointPosition pop);
		
		 //根据PointCode 验证是否重名
	    @Select("select count(*) from point_position where point_code=#{code}")
	   public int  countByCode(String code );
		 //根据equipmentName 验证是否重名
	    @Select("select count(*) from point_position where point_name=#{code}")
	   public int  countByPname (String pname );
		
	    //根据id删除点位
		@Delete("delete from point_position where point_name=#{pointName}")
		public void delectPointById(PointPosition pop);
		//根据id查询点位
		@Select("select * from point_position where point_id=#{pointId}")
		public PointPosition selectPointById(Integer pointId);
		
		
		//根据不同条件查询设备信息  if版 动态sql     concat('%',#{linkName},'%')   concat('%',#{string},'%')
		        @Select({"<script> "
					    + "select * from point_position "
		        		+"<where>"
						+ "<if test = 'pointName != null and pointName !=&apos;&apos;   '> "
						+" and point_name like concat('%',#{pointName},'%') "
						+"</if>"
						+ "<if test = 'sectionCode != null  and sectionCode !=&apos;&apos;  '> "
						+"  and section_code like concat('%',#{sectionCode},'%') "
						+"</if>"	
						+ "<if test = 'pointCode != null  and pointCode !=&apos;&apos;  '> "
						+" and  point_code like concat('%',#{pointCode},'%') "
						+"</if>"			
						+ "<if test = 'pointType != null  and pointType !=&apos;&apos;  '> "
						+"  and point_type like concat('%',#{pointType},'%') "
						+"</if>"
						+ "<if test = 'roadName != null  and roadName !=&apos;&apos;  '> "
						+" and  road_name like concat('%',#{roadName},'%') "
						+"</if>"
						+"</where>"
						+"  order by point_id asc;"
						+"</script>"})
				public List<PointPosition> selectpointBymore(PointPosition pop);
		
		
	//根据id修改设备信息  if版 动态sql
		@Update({"<script> "
			    + "update point_position set "
				+" point_name=#{pointName},"
				+" section_code=#{sectionCode},"
				+" longitude=#{longitude},"
				+" latitude=#{latitude},"
				+" point_code=#{pointCode},"
				+" shape=#{shape},"
				+" Lane_number=#{LaneNumber},"
				+" point_type=#{pointType},"
				+" road_name=#{roadName} "
				+"  where point_id=#{pointId};"
				+"</script>"})
		public void updatePointById(PointPosition pop);

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
	    @Select("select * from point_position  order by point_id asc")
		public List<PointPosition> selectAllPoint();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
