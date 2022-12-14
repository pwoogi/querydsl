package com.study.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.QMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.study.querydsl.entity.QMember.*;

@Repository
public class MemberJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;


    public MemberJpaRepository(EntityManager em, JPAQueryFactory jpaQueryFactory) {
        this.em = em;
        this.queryFactory = jpaQueryFactory;
    }

    public void save(Member member) {
        em.persist(member);
    }

    public Optional<Member> findById(Long id) {
        Member findMember = em.find(Member.class, id);
        return Optional.ofNullable(findMember);

    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();

    }

    public List<Member> findAll_QueryDsl() {
        return queryFactory
                .selectFrom(member)
                .fetch();

    }

    public List<Member> findByUsername(String username) {
        return em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", username)
                .getResultList();

    }

    public List<Member> findByUsername_QueryDsl(String username) {
        return queryFactory
                .selectFrom(member)
                .where(member.username.eq(username))
                .fetch();
    }

}
