package com.yc.tc.equipment.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Associated;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.dao.AssociatedMapper;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.StorageMapper;
import com.yc.tc.equipment.util.instUtils;



@Service
public class AssociatedBiz {
	
	@Resource
	private AssociatedMapper ampper;
	@Resource
	private EquipmentMapper empper;
	
	//添加关联信息
		public void addAsd(Associated asd)throws BizException {
			//可以忽略字段的验证
			ampper.insertAssociated(asd);
		}
		
		
		public void addAsByid(Integer asid) {
			// TODO Auto-generated method stub
			//读取当前设备id
			 Integer equetid= instUtils.limt.get("Equipmentid");
			///根据设备id放入Associated
			 empper.insertAsidByEid(equetid,asid);
		}

}
