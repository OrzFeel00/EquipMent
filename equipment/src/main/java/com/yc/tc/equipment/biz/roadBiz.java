package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.road;

import com.yc.tc.equipment.dao.PointPositionMapper;

import com.yc.tc.equipment.dao.roadMapper;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



@Service
public class roadBiz {
	
	@Resource
	private roadMapper rmpper;
	@Resource
	private PointPositionMapper pmpper;
	
	//添加设备基础信息
		public void addRod(road roa)throws BizException {
			//可以忽略字段的验证
			if(rmpper.countByrName(roa.getRoadName())>0) {
				throw new BizException("道路名称已存在");
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
	//找到所有的街道名称
	public List<String> selectAllRdNames(){
		List<String> nlist=rmpper.selectAllRdNames();  
		return nlist;
	}
	 //根据roadname 插入到point,
	  public void insetRidByname(String name) {
		//  根据roadname 返回rid,
		int rs=rmpper.selectRidByname(name);
		//读取当前点位id
		 Integer ponintid= instUtils.limt.get("point_id");
		///根据点位id放入roadid
		 pmpper.insertRoidByPid(rs,ponintid);
	}

	  
	// 查找所有的道路所有信息
	  public List<road> selectAllRoad()throws BizException {
			if(rmpper.selectAllRoad()==null) {
				throw new BizException("暂时没有记录点位");
			}
			List<road> rlist=rmpper.selectAllRoad();
			
			return rlist;
		}
	  //删除道路
	public void dellroad(road road) {
		rmpper.delectRoadById(road);
		
	}
	
	//根据条件模糊查询road
	public List<road> selectroadBymore(road road)throws BizException  {
		List<road> roads=rmpper.selectroadBymore(road);
		
		return roads;
	}
		
	//修改街道
	public void updatePointById(road road)throws BizException {
		 String insroadname=instUtils2.limt2.get("insroadname");
	  //验证是否重复名 且不包括自己本身的名字
		if((rmpper.countByrName(road.getRoadName())>0) && (!(road.getRoadName().equals(insroadname)))) {
			throw new BizException("道路名称已存在!");
		}
		rmpper.updateRoadById(road);
	}

		

}
