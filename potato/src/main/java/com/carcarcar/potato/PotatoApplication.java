package com.carcarcar.potato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//스프링부트가 메인을 찾는다. 가장 먼저.
@SpringBootApplication // 서블릿 작동, spring bean을 주입
public class PotatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PotatoApplication.class, args);
	}

}
