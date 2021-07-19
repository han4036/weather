package org.zerock.myapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.domain.WeatherVO;
import org.zerock.myapp.service.WeatherService;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;


@Log4j
@EnableScheduling
@RestController
@RequestMapping("/api")
public class WeatherApiController2 {
	
	
	@Autowired
	WeatherService service;
	
	// serviceKey는 기상청에서 제공해주며 고정으로 사용되고
	// 위도와 경도는 분당시 구미동으로 고정 하기위해 final static을 사용
	final static String serviceKey = "WBnK0gPLvl2z8n%2FBujlX6vtsLZzzZGlBJYhNB6MvacORuj8GAQy5jKOh5HbgitXV6mvVB02U0xY9PyR1CYxGuw%3D%3D";
	final static String nx = "62";
	final static String ny = "122";
	
//	매일 5시, 23시에 실행되는 스케줄러
	@Scheduled(cron = "0 0 05,11,17,23 * * *")
//	@Scheduled(fixedRate=15000)
	@RequestMapping("/weather2")
	public void restApiWeather() throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH");
		
		Date now = new Date();
		
		String date2 = "20210718";
		String time1 = "2300";
		String date1 = format.format(now);			// base_date
		String time2 = format2.format(now) + "00";	// base_time
		String type = "json";
		String pageNo = "1";
		String numOfRows = "709";
		
		WeatherDTO dto = new WeatherDTO();
		
		String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
		
		StringBuilder urlBuilder = new StringBuilder(apiURL);
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="+serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + numOfRows);
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);
		urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(date2, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode(time1, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8"));
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		System.out.println("Response code : " + conn.getResponseCode());
		
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		} // if-else
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine()) != null) {
			sb.append(line);
		} // while
		
		rd.close();
		conn.disconnect();
		String result = sb.toString();
		
		JSONParser parser = new JSONParser();
		
		log.debug("\n\t>>>>>>>>>>>>>>>>>>" + result);
				
		JSONObject obj = (JSONObject)parser.parse(result);
		JSONObject res = (JSONObject)obj.get("response");
		JSONObject body = (JSONObject)res.get("body");
		JSONObject items = (JSONObject)body.get("items");
		JSONArray item = (JSONArray)items.get("item");
		
		String category;
		JSONObject weather;
		
		
		String day = "";
		String time = "";
		Object fcstValue;
		Object fcstDate;
		Object fcstTime;
		
		int re;
		
		String t = null;
		
		for(int i=0; i<item.size(); i++) {
			weather = (JSONObject) item.get(i);
			fcstValue = weather.get("fcstValue");
			fcstDate = weather.get("fcstDate");
			fcstTime = weather.get("fcstTime");
			
			log.info("\n\t >>>>>>>>>> weather : " + weather);
			
			
			category = (String) weather.get("category");
			
			switch(category) {
			case "REH" :
				
				dto.setCategory("습도");
				dto.setReh(Integer.parseInt(String.valueOf(weather.get("fcstValue"))));
				dto.setFcst_date((weather.get("fcstDate").toString()));
				dto.setFcst_time((weather.get("fcstTime").toString()));
				t = "t"+ dto.getFcst_time().substring(0, 2);
				dto.setT(t);
				
				re = this.service.dateCheck1(dto);
				
				log.info("\n\t>>>>>>>>>>>>>>>" + dto.getFcst_time());
				
				if(re == 0) {
					this.service.date1(dto);
				} // if
				this.service.uReh(dto);
				break;
				
			case "TMP" :
				dto.setCategory("온도");
				dto.setTmp(Integer.parseInt(String.valueOf(weather.get("fcstValue"))));
				dto.setFcst_date((weather.get("fcstDate").toString()));
				dto.setFcst_time((weather.get("fcstTime").toString()));
				t = "t"+ dto.getFcst_time().substring(0, 2);
				dto.setT(t);
				
				re = this.service.dateCheck1(dto);
				
				if(re == 0) {
					this.service.date1(dto);
				} // if
				this.service.uT1h(dto);
				break;
			} // switch
			
			if(!day.equals(fcstDate.toString())) {
				day = fcstDate.toString();
			} // if
			
			if(!time.equals(fcstTime.toString())) {
				time = fcstTime.toString();
				System.out.println("날짜 : " + day + "\n" + "시간 : "  + time);
			} // if
			
			
			// 카테고리가 습도일 경우
			if(category.equals("REH")) {
				System.out.print("\n\t category : " + dto.getCategory());
				System.out.print(", fcst_Value : " + dto.getReh());
				System.out.print(", fcstDate : " + dto.getFcst_date());
				System.out.println(", fcstTime : " + dto.getFcst_time());
				System.out.println();
			} // if
			
			if(category.equals("TMP")) {
				System.out.print("\n\t category : " + dto.getCategory());
				System.out.print(", fcst_Value : " + dto.getTmp());
				System.out.print(", fcstDate : " + dto.getFcst_date());
				System.out.println(", fcstTime : " + dto.getFcst_time());
				System.out.println();
			} // if
			
		} // for
		
	} // WeatherApiController2
	
} // end class