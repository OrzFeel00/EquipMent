package com.yc.tc.equipment.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.dao.EquipmentMapper;



@Service
public class EquipmentBiz {
	
	@Resource
	private EquipmentMapper empper;
	
	//注册验证
		public void addEquip(Equipment eq)throws BizException {
			//可以忽略字段的验证
			//经行同名验证
			if(empper.countByeName(eq.getEquipmentName())>0) {
				throw new BizException("设备已存在");
			}
			empper.insertEquipment(eq);
		}

}
