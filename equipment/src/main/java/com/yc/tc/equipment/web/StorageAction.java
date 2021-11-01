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
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.StorageBiz;


@Controller
public class StorageAction {
	//依赖注入
	@Resource
	private  StorageBiz  sBiz;
	
	
   
	 //管理员端
	
	
	//去存储信息录入页面
			@GetMapping("toStorage")
			public String touindex() {
				return "admin/inStorage";
			}
			
			//存储信息录入
			@PostMapping("Storage.do")
			public String register(@Valid Storage sto,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("sto",sto);
					return "admin/inEquipment";
				}
				
				try {
					System.out.println(sto.toString());
					sBiz.addSto(sto);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("sto",sto);
					return "admin/inStorage";
				}
				//响应重定向  redirect:index
				return "admin/inStorage";
			}


}
