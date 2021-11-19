package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Law;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.ip;




public interface ipMapper {
	

		
    //添加ip 
		@Insert("insert into ip values (null,#{pointName},#{equipmentName},#{ip},#{mac},#{prot})")
		@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	   public  int insertip(ip p);
		
		 //根据ip 验证是否重名
	    @Select("select count(*) from ip where point_name=#{pointName} and equipment_name=#{equipmentName} "
	    		+ " and ip=#{ip} and mac=#{mac} and prot=#{prot}")
	   public int  countByipmor(ip i );
	    
	    
	    //查找所有的ip信息
	    @Select("select * from ip where  point_name=#{pointName} and equipment_name=#{equipmentName} ")
		public List<ip> selectipbyname(ip p);
	    
		 //根据equipmentName 验证是否重名
	    @Select("select count(*) from point_position where point_name=#{code}")
	   public int  countByPname (String pname );
		
	    //根据id删除点位
		@Delete("delete from law where id=#{id}")
		public void delectLawById(int lawid);
		//根据id查询点位
		@Select("select * from point_position where point_id=#{pointId}")
		public PointPosition selectPointById(Integer pointId);
		
		
      
	    
	    

		


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
