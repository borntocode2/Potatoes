package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//이건 왜?
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //save메서드가 호출된다면 member객체의 ID가 Long타입으로 증가되고
        store.put(member.getId(), member);//store 해쉬맵에 id가 저장되고 member 객체가 저장된다.;
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //id를 찾는 메서드 findById가 호출되면 store에서 Optional로 감싸진 id를 리턴
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny(); //**요놈
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
