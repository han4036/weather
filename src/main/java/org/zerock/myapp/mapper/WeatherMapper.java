package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.myapp.domain.WeatherDTO;
import org.zerock.myapp.domain.WeatherVO;

public interface WeatherMapper {
	
	public abstract void insertDate(WeatherDTO dto) throws Exception;
	
	public abstract int dataCount(WeatherDTO dto) throws Exception;
	
	public abstract List<WeatherVO> weatherList(WeatherVO vo) throws Exception;
	
	
	public abstract void uTMP1(WeatherDTO dto) throws Exception;
	
	public abstract void uREH1(WeatherDTO dto) throws Exception;
}
