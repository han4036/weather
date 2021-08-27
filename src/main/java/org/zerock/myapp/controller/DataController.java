package org.zerock.myapp.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.WeatherDTO;
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
	
	@GetMapping("/chart3")
	public String chart3Get() throws Exception {
		log.debug("chart3Get() invoked.");
		
		
		return "/chart/chart2";
	}
	
	
//	@GetMapping("/chart2")
//	public void chart2( Model model, String date, String category) throws Exception {
//		log.debug("chart2() invoked.");
//		
//		StringBuilder df = new StringBuilder();
//		
//		System.out.println(date);
//		
//		// 입력받은 값 date의 "-"를 빼기위한 substring
//		// ex) 2021-07-21 = 20210721
//		df.append(date.substring(0, 4)).append(date.substring(5, 7)).append(date.substring(8));
//		
//		System.out.println(">>>>>>>>>>> df : " + df);
//		
//		WeatherVO vo = new WeatherVO();
//		
//		if(category.equals("온도")) {
//			vo.setDataType(1);
//			vo.setInputdatetime(df.toString());
//		} else if(category.equals("습도")) {
//			vo.setDataType(2);
//			vo.setInputdatetime(df.toString());
//		}
//		
//		List<WeatherVO> li = this.service2.weatherList(vo);
//		
//		
//		HashMap<String, Object> list = new HashMap<>();
//		
//		JSONObject jso = new JSONObject();
//		JSONParser jp = new JSONParser();
//		
////		
////		JSONParser jp = new JSONParser();
////		jso = (JSONObject) jp.parse(li.toString());
////		
////		System.out.println(jso);
//		
//		log.debug(li.toString());
////		vo = li.get(0);
//		
//		int[] re = new int[24];
//		
//		String[] d1 = new String[24];
//		
//		for(int i=0; i<d1.length; ++i) {
//			if(i<10) {
//				d1[i] = "0"+String.valueOf(i)+":00";
//			} else if(i>= 10) {
//				d1[i] = String.valueOf(i)+":00";
//			} // if
//		} // for
//		
//		
//		for(int i=0; i<d1.length; i++) {
//			re[i] = i;
//			
//		} // for
//		
//		String colName ="";
//		String colData1 ="[{'구분':";
//		String colData2 ="";
//		
//		
//		List<String> ddde2 = new ArrayList<>();
//		
//		
////		 var gridData = [{'구분':"00:00",'온도':"27"}];
//		// ['00:00', 27],
//		
//		StringBuilder gridRow = new StringBuilder();
//		StringBuilder gridRow2 = new StringBuilder();
//		
////		String jsonString = 
////        "[{\"custNm\":\"홍길동\","+ "\"custPh\":\"010-0000-0000\","+ "\"birth\":\"2000-01-23\""+ "}]"		;
////		  [{"custNm":"홍길동","custPh":"010-0000-0000","birth":"2000-01-23"}]
//		StringBuilder chartRow = new StringBuilder();
//		StringBuilder chartRow2 = new StringBuilder();
//		
//		JSONArray ja = new JSONArray();
//		
//		if(vo.getDataType().equals(1)) {
//			
//			colName = "\"온도\"";
//			
//			System.out.println(colName);
//			chartRow.append("['시간', '온도'],");
//			
//			for(WeatherVO vo1 : li) {
//				
//				list.put("tmp", vo1);
//				
//				vo = vo1;
//				
//				
//				
//				gridRow2.append("[{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[0]+"\", "+colName+":\""+vo1.getT00()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[1]+"\", "+colName+":\""+vo1.getT01()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[2]+"\", "+colName+":\""+vo1.getT02()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[3]+"\", "+colName+":\""+vo1.getT03()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[4]+"\", "+colName+":\""+vo1.getT04()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[5]+"\", "+colName+":\""+vo1.getT05()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[6]+"\", "+colName+":\""+vo1.getT06()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[7]+"\", "+colName+":\""+vo1.getT07()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[8]+"\", "+colName+":\""+vo1.getT08()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[9]+"\", "+colName+":\""+vo1.getT09()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[10]+"\", "+colName+":\""+vo1.getT10()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[11]+"\", "+colName+":\""+vo1.getT11()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[12]+"\", "+colName+":\""+vo1.getT12()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[13]+"\", "+colName+":\""+vo1.getT13()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[14]+"\", "+colName+":\""+vo1.getT14()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[15]+"\", "+colName+":\""+vo1.getT15()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[16]+"\", "+colName+":\""+vo1.getT16()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[17]+"\", "+colName+":\""+vo1.getT17()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[18]+"\", "+colName+":\""+vo1.getT18()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[19]+"\", "+colName+":\""+vo1.getT19()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[20]+"\", "+colName+":\""+vo1.getT20()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[21]+"\", "+colName+":\""+vo1.getT21()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[22]+"\", "+colName+":\""+vo1.getT22()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[23]+"\", "+colName+":\""+vo1.getT23()+"\"}]");
//				
////				gridRow.append("[{\"구분\":\""+d1[0]+"\", "+colName+":\""+vo1.getT00()+"\"},")
////				  .append("{\"구분\":\""+d1[1]+"\", "+colName+":\""+vo1.getT01()+"\"},")
////				  .append("{\"구분\":\""+d1[2]+"\", "+colName+":\""+vo1.getT02()+"\"},")
////				  .append("{\"구분\":\""+d1[3]+"\", "+colName+":\""+vo1.getT03()+"\"},")
////				  .append("{\"구분\":\""+d1[4]+"\", "+colName+":\""+vo1.getT04()+"\"},")
////				  .append("{\"구분\":\""+d1[5]+"\", "+colName+":\""+vo1.getT05()+"\"},")
////				  .append("{\"구분\":\""+d1[6]+"\", "+colName+":\""+vo1.getT06()+"\"},")
////				  .append("{\"구분\":\""+d1[7]+"\", "+colName+":\""+vo1.getT07()+"\"},")
////				  .append("{\"구분\":\""+d1[8]+"\", "+colName+":\""+vo1.getT08()+"\"},")
////				  .append("{\"구분\":\""+d1[9]+"\", "+colName+":\""+vo1.getT09()+"\"},")
////				  .append("{\"구분\":\""+d1[10]+"\", "+colName+":\""+vo1.getT10()+"\"},")
////				  .append("{\"구분\":\""+d1[11]+"\", "+colName+":\""+vo1.getT11()+"\"},")
////				  .append("{\"구분\":\""+d1[12]+"\", "+colName+":\""+vo1.getT12()+"\"},")
////				  .append("{\"구분\":\""+d1[13]+"\", "+colName+":\""+vo1.getT13()+"\"},")
////				  .append("{\"구분\":\""+d1[14]+"\", "+colName+":\""+vo1.getT14()+"\"},")
////				  .append("{\"구분\":\""+d1[15]+"\", "+colName+":\""+vo1.getT15()+"\"},")
////				  .append("{\"구분\":\""+d1[16]+"\", "+colName+":\""+vo1.getT16()+"\"},")
////				  .append("{\"구분\":\""+d1[17]+"\", "+colName+":\""+vo1.getT17()+"\"},")
////				  .append("{\"구분\":\""+d1[18]+"\", "+colName+":\""+vo1.getT18()+"\"},")
////				  .append("{\"구분\":\""+d1[19]+"\", "+colName+":\""+vo1.getT19()+"\"},")
////				  .append("{\"구분\":\""+d1[20]+"\", "+colName+":\""+vo1.getT20()+"\"},")
////				  .append("{\"구분\":\""+d1[21]+"\", "+colName+":\""+vo1.getT21()+"\"},")
////				  .append("{\"구분\":\""+d1[22]+"\", "+colName+":\""+vo1.getT22()+"\"},")
////				  .append("{\"구분\":\""+d1[23]+"\", "+colName+":\""+vo1.getT23()+"\"}]");
//				
//				
//				
//				
//				
//				chartRow.append("['"+d1[0]+"', " + vo1.getT00()+"],")
//				   .append("['"+d1[1]+"', " + vo1.getT01()+"],") 
//				   .append("['"+d1[2]+"', " + vo1.getT02()+"],")
//				   .append("['"+d1[3]+"', " + vo1.getT03()+"],")
//				   .append("['"+d1[4]+"', " + vo1.getT04()+"],")
//				   .append("['"+d1[5]+"', " + vo1.getT05()+"],")
//				   .append("['"+d1[6]+"', " + vo1.getT06()+"],")
//				   .append("['"+d1[7]+"', " + vo1.getT07()+"],")
//				   .append("['"+d1[8]+"', " + vo1.getT08()+"],")
//				   .append("['"+d1[9]+"', " + vo1.getT09()+"],")
//				   .append("['"+d1[10]+"', " + vo1.getT10()+"],")
//				   .append("['"+d1[11]+"', " + vo1.getT11()+"],")
//				   .append("['"+d1[12]+"', " + vo1.getT12()+"],")
//				   .append("['"+d1[13]+"', " + vo1.getT13()+"],")
//				   .append("['"+d1[14]+"', " + vo1.getT14()+"],")
//				   .append("['"+d1[15]+"', " + vo1.getT15()+"],")
//				   .append("['"+d1[16]+"', " + vo1.getT16()+"],")
//				   .append("['"+d1[17]+"', " + vo1.getT17()+"],")
//				   .append("['"+d1[18]+"', " + vo1.getT18()+"],")
//				   .append("['"+d1[19]+"', " + vo1.getT19()+"],")
//				   .append("['"+d1[20]+"', " + vo1.getT20()+"],")
//				   .append("['"+d1[21]+"', " + vo1.getT21()+"],")
//				   .append("['"+d1[22]+"', " + vo1.getT22()+"],")
//				   .append("['"+d1[23]+"', " + vo1.getT23()+"]");
//				
//				
//				chartRow2.append("{\""+d1[0]+"");
//				
//				
//				ddde2.add("['"+d1[0]+"', " + vo1.getT00()+"]");
//				ddde2.add("['"+d1[1]+"', " + vo1.getT01()+"]");
//				ddde2.add("['"+d1[2]+"', " + vo1.getT02()+"]");
//				ddde2.add("['"+d1[3]+"', " + vo1.getT03()+"]");
//				ddde2.add("['"+d1[4]+"', " + vo1.getT04()+"]");
//				ddde2.add("['"+d1[5]+"', " + vo1.getT05()+"]");
//				ddde2.add("['"+d1[6]+"', " + vo1.getT06()+"]");
//				ddde2.add("['"+d1[7]+"', " + vo1.getT07()+"]");
//				ddde2.add("['"+d1[8]+"', " + vo1.getT08()+"]");
//				ddde2.add("['"+d1[9]+"', " + vo1.getT09()+"]");
//				ddde2.add("['"+d1[10]+"', " + vo1.getT10()+"]");
//				ddde2.add("['"+d1[11]+"', " + vo1.getT11()+"]");
//				ddde2.add("['"+d1[12]+"', " + vo1.getT12()+"]");
//				ddde2.add("['"+d1[13]+"', " + vo1.getT13()+"]");
//				ddde2.add("['"+d1[14]+"', " + vo1.getT14()+"]");
//				ddde2.add("['"+d1[15]+"', " + vo1.getT15()+"]");
//				ddde2.add("['"+d1[16]+"', " + vo1.getT16()+"]");
//				ddde2.add("['"+d1[17]+"', " + vo1.getT17()+"]");
//				ddde2.add("['"+d1[18]+"', " + vo1.getT18()+"]");
//				ddde2.add("['"+d1[19]+"', " + vo1.getT19()+"]");
//				ddde2.add("['"+d1[20]+"', " + vo1.getT20()+"]");
//				ddde2.add("['"+d1[21]+"', " + vo1.getT21()+"]");
//				ddde2.add("['"+d1[22]+"', " + vo1.getT22()+"]");
//				ddde2.add("['"+d1[23]+"', " + vo1.getT23()+"]");
//				   
//				System.out.println(chartRow);
//			}
//		
//		} else {
//			
//			chartRow.append("['시간', '습도'],");
//			
//			for(WeatherVO vo1 : li) {
//				
//				colName = "\"습도\"";
//				
//				vo = vo1;
//				
//				gridRow2.append("[{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[0]+"\", "+colName+":\""+vo1.getT00()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[1]+"\", "+colName+":\""+vo1.getT01()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[2]+"\", "+colName+":\""+vo1.getT02()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[3]+"\", "+colName+":\""+vo1.getT03()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[4]+"\", "+colName+":\""+vo1.getT04()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[5]+"\", "+colName+":\""+vo1.getT05()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[6]+"\", "+colName+":\""+vo1.getT06()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[7]+"\", "+colName+":\""+vo1.getT07()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[8]+"\", "+colName+":\""+vo1.getT08()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[9]+"\", "+colName+":\""+vo1.getT09()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[10]+"\", "+colName+":\""+vo1.getT10()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[11]+"\", "+colName+":\""+vo1.getT11()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[12]+"\", "+colName+":\""+vo1.getT12()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[13]+"\", "+colName+":\""+vo1.getT13()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[14]+"\", "+colName+":\""+vo1.getT14()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[15]+"\", "+colName+":\""+vo1.getT15()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[16]+"\", "+colName+":\""+vo1.getT16()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[17]+"\", "+colName+":\""+vo1.getT17()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[18]+"\", "+colName+":\""+vo1.getT18()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[19]+"\", "+colName+":\""+vo1.getT19()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[20]+"\", "+colName+":\""+vo1.getT20()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[21]+"\", "+colName+":\""+vo1.getT21()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[22]+"\", "+colName+":\""+vo1.getT22()+"\"},")
//				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[23]+"\", "+colName+":\""+vo1.getT23()+"\"}]");
//				
//			
//				chartRow.append("['"+d1[0]+"', " + vo1.getT00()+"],")
//				   .append("['"+d1[1]+"', " + vo1.getT01()+"],")
//				   .append("['"+d1[2]+"', " + vo1.getT02()+"],")
//				   .append("['"+d1[3]+"', " + vo1.getT03()+"],")
//				   .append("['"+d1[4]+"', " + vo1.getT04()+"],")
//				   .append("['"+d1[5]+"', " + vo1.getT05()+"],")
//				   .append("['"+d1[6]+"', " + vo1.getT06()+"],")
//				   .append("['"+d1[7]+"', " + vo1.getT07()+"],")
//				   .append("['"+d1[8]+"', " + vo1.getT08()+"],")
//				   .append("['"+d1[9]+"', " + vo1.getT09()+"],")
//				   .append("['"+d1[10]+"', " + vo1.getT10()+"],")
//				   .append("['"+d1[11]+"', " + vo1.getT11()+"],")
//				   .append("['"+d1[12]+"', " + vo1.getT12()+"],")
//				   .append("['"+d1[13]+"', " + vo1.getT13()+"],")
//				   .append("['"+d1[14]+"', " + vo1.getT14()+"],")
//				   .append("['"+d1[15]+"', " + vo1.getT15()+"],")
//				   .append("['"+d1[16]+"', " + vo1.getT16()+"],")
//				   .append("['"+d1[17]+"', " + vo1.getT17()+"],")
//				   .append("['"+d1[18]+"', " + vo1.getT18()+"],")
//				   .append("['"+d1[19]+"', " + vo1.getT19()+"],")
//				   .append("['"+d1[20]+"', " + vo1.getT20()+"],")
//				   .append("['"+d1[21]+"', " + vo1.getT21()+"],")
//				   .append("['"+d1[22]+"', " + vo1.getT22()+"],")
//				   .append("['"+d1[23]+"', " + vo1.getT23()+"]");
//				
//				
//				ddde2.add("['"+d1[0]+"', " + vo1.getT00()+"],");
//				ddde2.add("['"+d1[1]+"', " + vo1.getT01()+"],");
//				ddde2.add("['"+d1[2]+"', " + vo1.getT02()+"],");
//				ddde2.add("['"+d1[3]+"', " + vo1.getT03()+"],");
//				ddde2.add("['"+d1[4]+"', " + vo1.getT04()+"],");
//				ddde2.add("['"+d1[5]+"', " + vo1.getT05()+"],");
//				ddde2.add("['"+d1[6]+"', " + vo1.getT06()+"],");
//				ddde2.add("['"+d1[7]+"', " + vo1.getT07()+"],");
//				ddde2.add("['"+d1[8]+"', " + vo1.getT08()+"],");
//				ddde2.add("['"+d1[9]+"', " + vo1.getT09()+"],");
//				ddde2.add("['"+d1[10]+"', " + vo1.getT10()+"],");
//				ddde2.add("['"+d1[11]+"', " + vo1.getT11()+"],");
//				ddde2.add("['"+d1[12]+"', " + vo1.getT12()+"],");
//				ddde2.add("['"+d1[13]+"', " + vo1.getT13()+"],");
//				ddde2.add("['"+d1[14]+"', " + vo1.getT14()+"],");
//				ddde2.add("['"+d1[15]+"', " + vo1.getT15()+"],");
//				ddde2.add("['"+d1[16]+"', " + vo1.getT16()+"],");
//				ddde2.add("['"+d1[17]+"', " + vo1.getT17()+"],");
//				ddde2.add("['"+d1[18]+"', " + vo1.getT18()+"],");
//				ddde2.add("['"+d1[19]+"', " + vo1.getT19()+"],");
//				ddde2.add("['"+d1[20]+"', " + vo1.getT20()+"],");
//				ddde2.add("['"+d1[21]+"', " + vo1.getT21()+"],");
//				ddde2.add("['"+d1[22]+"', " + vo1.getT22()+"],");
//				ddde2.add("['"+d1[23]+"', " + vo1.getT23()+"],");
//			}
//		
//		}
//		
//		System.out.println("DDDDDDd : " + ja);
//		
//		System.out.println("gridRow2 : " + gridRow2);
//		ja = (JSONArray)jp.parse(gridRow2.toString());
//		
//		System.out.println("ja : " + ja);
//		
////		ja = (JSONArray)jp.parse(gridRow.toString());
//		
//		System.out.println("\n\t >>>>>>>>>>>>>>> vo : " + ja);
//		
//		model.addAttribute("vo", vo);
//		model.addAttribute("gridRow", ja);
//		model.addAttribute("chartRow",chartRow);
//		model.addAttribute("date", date);
//		model.addAttribute("cate", category);
//		model.addAttribute("colName", colName);
//		model.addAttribute("llist", ddde2);
//		
//	} // chart2
	
	
	@GetMapping("/chart")
	public void chart(WeatherVO vo, Model model) throws Exception {
		log.debug("chart() invoked.");
		
		
	} // chart
	
	@PostMapping("/chart4")
	@ResponseBody
	public String chart4(@RequestParam(value="id")Integer id, @RequestParam(value="cellName")String cellName,
			@RequestParam(value="cellValue")Integer cellValue, @RequestParam(value="date") String dayInfo, WeatherDTO dto) throws Exception {
		log.debug("chart4() invoked.");
		
		log.debug(">>>>>>id : "+id);
		log.debug(">>>>>>cellname : " + cellName);
		log.debug(">>>>>>cellValue : "+cellValue);
		log.debug("dayInfo : "+dayInfo);
		String t = "";
		Integer value = null;
		Integer dataType = null;
		StringBuilder day = new StringBuilder();
		
		if(!("".equals(cellName))) {
			System.out.println("YES!!!!");
			
			if("온도".equals(cellName)) {
				dataType = 1;
				
			} else if("습도".equals(cellName)) {
				dataType = 2;
				
			} // if-else
			
			switch(id) {
			case 1:
				t = "T00";
				value = cellValue;
				break;
			case 2:
				t = "T01";
				value = cellValue;
				break;
			case 3:
				t = "T02";
				value = cellValue;
				break;
			case 4:
				t = "T03";
				value = cellValue;
				break;
			case 5:
				t = "T04";
				value = cellValue;
				break;
			case 6:
				t = "T05";
				value = cellValue;
				break;
			case 7:
				t = "T06";
				value = cellValue;
				break;
			case 8:
				t = "T07";
				value = cellValue;
				break;
			case 9:
				t = "T08";
				value = cellValue;
				break;
			case 10:
				t = "T09";
				value = cellValue;
				break;
			case 11:
				t = "T10";
				value = cellValue;
				break;
			case 12:
				t = "T11";
				value = cellValue;
				break;
			case 13:
				t = "T12";
				value = cellValue;
				break;
			case 14:
				t = "T13";
				value = cellValue;
				break;
			case 15:
				t = "T14";
				value = cellValue;
				break;
			case 16:
				t = "T15";
				value = cellValue;
				break;
			case 17:
				t = "T16";
				value = cellValue;
				break;
			case 18:
				t = "T17";
				value = cellValue;
				break;
			case 19:
				t = "T18";
				value = cellValue;
				break;
			case 20:
				t = "T19";
				value = cellValue;
				break;
			case 21:
				t = "T20";
				value = cellValue;
				break;
			case 22:
				t = "T21";
				value = cellValue;
				break;
			case 23:
				t = "T22";
				value = cellValue;
				break;
			case 24:
				t = "T23";
				value = cellValue;
				break;
			}
		}
		
		
		
//		if("온도".equals(cellName)) {
//			dataType = 1;
//			switch(id) {
//			case 1:
//				t = "T00";
//				value = cellValue;
//				break;
//			case 2:
//				t = "T01";
//				value = cellValue;
//				break;
//			case 3:
//				t = "T02";
//				value = cellValue;
//				break;
//			case 4:
//				t = "T03";
//				value = cellValue;
//				break;
//			case 5:
//				t = "T04";
//				value = cellValue;
//				break;
//			case 6:
//				t = "T05";
//				value = cellValue;
//				break;
//			case 7:
//				t = "T06";
//				value = cellValue;
//				break;
//			case 8:
//				t = "T07";
//				value = cellValue;
//				break;
//			case 9:
//				t = "T08";
//				value = cellValue;
//				break;
//			case 10:
//				t = "T09";
//				value = cellValue;
//				break;
//			case 11:
//				t = "T10";
//				value = cellValue;
//				break;
//			case 12:
//				t = "T11";
//				value = cellValue;
//				break;
//			case 13:
//				t = "T12";
//				value = cellValue;
//				break;
//			case 14:
//				t = "T13";
//				value = cellValue;
//				break;
//			case 15:
//				t = "T14";
//				value = cellValue;
//				break;
//			case 16:
//				t = "T15";
//				value = cellValue;
//				break;
//			case 17:
//				t = "T16";
//				value = cellValue;
//				break;
//			case 18:
//				t = "T17";
//				value = cellValue;
//				break;
//			case 19:
//				t = "T18";
//				value = cellValue;
//				break;
//			case 20:
//				t = "T19";
//				value = cellValue;
//				break;
//			case 21:
//				t = "T20";
//				value = cellValue;
//				break;
//			case 22:
//				t = "T21";
//				value = cellValue;
//				break;
//			case 23:
//				t = "T22";
//				value = cellValue;
//				break;
//			case 24:
//				t = "T23";
//				value = cellValue;
//				break;
//			}
//		}
//		
//		if("습도".equals(cellName)) {
//			dataType = 2;
//			switch(id) {
//			case 1:
//				t = "T00";
//				value = cellValue;
//				break;
//			case 2:
//				t = "T01";
//				value = cellValue;
//				break;
//			case 3:
//				t = "T02";
//				value = cellValue;
//				break;
//			case 4:
//				t = "T03";
//				value = cellValue;
//				break;
//			case 5:
//				t = "T04";
//				value = cellValue;
//				break;
//			case 6:
//				t = "T05";
//				value = cellValue;
//				break;
//			case 7:
//				t = "T06";
//				value = cellValue;
//				break;
//			case 8:
//				t = "T07";
//				value = cellValue;
//				break;
//			case 9:
//				t = "T08";
//				value = cellValue;
//				break;
//			case 10:
//				t = "T09";
//				value = cellValue;
//				break;
//			case 11:
//				t = "T10";
//				value = cellValue;
//				break;
//			case 12:
//				t = "T11";
//				value = cellValue;
//				break;
//			case 13:
//				t = "T12";
//				value = cellValue;
//				break;
//			case 14:
//				t = "T13";
//				value = cellValue;
//				break;
//			case 15:
//				t = "T14";
//				value = cellValue;
//				break;
//			case 16:
//				t = "T15";
//				value = cellValue;
//				break;
//			case 17:
//				t = "T16";
//				value = cellValue;
//				break;
//			case 18:
//				t = "T17";
//				value = cellValue;
//				break;
//			case 19:
//				t = "T18";
//				value = cellValue;
//				break;
//			case 20:
//				t = "T19";
//				value = cellValue;
//				break;
//			case 21:
//				t = "T20";
//				value = cellValue;
//				break;
//			case 22:
//				t = "T21";
//				value = cellValue;
//				break;
//			case 23:
//				t = "T22";
//				value = cellValue;
//				break;
//			case 24:
//				t = "T23";
//				value = cellValue;
//				break;
//			}
//		}
		
		day.append(dayInfo.substring(0, 4)).append(dayInfo.substring(5, 7)).append(dayInfo.substring(8));
		
		dto.setT(t);
		dto.setDataType(dataType);
		dto.setValue(value);
		dto.setInputdatetime(day.toString());
		
		this.service2.uWeatherValue(dto);
		
		
		return "success";
	} // chart
	
	@RequestMapping(value="/chart3", method= RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> chart3( Model model, 
			String date, String category, 
			HttpServletResponse res, HttpServletRequest req) throws Exception {
		log.debug("chart3() invoked.");
		
		log.debug("date : " + date);
		
		StringBuilder df = new StringBuilder();
		
		res.setCharacterEncoding("UTF-8");
		
		System.out.println(date);
		
//		date="2021-07-26";
//		CATEGORY="온도";
		
		// 입력받은 값 date의 "-"를 빼기위한 substring
		// ex) 2021-07-21 = 20210721
		//     12345678910
		df.append(date.substring(0, 4)).append(date.substring(5, 7)).append(date.substring(8));
//		df.append(date);
		
		System.out.println(">>>>>>>>>>> df : " + df);
		
		WeatherVO vo = new WeatherVO();
		
		if(category.equals("온도")) {
			vo.setDataType(1);
			vo.setInputdatetime(df.toString());
		} else if(category.equals("습도")) {
			vo.setDataType(2);
			vo.setInputdatetime(df.toString());
		}
		
		List<WeatherVO> li = this.service2.weatherList(vo);
		
		
		HashMap<String, Object> list = new HashMap<>();
		
		JSONObject jso = new JSONObject();
		JSONParser jp = new JSONParser();
		
//		
//		JSONParser jp = new JSONParser();
//		jso = (JSONObject) jp.parse(li.toString());
//		
//		System.out.println(jso);
		
		log.debug(li.toString());
//		vo = li.get(0);
		
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
		
		String colName ="";
		String colModel ="";
		Integer sid;
		String chartName = "";
		
		List<String> ddde2 = new ArrayList<>();
		
		
		StringBuilder gridRow = new StringBuilder();
		
//		String jsonString = 
//        "[{\"custNm\":\"홍길동\","+ "\"custPh\":\"010-0000-0000\","+ "\"birth\":\"2000-01-23\""+ "}]"		;
//		  [{"custNm":"홍길동","custPh":"010-0000-0000","birth":"2000-01-23"}]
		StringBuilder chartRow = new StringBuilder();
		StringBuilder grid = new StringBuilder();
		
		if(vo.getDataType().equals(1)) {
			
//			colName = "[\"구분\",\"온도\"]";
			colName = "\"온도\"";
//			colModel = "\"온도\"";
			
			System.out.println(colName);
			chartRow.append("['시간', '온도'],");
			
			for(WeatherVO vo1 : li) {
				
				list.put("tmp", vo1);
				
				vo = vo1;
				
				sid = vo1.getSid();
				
				gridRow.append("[{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[0]+"\", "+colName+":\""+vo1.getT00()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[1]+"\", "+colName+":\""+vo1.getT01()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[2]+"\", "+colName+":\""+vo1.getT02()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[3]+"\", "+colName+":\""+vo1.getT03()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[4]+"\", "+colName+":\""+vo1.getT04()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[5]+"\", "+colName+":\""+vo1.getT05()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[6]+"\", "+colName+":\""+vo1.getT06()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[7]+"\", "+colName+":\""+vo1.getT07()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[8]+"\", "+colName+":\""+vo1.getT08()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[9]+"\", "+colName+":\""+vo1.getT09()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[10]+"\", "+colName+":\""+vo1.getT10()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[11]+"\", "+colName+":\""+vo1.getT11()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[12]+"\", "+colName+":\""+vo1.getT12()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[13]+"\", "+colName+":\""+vo1.getT13()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[14]+"\", "+colName+":\""+vo1.getT14()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[15]+"\", "+colName+":\""+vo1.getT15()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[16]+"\", "+colName+":\""+vo1.getT16()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[17]+"\", "+colName+":\""+vo1.getT17()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[18]+"\", "+colName+":\""+vo1.getT18()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[19]+"\", "+colName+":\""+vo1.getT19()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[20]+"\", "+colName+":\""+vo1.getT20()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[21]+"\", "+colName+":\""+vo1.getT21()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[22]+"\", "+colName+":\""+vo1.getT22()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[23]+"\", "+colName+":\""+vo1.getT23()+"\"}]");
				
				
				chartRow.append("['"+d1[0]+"', " + vo1.getT00()+"],")
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
				
				ddde2.add("['"+d1[0]+"', " + vo1.getT00()+"],");
				ddde2.add("['"+d1[1]+"', " + vo1.getT01()+"],");
				ddde2.add("['"+d1[2]+"', " + vo1.getT02()+"],");
				ddde2.add("['"+d1[3]+"', " + vo1.getT03()+"],");
				ddde2.add("['"+d1[4]+"', " + vo1.getT04()+"],");
				ddde2.add("['"+d1[5]+"', " + vo1.getT05()+"],");
				ddde2.add("['"+d1[6]+"', " + vo1.getT06()+"],");
				ddde2.add("['"+d1[7]+"', " + vo1.getT07()+"],");
				ddde2.add("['"+d1[8]+"', " + vo1.getT08()+"],");
				ddde2.add("['"+d1[9]+"', " + vo1.getT09()+"],");
				ddde2.add("['"+d1[10]+"', " + vo1.getT10()+"],");
				ddde2.add("['"+d1[11]+"', " + vo1.getT11()+"],");
				ddde2.add("['"+d1[12]+"', " + vo1.getT12()+"],");
				ddde2.add("['"+d1[13]+"', " + vo1.getT13()+"],");
				ddde2.add("['"+d1[14]+"', " + vo1.getT14()+"],");
				ddde2.add("['"+d1[15]+"', " + vo1.getT15()+"],");
				ddde2.add("['"+d1[16]+"', " + vo1.getT16()+"],");
				ddde2.add("['"+d1[17]+"', " + vo1.getT17()+"],");
				ddde2.add("['"+d1[18]+"', " + vo1.getT18()+"],");
				ddde2.add("['"+d1[19]+"', " + vo1.getT19()+"],");
				ddde2.add("['"+d1[20]+"', " + vo1.getT20()+"],");
				ddde2.add("['"+d1[21]+"', " + vo1.getT21()+"],");
				ddde2.add("['"+d1[22]+"', " + vo1.getT22()+"],");
				ddde2.add("['"+d1[23]+"', " + vo1.getT23()+"],");
				
				   
				System.out.println(chartRow);
			}
		
		} else if(vo.getDataType().equals(2)){
			
			chartRow.append("['시간', '습도'],");
			
			for(WeatherVO vo1 : li) {
				
//				colName = "[\"구분\",\"습도\"]";
				colName = "\"습도\"";
//				colModel = "\"습도\"";
				
				vo = vo1;
				
				sid = vo1.getSid();
				
				gridRow.append("[{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[0]+"\", "+colName+":\""+vo1.getT00()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[1]+"\", "+colName+":\""+vo1.getT01()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[2]+"\", "+colName+":\""+vo1.getT02()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[3]+"\", "+colName+":\""+vo1.getT03()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[4]+"\", "+colName+":\""+vo1.getT04()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[5]+"\", "+colName+":\""+vo1.getT05()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[6]+"\", "+colName+":\""+vo1.getT06()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[7]+"\", "+colName+":\""+vo1.getT07()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[8]+"\", "+colName+":\""+vo1.getT08()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[9]+"\", "+colName+":\""+vo1.getT09()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[10]+"\", "+colName+":\""+vo1.getT10()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[11]+"\", "+colName+":\""+vo1.getT11()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[12]+"\", "+colName+":\""+vo1.getT12()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[13]+"\", "+colName+":\""+vo1.getT13()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[14]+"\", "+colName+":\""+vo1.getT14()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[15]+"\", "+colName+":\""+vo1.getT15()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[16]+"\", "+colName+":\""+vo1.getT16()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[17]+"\", "+colName+":\""+vo1.getT17()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[18]+"\", "+colName+":\""+vo1.getT18()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[19]+"\", "+colName+":\""+vo1.getT19()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[20]+"\", "+colName+":\""+vo1.getT20()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[21]+"\", "+colName+":\""+vo1.getT21()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[22]+"\", "+colName+":\""+vo1.getT22()+"\"},")
				  .append("{\"sid\":\""+vo1.getSid()+"\", "+"\"구분\":\""+d1[23]+"\", "+colName+":\""+vo1.getT23()+"\"}]");
				
			
				chartRow.append("['"+d1[0]+"', " + vo1.getT00()+"],")
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
				
				ddde2.add("['"+d1[0]+"', " + vo1.getT00()+"],");
				ddde2.add("['"+d1[1]+"', " + vo1.getT01()+"],");
				ddde2.add("['"+d1[2]+"', " + vo1.getT02()+"],");
				ddde2.add("['"+d1[3]+"', " + vo1.getT03()+"],");
				ddde2.add("['"+d1[4]+"', " + vo1.getT04()+"],");
				ddde2.add("['"+d1[5]+"', " + vo1.getT05()+"],");
				ddde2.add("['"+d1[6]+"', " + vo1.getT06()+"],");
				ddde2.add("['"+d1[7]+"', " + vo1.getT07()+"],");
				ddde2.add("['"+d1[8]+"', " + vo1.getT08()+"],");
				ddde2.add("['"+d1[9]+"', " + vo1.getT09()+"],");
				ddde2.add("['"+d1[10]+"', " + vo1.getT10()+"],");
				ddde2.add("['"+d1[11]+"', " + vo1.getT11()+"],");
				ddde2.add("['"+d1[12]+"', " + vo1.getT12()+"],");
				ddde2.add("['"+d1[13]+"', " + vo1.getT13()+"],");
				ddde2.add("['"+d1[14]+"', " + vo1.getT14()+"],");
				ddde2.add("['"+d1[15]+"', " + vo1.getT15()+"],");
				ddde2.add("['"+d1[16]+"', " + vo1.getT16()+"],");
				ddde2.add("['"+d1[17]+"', " + vo1.getT17()+"],");
				ddde2.add("['"+d1[18]+"', " + vo1.getT18()+"],");
				ddde2.add("['"+d1[19]+"', " + vo1.getT19()+"],");
				ddde2.add("['"+d1[20]+"', " + vo1.getT20()+"],");
				ddde2.add("['"+d1[21]+"', " + vo1.getT21()+"],");
				ddde2.add("['"+d1[22]+"', " + vo1.getT22()+"],");
				ddde2.add("['"+d1[23]+"', " + vo1.getT23()+"],");
			}
		
		}
		
		JSONArray jg = (JSONArray)jp.parse(gridRow.toString());
		
//		JSONArray jc = (JSONArray)jp.parse(chartRow.toString());
		String jc = chartRow.toString();
		
		System.out.println(chartRow.toString());
		
		System.out.println("\n\t >>>>>>>>>>>>>>> jg : " + jg);
		
		model.addAttribute("vo", vo);
		model.addAttribute("gridRow", jg);
		model.addAttribute("chartRow",chartRow);
		model.addAttribute("date", date);
		model.addAttribute("cate", category);
		model.addAttribute("colName", colName);
		model.addAttribute("colModel", colModel);
		
		String de = URLEncoder.encode(jg.toString(), "UTF-8");
		
		HashMap<String, Object> mapResult = new HashMap<String, Object>();
		
		List<JSONObject> jgData = new ArrayList<>();
		
		JSONParser jps = new JSONParser();
		
		for(int i=0; i<jg.size(); i++) {
			jgData.add(i, (JSONObject) jg.get(i));
		}
		
		JSONArray jas = new JSONArray();
		
//		jas = (JSONArray)jps.parse(jc);
		
		System.out.println(">>>>>>>> jas : " + jc);
		
		System.out.println(">>>>>>>>: jdData" + jgData);
		
//		for(int i=0; i<jc.size(); i++) {
//			jcData.add(i, (JSONObject) jc.get(i));
//		}
		
		mapResult.put("grid", jgData);
		mapResult.put("chart", jc);
		mapResult.put("name", colName);
		mapResult.put("model", jc);
		mapResult.put("cList", ddde2);
		mapResult.put("cate2", category);
		
		
		log.debug(">>>>>>>>>>>>"+ mapResult.toString());
		
		return mapResult;
		
	} // chart2
	
}
