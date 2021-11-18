package com.yc.tc.equipment.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.yc.tc.equipment.bean.Project;


public class instUtils3 {

	/**   
	 *暂时根据名称归纳 值  concurrenthashmap
	 * @param 
	 * @returnconcurrenthashmap
	 */
	public static Map<String, Project> limtpr = new ConcurrentHashMap<>();
	
	
}
