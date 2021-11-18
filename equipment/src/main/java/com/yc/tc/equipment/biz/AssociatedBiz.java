package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Associated;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.dao.AssociatedMapper;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.StorageMapper;
import com.yc.tc.equipment.dao.equiopmentallMapper;
import com.yc.tc.equipment.util.instUtils;



@Service
public class AssociatedBiz {
	
	@Resource
	private AssociatedMapper ampper;
	@Resource
	private EquipmentMapper empper;
	@Resource
	private equiopmentallMapper eqmpper;
	
	//添加关联信息
		public void inaddAsd(euiopmentall eptr)throws BizException {
			//读取当前设备idmr
			 Integer inEquipmentid= instUtils.limt.get("inEquipmentid");
			 eptr.setEquipmentId(inEquipmentid);
			 eqmpper.insertAstomrByEid(eptr);
		
		}
		
		
		

        
        //aad ass 到 eptr
		public void addAsdtr( euiopmentall eptr)throws BizException {
			// TODO Auto-generated method stub
        	
        	//读取当前设备idmr
			 Integer eptrrid= instUtils.limt.get("eptrrid");
			 eptr.setEquipmentId(eptrrid);
			 eqmpper.insertAstomrByEid(eptr);
			
		}

      //edt
		public void updatAssocById(euiopmentall eptr)throws BizException {
		
			eqmpper.insertAstomrByEid(eptr);
		}

}
