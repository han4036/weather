package org.zerock.myapp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.service.WeatherService;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;


@Log4j
@Configuration
@EnableScheduling
@RestController
@RequestMapping("/")
public class WeatherApiController {
	
	
	@Autowired
	WeatherService service;
	
	// serviceKey는 기상청에서 제공해주며 고정으로 사용되고
	// 위도와 경도는 분당시 구미동으로 고정 하기위해 final static을 사용
	final static String serviceKey = "WBnK0gPLvl2z8n%2FBujlX6vtsLZzzZGlBJYhNB6MvacORuj8GAQy5jKOh5HbgitXV6mvVB02U0xY9PyR1CYxGuw%3D%3D";
	final static String nx = "62";
	final static String ny = "122";
	
//	@Scheduled(fixedDelay=3000)
	@GetMapping("/weather")
	public String restApiWeather(WeatherDTO dto) throws Exception {
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH");
		
		Date now = new Date();
		
		String date1 = format.format(now);
		String time1 = format2.format(now);
		String time2 = format2.format(now) + "00";
		
		String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst"
					+ "?serviceKey="+ serviceKey
					+ "&pageNo=1"
					+ "&numOfRows=10"
					+ "&dataType=JSON"
					+ "&base_date=" + date1
//					+ "&base_time=" + time2
					+ "&base_time=0900"
					+ "&nx=" + nx
					+ "&ny=" + ny;
		
		HashMap<String, Object> resultMap = getDataFromJson(url,"UTF-8","GET","");
		
		System.out.println("# RESULT : " + resultMap.toString());
		
		System.out.println("\n + \t"+ resultMap.get("response"));
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("result", resultMap);
		
		System.out.println(jsonObj);
		
		int result = this.service.dateCheck1(dto);
		
		if(result == 0) {
//			this.service.date11(dto);
//			this.service.weatherUpdate(dto);
		} else {
//			this.service.weatherUT00(dto);
		} // if-else
		
		return jsonObj.toString();
		
		
	} // restApiWeather
	
	
	public HashMap<String, Object> getDataFromJson(String url, String encoding, String type, String jsonStr) throws Exception {
		
		boolean isPost = false;
		
		if("post".equals(type)) {
			isPost = true;
		} else {
//			url = "".equals(jsonStr) ? url : url + "?request=" + jsonStr;
			
			if(!("".equals(jsonStr))) {
				url = url+"?request="+jsonStr;
			}
			
		} // if-else
		
		return getStringFromURL(url, encoding, isPost, jsonStr, "application/json");
		
	} // getDataFromJson
	
	
	public HashMap<String, Object> getStringFromURL(String url, String encoding, boolean isPost, String parameter, String contentType)
		throws Exception {
		
		URL apiURL = new URL(url);
		
		HttpURLConnection conn = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		HashMap<String, Object> resultMap = new HashMap<>();
		
		try {
			conn = (HttpURLConnection) apiURL.openConnection();
			conn.setConnectTimeout(7000);
			conn.setReadTimeout(7000);
			conn.setDoOutput(true);
			
			if(isPost) {
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", contentType);
				conn.setRequestProperty("Accept", "*/*");
			} else {
				conn.setRequestMethod("GET");
				
			} // if-else
			
			conn.connect();
			
			if(isPost) {
				bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
				bw.write(parameter);
				bw.flush();
				bw = null;
			} // if
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
			
			String line = null;
			
			StringBuffer result = new StringBuffer();
			
			while((line=br.readLine()) != null) result.append(line);
			
			ObjectMapper mapper = new ObjectMapper();
			
			resultMap = mapper.readValue(result.toString(), HashMap.class);
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(url + " interface failed" + e.toString());
		} finally {
			if(conn != null) conn.disconnect();
			if(br != null) br.close();
			if(bw != null) bw.close();
			
		} // try-catch-finally
		
		return resultMap;
	} // getStringFromURL
	
	
} // end class