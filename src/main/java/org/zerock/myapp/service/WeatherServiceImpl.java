package org.zerock.myapp.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.domain.WeatherVO;
import org.zerock.myapp.mapper.WeatherMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	WeatherMapper mapper;

	@Override
	public void date1(WeatherDTO dto) throws Exception {
		log.debug("date1(dto) invoked.");
		
		this.mapper.date1(dto);
		
		
	} // date1
	
	@Override
	public int dateCheck1(WeatherDTO dto) throws Exception {
		log.debug("dateCheck1(dto) invoked.");
		
		int result = this.mapper.cccc(dto);
		
		log.debug(result);
		return result;
	}
	
	@Override
	public List<WeatherDTO> weatherL(WeatherDTO dto) throws Exception {
		log.debug("weatherL(dto) invoked.");
		
		return this.mapper.lookupT1H(dto);
	} // weatherL

	@Override
	public void uT1h(WeatherDTO dto) throws Exception {
		log.debug("uT1h1(dto) invoked.");
		
		this.mapper.uT1H(dto);
		
	} // uT1h1
	
	@Override
	public void uReh(WeatherDTO dto) throws Exception {
		log.debug("uReh1(dto) invoked.");
		
		this.mapper.uREH(dto);
		
	} // uReh1
	
	@Override
	public List<WeatherVO> selectWeather(WeatherVO vo) throws Exception {
		log.debug("selectWeather(dto) invoked");
		
		
		return this.mapper.selectWeather(vo);
	} // selectWeather
	
	

} // end class
