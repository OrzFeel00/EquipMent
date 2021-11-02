package com.yc.tc.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;




public interface StorageMapper {
	
	
		
       //添加设备存储信息
        @Insert("insert into storage values (null"
				+ ",#{storageDay},#{videoAddress},#{bitstreamType}"
				+ ",#{codingFormat},#{bitrateSize},#{rateType}"
				+ ",#{pictureFormat})")
    	@Options(useGeneratedKeys = true, keyProperty = "storageId", keyColumn = "storage_id")
	    public  int insertStorage(Storage s);
    	
	 
		
	
}
