package com.study.querydsl.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(of = {"id", "username", "age"})
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username){
        this(username, 0);

    }

    public Member(String username, int age){
        this(username, age, null);

    }

    public Member(String username, int age, Team team){
        this.username = username;
        this.age = age;
        if(team != null){
            changeTeam(team);
        }

    }

    public static Member createMember(){
        return Member.builder()
                .id(1L)
                .age(100)
                .username("chris")
                .build();

    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
