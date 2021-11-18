package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Law;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.dao.LawMapper;
import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.util.instUtils2;

@Service
public class LawBiz {

		@Resource
		private PointPositionMapper pmpper;
		@Resource
		private LawMapper lmpper;
	
	   //点位验证
		public void addLaw(Law law)throws BizException {
			    
				lmpper.insertLaw(law);
		
			}

	            	//找到所有的点位名称
				public List<String> selectAllPointNames() {
					List<String> pionlist=pmpper.selectAllPointNames();  
					return pionlist;
				}
				
				//查询所有law
				public List<Law> selectALLLaws()throws BizException {
					if(lmpper.selectALLLaws()==null) {
						throw new BizException("暂时没有执法记录");
					}					
					return lmpper.selectALLLaws();
				}
				
				//根据id擦寻名称
				public String selectpointnameByid(int pid) {
					 
					return  pmpper.selectnameByid(pid);
				}
				
				//删除点位
				public void dellLaw(int lawid) {
					lmpper.delectLawById(lawid);
				}
				//根据id查询点位
				public PointPosition selectPointById(Integer pid) {
					 PointPosition pop=pmpper.selectPointById(pid);
					return pop;
				}
				//根据条件模糊查询
				public List<Law> selectLawBymor(Law law)throws BizException {
					
					return lmpper.selectLawBymor(law);
				}
				//修改点位
				public void updateLawById(Law law)throws BizException {
	
					
					lmpper.updateLawById(law);
				}

				

				
				

}
