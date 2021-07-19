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
	public void chart2(WeatherVO vo, Model model) throws Exception {
		log.debug("chart2() invoked.");
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		Date day = new Date();
		
		String dd = sd.format(day);
		
		
		vo.setCategory("온도");
		vo.setFcst_date(dd);
		
		List<WeatherVO> li = this.service2.selectWeather(vo);
		
		vo = li.get(0);
		
		JSONObject jo = new JSONObject();
		
		String json = "";
		
		JSONParser jp = new JSONParser();
		
		System.out.println(">>>>vo" );
		
		int[] re = new int[24];
		
		String[] d1 = new String[24];
		
		for(int i=0; i<d1.length; ++i) {
			if(i<10) {
				d1[i] = "0"+String.valueOf(i)+":00";
			} else if(i>= 10) {
				d1[i] = String.valueOf(i)+":00";
			}
		}
		
		
		for(int i=0; i<d1.length; i++) {
			re[i] = i;
			
			System.out.print(" "+re[i]);
		}
		
		
		System.out.println("xxxxxxxxxxxxxxx"+d1[23]);
		
		StringBuilder row = new StringBuilder();
		
		if(vo.getCategory().equals("습도")) {
			
		}
			
		
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
		
		
		
		
		
		model.addAttribute("row",row);
		
	} // chart2
	
	
	@GetMapping("/chart")
	public ModelAndView chart(WeatherVO vo, Model model) throws Exception {
		log.debug("chart() invoked.");
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		
		Date now = new Date();
		
		
		
		String dt = sd.format(now);
		vo.setFcst_date(dt);
		
		ModelAndView mv = new ModelAndView();
		
		List<WeatherVO> li = this.service2.selectWeather(vo);
		
		int num = 0;
		
		log.debug("gggggggggggggg"+li.toString());
		
		mv.addObject("list", li);
		mv.setViewName("/chart/chart");
		
//		StringBuilder str = new StringBuilder();
		
		String str = "[";
		str += "['날짜', '날씨정보', '00:00', '01:00', '02:00', '03:00시', '04:00', '05:00', '06:00', '07:00', '08:00시', '09:00', '10:00'] ,";
		
		for(WeatherVO vo1 : li) {
			str +="['";
			str += vo1.getFcst_date();
			str += "', ";
			str += vo1.getCategory();
			str += "', ";
			str += vo1.getT00();
			str += "', ";
			str += vo1.getT01();
			str += "', ";
			str += vo1.getT02();
			str += "', ";
			str += vo1.getT03();
			str += "', ";
			str += vo1.getT04();
			str += "', ";
			str += vo1.getT05();
			str += "', ";
			str += vo1.getT06();
			str += "', ";
			str += vo1.getT07();
			str += "', ";
			str += vo1.getT08();
			str += "', ";
			str += vo1.getT09();
			str += "', ";
			str += vo1.getT10();
			str += " ]";
			
			num++;
			if(num<li.size()) {
				str += ",";
			}
			
		}
		
		str+="]";
		mv.addObject("str", str);
		
		return mv;
		
		
		
		
//		row.append("["+re[0]+", " + vo1.getT00()+"],")
//		   .append("["+re[1]+", " + vo1.getT01()+"],")
//		   .append("["+re[2]+", " + vo1.getT02()+"],")
//		   .append("["+re[3]+", " + vo1.getT03()+"],")
//		   .append("["+re[4]+", " + vo1.getT04()+"],")
//		   .append("["+re[5]+", " + vo1.getT05()+"],")
//		   .append("["+re[6]+", " + vo1.getT06()+"],")
//		   .append("["+re[7]+", " + vo1.getT07()+"],")
//		   .append("["+re[8]+", " + vo1.getT08()+"],")
//		   .append("["+re[9]+", " + vo1.getT09()+"],")
//		   .append("["+re[10]+", " + vo1.getT10()+"],")
//		   .append("["+re[11]+", " + vo1.getT11()+"],")
//		   .append("["+re[12]+", " + vo1.getT12()+"],")
//		   .append("["+re[13]+", " + vo1.getT13()+"],")
//		   .append("["+re[14]+", " + vo1.getT14()+"],")
//		   .append("["+re[15]+", " + vo1.getT15()+"],")
//		   .append("["+re[16]+", " + vo1.getT16()+"],")
//		   .append("["+re[17]+", " + vo1.getT17()+"],")
//		   .append("["+re[18]+", " + vo1.getT18()+"],")
//		   .append("["+re[19]+", " + vo1.getT19()+"],")
//		   .append("["+re[20]+", " + vo1.getT20()+"],")
//		   .append("["+re[21]+", " + vo1.getT21()+"],")
//		   .append("["+re[22]+", " + vo1.getT22()+"],")
//		   .append("["+re[23]+", " + vo1.getT23()+"]");
		
		
		
//		str.append("[")
//		   .append("['날짜', '날씨정보', '00:00', '01:00', '02:00', '03:00시', '04:00', '05:00', '06:00', '07:00', '08:00시', '09:00', '10:00'] ,");
////		   .append(" '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00'], ");
//		
//		
//		for(WeatherVO vo1 : li) {
//			str.append("['")
//			   .append(vo1.getFcst_date())
//			   .append("', '"+vo1.getCategory()+"', '"+vo1.getT00()+"', '" +"', '"+vo1.getT01()+"', '" + "', '"+vo1.getT02()+"', '")
//			   .append(vo1.getT03()+"', '"+vo1.getT04()+"', '"+vo1.getT05()+"', '"+"', '"+vo1.getT06()+"', '"+"', '"+vo1.getT07()+"', '")
//			   .append(vo1.getT08()+"', '"+ vo1.getT09()+"', '"+ vo1.getT10()+" ]");
//			
//			num++;
//			if(num<li.size()) {
//				str.append(",");
//			}
//			
//			   
//		}
//		str.append("]");
//		
//		String stt = str.toString();
//		
//		mv.addObject("stt", stt);
		
	} // chart
	
}
