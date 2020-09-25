package com.harper.book.springboot.service.posts;

import com.harper.book.springboot.domain.posts.Posts;
import com.harper.book.springboot.domain.posts.PostsRepository;
import com.harper.book.springboot.web.dto.PostsResponseDto;
import com.harper.book.springboot.web.dto.PostsSaveRequestDto;
import com.harper.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링에서 bean을 주입받는 방식은 다음과 같다. @Autowired, @Setter, 생성자.
// 이 중 가장 권장받는 방법은 생성자로 주입받는방식이다.
// @RequiredArgsConstructor가 대신 생성해 준 것. ( 롬복 어노테이션)
@RequiredArgsConstructor
@Service
public class PostsServcie{
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }



    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                                    .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

              posts.update(requestDto.getTitle(), requestDto.getContent());

              return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
