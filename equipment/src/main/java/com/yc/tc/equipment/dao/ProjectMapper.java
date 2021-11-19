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
		public int insertProject(Project prt);
		

		
	
	    
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
	    
	    
	    // 查找所有的项目所有信息
	    @Select("select * from project order by project_name ,point_name")
		public List<Project> selectAllProject();
	    
	    // 查找所有的项目所有名称
	    @Select("select DISTINCT project_name from project order by project_name ")
		public List<String> selectAllProjectNames();
	    
	    
	    
	  //根据不同条件查询项目信息  if版 动态sql     concat('%',#{linkName},'%')   concat('%',#{string},'%')
        @Select({"<script> "
			    + "select * from project "
        		+"<where>"
				+ "<if test = 'projectName != null and projectName !=&apos;&apos;   '> "
				+" and project_name like concat('%',#{projectName},'%') "
				+"</if>"
				+ "<if test = 'contractor != null  and contractor !=&apos;&apos;  '> "
				+"  and contractor like concat('%',#{contractor},'%') "
				+"</if>"	
				+ "<if test = 'buildUnit != null  and buildUnit !=&apos;&apos;  '> "
				+" and  build_unit like concat('%',#{buildUnit},'%') "
				+"</if>"			
				+ "<if test = 'constructionUnit != null  and constructionUnit !=&apos;&apos;  '> "
				+"  and construction_unit like concat('%',#{constructionUnit},'%') "
				+"</if>"
				+ "<if test = 'constructionProject != null  and constructionProject !=&apos;&apos;  '> "
				+" and  construction_project like concat('%',#{constructionProject},'%') "
				+"</if>"
				+ "<if test = 'pointName != null  and pointName !=&apos;&apos;  '> "
				+" and  point_name like concat('%',#{pointName},'%') "
				+"</if>"
				+ "<if test = 'equipmentName != null  and equipmentName !=&apos;&apos;  '> "
				+" and  equipment_name like concat('%',#{equipmentName},'%') "
				+"</if>"
				+"</where>"
				+"  order by project_name asc;"
				+"</script>"})
		public List<Project> selectProjectBymore(Project prt);



         //根据 prt的prname  poinname   eqname 锁定对象
        @Select("select * from project where project_name=#{projectName} and point_name=#{pointName} and equipment_name=#{equipmentName} ")
		public Project selectprojectbyrpe(Project prt);
        
        
      //根据id删除项目
      		@Delete("delete from project where id=#{id}")
      		public void delectPointById(Project pop);




      	//根据id修改设备信息  if版 动态sql
    		@Update({"<script> "
    			    + "update project set "
    				+" project_name=#{projectName},"
    				+" purchase_date=#{purchaseDate},"
    				+" install_date=#{installDate},"
    				+" contractor=#{contractor},"
    				+" construction_period=#{constructionPeriod},"
    				+" build_unit=#{buildUnit},"
    				+" construction_type=#{constructionType},"
    				+" contract_number=#{contractNumber},"
    				+" construction_status=#{constructionStatus}, "
    				+" construction_unit=#{constructionUnit}, "
    				+" construction_project=#{constructionProject}, "
    				+" point_name=#{pointName}, "
    				+" equipment_name=#{equipmentName}"
    				+"  where id=#{id};"
    				+"</script>"})
			public void updatePrtById(Project pop);
	    

      
}
