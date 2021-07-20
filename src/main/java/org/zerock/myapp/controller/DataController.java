package org.zerock.myapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
	
	@GetMapping("/chart2")
	public void chart2( Model model, String date, String category) throws Exception {
		log.debug("chart2() invoked.");
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		Date day = new Date();
		
		String dd = sd.format(day);
		
		WeatherVO vo = new WeatherVO();
		
		if(date == "" || category == "") {
			
			vo.setCategory("온도");
			vo.setFcst_date(dd);
			
		} else {
			vo.setCategory(category);
			vo.setFcst_date(date);
		}
		
		List<WeatherVO> li = this.service2.selectWeather(vo);
		
		vo = li.get(0);
		
		int[] re = new int[24];
		
		String[] d1 = new String[24];
		
		for(int i=0; i<d1.length; ++i) {
			if(i<10) {
				d1[i] = "0"+String.valueOf(i)+":00";
			} else if(i>= 10) {
				d1[i] = String.valueOf(i)+":00";
			} // if
		} // for
		
		
		for(int i=0; i<d1.length; i++) {
			re[i] = i;
			
		} // for
		
		StringBuilder row = new StringBuilder();
		
		if(vo.getCategory().equals("온도")) {
			
			row.append("['시간', '온도'],");
			
			JSONArray body = new JSONArray();
			
			for(WeatherVO vo1 : li) {
				
				row.append("['"+d1[0]+"', " + vo1.getT00()+"],")
				   .append("['"+d1[1]+"', " + vo1.getT01()+"],")
				   .append("['"+d1[2]+"', " + vo1.getT02()+"],")
				   .append("['"+d1[3]+"', " + vo1.getT03()+"],")
				   .append("['"+d1[4]+"', " + vo1.getT04()+"],")
				   .append("['"+d1[5]+"', " + vo1.getT05()+"],")
				   .append("['"+d1[6]+"', " + vo1.getT06()+"],")
				   .append("['"+d1[7]+"', " + vo1.getT07()+"],")
				   .append("['"+d1[8]+"', " + vo1.getT08()+"],")
				   .append("['"+d1[9]+"', " + vo1.getT09()+"],")
				   .append("['"+d1[10]+"', " + vo1.getT10()+"],")
				   .append("['"+d1[11]+"', " + vo1.getT11()+"],")
				   .append("['"+d1[12]+"', " + vo1.getT12()+"],")
				   .append("['"+d1[13]+"', " + vo1.getT13()+"],")
				   .append("['"+d1[14]+"', " + vo1.getT14()+"],")
				   .append("['"+d1[15]+"', " + vo1.getT15()+"],")
				   .append("['"+d1[16]+"', " + vo1.getT16()+"],")
				   .append("['"+d1[17]+"', " + vo1.getT17()+"],")
				   .append("['"+d1[18]+"', " + vo1.getT18()+"],")
				   .append("['"+d1[19]+"', " + vo1.getT19()+"],")
				   .append("['"+d1[20]+"', " + vo1.getT20()+"],")
				   .append("['"+d1[21]+"', " + vo1.getT21()+"],")
				   .append("['"+d1[22]+"', " + vo1.getT22()+"],")
				   .append("['"+d1[23]+"', " + vo1.getT23()+"]");
				   
				System.out.println(row);
			}
		
		} else {
			row.append("['시간', '습도'],");
			
			JSONArray body = new JSONArray();
			
			for(WeatherVO vo1 : li) {
				
				row.append("['"+d1[0]+"', " + vo1.getT00()+"],")
				   .append("['"+d1[1]+"', " + vo1.getT01()+"],")
				   .append("['"+d1[2]+"', " + vo1.getT02()+"],")
				   .append("['"+d1[3]+"', " + vo1.getT03()+"],")
				   .append("['"+d1[4]+"', " + vo1.getT04()+"],")
				   .append("['"+d1[5]+"', " + vo1.getT05()+"],")
				   .append("['"+d1[6]+"', " + vo1.getT06()+"],")
				   .append("['"+d1[7]+"', " + vo1.getT07()+"],")
				   .append("['"+d1[8]+"', " + vo1.getT08()+"],")
				   .append("['"+d1[9]+"', " + vo1.getT09()+"],")
				   .append("['"+d1[10]+"', " + vo1.getT10()+"],")
				   .append("['"+d1[11]+"', " + vo1.getT11()+"],")
				   .append("['"+d1[12]+"', " + vo1.getT12()+"],")
				   .append("['"+d1[13]+"', " + vo1.getT13()+"],")
				   .append("['"+d1[14]+"', " + vo1.getT14()+"],")
				   .append("['"+d1[15]+"', " + vo1.getT15()+"],")
				   .append("['"+d1[16]+"', " + vo1.getT16()+"],")
				   .append("['"+d1[17]+"', " + vo1.getT17()+"],")
				   .append("['"+d1[18]+"', " + vo1.getT18()+"],")
				   .append("['"+d1[19]+"', " + vo1.getT19()+"],")
				   .append("['"+d1[20]+"', " + vo1.getT20()+"],")
				   .append("['"+d1[21]+"', " + vo1.getT21()+"],")
				   .append("['"+d1[22]+"', " + vo1.getT22()+"],")
				   .append("['"+d1[23]+"', " + vo1.getT23()+"]");
			}
		
		}
		
		model.addAttribute("row",row);
		model.addAttribute("date", date);
		model.addAttribute("cate", category);
		
	} // chart2
	
	
	@GetMapping("/chart")
	public void chart(WeatherVO vo, Model model) throws Exception {
		log.debug("chart() invoked.");
		
		
	} // chart
	
}
