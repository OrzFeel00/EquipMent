package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.StorageBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;


@Controller
public class StorageAction {
	//依赖注入
	@Resource
	private  StorageBiz  sBiz;
	@Resource
	private  equiopmentallBiz eqBiz;
	
   
	 //管理员端
	
	
	//去存储信息录入页面
			@GetMapping("toStorage")
			public String touindex() {
				return "admin/Storage/inStorage";
			}
			
			//存储信息录入
			@PostMapping("Storage.do")
			public String inregister( euiopmentall eptr,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/Storage/inStorage";
				}
				
				try {
					sBiz.inaddSto(eptr);
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/Storage/inStorage";
				}
				//响应重定向  redirect:index
				return "admin/BaseEquipment/inBaseEquipment";
			}
			
			
			
			//关存储add
			@PostMapping("addStorage.do")
			public String register( euiopmentall eptr,Errors errors,Model m) {
				if(errors.hasErrors()) {
					System.out.println(errors);
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/associated/addaddAssociatedmor";
				}
				try {
					
				
					sBiz.addStor(eptr);
	
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/Storage/addStorage";
				}
				//响应重定向  redirect:index
				return "admin/BaseEquipment/addEquipmentmor";
			}
			
			
			//关联存储edt
			@PostMapping("edtStorage.do")
			public String edtpoint(euiopmentall eptr,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
				  
				return "admin/Storage/edtStorage";
				}
				try {
					Integer eptrrid= instUtils.limt.get("edteptrrid");
					 eptr.setEquipmentId(eptrrid);

				sBiz.updatStorById(eptr);
				//放入单个完整的eptr到m
				 m.addAttribute("eptr",eqBiz.selecteptrbyid(eptrrid));
		
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息			
					//errors.rejectValue("pointName", "pointName",e.getMessage());		
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
			     
					return "admin/Storage/edtStorage";
				}
				return "admin/BaseEquipment/edtEquipmentmor";
			}


}
