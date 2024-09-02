package hello.hello_spring.domain;

public class Member {

    private Long id;//데이터를 구분하기위해 시스템이정하는 id
    private String name;

    public Long getId(){ //메서드
        return id;
    }

    public void setId(Long id){ // id를 세팅한다. 왜 파라미터가 Member member 엔티티가 아닌가?
        this.id = id;
    }

    public String getName(){ //메서드

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
