package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.WeatherVO;
import org.zerock.myapp.service.WeatherService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@NoArgsConstructor
@Controller
@RequestMapping("/chart")
public class DataController {

	@Autowired
	WeatherService service2;
	
	
	@GetMapping("/chart")
	public ModelAndView chart(WeatherVO vo, Model model) throws Exception {
		log.debug("chart() invoked.");
		
		String dt = "20210714";
		vo.setBase_date(dt);
		
		ModelAndView mv = new ModelAndView();
		
		List<WeatherVO> li = this.service2.selectWeather(vo);
		
		int num = 0;
		
		log.debug(vo.toString());
		
		mv.addObject("list", li);
		mv.setViewName("/chart/chart");
		
		StringBuilder str = new StringBuilder();
		
		str.append("[")
		   .append("['날짜', '날씨정보', '00시', '01시', '02시', '03시', '04시', '05시', '06시', '07시', '08시', '09시', '10시',")
		   .append(" '11시', '12시', '13시', '14시', '15시', '16시', '17시', '18시', '19시', '20시', '21시', '22시', '23시'],");
		
		for(WeatherVO vo1 : li) {
			str.append("['");
			   
		}
		
		
		
		return mv;
	} // chart
	
}
