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
import com.yc.tc.equipment.bean.Law;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.LawBiz;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;
import com.yc.tc.equipment.biz.roadBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



@Controller
public class LawAction {
	//依赖注入
	@Resource
	private  equiopmentallBiz eBiz;
	@Resource
	private  LawBiz lBiz;
	
	
   
            //管理员端
		

      
      
			//----------------------//
			
			
			//去law show
			@GetMapping("toshowLaw")
			public String toshowLaw(Model m ) throws BizException {
		
				//查询当前的所有law					
				m.addAttribute("lawlist",lBiz.selectALLLaws());
				return "admin/Law/showLaw";
			}
			
			//do点位查询
			@RequestMapping("showLaw.do")
			public String showpoint( Law law,Model m,Errors errors) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("law",law);
					return "admin/Law/showLaw";
				}
				
				try {
					
					
					//查询当前的有的law									
					m.addAttribute("lawlist",lBiz.selectLawBymor(law));
					 m.addAttribute("sorlaw", law);
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					errors.reject("pointnull",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("law",law);
					return "admin/Law/showLaw";
				}
				
				return "admin/Law/showLaw";
			}
			
			
			
			
			 //去点位add页面
			@GetMapping("toaddLaw")
			public String toaddpoint(Model m) throws BizException {
				 //所有设备名称
				 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				return "admin/Law/addLaw";
			}
			
			
			//do点位add
			@PostMapping("addLaw.do")
			public String doaddpoint(@Valid Law law,Errors errors,Model m) throws BizException {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("law",law);
				   
	
				    m.addAttribute("eptss", eBiz.selectAllEptmor());
					return "admin/Law/addLaw";
				}
				
				try {	
				    //插入点位信息
					lBiz.addLaw(law);
		        
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("law",law);
					return "admin/Law/addLaw";
				}
				//响应重定向  redirect:index
				return "admin/Law/addsucceseinLaw";
			}
			
			
			
			
			
			//去点位删除
			@RequestMapping("todellLaw")
			public String todellpoint(Model m ) throws BizException {
				
				
				return "admin/Law/dellLaw";
			}
			
			//do点位删除
			@RequestMapping("dellLaw.do")
			public String dellpoint(Law law,Model m) throws BizException {
				
				lBiz.dellLaw(law.getId());
				//查询当前的有的law									
				m.addAttribute("lawlist",lBiz.selectLawBymor(law));
				
				return "admin/Law/dellsucceseinLaw";
			}
			

			
			//去点位编辑(先去确认)
			@GetMapping("toedtLaw")
			public String edt(Model m ) throws BizException {
		       
				//所有设备名称
				 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				return "admin/Law/edtLaw";
			}
			
			
			
			//do点位编辑
			@PostMapping("edtLaw.do")
			public String edtpoint(Law law,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("law",law);
					//所有设备名称
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				return "admin/Law/edtLaw";
				}
				
				try {
		
				//System.out.println(pop.toString());
				lBiz.updateLawById(law);
				
				//查询当前的有的law									
				m.addAttribute("lawlist",lBiz.selectLawBymor(law));
				
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息					
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("law",law);
					//所有设备名称
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
					return "admin/Law/edtLaw";
				}
				return "admin/Law/succesetdt";
			}
			
			
			
			


}
