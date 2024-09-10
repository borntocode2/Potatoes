package hello.hello_spring.controller;

import hello.hello_spring.domain.CreateDto;
import hello.hello_spring.domain.Member;
import hello.hello_spring.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Autowired를 왜 쓰는 건가? 그냥 service빈 등록해서 쓰면 되는거 아닌가?
//Autowired밑에 왜 생성자가 있는 건가? 생성자로 인해 memberservice가 생성되고 그것이 Controller에 등록?
@Controller //스프링 컨테이너 통에서 스프링 안에 MemberController 객체를 넣어둔다. -> 스프링컨테이너에서 스프링빈이 관리된다.
public class MemberController {

    private final MemberService memberService;// 스프링 컨테이너에 등록하는 과정, bean이다, 갈아끼울 수 있다.


 @Autowired//멤버컨트롤러가 스프링에 생성될 때, 스프링빈에 등록되어있는 멤버서비스 객체를 넣어준다 -> DI
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
     return "members/createMemberForm";
    }
    @PostMapping("/members/new") //form의 post랑 매핑된 것
    public String create(MemberForm form){ //form.html에 name이 form의 name이랑 연결됨.
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return"redirect:/";
    }
}
