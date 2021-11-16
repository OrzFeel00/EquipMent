package com.yc.tc.equipment.biz;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.StorageMapper;
import com.yc.tc.equipment.dao.equiopmentallMapper;
import com.yc.tc.equipment.util.instUtils;



@Service
public class StorageBiz {
	
	@Resource
	private StorageMapper smpper;
	@Resource
	private EquipmentMapper empper;
	@Resource
	private equiopmentallMapper eqmpper;
	
	//添加存储信息
		public void addSto(Storage sto)throws BizException {
			//可以忽略字段的验证
			smpper.insertStorage(sto);
		}
		
		public void addStByid(Integer stid) {
			// TODO Auto-generated method stub
			//读取当前设备id
			 Integer equetid= instUtils.limt.get("Equipmentid");
			///根据设备id放入Storage
			 empper.insertStidByEid(equetid,stid);
		}

		public void addStor(@Valid euiopmentall eptr)throws BizException {
			// TODO Auto-generated method stub
			Integer eptrrid= instUtils.limt.get("eptrrid");
			
			 eptr.setEquipmentId(eptrrid);
			 eqmpper.insertStromrByEid(eptr);
			
		}
		
		
		//更新ass 到 eptr
		public void updatStorById(euiopmentall eptr)throws BizException {
			// TODO Auto-generated method stub
			 eqmpper.insertStromrByEid(eptr);
		}
		
		
				

}
