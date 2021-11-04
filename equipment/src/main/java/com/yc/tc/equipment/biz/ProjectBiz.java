package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;


import com.yc.tc.equipment.bean.Project;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.dao.ProjectMapper;

import com.yc.tc.equipment.util.instUtils2;

@Service
public class ProjectBiz {

		@Resource
		private  ProjectMapper pmpper;
		@Resource
		private  PointPositionMapper prmpper;
		@Resource
		private  EquipmentMapper empper;
	
	   //项目插入
		public void addPrt(Project prt)throws BizException {
				//可以忽略字段的验证

			pmpper.insertProject(prt);
		
			}

		//插入点位到项目
		public void insertPioByprName(String pointName) {
			//根据 pointName 返回id
		int poid=	prmpper.selectpoidByPname(pointName);
			// TODO Auto-generated method stub
		//读取当前项目name
		 String projectName= instUtils2.limt2.get("ProjectName");
		 //根据项目name插入poid
		 pmpper.insertPoidByName(poid,projectName);
		}
		
       //插入设备到项目
		public void insertEqtByprName(String equipmentName) {
			//根据 pointName 返回id
		int eqid=empper.selecteqidByname(equipmentName);
		
		//读取当前项目name
		 String projectName= instUtils2.limt2.get("ProjectName");
		//根据项目name插入eqid
		 pmpper.insertEqidByName(eqid,projectName);

		}
		
		

   
	

}
