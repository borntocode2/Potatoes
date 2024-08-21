package hello.hello_spring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //URL 뒤에 /블라블라 를 get하면 hello랑 매핑
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // resources-templates/ + {hello} + .html
                        // return "ViewName"; 을 자동으로 resources-templates에서 찾아준다.


    }
}
