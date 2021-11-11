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
				+ ",#{contractNumber},#{constructionStatus},#{constructionUnit},#{constructionProject},#{pointName},#{equipmentName})")
		@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
		public void insertProject(Project prt);
		

		
	
	    
		//根据Projectid查询项目
	    @Select("select * from project where id=#{projectId}")
		public Project selectProByprid( int projectId );
		

		//根据项目name插入poid
		//@Update("update project set point_id=#{poid} where project_name=#{projectName}")
	//	public void insertPoidByName(int poid, String projectName);
		
		//根据项目id插入poiname
		@Update("update project set point_name=#{poiname} where id=#{projectId}")
		public void insertPonaById(String poiname, int projectId);
				
		//根据项目name插入Eqid
	//	@Update("update project set equipment_id=#{Eqid} where project_name=#{projectName}")
	//	public void insertEqidByName(int Eqid, String projectName);
		
		//根据项目id插入Eqid
		@Update("update project set equipment_name=#{Eqname} where id=#{projectId}")
		public void insertEqnameById(String Eqname, int projectId );


		 //根据projectName 验证是否重名
	    @Select("select count(*) from project where project_name=#{projectName}")
	    public int  countByPrname (String projectName );
	    
	    //根据projectID找到piontName的值
	    @Select("select point_name from project where id=#{projectID}")
	    public String  selectpointnByPrId (int projectID );
	    
	    //根据projectID 找到equipmentnamed的值
	    @Select("select equipment_name from project where id=#{projectID}")
	    public String  selectEptnByPrId(int projectID  );
	    
	    //根据projectName 验证是否重名
	    @Select("select count(*) from project where project_name=#{ProjectName} and point_name=#{pointName} and equipment_name=#{equipmentName}")
	    public int  countByIdPidPpoit (String ProjectName,String pointName,String equipmentName );

      
}
