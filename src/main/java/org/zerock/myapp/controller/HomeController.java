package org.zerock.myapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.myapp.domain.WeatherVO;
import org.zerock.myapp.service.WeatherService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@NoArgsConstructor
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	WeatherService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		log.info("Welcome home! The client locale is" + locale);
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/hi")
	public void hi(Model model) throws Exception {
		log.debug("hi() invoked.");
		
		
		
		WeatherVO vo = new WeatherVO();
		WeatherVO vo2 = new WeatherVO();
		
		vo.setDataType(1);
		vo.setInputdatetime("20210721");
		
		List<WeatherVO> li = this.service.weatherList(vo);
		
		
		JSONObject obj = new JSONObject();
		JSONParser jp = new JSONParser();
		
		String[] d1 = new String[24];
		
		for(int i=0; i<d1.length; ++i) {
			if(i<10) {
				d1[i] = "0"+String.valueOf(i)+":00";
			} else if(i>= 10) {
				d1[i] = String.valueOf(i)+":00";
			} // if
		} // for
		
		StringBuilder sb = new StringBuilder();
		
		String colName = "";
		
//		 var gridData = [{'구분':"00:00",'온도':"27"}];
//		String jsonString = 
//	             "[{\"custNm\":\"홍길동\","+ "\"custPh\":\"010-0000-0000\","+ "\"birth\":\"2000-01-23\""+ "}]"		;
//		 		  [{"custNm":"홍길동","custPh":"010-0000-0000","birth":"2000-01-23"}]
		
		for(WeatherVO vo1 : li) {
			colName = "\"온도\"";
			
			vo = vo1;
			
			sb.append("[{\"구분\":\""+d1[0]+"\", "+colName+":\""+vo1.getT00()+"\"},")
			  .append("{\"구분\":\""+d1[1]+"\", "+colName+":\""+vo1.getT01()+"\"},")
			  .append("{\"구분\":\""+d1[2]+"\", "+colName+":\""+vo1.getT02()+"\"},")
			  .append("{\"구분\":\""+d1[3]+"\", "+colName+":\""+vo1.getT03()+"\"},")
			  .append("{\"구분\":\""+d1[4]+"\", "+colName+":\""+vo1.getT04()+"\"},")
			  .append("{\"구분\":\""+d1[5]+"\", "+colName+":\""+vo1.getT05()+"\"},")
			  .append("{\"구분\":\""+d1[6]+"\", "+colName+":\""+vo1.getT06()+"\"},")
			  .append("{\"구분\":\""+d1[7]+"\", "+colName+":\""+vo1.getT07()+"\"},")
			  .append("{\"구분\":\""+d1[8]+"\", "+colName+":\""+vo1.getT08()+"\"},")
			  .append("{\"구분\":\""+d1[9]+"\", "+colName+":\""+vo1.getT09()+"\"},")
			  .append("{\"구분\":\""+d1[10]+"\", "+colName+":\""+vo1.getT10()+"\"},")
			  .append("{\"구분\":\""+d1[11]+"\", "+colName+":\""+vo1.getT11()+"\"},")
			  .append("{\"구분\":\""+d1[12]+"\", "+colName+":\""+vo1.getT12()+"\"},")
			  .append("{\"구분\":\""+d1[13]+"\", "+colName+":\""+vo1.getT13()+"\"},")
			  .append("{\"구분\":\""+d1[14]+"\", "+colName+":\""+vo1.getT14()+"\"},")
			  .append("{\"구분\":\""+d1[15]+"\", "+colName+":\""+vo1.getT15()+"\"},")
			  .append("{\"구분\":\""+d1[16]+"\", "+colName+":\""+vo1.getT16()+"\"},")
			  .append("{\"구분\":\""+d1[17]+"\", "+colName+":\""+vo1.getT17()+"\"},")
			  .append("{\"구분\":\""+d1[18]+"\", "+colName+":\""+vo1.getT18()+"\"},")
			  .append("{\"구분\":\""+d1[19]+"\", "+colName+":\""+vo1.getT19()+"\"},")
			  .append("{\"구분\":\""+d1[20]+"\", "+colName+":\""+vo1.getT20()+"\"},")
			  .append("{\"구분\":\""+d1[21]+"\", "+colName+":\""+vo1.getT21()+"\"},")
			  .append("{\"구분\":\""+d1[22]+"\", "+colName+":\""+vo1.getT22()+"\"},")
			  .append("{\"구분\":\""+d1[23]+"\", "+colName+":\""+vo1.getT23()+"\"}]");
		}
		
		System.out.println(sb);
		
		model.addAllAttributes(li);
		model.addAttribute("colName", colName);
		model.addAttribute("sb", sb);
		
		
	}
	
}
