package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Project;




public interface ProjectMapper {
	
		//添加设备
		//新增后返回主键keyPropertyjava对象属性名 ，  keyColumn数据库主键
		@Insert("insert into project values (null"
				+ ",#{projectName},#{purchaseDate},#{installDate}"
				+ ",#{contractor},#{constructionPeriod},#{buildUnit},#{constructionType}"
				+ ",#{contractNumber},#{constructionStatus},#{constructionUnit},#{constructionProject},#{pointId},#{equipmentId})")
		@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
		public void insertProject(Project prt);
		


		//根据项目name插入poid
		@Update("update project set point_id=#{poid} where project_name=#{projectName}")
		public void insertPoidByName(int poid, String projectName);
		
		//根据设备name插入poid
		@Update("update project set equipment_id=#{Eqid} where project_name=#{projectName}")
		public void insertEqidByName(int Eqid, String projectName);






}
