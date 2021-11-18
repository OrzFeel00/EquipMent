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
		public void inaddSto(euiopmentall eptr)throws BizException {
			Integer inEquipmentid= instUtils.limt.get("inEquipmentid");
			
			 eptr.setEquipmentId(inEquipmentid);
			 eqmpper.insertStromrByEid(eptr);
		}
		
	

		public void addStor( euiopmentall eptr)throws BizException {
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
