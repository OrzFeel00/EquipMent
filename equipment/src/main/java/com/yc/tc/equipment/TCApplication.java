package com.yc.tc.equipment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * mubaits命名空间注册
 * @author lenovo
 *
 */
@MapperScan("com.yc.tc.equipment.dao")
public class TCApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TCApplication.class, args);
	}

	
}
