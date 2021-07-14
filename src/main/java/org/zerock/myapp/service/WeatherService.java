package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.WeatherDTO;

public interface WeatherService {
	
	public abstract void date1(WeatherDTO dto) throws Exception;
	public abstract void date2(WeatherDTO dto) throws Exception;
	
	public abstract int dateCheck1(WeatherDTO dto) throws Exception;
	
	public abstract void uT1h(WeatherDTO dto) throws Exception;
	public abstract void uReh(WeatherDTO dto) throws Exception;
	
	public abstract WeatherDTO selectWeather(String base_date, String category) throws Exception;
	
	public abstract List<WeatherDTO> weatherL(WeatherDTO dto) throws Exception;
}
