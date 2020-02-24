package com.chsi.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.*;

@SpringBootApplication
@EnableSwagger2
public class SkeletonApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkeletonApplication.class, args);
	}
}
