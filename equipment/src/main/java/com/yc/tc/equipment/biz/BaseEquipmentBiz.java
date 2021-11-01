package com.yc.tc.equipment.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.BaseEquipment;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.dao.BaseEquipmentMapper;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.StorageMapper;



@Service
public class BaseEquipmentBiz {
	
	@Resource
	private BaseEquipmentMapper bmpper;
	
	//添加设备基础信息
		public void addSto(BaseEquipment bet)throws BizException {
			//可以忽略字段的验证
			if(bmpper.countByeSN(bet.getSn())>0) {
				throw new BizException("序列号已存在");
			}
			bmpper.insertBaseEquipment(bet);
		}

}
