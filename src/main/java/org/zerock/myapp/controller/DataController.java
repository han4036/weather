package org.zerock.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.service.WeatherService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@NoArgsConstructor
@Controller
@RequestMapping("/weather")
public class DataController {

	@Autowired
	WeatherService service2;
	
	
	@GetMapping("/lookup")
	public void re(String base_date, String category) throws Exception {
		log.debug("re(dto) invoked.");
		
		
		
//		WeatherDTO dto = this.service2.selectWeather(base_date, category);
//		
//		log.debug(dto);
		
		
//		return "/weather/result";
	}
	
}
