package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.euiopmentall;




public interface equiopmentallMapper {
	
		//添加设备
		//新增后返回主键keyPropertyjava对象属性名 ，  keyColumn数据库主键
		@Insert("insert into euiopmentall values (null"
				+ ",#{equipmentCode},#{equipmentName},#{equipmentUser}"
				+ ",#{equipmentPwd},#{equipmentType}"
				+ ",#{fillProperties},#{afunctionType},#{orientation}"
				+ ",#{positionType},#{pickup},#{securityMode},#{regMethod},#{confiAttribute}"
				+ ",#{storageDay},#{videoAddress},#{bitstreamType},#{codingFormat}"
				+ ",#{bitrateSize},#{rateType},#{pictureFormat}"
				+ ",#{sn},#{modelNumber},#{diskNumber},#{frameRate},#{brand}"
				+ ",#{resolvingPower},#{functionType},#{versionNumber},#{hostchannelsNumber},#{height},#{length})")
		@Options(useGeneratedKeys = true, keyProperty = "equipmentId", keyColumn = "equipment_id")
		public int insertEquipmentmor(euiopmentall e);
		
       
    	
	   //根据equipmentName 验证是否重名
	    @Select("select count(*) from euiopmentall where equipment_name=#{ename}")
	   public int  countByeName(String ename );
	    
	    //根据equipmentCode 验证是否重名
	    @Select("select count(*) from euiopmentall where equipment_code=#{equipmentCode}")
	   public int  countByecode(String equipmentCode );
	    
	  //根据sn 验证是否重名
	    @Select("select count(*) from euiopmentall where sn=#{sn}")
	   public int  countByeSN(String sn);
	    
	    //根据id删除设备
		@Delete("delete from euiopmentall where equipment_id=#{equipmentId}")
		public void delecteptrById(int equipmentId);
	   //根据id得到单个设备
		@Select("select * from euiopmentall where equipment_id=#{equipmentId}")
		public euiopmentall selecteptrbyid(int equipmentId);
	    
	    // 查找所有的设备名称信息
	    @Select("select equipment_name from euiopmentall  order by equipment_id asc")
		public List<String> selectAllEquNames();
	    
	    // 查找所有的设备mor所有信息
	    @Select("select * from euiopmentall  order by equipment_id asc")
		public List<euiopmentall> selectAllEqtmor();
		
		
		  @Select({"<script> "
				    + "select * from euiopmentall "
	        		+"<where>"
					+ "<if test = 'equipmentName != null and equipmentName !=&apos;&apos;   '> "
					+" and equipment_name like concat('%',#{equipmentName},'%') "
					+"</if>"
					+ "<if test = 'equipmentType != null  and equipmentType !=&apos;&apos;  '> "
					+"  and equipment_type like concat('%',#{equipmentType},'%') "
					+"</if>"	
					+ "<if test = 'afunctionType != null  and afunctionType !=&apos;&apos;  '> "
					+" and  afunction_type like concat('%',#{afunctionType},'%') "
					+"</if>"			
					+ "<if test = 'brand != null  and brand !=&apos;&apos;  '> "
					+"  and brand like concat('%',#{brand},'%') "
					+"</if>"
					+ "<if test = 'functionType != null  and functionType !=&apos;&apos;  '> "
					+" and  function_type like concat('%',#{functionType},'%') "
					+"</if>"
					+"</where>"
					+"  order by equipment_id asc;"
					+"</script>"})
			public List<euiopmentall> selectEptrBymore(euiopmentall eu);
			
			
			
			//根据euiopmentall修改设备信息  if版 动态sql
			@Update({"<script> "
				    + "update euiopmentall set "
					+" equipment_code=#{equipmentCode},"
					+" equipment_name=#{equipmentName},"
					+" equipment_user=#{equipmentUser},"
					+" equipment_pwd=#{equipmentPwd},"
					+" equipment_type=#{equipmentType}"
					+"  where equipment_id=#{equipmentId};"
					+"</script>"})
			public void updateEptrById(euiopmentall eptr);
			
			
			
			
			
		

		    //根据eptr 更新信息   asso
		    @Update("update euiopmentall set fill_properties=#{fillProperties},afunction_type=#{afunctionType} "
		    		+ ", orientation=#{orientation},position_type=#{positionType},pickup=#{pickup},security_mode=#{securityMode}"
		    		+ " ,reg_method=#{regMethod},confi_attribute=#{confiAttribute} where equipment_id=#{equipmentId}")
			public void insertAstomrByEid( euiopmentall eptr);
		    
		    //根据eptr 更新信息 stog
		    @Update("update euiopmentall set storage_day=#{storageDay},video_address=#{videoAddress}"
		    		+ " ,bitstream_type=#{bitstreamType},coding_format=#{codingFormat},bitrate_size=#{bitrateSize},rate_type=#{rateType}"
		    		+ " ,picture_format=#{pictureFormat} where equipment_id=#{equipmentId}")
		    public void insertStromrByEid(euiopmentall eptr);
		    
		    //根据eptr 更新信息  baseequip
		    @Update("update euiopmentall set sn=#{sn},model_number=#{modelNumber}"
		    		+ ", disk_number=#{diskNumber},frame_rate=#{frameRate},brand=#{brand},resolving_power=#{resolvingPower}"
		    		+ " ,function_type=#{functionType},version_number=#{versionNumber},hostchannels_number=#{hostchannelsNumber}"
		    		+ " ,height=#{height},length=#{length}  where equipment_id=#{equipmentId}")
		    public void insertBaeemrByEid( euiopmentall eptr);
	
}
