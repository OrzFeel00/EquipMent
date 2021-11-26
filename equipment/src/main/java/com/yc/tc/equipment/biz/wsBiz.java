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
		
		for(String obj:instque.limt2.values()){
            System.out.println("value:"+obj);
            if(ws.equals(obj)) {
            	relut=obj+"号"+id;
            }
        }
		 
		if(relut.equals("大鹏新")) {
			relut+="区";
		}
		
			return relut;
		}
		
		public String edtinputwz(String whereis,int pointid)throws BizException  {
			 //筛选得到对应的区,并且返回
			if(whereis.length()<6) {
				throw new BizException("请选择深圳市区");
			}
			
			if(!(whereis.substring(0, 6).equals("广东省深圳市"))) {
				throw new BizException("请选择深圳市区");
			}
		String ws=	whereis.substring(6, 9);
		String relut="初始区域";
		
		for(String obj:instque.limt2.values()){
           System.out.println("value:"+obj);
           if(ws.equals(obj)) {
           	relut=obj+"号"+pointid;
           }
       }
		 
		if(relut.equals("大鹏新")) {
			relut+="区";
		}
		
			return relut;
		}

}
