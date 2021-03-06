package com.yc.tc.equipment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.tc.equipment.bean.Associated;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.euiopmentall;
import com.yc.tc.equipment.biz.AssociatedBiz;
import com.yc.tc.equipment.biz.BaseEquipmentBiz;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;

import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.StorageBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;


@Controller
public class EquipmentAction {
	//依赖注入
	@Resource
	private  EquipmentBiz  eBiz;
	@Resource
	private  AssociatedBiz  aBiz;
	@Resource
	private  StorageBiz  sBiz;
	@Resource
	private  BaseEquipmentBiz  bBiz;
	@Resource
	private  equiopmentallBiz eqBiz;
	
	
   
	 //管理员端
	
	
	//去设备输入页面
			@GetMapping("toEquipment")
			public String touindex() {
				return "admin/equipment/inEquipment";
			}
			
			//设备录入
			@PostMapping("inEquipment.do")
			public String register( euiopmentall eptr,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/equipment/inEquipment";
				}
				
				try {
					//插入设备信息
					eqBiz.addeptmor(eptr);
					
			    //写入设备id
				  instUtils.limt.put("inEquipmentid", eptr.getEquipmentId());
				  
				  Integer eqtid= instUtils.limt.get("Equipmentid");
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					errors.rejectValue("equipmentName", "equipmentName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/equipment/inEquipment";
				}
				//响应重定向  redirect:index   跳转到基础设备信息
				return "admin/associated/inAssociated";  
			}
			
			   
			//----------------------//
			
			
			//去设备show
			@GetMapping("toshowept")
			public String toshowpoint(Model m ) throws BizException {
				//查询当前全部基础信息		  
				m.addAttribute("e",eqBiz.selectAllEptmor());	
				
				return "admin/equipment/showequipment";
			}
			
			//do设备查询
			@RequestMapping("showequipment.do")
			public String showpoint( euiopmentall eptr,Model m,Errors errors) {
				if(errors.hasErrors()) {

					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/equipment/showequipment";
				}
				
				try {
			
				    		
					//查询搜索结果放入m
					m.addAttribute("e",eqBiz.selectEptrBymore(eptr));
					m.addAttribute("soreptr", eptr);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					errors.reject("pointnull",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/equipment/showequipment";
				}
				
				return "admin/equipment/showequipment";
			}
			
			
			
			
			 //去点位add页面
			@GetMapping("toaddequipmentmor")
			public String toaddpoint(Model m) {
				 
				return "admin/equipment/addEquipmentmor";
			}
			
			
			//do点位add
			@PostMapping("addequipmentmor.do")
			public String doaddpoint(@Valid euiopmentall eptr,Errors errors,Model m) {
				
				
				try {
					
					
					//插入设备信息
					eqBiz.addeptmor(eptr);
		            //点位id传入map中
				     instUtils.limt.put("eptrrid", eptr.getEquipmentId());
				    
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 			
					errors.rejectValue("equipmentName", "equipmentName",e.getMessage());	
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
					return "admin/equipment/addEquipmentmor";
				}
				//响应重定向  redirect:index
				return "admin/associated/addaddAssociatedmor";
			}
			
			
			
			
			
			//去点位删除
			@RequestMapping("todellequipment")
			public String todellpoint(Model m ) throws BizException {
				
				
				return "admin/equipment/dellequipment";
			}
			
			//do点位删除
			@RequestMapping("dellequipment.do")
			public String dellpoint(euiopmentall eptr,Model m) throws BizException {
				
				eqBiz.dellpoint(eptr);
				
				
				return "admin/equipment/dellsucceseinequipment";
			}
			

			
			//去设备编辑(先去确认)
			@GetMapping("toedtequipment")
			public String edt(Model m ) throws BizException {
		       
				 
				return "admin/equipment/insedtequipment";
			}
			

			//do确认去去点位编辑
			@RequestMapping("insedtequipment.do")
			public String isnedt(euiopmentall eptr,Model m ) throws BizException {		
				 //根据id得到单个完整的eptr  放入m	  	
				 instUtils.limt.put("edteptrrid", eptr.getEquipmentId());		 
				 instUtils2.limt2.put("EquipmentCode", eptr.getEquipmentCode());	 
				 instUtils2.limt2.put("EquipmentName", eptr.getEquipmentName());			 
				 m.addAttribute("eptr", eqBiz.selecteptrbyid(eptr.getEquipmentId()));	 
				 
				
				 String sn=eqBiz.selecteptrbyid(eptr.getEquipmentId()).getSn();
				 if(sn==null) {
					 sn="nullsn";
				 }
				
                 instUtils2.limt2.put("eptSn", sn);
                 
				return "admin/equipment/edtequipment";
			}
			
			
			
			//do设备编辑
			@PostMapping("edtequipment.do")
			public String edtpoint(euiopmentall eptr,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
				  
				return "admin/equipment/edtequipment";
				}
				try {
					
				 Integer eptrrid= instUtils.limt.get("edteptrrid");
			     eptr.setEquipmentId(eptrrid);
					 
				eqBiz.updateEptrById(eptr);
				
				//放入单个完整的eptr到m
				 m.addAttribute("eptr",eqBiz.selecteptrbyid(eptrrid));
				
		
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息			
					errors.rejectValue("equipmentName", "equipmentName",e.getMessage());		
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eptr",eptr);
			     
					return "admin/equipment/edtequipment";
				}
				return "admin/associated/edtAssociatedmor";
			}


}
