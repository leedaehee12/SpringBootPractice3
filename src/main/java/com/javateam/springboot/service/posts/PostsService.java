package com.javateam.springboot.service.posts;

import com.javateam.springboot.web.domain.posts.PostRepository;
import com.javateam.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostRepository postRepository;
    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

}
