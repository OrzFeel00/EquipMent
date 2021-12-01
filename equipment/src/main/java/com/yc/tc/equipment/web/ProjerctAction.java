package com.yc.tc.equipment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Project;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.ProjectBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;
import com.yc.tc.equipment.dao.EquipmentMapper;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;
import com.yc.tc.equipment.util.instUtils3;

@Controller
public class ProjerctAction {
	//依赖注入
	@Resource
	private  PointPositionBiz prBiz;
	@Resource
	private  ProjectBiz pBiz;
	@Resource
	private  EquipmentBiz eBiz;
	@Resource
	private  equiopmentallBiz eqBiz;
	
	
   
            //管理员端
	
	
	        //去项目输入页面
			@GetMapping("toproject")
			public String touindex() {
				
				return "admin/Projerct/inProject";
			}
			
			//项目信息录入
			@PostMapping("Project.do")
			public String register(@Valid Project prt,Errors errors,Model m) {
				
				if(errors.hasErrors()) {
					m.addAttribute("prt",prt);
					m.addAttribute("errors", Utils.asMap(errors));
				m.addAttribute("prt",prt);
					return "admin/Projerct/inProject";
				}
				
				try {
					
					//插入点位信息
					pBiz.addPrt(prt);
		            //点位id传入map中
					 instUtils2.limt2.put("ProjectName", prt.getProjectName());	
				     instUtils.limt.put("ProjectId", prt.getId());	
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
				
					errors.rejectValue("projectName", "projectName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("prt",prt);
					return "admin/Projerct/inProject";
				}
				//响应重定向  redirect:index
				return "admin/Projerct/succeseinProject";
			}
			
			
		  //去项项目完备跳转到点位输入
			@GetMapping("tosucceseinProject")
		    	public String tousucceseinPoint() {
		    	return "admin/Projerct/succeseinProject";
			}
			
			//去项目录入点位
			@GetMapping("topointtoProject")
			public String topointtoProject(Model m) {
			   	 m.addAttribute("isprojectName", instUtils2.limt2.get("ProjectName"));
				 m.addAttribute("points", prBiz.selectAllPointNames());				 
				return "admin/Projerct/inpointtoProject";
			}
								
			//do给项目录入 点位
			@PostMapping("pointtoProject.do")
			public String pointtoProjec(PointPosition point,Model m) {				
			     //根据name写入roaid到point
				 // rBiz.insetRidByname(roa.getRoadName());
				 //根据name写入point到Projec
				 
				    pBiz.insertPioByprName(point.getPointName());
				    instUtils2.limt2.put("PRpointname", point.getPointName());	
				    m.addAttribute("isprojectName", instUtils2.limt2.get("ProjectName"));
				    m.addAttribute("ispointName", point.getPointName());
				   
				    m.addAttribute("equipments", eqBiz.selectAllEquplltNames());
				   
				return "admin/Projerct/inEquipmenttoProject";
			}
			
			
			//去给项目中点位录入设备
			@GetMapping("toEquipmenttoProject")
			public String toEquipmenttoProject(Model m) {
				
				
				 m.addAttribute("isprojectName", instUtils2.limt2.get("ProjectName"));
				 m.addAttribute("ispointName", instUtils2.limt2.get("PRpointname"));
				 
				 m.addAttribute("equipments", eqBiz.selectAllEquplltNames());
				return "admin/Projerct/inEquipmenttoProject";
			}
			
		
			//给项目录入设备
			@PostMapping("EquipmenttoProject.do")
			public String EquipmenttoProject(euiopmentall eqt,Model m,Errors errors) {				
				if(errors.hasErrors()) {
					 m.addAttribute("equipments", eqBiz.selectAllEquplltNames());
					m.addAttribute("errors", Utils.asMap(errors));
			     	m.addAttribute("eqt",eqt);
			   
					return "admin/Projerct/inEquipmenttoProject";
				}
				
				try {
				
				    
				    pBiz.insertEqtByprName(eqt.getEquipmentName());
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					m.addAttribute("isprojectName", instUtils2.limt2.get("ProjectName"));
					m.addAttribute("ispointName", instUtils2.limt2.get("PRpointname"));
					errors.rejectValue("equipmentId", "equipmentId",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
				    m.addAttribute("equipments", eqBiz.selectAllEquplltNames());
					m.addAttribute("eqt",eqt);
					
					return "admin/Projerct/inEquipmenttoProject";
				}
				return "admin/Projerct/succeseinProjectend";
			}

			
			@GetMapping("tosucceseinProjectend")
			public String tosucceseinProjectend() {
				
				 
				return "admin/Projerct/succeseToOut";
			}
			
			
			//----------------------------------------//
			   
					
					
					//去项目show
					@GetMapping("toshowproject")
					public String toshowpoint(Model m ) throws BizException {
				
						//查询当前的所有项目					
						m.addAttribute("projectlist",pBiz.selectAllProject());
						return "admin/Projerct/showproject";
					}
					
					//do点位查询
					@RequestMapping("showproject.do")
					public String showpoint( Project prt,Model m,Errors errors) {
						if(errors.hasErrors()) {					
							m.addAttribute("errors", Utils.asMap(errors));
							m.addAttribute("prt",prt);
							return "admin/Projerct/showproject";
						}
						
						try {
							
							//根据pop查询得到list结果集 
						
							m.addAttribute("projectlist",pBiz.selectProjectBymore(prt));
							 m.addAttribute("sorprt", prt);
						} catch (BizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
							//errors.rejectValue("nonull", "null",e.getMessage()); 			
							errors.reject("pointnull",e.getMessage());
							m.addAttribute("errors",Utils.asMap(errors));
							m.addAttribute("prt",prt);
							return "admin/Projerct/showproject";
						}
						
						return "admin/Projerct/showproject";
					}
					
					
					
					
					 //确认去project点位add页面
					@GetMapping("instoaddproject")
					public String instoaddpoint() {
						
						return "admin/Projerct/insaddprpoint";
					}
					
					
					 //do确认去project点位add
					@PostMapping("insaddproject.do")
					public String toaddpoint( Project prt ,Model m) {
						
						  instUtils.limt.put("insprtid",prt.getId());
						  instUtils2.limt2.put("ProjectName",prt.getProjectName());
						//m加入点位结果集
						 m.addAttribute("points", prBiz.selectAllPointNames());		
						return "admin/Projerct/addprpoint";
					}
					
					
					
					//去给项目project点位add
					@GetMapping("toaddpointtoproed")
					public String todoaddpointed(Model m) {
						 
						//m加入点位结果集
						 m.addAttribute("points", prBiz.selectAllPointNames());			
						return "admin/Projerct/addprpoint";
					}
					
					
					
					
					//do project点位add
					@PostMapping("addpointtopro.do")
					public String doaddpoint( PointPosition pop,Errors errors,Model m) {
						if(errors.hasErrors()) {
							m.addAttribute("errors", Utils.asMap(errors));
							m.addAttribute("pop",pop);					
							return "admin/Projerct/addpoint";
						}
						
						try {
							//插入点位到项目
							pBiz.addpointtoprt(pop.getPointName());
	
				   		 instUtils2.limt2.put("insPRpointname", pop.getPointName());	
				   		 
				   		 m.addAttribute("inspointName", pop.getPointName());
						 m.addAttribute("equipments", eqBiz.selectAllEquplltNames() );
						    
						} catch (BizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
							//errors.rejectValue("nonull", "null",e.getMessage()); 			 
							m.addAttribute("errors",Utils.asMap(errors));
							m.addAttribute("pop",pop);
							return "admin/Projerct/addpoint";
						}
						//响应重定向  redirect:index
						return "admin/Projerct/addprequipment";
					}
					
					
					//去给项目中点位录入设备
					@GetMapping("toaddeulltoproed")
					public String toaddequipment(Model m) {
						 
						 m.addAttribute("equipments", eqBiz.selectAllEquplltNames() );
						return "admin/Projerct/addprequipment";
					}
					
					
					//do project设备add
					@PostMapping("addeulltopro.do")
					public String addequipment( euiopmentall ell ,Errors errors,Model m) {
						if(errors.hasErrors()) {
							m.addAttribute("errors", Utils.asMap(errors));
							m.addAttribute("ell",ell);					
							return "admin/Projerct/addprequipment";
						}
						
						try {
							//插入设备到项目
							pBiz.addeuttoprt(ell.getEquipmentName());
							 
						    
						} catch (BizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
							//errors.rejectValue("nonull", "null",e.getMessage()); 	
							errors.rejectValue("equipmentId", "equipmentId",e.getMessage());
							m.addAttribute("errors",Utils.asMap(errors));
							m.addAttribute("ell",ell);
							 m.addAttribute("equipments", eqBiz.selectAllEquplltNames() );
							return "admin/Projerct/addprequipment";
						}
						//响应重定向  redirect:index
						return "admin/Projerct/addsuccesein";
					}
					
					
					
					
					
					
					//去项目删除
					@RequestMapping("todellproject")
					public String todellpoint(Model m ) throws BizException {
						
						
						return "admin/Projerct/dellproject";
					}
					
					//do项目删除
					@RequestMapping("dellproject.do")
					public String dellpoint(Project prt,Model m) throws BizException {
						
						pBiz.dellprot(prt);
						
						
						return "admin/Projerct/dellsucceseinPoint2";
					}
					

					
					//去点位编辑(先去确认)
					@GetMapping("toedtproject")
					public String edt(Model m ) throws BizException {
				     	
						return "admin/Projerct/insedtprt";
					}
									

					//do确认去去点位编辑
					@RequestMapping("insedtproject.do")
					public String isnedt(Project prt,Model m ) throws BizException {
						//把pointname保存下来
						 instUtils.limt.put("insid", prt.getId());
						 instUtils2.limt2.put("insprName", prt.getProjectName());	
						 instUtils2.limt2.put("insprequt", prt.getEquipmentName());
						 m.addAttribute("prt", prt);
						 m.addAttribute("equipments", eqBiz.selectAllEquplltNames() );						 
						return "admin/Projerct/edtprt";
					}
					
					
					
					//do点位编辑
					@PostMapping("edtproject.do")
					public String edtpoint(Project prt,Model m,Errors errors) {
						//执行点位修改
						if(errors.hasErrors()) {						
							m.addAttribute("errors", Utils.asMap(errors));
							m.addAttribute("prt",prt);				
						return "admin/Projerct/edtprt";
						}
						
						try {
									
							//根据id update
						pBiz.updatePrtById(prt);
						
						
						
						
						} catch (BizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息			
							errors.rejectValue("projectName", "projectName",e.getMessage());					   
							m.addAttribute("errors",Utils.asMap(errors));
							m.addAttribute("prt",prt);		
							 m.addAttribute("equipments", eqBiz.selectAllEquplltNames() );	
							return "admin/Projerct/edtprt";
						}
						return "admin/Projerct/succesetdt";
					}
					

}
