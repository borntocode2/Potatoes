package hello.hello_spring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") //URL 뒤에 /블라블라 를 get하면 hello랑 매핑
    public String hello(Model model) { // model 엔티티를 받고, model에다가 data를 직접 넣어주었따.
        model.addAttribute("data", "hello!!");
        return "hello"; // resources-templates/ + {hello} + .html
        // return "ViewName"; 을 자동으로 resources-templates에서 찾아준다.
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //브라우저에서 ?name = spring 같이 파라미터넘김
        model.addAttribute("name", name); //model을 받고, model에다가 scanf처럼 변수를 넣어주었따.
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody//HTTP의 BODY에 문자내용을 직접 반환
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody //hello-api가 매핑되어있네? 어라 ?ResponseBody네?
                  // hello 객체에 name을 파라미터로 넣은 상태로 반환
    public Hello helloApi(@RequestParam("name") String name){ // 3. Hello타입을 return 하는 정의문
        Hello hello = new Hello();
        hello.setName(name); // 4. 생성자를 통해 생성된 Hello타입의 객체 hello에다가 setName메서드에 name을 넣는다.
        return hello; //Body에 응답함
    }
    static class Hello { // 1. 클래스 Hello 생성
        private String name; // 2. 클래스 속성 name이 있다

        public String getName(){
            return name;
        }

        public void setName(String name){// 메서드
            this.name = name;
        }
    }
}
