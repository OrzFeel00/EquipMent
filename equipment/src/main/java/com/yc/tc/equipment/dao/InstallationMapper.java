package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Installation;
import com.yc.tc.equipment.bean.PointPosition;




public interface InstallationMapper {
	
	//根据点位名称 name 查询 全表  ；返回PointPosition列表
		@Select("select * from point_position where point_name=#{pointName} ")
		public List<PointPosition> selectPointByName(PointPosition pop);
		
    //添加install
		@Insert("insert into installation values (null"
				+ ",#{installationPosition},#{direction},#{lanes},#{powerPoint},#{pointName},#{equipmentName},#{transmissionType},#{computerRoom}"
				+ ",#{networkAttribute},#{idcard},#{accessNetwork},#{router},#{networkTiming},#{timingWarning},#{verificationDeadline},#{ip}"
				+ ",#{mac},#{prot})")
		@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	   public  int insertinstall(Installation ins);
		
		 //根据PointCode 验证是否重名
	    @Select("select count(*) from point_position where point_code=#{code}")
	   public int  countByCode(String code );
		 //根据equipmentName 验证是否重名
	    @Select("select count(*) from point_position where point_name=#{code}")
	   public int  countByPname (String pname );
		
	    //根据id删除点位
		@Delete("delete from installation where id=#{id}")
		public void delectinstallById(int id);
		//根据id查询点位
		@Select("select * from installation where id=#{instId}")
		public Installation selectInstallById(Integer instId);
		
		
		//根据不同条件查询设备信息  if版 动态sql     concat('%',#{linkName},'%')   concat('%',#{string},'%')
		        @Select({"<script> "
					    + "select * from installation "
		        		+"<where>"
						+ "<if test = 'pointName != null and pointName !=&apos;&apos;   '> "
						+" and point_name like concat('%',#{pointName},'%') "
						+"</if>"
						+ "<if test = 'equipmentName != null  and equipmentName !=&apos;&apos;  '> "
						+"  and equipment_name like concat('%',#{equipmentName},'%') "
						+"</if>"	
						+ "<if test = 'transmissionType != null  and transmissionType !=&apos;&apos;  '> "
						+" and  transmission_type like concat('%',#{transmissionType},'%') "
						+"</if>"			
						+ "<if test = 'computerRoom != null  and computerRoom !=&apos;&apos;  '> "
						+"  and computer_room like concat('%',#{computerRoom},'%') "
						+"</if>"
						+ "<if test = 'ip != null  and ip !=&apos;&apos;  '> "
						+" and  ip like concat('%',#{ip},'%') "
						+"</if>"
						+"</where>"
						+"  order by id asc;"
						+"</script>"})
				public List<Installation> selectinstallBymore(Installation install);
		
		
	//根据id修改设备信息  if版 动态sql
		@Update({"<script> "
			    + "update installation set "
				+" installation_position=#{installationPosition},"
				+" direction=#{direction},"
				+" lanes=#{lanes},"
				+" power_point=#{powerPoint},"
				+" point_name=#{pointName},"
				+" equipment_name=#{equipmentName},"
				+" transmission_type=#{transmissionType},"
				+" computer_room=#{computerRoom},"
				+" network_attribute=#{networkAttribute},"
				+" idcard=#{idcard},"
				+" access_network=#{accessNetwork},"
				+" router=#{router},"
				+" network_timing=#{networkTiming},"
				+" timing_warning=#{timingWarning},"
				+" verification_deadline=#{verificationDeadline},"
				+" ip=#{ip},"
				+" mac=#{mac},"
				+" prot=#{prot}"
				+"  where id=#{id};"
				+"</script>"})
		public void updateinstallById(Installation install);

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
	    @Select("select * from installation  order by id asc")
		public List<Installation> selectAllinstall();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
