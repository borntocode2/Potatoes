package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository//자바는 이게 repository인지 몰라, 어노테이션으로 알려준다. 이게 Repository야.
//리포지토리는 엔티티를 db랑 연결짓는 역할
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // new hashMap<>();  메서드 안에 Map t사용, 반대
                                                              // Map<Long, Member> 제네릭 타입, 타입을 일반화하여 안정적이게
                                                              // 자바 컬렉션 중에 Map 타입으로 제네릭을 정의하여 Long, Member타입만 받을 수 있게끔 정의함
    private static long sequence = 0L;

    @Override //다른 개발자한테 알려준다. 이건 상속받은거라고.
    public Member save(Member member) {
        member.setId(++sequence); //save메서드가 호출된다면 member객체의 ID가 Long타입으로 증가되고
        store.put(member.getId(), member);//store 해쉬맵에 id가 저장되고 member 객체가 저장된다.;
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { //store.get(id)는 id라는 키에 해당하는 Member 객체를 반환거나 NULL return
        return Optional.ofNullable(store.get(id)); //id를 이용하여 member 찾는 메서드
    }                                               // Member or Null을 반환하기 떄문에 .ofNullable 메서드를 이용해 NULL일경우 빈 객체반환

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny(); //반환 타입이
        //반환타입이 옵셔널이기 때문에, NULL값을 반환하진 않는다. 향후 검증로직에서 ifPresent 메서드 안의 NPE를 방지함.
        //문법 학습 필요
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
