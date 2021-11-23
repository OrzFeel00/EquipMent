package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.bean.road;

import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.dao.equiopmentallMapper;
import com.yc.tc.equipment.dao.roadMapper;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



@Service
public class equiopmentallBiz {
	
	@Resource
	private equiopmentallMapper eqmpper;

	

			
			
			//查找所有的设备所有信息
			public List<euiopmentall> selectAllEptmor()throws BizException {
				if(eqmpper.selectAllEqtmor()==null) {
					throw new BizException("暂时没有记录点位");
				}					
				return eqmpper.selectAllEqtmor();
			}

            //设备新增
			public void addeptmor( euiopmentall eq)throws BizException  {
				// TODO Auto-generated method stub
				
				//可以忽略字段的验证
				//经行同名验证
				if((eqmpper.countByecode(eq.getEquipmentCode())>0) && (eqmpper.countByeName(eq.getEquipmentName())>0)) {
					throw new BizException("设备编号已经名称已存在");
				}
				if(eqmpper.countByecode(eq.getEquipmentCode())>0) {
					throw new BizException("设备编号已存在");
				}
				if(eqmpper.countByeName(eq.getEquipmentName())>0) {
					throw new BizException("设备已存在");
				}
				
				
				eqmpper.insertEquipmentmor(eq);	
				
			}
			
			
			public List<euiopmentall> selectEptrBymore(euiopmentall eu)throws BizException {
			
				return	eqmpper.selectEptrBymore(eu);
			}


			public void dellpoint(euiopmentall eptr) throws BizException{
				// TODO Auto-generated method stub
				
				eqmpper.delecteptrById(eptr.getEquipmentId());
				
			}

			//根据id得到单个设备
			public euiopmentall selecteptrbyid(int equipmentid) {
				// TODO Auto-generated method stub
				return eqmpper.selecteptrbyid(equipmentid);
				
			}


			public void updateEptrById(euiopmentall eptr)throws BizException {
				
				 String EquipmentCode=instUtils2.limt2.get("EquipmentCode");
				 String EquipmentName=instUtils2.limt2.get("EquipmentName");
				 
				//经行同名验证
				 if((!(eptr.getEquipmentCode().equals(EquipmentCode))) || (!(eptr.getEquipmentName().equals(EquipmentName)))) {
					 
						if((eqmpper.countByecode(eptr.getEquipmentCode())>0) && (eqmpper.countByeName(eptr.getEquipmentName())>0)) {
							throw new BizException("设备编号已经名称已存在");
						}
						if(eqmpper.countByecode(eptr.getEquipmentCode())>0) {
							throw new BizException("设备编号已存在");
						}
						if(eqmpper.countByeName(eptr.getEquipmentName())>0 ) {
							throw new BizException("设备已存在");
						} 
				 }				
				eqmpper.updateEptrById(eptr);
				
			}
			
			
			//找到所有的设备名称
			public List<String> selectAllEquplltNames() {
				List<String> eqlist=eqmpper.selectAllEquNames();
				return eqlist;
			}
			

			
	
	

		

}
