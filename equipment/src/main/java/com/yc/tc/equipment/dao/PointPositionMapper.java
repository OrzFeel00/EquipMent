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
				+ ",#{pointType},#{roadId})")
		@Options(useGeneratedKeys = true, keyProperty = "pointId", keyColumn = "point_id")
	   public  int insertPoint(PointPosition pop);
		
		 //根据PointCode 验证是否重名
	    @Select("select count(*) from point_position where point_code=#{code}")
	   public int  countByCode(String code );
		 //根据equipmentName 验证是否重名
	    @Select("select count(*) from point_position where point_name=#{code}")
	   public int  countByPname (String pname );
		
	//根据id删除设备
		@Delete("delete from point_position where point_id=#{pointId}")
		public void delectPointById(PointPosition pop);
		
	//根据id修改设备信息  if版 动态sql
		@Update({"<script> "
			    + "update point_position set "
				+ "<if test = 'pointName != null and pointName !=&apos;&apos;   '> "
				+" point_name=#{pointName},"
				+"</if>"
				+ "<if test = 'sectionCode != null  and sectionCode !=&apos;&apos;  '> "
				+"  sectio_code=#{sectionCode},"
				+"</if>"
				+ "<if test = 'longitude != null  and longitude !=&apos;&apos;  '> "
				+" longitude=#{longitude},"
				+"</if>"
				+ "<if test = 'latitude != null  and latitude !=&apos;&apos;  '> "
				+" latitude=#{latitude},"
				+"</if>"
				+ "<if test = 'pointCode != null  and pointCode !=&apos;&apos;  '> "
				+" point_code=#{pointCode},"
				+"</if>"
				+ "<if test = 'shape != null  and shape !=&apos;&apos;  '> "
				+" shape=#{shape},"
				+"</if>"
				+ "<if test = 'LaneNumber != null  and LaneNumber !=&apos;&apos;  '> "
				+" Lane_number=#{LaneNumber},"
				+"</if>"
				+ "<if test = 'pointType != null  and pointType !=&apos;&apos;  '> "
				+" point_type=#{pointType},"
				+"</if>"
				+ "<if test = 'roadId != null  and roadId !=&apos;&apos;  '> "
				+" road_id=#{roadId},"
				+"</if>"
				+"  where point_id=#{point_id};"
				+"</script>"})
		public void updatePointById(PointPosition pop);

		  //根据点位id放入roadid
	    @Update("update point_position set road_id=#{roadId} where point_id=#{ponintid}")
		public void insertRoidByPid(Integer roadId, Integer ponintid);
}
