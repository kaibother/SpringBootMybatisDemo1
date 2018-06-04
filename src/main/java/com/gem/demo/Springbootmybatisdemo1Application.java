package com.gem.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gem.demo.dao")//去实例化接口实现类的对象
public class Springbootmybatisdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootmybatisdemo1Application.class, args);
	}
}
