package me.yosae.repository;

import me.yosae.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/data.sql")
    @Test
    void getAllMembers(){
        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/data.sql")
    @Test
    void getMember(){
        Member member = memberRepository.findById(2L).get();

        Assertions.assertEquals("name2", member.getName());
    }

    @Sql("/data.sql")
    @Test
    void getMemberByName(){
        Member member = memberRepository.findByName("name3").get();

        Assertions.assertEquals("name2", member.getName());
    }

    @Test
    void saveMember(){
        //given
        Member member = new Member(1L,"nameNew");
        //when
        memberRepository.save(member);
        //then
        Assertions.assertEquals("nameNew", memberRepository.findByName("nameNew").get().getName());
    }

    @Test
    void saveMembers(){
        //given
        List<Member> members = List.of(new Member(2L, "B"),
                new Member(3L, "C"));
        //when
        memberRepository.saveAll(members);
        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(members.size());
    }

    @Sql("/data.sql")
    @Test
    void deleteMemberById(){
        //when
        memberRepository.deleteById(2L);
        //then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    @Sql("/data.sql")
    @Test
    void update(){
        //given
        Member member = memberRepository.findById(2L).get();
        //when
        member.setName("BC");
        //then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }
}