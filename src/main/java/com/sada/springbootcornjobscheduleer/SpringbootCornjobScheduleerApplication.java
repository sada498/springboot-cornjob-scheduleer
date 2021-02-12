package com.sada.springbootcornjobscheduleer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static  final Logger LOGGER=LoggerFactory.getLogger(SpringbootCornjobScheduleerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCornjobScheduleerApplication.class, args);

	}

	@Configuration
	@EnableScheduling
	@ConditionalOnProperty(name = "scheduling.enabled",matchIfMissing = true)
	class SchedulingConfiguration{

	}

	/**
	 * by using @Scheduled to run methods
    */
//	@Scheduled(fixedRate = 2000L)
//	void someCornJob() throws  InterruptedException{
//		Date date=new Date();
//		String currentTime=String.valueOf(date);
//		//System.out.println("Australia current time :" + currentTime);
//	}
//
//	/**
//	 * add above method for thread sleep
//	*/
//	@Scheduled(initialDelay = 1000L,fixedRate = 2000L)
//	void someCornJobTread() throws  InterruptedException{
//		Date date=new Date();
//		String currentTime=String.valueOf(date);
//		//System.out.println("Australia current time :" + currentTime);
//		Thread.sleep(5000L);
//	}
//
//	/** By using java duration format for fixedDelayString
//	* For Example
//	* PT10M -> EVERY 10 minutes
//	* PT1H -> eVERY 1 Hour
//	*/
//	@Scheduled(initialDelay = 1000L,fixedDelayString = "PT1H")
//	void someCornJobTreadFixedDelayString() throws  InterruptedException{
//		Date date=new Date();
//		String currentTime=String.valueOf(date);
//		//System.out.println("Australia current time :" + currentTime);
//		Thread.sleep(5000L);
//	}
//	/**
//	 *By using Spring expression we can avoid the hard codded values
//	 * For example: ${someCornJob.delay}
//	 */
//	@Scheduled(initialDelay = 1000L,fixedDelayString = "${someCornJob.delay}")
//	void someCornJobTreadFixedDelayStringUsingApplicationProps() throws  InterruptedException{
//		Date date=new Date();
//		String currentTime=String.valueOf(date);
//		System.out.println("Australia current time :" + currentTime);
//		Thread.sleep(5000L);
//	}
//	/**
//	 *WE CAN USE CORN EXPRESSION ALSO
//	 * for example: corn= " * * * * * * "
//	 *                      S M H D M DW
//	 *      S- SECONDS
//	 *      M-MINUTES
//	 *      H-HOUR
//	 *      D-DAY
//	 *      M-MONTH
//	 *      DW-DAY OF THE WEEK
//	 * https://crontab.guru/
//	 * YOU CAN CHECK THE ABOVE WEB SITE TO CHECK YOUR CORN EXPRESSION TIME
// 	 */
//	//EX: every 5 min corn=" 0 */5 * * * *"
//	// Ex: every day 6pm ony on week days corn= "0 0 18 * * MON-FRI"
//
//	@Scheduled(initialDelay = 1000L,cron = "0 0 18 * * MON-FRI")
//	void someCornJobTreadFixedDelayStringWithCornExpression() throws  InterruptedException{
//		Date date=new Date();
//		String currentTime=String.valueOf(date);
//		//System.out.println("Australia current time :" + currentTime);
//		Thread.sleep(5000L);
//	}

	/**
	 * Note: All schedulers run on single thread by default
	 * To run the 2 methods parallel with @scheduler methods
	 * from spring 2.1 special name space for schedule tasks
	 * BY adding pool size "spring.task.scheduling.pol.size=10"
	 *  To test the below two method comment above all @scheduled method before test
	 */
	@Scheduled(fixedRate = 2000L)
	void someCornJobParallelTread1() throws  InterruptedException{
		Date date=new Date();
		String currentTime=String.valueOf(date);
		LOGGER.info("Australia current time (ParallelTread1):" + currentTime);
		//Thread.sleep(1000L);
	}
	@Scheduled(fixedRate = 2000L)
	void someCornJobParallelTread2() throws  InterruptedException{
		Date date=new Date();
		String currentTime=String.valueOf(date);
		LOGGER.info("Australia current time (ParallelTread2):" + currentTime);
		//Thread.sleep(1000L);
	}

}
