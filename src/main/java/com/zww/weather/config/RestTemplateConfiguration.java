package com.zww.weather.config;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfiguration
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * restTemplateProperties
     */
    @Autowired
    private RestTemplateProperties restTemplateProperties;

    /**
     * readTimeout <br>
     */
//    @Value("${rest.readtimeout}")
//    private int readTimeout;
    
    /**
     * connectTimeOut <br>
     */
//    @Value("${rest.connecttimeout}")
//    private int connectTimeOut;
    /**
     * Description: <br>
     * 
     * @author zhao.weiwei<br>
     * @taskId <br>
     * @param factory <br>
     * @return <br>
     */
    @Bean
    @ConditionalOnMissingBean({
        RestOperations.class, RestTemplate.class
    })
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        // return new RestTemplate(factory);
        RestTemplate restTemplate = new RestTemplate(factory);

        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                iterator.remove();
            }
        }
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate;
    }

    /**
     * Description: <br>
     * 
     * @author zhao.weiwei<br>
     * @taskId <br>
     * @return <br>
     */
    @Bean
    @ConditionalOnMissingBean({
        ClientHttpRequestFactory.class
    })
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(restTemplateProperties.getReadtimeout());
        factory.setConnectTimeout(restTemplateProperties.getConnecttimeout());
        return factory;
    }
}
