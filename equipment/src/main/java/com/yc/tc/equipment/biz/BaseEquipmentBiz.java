package com.yc.tc.equipment.biz;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.BaseEquipment;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.dao.BaseEquipmentMapper;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.StorageMapper;
import com.yc.tc.equipment.dao.equiopmentallMapper;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



@Service
public class BaseEquipmentBiz {
	
	@Resource
	private BaseEquipmentMapper bmpper;
	@Resource
	private equiopmentallMapper eqmpper;
	@Resource
	private EquipmentMapper empper;
	
	//添加设备基础信息
		public void inaddBqtr(euiopmentall eptr)throws BizException {
			
			if(eqmpper.countByeSN(eptr.getSn())>0) {
				throw new BizException("序列号已存在");
			}
			Integer inEquipmentid= instUtils.limt.get("inEquipmentid");
			 eptr.setEquipmentId(inEquipmentid);
			 eqmpper.insertBaeemrByEid(eptr);
		}

	
		public void addBqtr(@Valid euiopmentall eptr)throws BizException {
			// TODO Auto-generated method stub
			//可以忽略字段的验证
			if(eqmpper.countByeSN(eptr.getSn())>0) {
				throw new BizException("序列号已存在");
			}
			Integer eptrrid= instUtils.limt.get("eptrrid");
			 eptr.setEquipmentId(eptrrid);
			 eqmpper.insertBaeemrByEid(eptr);
		}
		//更新baes
		public void updatBaesById(euiopmentall eptr)throws BizException {
			// TODO Auto-generated method stub
			 String eptSn=instUtils2.limt2.get("eptSn");
				
				if((eqmpper.countByeSN(eptr.getSn())>0) && (!(eptr.getSn().equals(eptSn)))) {
					throw new BizException("出场序列号称已存在");
				}
			eqmpper.insertBaeemrByEid(eptr);
		}
		
		
		
		

}
