package com.yc.tc.equipment.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.tc.equipment.bean.Admin;
import com.yc.tc.equipment.biz.AdminBiz;
import com.yc.tc.equipment.biz.BizException;
import com.yc.tc.equipment.util.Utils;


@Controller
public class AdminAction {
	
	@Resource
	private AdminBiz aBiz;
	
	//去管理员登录页面
	@GetMapping("toadlogin")
	public String  AdminLgin(@Valid Admin adm,Errors errors,Model m) {

	
		return "admin/login";
	}
	//后台管理员登录页面
	@PostMapping("adlogin.do")
	public String login( Admin adm,Errors errors, HttpSession session,Model m) {
		if(errors.hasErrors()) {
			m.addAttribute("errors", Utils.asMap(errors));
			m.addAttribute("adm",adm);
	
			return "ulogin.html";
			
		}try {
			
			Admin admed= aBiz.Alogin(adm);
		    session.setAttribute("adlogined", admed);
	     	m.addAttribute("adlduser",admed);
	     	
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
			//三个参数  1 错误的字段名（属性名称）  2 错误代号 不指定就是全部 3错误的信息
		    errors.rejectValue("adm", "adm",e.getMessage());
		    
		    
			m.addAttribute("errors",Utils.asMap(errors));
			m.addAttribute("adm",adm);
	
        	return "admin/login";
		}
         
		
         return "admin/Index";
		
	}
	

}
