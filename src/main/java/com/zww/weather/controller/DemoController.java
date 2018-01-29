package com.zww.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoww on 2018/1/29.
 */
@Controller
public class DemoController {

    @RequestMapping("/index")
    public String index(Model model){
        String textValue = "上士闻道，仅能行之；中士闻道，若存若亡；下士闻道，大笑之。" +
                "不笑不足以为道。" +
                "故建言有之：明道若昧；进道若退；夷道若颣；上德若谷，大白若辱，广德若不足，建德若偷，质真若渝；大方无隅；大器免成；大音希声；大象无形。" +
                "道隐无名。" +
                "夫唯道，善始且善成。";
        model.addAttribute("textValue",textValue);
        return "demo/index";

    }
}
