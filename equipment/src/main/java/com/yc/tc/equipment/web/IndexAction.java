package com.yc.tc.equipment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;


@Controller
public class IndexAction {
	

	//去首登录页面
			@GetMapping("touIndex.html")
			public String touindex() {
				return "uindex";
			}


		
		
	
}
