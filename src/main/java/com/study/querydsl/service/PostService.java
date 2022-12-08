package com.study.querydsl.service;

import com.study.querydsl.dto.PostResponseDto;
import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.Post;
import com.study.querydsl.repository.MemberRepository;
import com.study.querydsl.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static com.study.querydsl.entity.Member.createMember;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    @PostConstruct
    public void init() {
        Member member = memberRepository.save(Member.builder().age(0).username("chris").build());
        for (int i = 1; i <= 25; ++i) {
            postRepository.save(Post.builder().title("제목" + i).content("내용" + i).member(member).build());
        }
    }
    public Page<PostResponseDto> findAll(Pageable pageable){
        return postRepository.findByMemberOrderByIdDesc(createMember(), pageable)
                .map(PostResponseDto::from);

    }
}
