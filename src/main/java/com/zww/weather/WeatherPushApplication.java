package com.zww.weather;

import com.zww.weather.config.RestTemplateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class WeatherPushApplication {

	@Autowired
	static RestTemplate restTemplate;

	public static void main(String[] args) {
        SpringApplication.run(WeatherPushApplication.class, args);
    }

    // main里面如何获取bean todo
	public static String getInfo(){
		String url = "http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(RestTemplateConfiguration.class);
//        RestTemplate restTemplate = (RestTemplate) ctx.getBean("restTemplate");
        Object o = restTemplate.getForObject(url, Object.class);
		System.out.print(o.toString());
		return o.toString();
	}
}
