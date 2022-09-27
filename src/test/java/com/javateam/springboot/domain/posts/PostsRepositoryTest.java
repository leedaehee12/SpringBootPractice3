package com.javateam.springboot.domain.posts;

import com.javateam.springboot.web.domain.posts.PostRepository;
import com.javateam.springboot.web.domain.posts.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {


    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();

    }

    @Test
    public void save_load(){
    //given
        String title = "Test Title";
        String content = "Test Test";

        postRepository.save(Posts.builder().title(title).content(content).build());


        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2022,9,26,0,0,0);
        postRepository.save(Posts.builder().title("title").content("content").author("author").build());
        //when
        List<Posts> postsList = postRepository.findAll();
        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>createDate = " + posts.getCreatedDate()+", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
