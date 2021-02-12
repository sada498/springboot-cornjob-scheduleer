package com.sada.springbootcornjobscheduleer;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication

public class SpringbootCornjobScheduleerApplication {

	Date date=new Date();
	String currentTime=String.valueOf(date);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCornjobScheduleerApplication.class, args);
		System.out.println("hello");
	}

	@Configuration
	@EnableScheduling
	@ConditionalOnProperty(name = "scheduling.enabled",matchIfMissing = true)
	class SchedulingConfiguration{

	}

	// by using @Scheduled to run methods

	@Scheduled(fixedRate = 2000L)
	void someCornJob() throws  InterruptedException{
		Date date=new Date();
		String currentTime=String.valueOf(date);
		System.out.println("Australia current time :" + currentTime);

	}



}
