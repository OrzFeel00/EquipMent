package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.dao.PointPositionMapper;

@Service
public class PointPositionBiz {

		@Resource
		private PointPositionMapper pmpper;
	
	   //点位验证
		public void addPop(PointPosition pop)throws BizException {
			    	//可以忽略字段的验证
			    	//经行同名验证
		    	if((pmpper.countByCode(pop.getPointCode())>0) && (pmpper.countByPname(pop.getPointName())>0)) {
				    throw new BizException("点位名称和编码已存在");
			    }
			
				if(pmpper.countByCode(pop.getPointCode())>0) {
					throw new BizException("点位编码已存在");
				}
				if(pmpper.countByPname(pop.getPointName())>0) {
					throw new BizException("点位名称已存在");
				}
				pmpper.insertPoint(pop);
		
			}

	            	//找到所有的点位名称
				public List<String> selectAllPointNames() {
					List<String> pionlist=pmpper.selectAllPointNames();  
					return pionlist;
				}
				
				public List<PointPosition> selectAllPoint()throws BizException {
					if(pmpper.selectAllPoint()==null) {
						throw new BizException("暂时没有记录点位");
					}
					List<PointPosition> plist=pmpper.selectAllPoint();
					
					return plist;
				}
				
				//删除点位
				public void dellpoint(PointPosition pop) {
					pmpper.delectPointById(pop);
				}
				//根据id查询点位
				public PointPosition selectPointById(Integer pid) {
					 PointPosition pop=pmpper.selectPointById(pid);
					return pop;
				}
				//根据条件模糊查询
				public List<PointPosition> selectpointBymore(PointPosition pop) {
					System.out.println("9999o999+"+pop.toString());
					List<PointPosition> pop1=pmpper.selectpointBymore(pop);
					return pop1;
				}
				

}
