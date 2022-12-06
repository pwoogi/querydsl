package com.study.querydsl.dto;

import com.study.querydsl.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PostResponseDto {

    private Long id;

    private String username;

    private String title;

    private String content;

    public static PostResponseDto from(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .username(post.getMember().getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .build();

    }
}
