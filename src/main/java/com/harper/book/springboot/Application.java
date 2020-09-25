package com.harper.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 이 어노테이션으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로.
// 이 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 상단에 위치해야한다.
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {
    public static void main(String[] args) {

        // springApplication.run으로 인해 내장 was가 실행된다. 스프링부트에서는 내장 WAS를 사용하는것을 권장.
        SpringApplication.run(Application.class, args);
    }
}