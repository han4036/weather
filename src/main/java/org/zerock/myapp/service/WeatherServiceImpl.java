package org.zerock.myapp.service;

import java.util.List;

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
	public void insertDate(WeatherDTO dto) throws Exception {
		log.debug("insertDate(dto) invoked.");
		this.mapper.insertDate(dto);
	}

	@Override
	public int dataCount(WeatherDTO dto) throws Exception {
		log.debug("dataCount(dto) invoked.");
		
		int result = this.mapper.dataCount(dto);
		
		return result;
	}

	@Override
	public List<WeatherVO> weatherList(WeatherVO vo) throws Exception {
		log.debug("weatherList(dto) invoked.");
		
		return this.mapper.weatherList(vo);
	}
	

	@Override
	public void uTMP1(WeatherDTO dto) throws Exception {
		log.debug("uTMP1(dto) invoked.");
		
		this.mapper.uTMP1(dto);
		
	}
	
	@Override
	public void uWeatherValue(WeatherDTO dto) throws Exception {
		log.debug("uWeatherValue(vo) invoked.");
		
		this.mapper.uWeatherValue(dto);
	}

	@Override
	public void uREH1(WeatherDTO dto) throws Exception {
		log.debug("uREH1(dto) invoked.");
		
		this.mapper.uREH1(dto);
		
	} // date1
	
	
	

} // end class
