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
import com.yc.tc.equipment.biz.AssociatedBiz;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.EquipmentBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.StorageBiz;


@Controller
public class AssociatedAction {
	//依赖注入
	@Resource
	private  AssociatedBiz  aBiz;
	
	
   
	 //管理员端
	
	
	//去关联信息录入页面
			@GetMapping("toAssociated")
			public String touindex() {
				return "admin/inAssociated";
			}
			
			//关联信息录入
			@PostMapping("Associated.do")
			public String register(@Valid Associated asd,Errors errors,Model m) {
				if(errors.hasErrors()) {
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("asd",asd);
					return "admin/inAssociated";
				}
				
				try {
					System.out.println(asd.toString());	
					aBiz.addAsd(asd);
					//根据设备id传入关联id
					aBiz.addAsByid(asd.getAssociatedId());
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("asd",asd);
					return "admin/inAssociated";
				}
				//响应重定向  redirect:index
				return "admin/succeseinEpt";
			}


}
