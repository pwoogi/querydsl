package com.study.querydsl.controller;

import com.study.querydsl.dto.PostResponseDto;
import com.study.querydsl.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

//    @GetMapping("/post")
//    public List<PostResponseDto> find(@PageableDefault(size = 7) Pageable pageable){
//        return postService.findAll(pageable).getContent();
//    }
}
