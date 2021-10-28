package com.yc.tc.equipment.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.tc.equipment.biz.PointPositionBiz;

@Controller
public class PointPositionAction {
	//依赖注入
	@Resource
	private  PointPositionBiz Pop;
	
	
   
	 //管理员端
	
	
	//去点位输入页面
			@GetMapping("inPoint")
			public String touindex() {
				return "admin/inPoint";
			}


}
