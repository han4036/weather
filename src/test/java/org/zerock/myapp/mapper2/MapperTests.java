package org.zerock.myapp.mapper2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.mapper.WeatherMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
         "file:src/main/webapp/WEB-INF/spring/root-context.xml"
   })
public class MapperTests {
	
//	@Autowired
//	WeatherService2 service;
	
	@Autowired
	WeatherMapper mapper;
	
	
	@Before
	public void setup() throws Exception {
		log.debug("setup() invoked.");
		
		
	} // setup
	
	
	@Test
	public void mapperTest() throws Exception {
		log.debug("mapperTest() invoked.");
		
		WeatherDTO dto2 = new WeatherDTO();
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		
		sd.format(now);
		
		dto2.setDataType(1);
		dto2.setInputdatetime(sd.format(now));
		
		log.debug("success");
		
		
//		this.service.insertDate(dto2);
		this.mapper.insertDate(dto2);
		
	} // mapperTest
	
	
	@After
	public void tearDown() throws Exception {
		log.debug("tearDown() invoked.");
		
		
		
	} // tearDown
	
} // end class
