package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;


import com.yc.tc.equipment.bean.Project;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.dao.ProjectMapper;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;

@Service
public class ProjectBiz {

		@Resource
		private  ProjectMapper pmpper;
		@Resource
		private  PointPositionMapper pompper;
		@Resource
		private  EquipmentMapper empper;
	
	   //项目插入
		public void addPrt(Project prt)throws BizException {
				//同名验证
			if(pmpper.countByPrname(prt.getProjectName()) >0) {
				throw new BizException("项目不能重复新增");
			}
			pmpper.insertProject(prt);
		
			}

		
		//插入点位到项目
		public void insertPioByprName(String pointName) {		
		 //读取当前projectid
		 int projectid= instUtils.limt.get("ProjectId");
		 
		 //根据projectid判断 project表是否有点位name(id只能新增一次，所以就是开始的那个)
		 if(pmpper.selectpointnByPrId(projectid) != null) {
			 //有point的情况 直接新增   
			Project pr= pmpper.selectProByprid(projectid);//返回新的project对象
			pr.setPointName(pointName) ;//插入pointName到project对象
			pmpper.insertProject(pr);//新增
			return;
		 }
		 //根据项目name插入pointname
		 pmpper.insertPonaById(pointName,projectid);
		}
		
		
       //插入设备到项目
		public void insertEqtByprName(String equipmentName)throws BizException {
	      //读取当前项目 点位的name
		 String PRpointname= instUtils2.limt2.get("PRpointname");
		 System.out.println("112121++"+PRpointname);
		 //读取当前projectid
		 int projectid= instUtils.limt.get("ProjectId");
		 String  ProjectName =instUtils2.limt2.get("ProjectName");
		 //根据projectid判断 project表是否有设备信息  初始值是否有设备name
		 if(pmpper.selectEptnByPrId(projectid) != null) {		 
			 //先判断是否重复插入    ProjectName    pointname      equiname   
			 if(pmpper.countByIdPidPpoit(ProjectName, PRpointname, equipmentName)>0){
				 throw new BizException("该点位已有这个设备");
			 }
			 //有eptid的情况 直接新增   
			Project pr= pmpper.selectProByprid(projectid);//返回project,根据id才是唯一最开始的那个
			pr.setEquipmentName(equipmentName); ;//插入eqid到projecst
			pr.setPointName(PRpointname);			
			pmpper.insertProject(pr);
			return;
		 }
		 
		 
		//根据项目name插入eqid
		 pmpper.insertEqnameById(equipmentName,projectid);

		}
		
		

   
	

}
