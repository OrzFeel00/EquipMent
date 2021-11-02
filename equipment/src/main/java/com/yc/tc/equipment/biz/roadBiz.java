package com.yc.tc.equipment.biz;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;



import com.yc.tc.equipment.bean.road;

import com.yc.tc.equipment.dao.PointPositionMapper;

import com.yc.tc.equipment.dao.roadMapper;
import com.yc.tc.equipment.util.instUtils;



@Service
public class roadBiz {
	
	@Resource
	private roadMapper rmpper;
	@Resource
	private PointPositionMapper pmpper;
	
	//添加设备基础信息
		public void addRod(road roa)throws BizException {
			//可以忽略字段的验证
			if(rmpper.countByeCode(roa.getRoadCode())>0) {
				throw new BizException("道路已存在");
			}
			rmpper.insertroad(roa);
		}
//把道路标识填入点位
		public void addRoadbyid(Integer roadId) {
			// TODO Auto-generated method stub
			//读取当前点位id
			 Integer ponintid= instUtils.limt.get("point_id");
			///根据点位id放入roadid
			 pmpper.insertRoidByPid(roadId,ponintid);
		}

		

		

}
