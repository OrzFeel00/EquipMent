package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.Associated;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.biz.AssociatedBiz;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.StorageBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;


@Controller
public class AssociatedAction {
	//依赖注入
	@Resource
	private  AssociatedBiz  aBiz;
	
	@Resource
	private  equiopmentallBiz eqBiz;
   
	 //管理员端
	
	
	//去关联信息录入页面
			@GetMapping("toAssociated")
			public String touindex() {
				return "admin/associated/inAssociated";
			}
			
			//关联信息录入
			@PostMapping("Associated.do")
			public String inregister( euiopmentall eptr,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/associated/inAssociated";
				}
				
				try {
				
					
					aBiz.inaddAsd(eptr);
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/associated/inAssociated";
				}
				//响应重定向  redirect:index  
				return "admin/Storage/inStorage";
			}
			
			
			
			//关联信息add
			@PostMapping("addAssociated.do")
			public String register( euiopmentall eptr,Errors errors,Model m) {
				if(errors.hasErrors()) {
					
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/associated/addaddAssociatedmor";
				}
				
				try {
					
					aBiz.addAsdtr(eptr);
					//根据设备id传入关联id
				
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					errors.rejectValue(null, "null",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/associated/addaddAssociatedmor";
				}
				//响应重定向  redirect:index
				return "admin/Storage/addStorage";
			}
			
			

			//关联信息edt
			@PostMapping("edtAssociated.do")
			public String edtpoint(euiopmentall eptr,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
				  
				return "admin/associated/edtAssociatedmor";
				}
				try {
					Integer eptrrid= instUtils.limt.get("edteptrrid");
					 eptr.setEquipmentId(eptrrid);

				aBiz.updatAssocById(eptr);
				//放入单个完整的eptr到m
				 m.addAttribute("eptr",eqBiz.selecteptrbyid(eptrrid));
				
				 
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息			
					errors.rejectValue("pointName", "pointName",e.getMessage());		
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
			     
					return "admin/associated/edtAssociatedmor";
				}
				return "admin/Storage/edtStorage";
			}

			
			
			
			
			
			


}
