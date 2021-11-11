package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.biz.PointPositionBiz;


@Controller
public class EquipmentAction {
	//依赖注入
	@Resource
	private  EquipmentBiz  eBiz;
	
	
   
	 //管理员端
	
	
	//去设备输入页面
			@GetMapping("toEquipment")
			public String touindex() {
				return "admin/equipment/inEquipment";
			}
			
			//设备录入
			@PostMapping("inEquipment.do")
			public String register(@Valid Equipment eqt,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("eqt",eqt);
					return "admin/equipment/inEquipment";
				}
				
				try {
					eBiz.addEquip(eqt);
					//这里用mybatis返回了主键id给对应的bean
					System.out.println(eqt.getEquipmentId());
			    //写入设备id
				  instUtils.limt.put("Equipmentid", eqt.getEquipmentId());
				  
				  Integer eqtid= instUtils.limt.get("Equipmentid");
					System.out.println(eqtid);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					errors.rejectValue("equipmentName", "equipmentName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("eqt",eqt);
					return "admin/equipment/inEquipment";
				}
				//响应重定向  redirect:index   跳转到基础设备信息
				return "admin/BaseEquipment/inBaseEquipment";
			}


}
