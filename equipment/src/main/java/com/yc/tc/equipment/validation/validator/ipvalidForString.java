package com.yc.tc.equipment.validation.validator;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yc.tc.equipment.validation.ipvalid;
//第一个参数是你要针对的是那个注解，第二个是是什么类型的
public class ipvalidForString implements ConstraintValidator<ipvalid, String>{

	
	//初始化     ，会穿一个注解进来
	@Override
	public void initialize(ipvalid constraintAnnotation) {
		// TODO Auto-generated method stub   compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
    //验证         ，把值传给你
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 Pattern pattern = Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
	        Matcher matcher = pattern.matcher(value);
	        
	        try {
	            if (!matcher.matches()) {
	                return false;
	            } else {
	                for (int i = 1; i <= 4; i++) {
	                    int octet = Integer.valueOf(matcher.group(i));
	                    if (octet > 255) {
	                        return false;
	                    }
	                }
	                return true;
	            }
	        } catch (Exception e) {
	            return false;
	        }
	        
	    }
	



}
