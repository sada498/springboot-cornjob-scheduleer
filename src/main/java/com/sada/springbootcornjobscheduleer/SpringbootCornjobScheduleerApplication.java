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
		//System.out.println("Australia current time :" + currentTime);
	}

	// add above method for thread sleep
	//
	@Scheduled(initialDelay = 1000L,fixedRate = 2000L)
	void someCornJobTread() throws  InterruptedException{
		Date date=new Date();
		String currentTime=String.valueOf(date);
		System.out.println("Australia current time :" + currentTime);
		Thread.sleep(5000L);
	}

	/* By using java duration format for fixedDelayString
	* For Example
	* PT10M -> EVERY 10 minutes
	* PT1H -> eVERY 1 Hour
	*/
	@Scheduled(initialDelay = 1000L,fixedDelayString = "PH1H")
	void someCornJobTreadFixedDelayString() throws  InterruptedException{
		Date date=new Date();
		String currentTime=String.valueOf(date);
		System.out.println("Australia current time :" + currentTime);
		Thread.sleep(5000L);
	}


}
