package sample.datajpa.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.transaction.annotation.Transactional;

import sample.datajpa.entity.Member;

@SpringBootTest
@Transactional
class MemberRepositoryTest {


	@Autowired MemberRepository memberRepository;

	@Test
	@Description("스프링 데이터 JPA 테스트")
	public void memberTest(){
		Member member = new Member("memberA");
		Member savedMember = memberRepository.save(member);

		Member findMember = memberRepository.getOne(savedMember.getId());

		assertThat(findMember.getId()).isEqualTo(savedMember.getId());
		assertThat(findMember.getUsername()).isEqualTo(savedMember.getUsername());
		assertThat(findMember).isEqualTo(savedMember);
	}
}