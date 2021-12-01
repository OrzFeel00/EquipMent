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
import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.dao.StorageMapper;
import com.yc.tc.equipment.dao.equiopmentallMapper;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instque;



@Service
public class wsBiz {
	
	
	@Resource
	private PointPositionMapper pmpper;
	


		public String inputwz(String whereis)throws BizException  {
			 //筛选得到对应的区,并且返回
			if(whereis.length()<6) {
				throw new BizException("请选择深圳市区");
			}
			if(!(whereis.substring(0, 6).equals("广东省深圳市"))) {
				throw new BizException("请选择深圳市区");
			}
		String ws=	whereis.substring(6, 9);
		String relut="初始区域";
		int id=pmpper.gettopid()+1;
	    String ids=id+"";
		for(Integer key:instque.limt2.keySet()){
        
			 relut =instque.limt2.get(key);
            if(ws.equals(relut)) {
            	relut=key+ids;
            	break;
            }
        }
		
			return relut;
		}
		
		
		public String edtinputwz(String whereis,int pointid)throws BizException  {
			
			if(whereis.substring(0,4).equals(4403+"")) {
				return whereis;
			}
			 //筛选得到对应的区,并且返回
			if(whereis.length()<6) {
				throw new BizException("请选择深圳市区");
			}
			
			if(!(whereis.substring(0, 6).equals("广东省深圳市"))) {
				throw new BizException("请选择深圳市区");
			}
			
		String ws=	whereis.substring(6, 9);
		String relut="初始区域";
		String ids=pointid+"";
		for(Integer key:instque.limt2.keySet()){
	        
			 relut =instque.limt2.get(key);
           if(ws.equals(relut)) {
           	relut=key+ids;
           	break;
           }
       }
		 
		
			return relut;
		}


		public String setRegion(String administrativeRegion)throws BizException{
			 //筛选得到对应的区,并且返回
			
			
			for(String obj:instque.limt2.values()){
	           if(administrativeRegion.equals(obj)) {
	           return administrativeRegion;
	           }
	       }
			
			if(administrativeRegion.length()<6) {
				throw new BizException("请选择深圳市区");
			}
			if(!(administrativeRegion.substring(0, 6).equals("广东省深圳市"))) {
				throw new BizException("请选择深圳市区");
			}
			
			return  administrativeRegion.substring(6, 9);
		}

}
