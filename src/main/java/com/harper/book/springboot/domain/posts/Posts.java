package com.harper.book.springboot.domain.posts;

import com.harper.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity  // JPA의 annotation, 테이블과 링크될 클래스임을 명시
public class Posts extends BaseTimeEntity {      // BaseTimeEntity를 상속받음으로써 앞으로 추가, 수정될 entity의 등록,수정시간 고민할 필요없음

    @Id  // 해당 table의 Primary Key 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}


//import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
//import com.harper.book.springboot.domain.BaseTimeEntity;
//import com.sun.javafx.beans.IDProperty;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//
//@Getter     // 클래스 내 모든 필드의 Getter 메소드를 자동 생성. Entity클래스에서는 절대 Setter 메서드를 만들지 않는다.
//@NoArgsConstructor  // 롬복 어노테이션. public Posts(){} 와 같은 효과. (기본생성자)
//@Entity     // JPA 어노테이션션 -> 엔티티 클래스는 실제 DB의 테이블과 매칭될 클래스. 테이블과 링크될 클래스.  // 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭.
//public class Posts extends BaseTimeEntity {
//
//    @Id // -> 해당 테이블의 PK필드를 나타낸다.
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // -> PK의 생성 규칙을 나타낸다. 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야지 auto_increment가 된다.
//    private Long id;  // Entity의 PK는 Long 타입의 Auto_increment를 추천한다.
//
//    @Column(length = 500, nullable = false) //-> 굳이 선언하지 않더라도 해당클래스의 필드는 모두 칼럼이 된다.
//    private String title;
//
//    @Column(columnDefinition = "TEXT", nullable = false) // -> 사용하는 이유는 ,기본값 외에도 추가로 변경이 필요한 옵션이 있으면 사용.
//    private String content;                              // 문자열의 경우 사이즈를 500으로 늘리고싶거나 타입을 TEXT로 변경하고 싶은 경우 등에 사용.
//
//    private String author;
//
//    @Builder // -> 해당 클래스의 빌더패턴 클래스를 생성. 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
//    public Posts(String title, String content, String author){
//        this.title = title;
//        this.content = content;
//        this.author = author;
//    }
//
//    public void update(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//}
