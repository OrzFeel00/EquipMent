package com.yc.tc.equipment.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yc.tc.equipment.biz.PointPositionBiz;

@Controller
public class PointPositionAction {
	//依赖注入
	@Resource
	private  PointPositionBiz Pop;
	

}
