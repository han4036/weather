package org.zerock.myapp.mapper;

import java.util.List;

import org.json.simple.JSONObject;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.domain.WeatherVO;

public interface WeatherMapper {
	
	public abstract void date1(WeatherDTO dto) throws Exception;
	
	public abstract int cccc(WeatherDTO dto) throws Exception;
	
	public abstract void uT1H(WeatherDTO dto) throws Exception;
	public abstract void uREH(WeatherDTO dto) throws Exception;
	
	public abstract List<WeatherVO> selectWeather(WeatherVO vo) throws Exception;
//	public abstract WeatherDTO selectReh(WeatherDTO dto) throws Exception;
	
	public abstract List<WeatherDTO> lookupT1H(WeatherDTO dto) throws Exception;
}
