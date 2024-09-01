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

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

        public Long join(Member member) {
            validateDuplicateMember(member); //중복 회원 방지
            memberRepository.save(member); //save메서드에 반환 타입은 Member타입이다,
            return member.getId(); //왜 return이지?
        }
        private void validateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName())// 옵셔널안에 멤버 객체가 있는 것 //Repo에서 member의 네임이 존재하면 throw new
                    .ifPresent(m -> { // ifpresent가 Null을 받으면 NPE를 발생시키고, 값이 있으면 ifpresent 파라미터의 함수를 실행시킴.
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
