package com.zww.weather;

import com.zww.weather.config.RestTemplateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
//@EnableScheduling
public class WeatherPushApplication {

	@Autowired
	static RestTemplate restTemplate;

	public static void main(String[] args) {
        SpringApplication.run(WeatherPushApplication.class, args);
    }
}
