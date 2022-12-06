package com.study.querydsl.repository;

import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByMemberOrderByIdDesc(Member member, Pageable pageable);
}
