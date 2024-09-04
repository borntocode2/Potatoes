//package hello.hello_spring.sevice;
//
//import hello.hello_spring.repository.MemberRepository;
//import hello.hello_spring.repository.MemoryMemberRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////자바 직접 빈 등록
//@Configuration //스프링부트 기동 될때, 빈으로 등록되어야할 것을 스프링에게 알려주는것
//public class SpringConfig {
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository()); // memberRepository()가 뭔지 어떻게 알고?
//    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
