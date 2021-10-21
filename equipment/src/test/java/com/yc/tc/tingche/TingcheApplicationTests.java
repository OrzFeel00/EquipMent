package com.yc.tc.tingche;

import javax.annotation.Resource;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.tc.equipment.bean.Ip;





@SpringBootTest
class TingcheApplicationTests {
	
	@Resource
    private Validator validator;
	
	@Test
	void contextLoads() {
		
		Ip  ip= new Ip();
		
		ip.setIp("1.2.33.123");
		System.out.println(ip+"*****");
	}
	
	
	
}
