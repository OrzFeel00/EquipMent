package com.yc.tc.equipment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.tc.equipment.bean.Installation;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.Storage;
import com.yc.tc.equipment.bean.ip;
import com.yc.tc.equipment.bean.road;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.biz.InstallationBiz;
import com.yc.tc.equipment.biz.PointPositionBiz;
import com.yc.tc.equipment.biz.equiopmentallBiz;
import com.yc.tc.equipment.biz.roadBiz;
import com.yc.tc.equipment.util.Utils;
import com.yc.tc.equipment.util.instUtils;
import com.yc.tc.equipment.util.instUtils2;



@Controller
public class InstallationAction {
	//依赖注入
	@Resource
	private  PointPositionBiz pBiz;
	@Resource
	private  equiopmentallBiz eBiz;
	@Resource
	private  InstallationBiz  iBiz;
	
	
	
   
            //管理员端
	  
			
			   
			//----------------------//
			
			
			//去点位show
			@GetMapping("toshowinstall")
			public String toshowpoint(Model m ) throws BizException {
		
				//查询当前的所有install					
				m.addAttribute("installlist",iBiz.selectAllinstall());
				return "admin/Installation/showinstall";
			}
			
			//do点位查询
			@RequestMapping("showinstall.do")
			public String showpoint( Installation install,Model m,Errors errors) {
				if(errors.hasErrors()) {
				
					m.addAttribute("errors", Utils.asMap(errors));
					m.addAttribute("install",install);
					return "admin/Installation/showinstall";
				}
				
				try {
					
					//查询当前的ins			
					m.addAttribute("installlist",iBiz.selectinstallBymore(install));
					
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					errors.reject("pointnull",e.getMessage());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("install",install);
					return "admin/Installation/showinstall";
				}
				
				return "admin/Installation/showinstall";
			}
			
			
			
			
			 //去点位add页面
			@GetMapping("toaddinstall")
			public String toaddpoint(Model m) {
				 //all点位名称   //all车位名称
				 m.addAttribute("points", pBiz.selectAllPointNames());	
				 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				return "admin/Installation/addinstall";
			}
			
			
			//do insadd
			@PostMapping("addinstall.do")
			public String doaddpoint( @Validated Installation install,Errors errors,Model m) {
			
				
				try {
					System.out.println("insadd:::"+install);
					
					//插入ins信息
					iBiz.addinstall(install);
		            //记录ip信息
					iBiz.addip(install);
				    
				    
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 对应errors里的名称 不指定就是全部 3提示报错误的信息
					//errors.rejectValue("nonull", "null",e.getMessage()); 
					
					
					errors.rejectValue("pointName", "pointName",e.getMessage());
					 m.addAttribute("points", pBiz.selectAllPointNames());	
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
					m.addAttribute("errors",Utils.asMap(errors));
					m.addAttribute("install",install);
					return "admin/Installation/addinstall";
				}
				//响应重定向  redirect:index
				return "admin/Installation/addsucceseininstall";
			}
			
			
			
			
			
			//去点位删除
			@RequestMapping("todellinstall")
			public String todellpoint(Model m ) throws BizException {
				
				
				return "admin/Installation/dellinstall";
			}
			
			//do点位删除
			@RequestMapping("dellinstall.do")
			public String dellpoint(Installation install,Model m) throws BizException {
			
				//根据id得到完整的install
				Installation isn=iBiz.selectInstallById(install.getId());
				//删除根据id
				iBiz.dellinstall(install.getId());
				//每次删除的时候看看是不是最后删除，如果是，则删除ip表对应的设备和点位组
				iBiz.dellinsformip(isn);
				
				return "admin/Installation/dellsucceseininstall";
			}
			

			
			//去点位编辑(先去确认)
			@GetMapping("toedtinstall")
			public String edt(Model m ) throws BizException {
		       
				return "admin/Installation/insedtLaw";
			}
			

			//do确认去去ins编辑
			@RequestMapping("insedtinstall.do")
			public String isnedt(Installation install,Model m ) throws BizException {
				//把pointname保存下来
				 instUtils.limt.put("installId", install.getId());	
				 
				 //根据id得到完整的install
				
				 m.addAttribute("install", iBiz.selectInstallById(install.getId()));
				 
				 //all点位名称   //all车位名称
				 m.addAttribute("points", pBiz.selectAllPointNames());	
				 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				return "admin/Installation/edtinstall";
			}
			
			
			
			//do ins编辑
			@PostMapping("edtinstall.do")
			public String edtpoint(Installation install,Model m,Errors errors) {
				//执行点位修改
				if(errors.hasErrors()) {
				
					m.addAttribute("errors", Utils.asMap(errors));
					
					m.addAttribute("install",install);
				    m.addAttribute("points", pBiz.selectAllPointNames());	
					m.addAttribute("eptss", eBiz.selectAllEquplltNames());
				return "admin/Installation/edtinstall";
				}
				
				try {
					//设置id
					install.setId(instUtils.limt.get("installId")); 
					
				//System.out.println(pop.toString());
				iBiz.updateinstallById(install);
				iBiz.addip(install);
				
				
				
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//三个参数  1 属性名（实体字段名）  2 设定对应errors里的名称 不指定就是全部 3提示报错误的信息								   
					m.addAttribute("errors",Utils.asMap(errors));
					
					m.addAttribute("install",install);
					 m.addAttribute("points", pBiz.selectAllPointNames());	
					 m.addAttribute("eptss", eBiz.selectAllEquplltNames());
					return "admin/Installation/edtinstall";
				}
				return "admin/Installation/succesetdt";
			}
			
			
			
			//去ins 历史端口  确认
			@GetMapping("toinsprot")
			public String toinsprot(Model m ) throws BizException {
		       
				return "admin/Installation/insprot";
			}
			

			//do去ins 历史端口  确认
			@RequestMapping("insprot.do")
			public String insprotdo(ip ip,Model m ) throws BizException {
					
				 
				 //根据ip得到完整的ips
				
				  
				 m.addAttribute("ips", iBiz.selectipbyname(ip));
			
				return "admin/Installation/showprot2";
			}
			
			
			


}
