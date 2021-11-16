package com.yc.tc.equipment.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Associated;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;

import com.yc.tc.equipment.dao.EquipmentMapper;




@Service
public class EquipmentBiz {
	
	@Resource
	private EquipmentMapper empper;
	
	//注册验证
		public void addEquip(Equipment eq)throws BizException {
			//可以忽略字段的验证
			//经行同名验证
			if((empper.countByecode(eq.getEquipmentCode())>0) && (empper.countByeName(eq.getEquipmentName())>0)) {
				throw new BizException("设备编号已经名称已存在");
			}
			if(empper.countByecode(eq.getEquipmentCode())>0) {
				throw new BizException("设备编号已存在");
			}
			if(empper.countByeName(eq.getEquipmentName())>0) {
				throw new BizException("设备已存在");
			}
			empper.insertEquipment(eq);
	
		}
		
		
    	//找到所有的设备名称
				public List<String> selectAllEquptNames() {
					List<String> eqlist=empper.selectAllEquNames();
					return eqlist;
				}
				
				//查找所有的设备所有信息
				public List<Equipment> selectAllEpt()throws BizException {
					if(empper.selectAllEqt()==null) {
						throw new BizException("暂时没有记录点位");
					}					
					return empper.selectAllEqt();
				}
				
				


		
				
				
				
			
				
				
				
				

}
