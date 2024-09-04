package hello.hello_spring.sevice;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//이건 왜?
public class MemberService {

    private MemberRepository memberRepository; //여기서 실제 memberRepository가 만들어지고, 파라미터에 넣어주는 것.

    // 원래는 MemberRepository를 찾아서 MemberService 생성자에 주입시켜줘야 하는데,
    // 여기서 16번째 코드로 바로 주입되는 것이냐, 아님 스프링 어노테이션으로 주입되는 것이냐의 갈림길
    // @Autowired랑 @Repository 묶어주니 자동으로 MemberRepository에 주입이 되는 것인가?
    // 그렇다면,  서비스 어노테이션이 붙어있는 객체의 @Autowired는 스프링에서 자동적으로 Repository 어노테이션이랑 연결해주는 것인가?

    @Autowired
    public MemberService(MemberRepository memberRepository){ //MemberService객체가 생성될 때, MemberRepository 타입의 클래스를 넣는다.
        this.memberRepository = memberRepository;
    }

        public Long join(Member member) {
            validateDuplicateMember(member); //중복 회원 방지
            memberRepository.save(member); //save메서드에 반환 타입은 Member타입이다,
            return member.getId(); //왜 Optional이 아닌가?
        }
        private void validateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName())// 옵셔널안에 멤버 객체가 있는 것 //Repo에서 member의 네임이 존재하면 throw new
                    .ifPresent(m -> { // ifpresent(옵셔널 전용)가 옵셔널 객체의 값을 꺼내본다., 값이 Optional.empty()면 실행X
                        // , 값이 있으면 ifpresent 파라미터의 함수를 실행시킴.
                        throw new IllegalStateException("이미 존재하는 회원입니다."); // throw 뒤에는 예외 객체가 와야함,
                    });                                                         // IllegalStateException은 예외객체임,
            // NullPointerException도 예외객체..etc
            // findByName이 NULL값이 아니기 위해
        }

        //전체 회원 조회
        public List<Member> findMembers() {
            return memberRepository.findAll();
        }

        public Optional<Member> findOne(Long memberId) {
            return memberRepository.findById(memberId);
        }
}
