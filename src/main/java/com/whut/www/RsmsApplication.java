package com.whut.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.whut.www")
@MapperScan("com.whut.www.*")
public class RsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsmsApplication.class, args);
	}

}
