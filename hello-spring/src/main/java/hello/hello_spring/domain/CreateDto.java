package hello.hello_spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //
@NoArgsConstructor //createDto를 컨테이너의 객체로 만들기 위해서
@AllArgsConstructor//createDto를 컨테이너의 객체로 만들기 위해서

public class CreateDto {

    private Long id;//데이터를 구분하기위해 시스템이정하는 id
    private String name;

}
