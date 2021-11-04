package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Project;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.ProjectBiz;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils2;

@Controller
public class ProjerctAction {
	//依赖注入
	@Resource
	private  PointPositionBiz prBiz;
	@Resource
	private  ProjectBiz pBiz;
	@Resource
	private  EquipmentBiz eBiz;
	
	
   
            //管理员端
	
	
	        //去项目输入页面
			@GetMapping("toProject")
			public String touindex() {
				return "admin/inProject";
			}
			
			//项目信息录入
			@PostMapping("Project.do")
			public String register(@Valid Project prt,Errors errors,Model m) {
				System.out.println(prt.toString());
//				if(errors.hasErrors()) {
//					System.out.println("11111111111111");
//					m.addAttribute("errors", Utils.asMap(errors));
//					m.addAttribute("prt",prt);
//					return "admin/inProject";
//				}
				
				try {
					System.out.println(prt.toString());
					//插入点位信息
					System.out.println("222222222222222");
					pBiz.addPrt(prt);
		            //点位id传入map中
				     instUtils2.limt2.put("ProjectName", prt.getProjectName());
				     
				     String ProjectName= instUtils2.limt2.get("ProjectName");
						System.out.println("刘浪"+ProjectName);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					System.out.println("33333333");
					errors.rejectValue("pointName", "pointName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("prt",prt);
					return "admin/inProject";
				}
				//响应重定向  redirect:index
				return "admin/succeseinProject";
			}
			
			   //去点位输入页面
						@GetMapping("tosucceseinProject")
						public String tousucceseinPoint() {
							return "admin/succeseinProject";
						}
			
			//去给项目录入点位
			@GetMapping("topointtoProject")
			public String topointtoProject(Model m) {
				
				 m.addAttribute("points", prBiz.selectAllPointNames());				 
				return "admin/inpointtoProject";
			}
			//去给项目中点位录入设备
			@GetMapping("toEquipmenttoProject")
			public String toEquipmenttoProject(Model m) {
				
				 m.addAttribute("equipments", eBiz.selectAllPointNames());
				return "admin/inEquipmenttoProject";
			}
			
			//给项目录入点位
			@PostMapping("pointtoProject.do")
			public String pointtoProjec(PointPosition point,Model m) {				
			     //根据name写入roaid到point
				 // rBiz.insetRidByname(roa.getRoadName());
				 //根据name写入point到Projec
				    pBiz.insertPioByprName(point.getPointName());
				    m.addAttribute("equipments", eBiz.selectAllPointNames());
				return "admin/inEquipmenttoProject";
			}
			//给项目录入设备
			@PostMapping("EquipmenttoProject.do")
			public String EquipmenttoProject(Equipment eqt,Model m) {				
			     //根据name写入roaid到point
				 // rBiz.insetRidByname(roa.getRoadName());
				 //根据name写入point到Projec
				    pBiz.insertEqtByprName(eqt.getEquipmentName());
				return "admin/succeseinProjectend";
			}


}
