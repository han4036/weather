package org.zerock.myapp.domain;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WeatherDTO {
	@NonNull
	private String category;
	@NonNull
	private String fcst_date;
	
	private String fcst_time;
	@NonNull
	private String tmp;
	@NonNull
	private String reh;
	private String t;
	
	
}
