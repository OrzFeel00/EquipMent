package com.yc.tc.equipment.validation.validator;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yc.tc.equipment.validation.macvalid;



//第一个参数是你要针对的是那个注解，第二个是是什么类型的
public class macvalidForString implements ConstraintValidator<macvalid, String>{

	
	//初始化     ，会穿一个注解进来
	@Override
	public void initialize(macvalid constraintAnnotation) {
		// TODO Auto-generated method stub   compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
    //验证         ，把值传给你
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 Pattern pattern = Pattern.compile("^([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}$");
	        Matcher matcher = pattern.matcher(value);//创建Matcher对象
	        boolean b=matcher.matches();
	        
	        try {
	            if (!matcher.matches()) {//将字符串和模式匹配,符合规则为true,else false
	                return false;
	            } 
	           return true;
	        } catch (Exception e) {
	            return false;
	        }
	        
	    }
	



}
