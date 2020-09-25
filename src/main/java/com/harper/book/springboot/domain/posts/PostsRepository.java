package com.harper.book.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

// Dao라고 불리는 DB Layer 접근자. Repository라고 부르며 인터페이스로 생성.
// Entity클래스와 기본 Entity Repository는 함께 위치해야한다. Entity클래스는 기본 Repository 없이는 제대로 역할을 할 수 가없음.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
