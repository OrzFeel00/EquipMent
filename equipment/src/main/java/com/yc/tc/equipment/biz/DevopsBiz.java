package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Devops;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.dao.DevopsMapper;
import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.util.instUtils2;

@Service
public class DevopsBiz {

		@Resource
		private PointPositionMapper pmpper;
		@Resource
		private DevopsMapper dmpper;
	
	   //运维信息add
		public void adddep(Devops dep)throws BizException {
			
				dmpper.insertDevop(dep);
		
			}

	            	//找到所有的点位名称
				public List<String> selectAllPointNames() {
					List<String> pionlist=pmpper.selectAllPointNames();  
					return pionlist;
				}
				
				//查询所有点位
				public List<Devops> selectAllDevop()throws BizException {
					if(dmpper.selectAllDevop()==null) {
						throw new BizException("暂时没有记录运维信息");
					}					
					return dmpper.selectAllDevop();
				}
				
				//根据id擦寻名称
				public String selectpointnameByid(int pid) {
					 
					return  pmpper.selectnameByid(pid);
				}
				
				//删除点位
				public void delldep(int depid) {
					dmpper.delectdepById(depid);
				}
				//根据id查询点位
				public PointPosition selectPointById(Integer pid) {
					 PointPosition pop=pmpper.selectPointById(pid);
					return pop;
				}
				//根据条件模糊查询
				public List<Devops> selectDevopBymore(Devops dep)throws BizException {
					
					return dmpper.selectDevopBymore(dep);
				}
				//修改dep
				public void updateDevopsById(Devops dep)throws BizException {
					 
					dmpper.updateDevopsById(dep);
				}
				

}
