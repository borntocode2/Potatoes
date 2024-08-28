package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 컨테이너 통에서 스프링 안에 MemberController 객체를 넣어둔다. -> 스프링컨테이너에서 스프링빈이 관리된다.
public class MemberController {

    private final MemberService memberService;// 스프링 컨테이너에 등록하는 과정

    @Autowired //멤버컨트롤러가 스프링에 생성될 때, 스프링빈에 등록되어있는ㄴ 멤버서비스 객체를 넣어준다 -> DI
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
