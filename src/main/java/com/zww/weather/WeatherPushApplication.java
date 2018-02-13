package com.zww.weather;

import com.zww.weather.config.RestTemplateConfiguration;
import com.zww.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
@EnableScheduling
public class WeatherPushApplication {

	@Autowired
	static RestTemplate restTemplate;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WeatherPushApplication.class, args);
//		WeatherService weatherService = (WeatherService) ctx.getBean("weatherService");
//		String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=101020100";
//		System.out.printf(weatherService.getWeatherDtlInfo(url).toString());
	}
}
