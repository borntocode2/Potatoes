package hello.hello_spring.sevice;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //이건 왜?
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository() { //인터페이스라서 이따구로 만든건가?
        public Long join(Member member) {
            validateDuplicateMember(member); //중복 회원 방지
            memberRepository.save(member);
            return member.getId();
        }

        private void validateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName()) //Repo에서 member의 네임이 존재하면 throw new
                    .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다."); // throw 뒤에는 예외 객체가 와야함,
                    });                                                         // IllegalStateException은 예외객체임,
            // NullPointerException도 예외객체..etc
        }

        //전체 회원 조회
        public List<Member> findMembers() {
            return memberRepository.findAll();
        }

        public Optional<Member> findOne(Long memberId) {
            return memberRepository.findById(memberId);
        }
    };
}
