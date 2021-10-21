package com.yc.tc.equipment.validation;


import static java.lang.annotation.ElementType.FIELD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.yc.tc.equipment.validation.validator.ipvalidForString;

//target表示该注解可以放在什么地方，method（方法） field（字段）  注解类型   构造器  参数   泛型   类
//@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE, TYPE })
@Target({FIELD })//我现在只希望放在字段上
@Retention(RUNTIME)//表示这个注解在运行时仍然可以生效
@Documented//注解会出现在生成的文档中
@Constraint(validatedBy = { ipvalidForString.class})//这里写实现类，可以是多个，实现ConstraintValidator接口

public @interface ipvalid {
	
	String message() default "必须是ip的格式";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
