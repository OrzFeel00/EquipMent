package com.yc.tc.equipment.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.StorageMapper;



@Service
public class StorageBiz {
	
	@Resource
	private StorageMapper smpper;
	
	//添加存储信息
		public void addSto(Storage sto)throws BizException {
			//可以忽略字段的验证
			smpper.insertStorage(sto);
		}

}
