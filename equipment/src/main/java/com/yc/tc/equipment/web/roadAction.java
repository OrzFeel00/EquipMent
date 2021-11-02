package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.BaseEquipment;
import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BaseEquipmentBiz;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
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
				return "admin/inroad";
			}
			
			//道路信息录入
			@PostMapping("road.do")
			public String register(@Valid road roa,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("roa",roa);
					return "admin/inroad";
				}
				
				try {
					System.out.println(roa.toString());
					//输入道路
					rBiz.addRod(roa);
					//把对应id存入当前点位表中
					//rBiz.addRoadbyid(roa.getRoadId());
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					errors.rejectValue("roadCode", "roadCode",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("roa",roa);
					return "admin/inroad";
				}
				//响应重定向  redirect:index  
				return "admin/succeseinRoad";
			}


}
