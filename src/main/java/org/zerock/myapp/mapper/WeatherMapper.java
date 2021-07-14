package org.zerock.myapp.mapper;

import java.util.List;

import org.zerock.myapp.domain.WeatherDTO;

public interface WeatherMapper {
	
	public abstract void date1(WeatherDTO dto) throws Exception;
	public abstract void date2(WeatherDTO dto) throws Exception;
	
	public abstract int cccc(WeatherDTO dto) throws Exception;
	
	public abstract void uT1H(WeatherDTO dto) throws Exception;
	public abstract void uREH(WeatherDTO dto) throws Exception;
	
	public abstract WeatherDTO selectWeather(String base_date, String category) throws Exception;
//	public abstract WeatherDTO selectReh(WeatherDTO dto) throws Exception;
	
	public abstract List<WeatherDTO> lookupT1H(WeatherDTO dto) throws Exception;
}
