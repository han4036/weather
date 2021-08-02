package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class WeatherDTO {

	private Integer dataType;
	private String inputdatetime;
	private String fcst_time;
	private Integer tmp;
	private Integer reh;
	private Integer value;
	private String t;
	
}
