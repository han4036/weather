package org.zerock.myapp.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.log4j.Log4j;

@Log4j
@EnableScheduling
public class SchedulerTest {

	
	@Scheduled(fixedDelay=3000)
	public void autoLog() {
		
		System.out.println("Delay 3000");;
		
	}
	
	
}
