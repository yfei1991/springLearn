package com.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BatchCenterApp {
	public static void main(String[] args) {
		// 固定端口
		// SpringApplication.run(FileCenterApp.class, args);

		SpringApplication app = new SpringApplication(BatchCenterApp.class);
		ConfigurableApplicationContext context = app.run(args);
		context.close();
	}
}
 