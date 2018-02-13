package com.zww.weather;

import com.zww.weather.model.EmailDto;
import com.zww.weather.model.WeatherResponseDto;
import com.zww.weather.service.MailService;
import com.zww.weather.service.WeatherService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoww on 2018/2/9.
 */
public class MailServiceMockTest extends AbstractCoreBootTests{
    @Mock
    private MailService mailService;

    @Mock
    private WeatherService weatherService;

    @Before
    public void setUp(){
        Mockito.when(mailService.sendSimpleMail(Mockito.any(EmailDto.class))).thenAnswer(new Answer<Map<String,String>>() {
            @Override
            public Map<String,String> answer(InvocationOnMock invocationOnMock) throws Throwable {
                Map map = new HashMap();
                map.put("a","aa");
                return map;
            }
        });

        Mockito.when(weatherService.getWeatherDtlInfo(Mockito.anyString())).thenReturn(new WeatherResponseDto());

        // 对于无返回值的方法，可使用dothrow方法。不过一般不用对 void 方法打桩, 事后 verify 就行.
        // 可见 https://unmi.cc/mockito-how-to-mock-void-method/#more-7748
    }

    @Test
    public void testSendSimpleMail(){
        EmailDto emailDto = Mockito.mock(EmailDto.class);
        Map<String,String> map = mailService.sendSimpleMail(emailDto);
        Assert.assertEquals(map.get("a"),"aa");
    }

    @Test
    public void testGetWeatherDtlInfo(){
        WeatherResponseDto weatherResponseDto = weatherService.getWeatherDtlInfo("aaa");
    }
}
