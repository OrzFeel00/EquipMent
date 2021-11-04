package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.roadBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;

@Controller
public class PointPositionAction {
	//依赖注入
	@Resource
	private  PointPositionBiz pBiz;
	@Resource
	private  roadBiz rBiz;
	
	
   
            //管理员端
	
	
	        //去点位输入页面
			@GetMapping("toPoint")
			public String touindex() {
				return "admin/inPoint";
			}
			
			//点位信息录入
			@PostMapping("Point.do")
			public String register(@Valid PointPosition pop,Errors errors,Model m) {
				if(errors.hasErrors()) {
					System.out.println("12222222"+pop.toString());
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("pop",pop);
					return "admin/inPoint";
				}
				
				try {
					System.out.println("22222222"+pop.toString());
					//插入点位信息
					pBiz.addPop(pop);
		            //点位id传入map中
				     instUtils.limt.put("point_id", pop.getPointId());
				     
				     Integer eqtid= instUtils.limt.get("point_id");
						System.out.println("刘浪"+eqtid);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
					System.out.println("32222222"+pop.toString());
					errors.rejectValue("pointName", "pointName",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("pop",pop);
					return "admin/inPoint";
				}
				//响应重定向  redirect:index
				return "admin/succeseinPoint";
			}
			
			   //去点位输入页面
						@GetMapping("tosucceseinPoint")
						public String tousucceseinPoint() {
							return "admin/succeseinPoint";
						}
			
			//去点位录入道路标识
			@GetMapping("torodtopoint")
			public String torodtoponit(Model m) {
				System.out.println(rBiz.selectAllRdNames());
				 m.addAttribute("roads", rBiz.selectAllRdNames());
				return "admin/inroadtoPoint";
			}
			
			//给点位录入道路标识
			@PostMapping("rodtopoint.do")
			public String rodtoponit(road roa,Model m) {				
			     //根据name写入roaid到point
				 rBiz.insetRidByname(roa.getRoadName());
				
				return "admin/inPoint";
			}
			


}
