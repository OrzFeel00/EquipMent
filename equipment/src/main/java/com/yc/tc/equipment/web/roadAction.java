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

import com.yc.tc.equipment.bean.BaseEquipment;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BaseEquipmentBiz;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.StorageBiz;
import com.yc.tc.equipment.biz.roadBiz;


@Controller
public class roadAction {
	//依赖注入
	@Resource
	private  roadBiz rBiz;
	
   
	        //管理员端
	
	
	        //去道路录入页面
			@GetMapping("toroad")
			public String touindex() {
				return "admin/road/inroad";
			}
			
			//道路信息录入
			@PostMapping("road.do")
			public String register(@Valid road roa,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("roa",roa);
					return "admin/road/inroad";
				}
				
				try {
					//输入道路
					rBiz.addRod(roa);
					//把对应id存入当前点位表中
					//rBiz.addRoadbyid(roa.getRoadId());
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					errors.rejectValue("roadName", "roadName",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("roa",roa);
					return "admin/road/inroad";
				}
				//响应重定向  redirect:index  
				return "admin/road/succeseinRoad";
			}
			
			
		//----------------------------------------------//
			
			
			//去街道show
			@GetMapping("toshowroad")
			public String toshowpoint(Model m ) throws BizException {
		
				//查询当前所有街道
				List<road>roadlist=rBiz.selectAllRoad();
				m.addAttribute("roadlist",roadlist);
				
				return "admin/road/showroad";
			}
			
			//do 街道查询
			@RequestMapping("showroad.do")
			public String showpoint( road road,Model m,Errors errors) {
				if(errors.hasErrors()) {
				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("road",road);
					return "admin/road/showroad";
				}
				
				try {
					//根据road查询
					List<road>  roadlist=rBiz.selectroadBymore(road);
					
					//放入点位信息
					m.addAttribute("roadlist",roadlist);
					 m.addAttribute("sorroad", road);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();						
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("road",road);
					return "admin/road/showroad";
				}
				
				return "admin/road/showroad";
			}
			
			
			
			
			 //去街道add页面
			@GetMapping("toaddroad")
			public String toaddpoint(Model m) {
				
				return "admin/road/addroad";
			}
			
			
			//do街道add
			@PostMapping("addroad.do")
			public String doaddpoint(@Valid road roa,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("roa",roa);
					return "admin/road/addroad";
				}
				
				try {
					
					//插入街道信息
					rBiz.addRod(roa);			    
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					errors.rejectValue("roadName", "roadName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("roa",roa);
					return "admin/road/addroad";
				}
				//响应重定向  redirect:index
				return "admin/road/addsucceseinRoad";
			}
			
			
			
			
			
			//去街道删除
			@RequestMapping("todellroad")
			public String todellpoint(Model m ) throws BizException {
				
				
				return "admin/road/dellroad";
			}
			
			//do街道删除
			@RequestMapping("dellroad.do")
			public String dellpoint(road road,Model m) throws BizException {
			
				System.out.println("删除道路"+road.toString());
		
		         
				rBiz.dellroad(road);
				//查询当前所有街道
				List<road>roadlist=rBiz.selectAllRoad();
				m.addAttribute("roadlist",roadlist);
				
				return "admin/road/dellsucceseinroad";
			}
			
			

			
			//去街道编辑(先去确认)
			@GetMapping("toedtroad")
			public String edt(Model m ) throws BizException {
		       		 
				return "admin/road/insedtroad";
			}
			
			
			//do确认去街道编辑
			@RequestMapping("insedtroad.do")
			public String isnedt(road road,Model m ) throws BizException {
				//把roadname保存下来
				 instUtils2.limt2.put("insroadname", road.getRoadName());	
				 
				 m.addAttribute("roa", road);
			
				return "admin/road/edtroad";
			}
			
			
			
			
			//do街道编辑
			@PostMapping("edtroad.do")
			public String edtpoint(road road,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("roa",road);
				return "admin/road/edtroad";
				}
				
				try {
				System.out.println("街道编辑开始"+road.toString());
				
					rBiz.updatePointById(road);
				
					//查询当前所有街道
					List<road>roadlist=rBiz.selectAllRoad();
					m.addAttribute("roadlist",roadlist);
				
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息			
					errors.rejectValue("roadName", "roadName",e.getMessage());				  
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("roa",road);		      
					return "admin/road/edtroad";
				}
				return "admin/road/succesetdtroad";
			}
			
			
			
			
			
			
			
			
			


}
