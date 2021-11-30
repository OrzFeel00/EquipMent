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
		 limt2.put(440303, "罗湖区"); 
		 limt2.put(440304, "福田区"); 
		 limt2.put(440305, "南山区"); 
		 limt2.put(440306, "宝安区");	 
		 limt2.put(440307, "龙岗区");  
		 limt2.put(440308, "盐田区");  
		 limt2.put(440309, "龙华区"); 
		 limt2.put(440310, "坪山区"); 
		 limt2.put(440311, "光明区"); 		 
		 limt2.put(440312, "大鹏新");  
	    }  
	
}
