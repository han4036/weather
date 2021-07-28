package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.domain.WeatherVO;

public interface WeatherService {
	
	public abstract void insertDate(WeatherDTO dto) throws Exception;
	
	public abstract int dataCount(WeatherDTO dto) throws Exception;
	
	public abstract List<WeatherVO> weatherList(WeatherVO vo) throws Exception;
	
	
	public abstract void uTMP1(WeatherDTO dto) throws Exception;
	
	public abstract void uREH1(WeatherDTO dto) throws Exception;
}
