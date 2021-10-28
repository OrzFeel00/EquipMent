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
	
	

	//去首登录页面
			@GetMapping("inPoint.html")
			public String touindex() {
				return "admin/inPoint";
			}


}
