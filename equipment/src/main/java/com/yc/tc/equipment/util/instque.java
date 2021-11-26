package com.yc.tc.equipment.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;


public class instque {

	/**   
	 *暂时根据名称归纳  区号
	 * @param 
	 * @returnconcurrenthashmap
	 */
	public static Map<Integer, String> limt2 ;
	
	 static  
	    {  
		 limt2 =  new ConcurrentHashMap<>();  
		 limt2.put(0, "龙华区");  
		 limt2.put(1, "龙岗区");  
		 limt2.put(2, "坪山区");  
		 limt2.put(3, "光明区");  
		 limt2.put(4, "盐田区");  
		 limt2.put(5, "南山区");  
		 limt2.put(6, "福田区");  
		 limt2.put(7, "宝安区");  
		 limt2.put(8, "罗湖区");  
		 limt2.put(9, "大鹏新");  
	    }  
	
}
