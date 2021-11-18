package com.yc.tc.equipment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.roadBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



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
			public String touindex(Model m) {
				 m.addAttribute("roads", rBiz.selectAllRdNames());
				return "admin/point/inPoint";
			}
			
			
			
			//do点位信息录入
			@RequestMapping("Point.do")
			public String register(@Valid PointPosition pop,Errors errors,Model m) {
			if(errors.hasErrors()) {
					System.out.println("12222222"+pop.toString());
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("pop",pop);
				 m.addAttribute("roads", rBiz.selectAllRdNames());
				return "admin/point/inPoint";
				}
				
				try {
					
					System.out.println("22222222"+pop.toString());
					//插入点位信息
					pBiz.addPop(pop);
		            //点位id传入map中
				     instUtils.limt.put("point_id", pop.getPointId());
				     
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
					
					errors.rejectValue("pointName", "pointName",e.getMessage());
				    m.addAttribute("roads", rBiz.selectAllRdNames());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("pop",pop);
					return "admin/point/inPoint";
				}
				//响应重定向  redirect:index
				return "admin/point/succeseinPoint";
			}
			
			   
			//----------------------//
			
			
			//去点位show
			@GetMapping("toshowpoint")
			public String toshowpoint(Model m ) throws BizException {
		
				//查询当前的所有点位					
				List<PointPosition> pointlist=pBiz.selectAllPoint();
				m.addAttribute("pointlist",pointlist);
				return "admin/point/showpoint";
			}
			
			//do点位查询
			@RequestMapping("showpoint.do")
			public String showpoint( PointPosition pop,Model m,Errors errors) {
				if(errors.hasErrors()) {
					System.out.println("12222222"+pop.toString());
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("pop",pop);
					return "admin/point/showpoint";
				}
				
				try {
					
					//根据pop查询
					List<PointPosition> pointlistmore =pBiz.selectpointBymore(pop);
					
					//查询当前的所有点位					
					//List<PointPosition> pointlist=pBiz.selectAllPoint();
					m.addAttribute("pointlist",pointlistmore);
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
					System.out.println("32222222"+pop.toString());
					errors.rejectValue("pointName", "pointName",e.getMessage());
					errors.reject("pointnull",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("pop",pop);
					return "admin/point/showpoint";
				}
				
				return "admin/point/showpoint";
			}
			
			
			
			
			 //去点位add页面
			@GetMapping("toaddpoint")
			public String toaddpoint(Model m) {
				 m.addAttribute("roads", rBiz.selectAllRdNames());
				return "admin/point/addpoint";
			}
			
			
			//do点位add
			@PostMapping("addPoint.do")
			public String doaddpoint(@Valid PointPosition pop,Errors errors,Model m) {
				if(errors.hasErrors()) {
					System.out.println("12222222"+pop.toString());
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("pop",pop);
					 m.addAttribute("roads", rBiz.selectAllRdNames());
					return "admin/point/addpoint";
				}
				
				try {
					
					System.out.println("22222222"+pop.toString());
					//插入点位信息
					pBiz.addPop(pop);
		            //点位id传入map中
				     instUtils.limt.put("point_id", pop.getPointId());
				    
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
					System.out.println("32222222"+pop.toString());
					errors.rejectValue("pointName", "pointName",e.getMessage());
				    m.addAttribute("roads", rBiz.selectAllRdNames());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("pop",pop);
					return "admin/point/addpoint";
				}
				//响应重定向  redirect:index
				return "admin/point/addsucceseinPoint";
			}
			
			
			
			
			
			//去点位删除
			@RequestMapping("todellpoint")
			public String todellpoint(Model m ) throws BizException {
				
				
				return "admin/point/dellpoint";
			}
			
			//do点位删除
			@RequestMapping("dellpoint.do")
			public String dellpoint(PointPosition pop,Model m) throws BizException {
				System.out.println("ssss");
				System.out.println("ssss"+pop.toString());
				pBiz.dellpoint(pop);
				//查询当前的所有点位					
				List<PointPosition> pointlist=pBiz.selectAllPoint();
				m.addAttribute("pointlist",pointlist);
				
				return "admin/point/dellsucceseinPoint2";
			}
			

			
			//去点位编辑(先去确认)
			@GetMapping("toedtpoint")
			public String edt(Model m ) throws BizException {
		       
				 
				 m.addAttribute("edtroads", rBiz.selectAllRdNames());
				return "admin/point/insedtpoint";
			}
			

			//do确认去去点位编辑
			@RequestMapping("insedtpoint.do")
			public String isnedt(PointPosition pop,Model m ) throws BizException {
				//把pointname保存下来
				 instUtils2.limt2.put("inspointname", pop.getPointName());	
				 
				 m.addAttribute("pop", pop);
				 m.addAttribute("edtroads", rBiz.selectAllRdNames());
				return "admin/point/edtpoint";
			}
			
			
			
			//do点位编辑
			@PostMapping("edtpoint.do")
			public String edtpoint(PointPosition pop,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {
					System.out.println("12222222"+pop.toString());
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("pop",pop);
				    m.addAttribute("roads", rBiz.selectAllRdNames());
				return "admin/point/edtpoint";
				}
				
				try {
		
				//System.out.println(pop.toString());
				pBiz.updatePointById(pop);
				
				//查询当前的所有点位					
				List<PointPosition> pointlist=pBiz.selectAllPoint();
				m.addAttribute("pointlist",pointlist);
				//redirect:admin/succeseinPoint
				
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息			
					errors.rejectValue("pointName", "pointName",e.getMessage());
				    m.addAttribute("roads", rBiz.selectAllRdNames());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("pop",pop);
			        m.addAttribute("edtroads", rBiz.selectAllRdNames());
					return "admin/point/edtpoint";
				}
				return "admin/point/succesetdt";
			}
			
			
			
			


}
