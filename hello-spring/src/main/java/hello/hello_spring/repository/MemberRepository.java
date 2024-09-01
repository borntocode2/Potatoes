package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import java.util.List;
import java.util.Optional;

//인터페이스 - 청사진, 아직 구현되지 않은 메서드
public interface MemberRepository {

    Member save(Member member); //Member 객체가 반환값 타입이다.
    Optional<Member> findById(Long id);//옵셔널은  널익셉션포인터 방지,
    Optional<Member> findByName(String name); //Optional 이 반환타입, 옵셔널 박스에 내가 원하고자하는 리턴값이 들어있다
    List<Member> findAll();



}
