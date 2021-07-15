package org.zerock.myapp.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.domain.WeatherVO;

public interface WeatherService {
	
	public abstract void date1(WeatherDTO dto) throws Exception;
	
	public abstract int dateCheck1(WeatherDTO dto) throws Exception;
	
	public abstract void uT1h(WeatherDTO dto) throws Exception;
	public abstract void uReh(WeatherDTO dto) throws Exception;
	
	public abstract List<WeatherVO> selectWeather(WeatherVO vo) throws Exception;
	
	public abstract List<WeatherDTO> weatherL(WeatherDTO dto) throws Exception;
}
