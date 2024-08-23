package hello.hello_spring.domain;

public class Member {

    private Long id;//데이터를 구분하기위해 시스템이정하는 id
    private String name;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

}
