package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 스프링부트의 컨트롤러로 임명하마 ~
public class MainController {
    @GetMapping("/sbb") //고유 URL/sbb 와 매핑하겠다 ~
    @ResponseBody
    public String index() {
        return "Index";
    }
}