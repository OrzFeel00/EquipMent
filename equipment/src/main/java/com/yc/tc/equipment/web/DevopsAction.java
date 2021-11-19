package com.yc.tc.equipment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.tc.equipment.bean.Devops;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.DevopsBiz;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.ProjectBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;
import com.yc.tc.equipment.biz.roadBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



@Controller
public class DevopsAction {
	//依赖注入
	@Resource
	private  PointPositionBiz pBiz;
	@Resource
	private  ProjectBiz prBiz;
	@Resource
	private  equiopmentallBiz eBiz;
	@Resource
	private  DevopsBiz dBiz;
	
	
	
   
            //管理员端

			   
			//----------------------//
			
			
			//去点位show
			@GetMapping("toshowtoDevop")
			public String toshowpoint(Model m ) throws BizException {
		
				//查询当前的所有devop				
				m.addAttribute("devoplist",dBiz.selectAllDevop());
				return "admin/Devops/showDevop";
			}
			
			//do点位查询
			@RequestMapping("showtoDevop.do")
			public String showpoint( Devops dep,Model m,Errors errors) {
				if(errors.hasErrors()) {
					
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("dep",dep);
					return "admin/Devops/showDevop";
				}
				
				try {
					
					//根据dep查询
					m.addAttribute("devoplist",dBiz.selectDevopBymore(dep));
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
				
					errors.reject("pointnull",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("dep",dep);
					return "admin/Devops/showDevop";
				}
				
				return "admin/Devops/showDevop";
			}
			
			
			
			
			 //去点位add页面
			@GetMapping("toaddtoDevop")
			public String toaddpoint(Model m) {
				 //all点位名称   //all车位名称   //all项目名称
				 m.addAttribute("points", pBiz.selectAllPointNames());	
				 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				 m.addAttribute("prts", prBiz.selectAllProjectNames());
				return "admin/Devops/adddep";
			}
			
			
			//do运维add
			@PostMapping("addtoDevop.do")
			public String doaddpoint(@Valid Devops dep,Errors errors,Model m) {
				if(errors.hasErrors()) {
					 m.addAttribute("errors", Utils.asMap(errors));
				     m.addAttribute("dep",dep);
					 m.addAttribute("points", pBiz.selectAllPointNames());	
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
					 m.addAttribute("prts", prBiz.selectAllProjectNames());
					return "admin/Devops/adddep";
				}
				
				try {
					System.out.println("do运维add"+dep);
			        //插入点位信息
					dBiz.adddep(dep);
				    
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 

					errors.rejectValue("pointName", "pointName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("dep",dep);
					 m.addAttribute("points", pBiz.selectAllPointNames());	
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
					 m.addAttribute("prts", prBiz.selectAllProjectNames());
					return "admin/Devops/adddep";
				}
				//响应重定向  redirect:index
				return "admin/Devops/addsucceseindep";
			}
			
			
			
			
			
			//去运维删除
			@RequestMapping("todelltoDevop")
			public String todellpoint(Model m ) throws BizException {
				
				
				return "admin/Devops/delldep";
			}
			
			//do运维删除
			@RequestMapping("delltoDevop.do")
			public String dellpoint(Devops dep,Model m) throws BizException {
			
				dBiz.delldep(dep.getDevopsId());
				
				
				return "admin/Devops/dellsucceseindep";
			}
			

			
			//去点位编辑(不怕重复)
			@GetMapping("toedttoDevop")
			public String edt(Model m ) throws BizException {
				 m.addAttribute("points", pBiz.selectAllPointNames());	
				 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				 m.addAttribute("prts", prBiz.selectAllProjectNames());
				return "admin/Devops/edtdevop";
			}
				
			
			//do点位编辑
			@PostMapping("edttoDevop.do")
			public String edtpoint(@Valid Devops dep,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {
					
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("dep",dep);
					m.addAttribute("points", pBiz.selectAllPointNames());	
				    m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				    m.addAttribute("prts", prBiz.selectAllProjectNames());
				return "admin/Devops/edtdevop";
				}
				
				try {
		
				//System.out.println(pop.toString());
				dBiz.updateDevopsById(dep);
						
				
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息							  
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("dep",dep);
					m.addAttribute("points", pBiz.selectAllPointNames());	
					m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				    m.addAttribute("prts", prBiz.selectAllProjectNames());
					return "admin/Devops/edtdevop";
				}
				return "admin/Devops/succesetdt";
			}
			
			
			
			


}
