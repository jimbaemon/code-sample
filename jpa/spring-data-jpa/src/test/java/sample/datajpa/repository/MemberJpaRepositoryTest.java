package sample.datajpa.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.transaction.annotation.Transactional;

import sample.datajpa.entity.Member;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

	@Autowired
	MemberJpaRepository memberJpaRepository;

	@Test
	@Description("저장한 멤버가 동일한지 확인")
	public void testMember(){
		Member member = new Member("memberA");
		Member savedMember = memberJpaRepository.save(member);

		Member findMember = memberJpaRepository.find(savedMember.getId());

		assertThat(findMember.getId()).isEqualTo(savedMember.getId());
		assertThat(findMember.getUsername()).isEqualTo(savedMember.getUsername());
		assertThat(findMember).isEqualTo(savedMember);
	}

	@Test
	public void basicCRUD(){
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		memberJpaRepository.save(member1);
		memberJpaRepository.save(member2);

		//단건 조회
		Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
		Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
		assertThat(findMember1).isEqualTo(member1);
		assertThat(findMember2).isEqualTo(member2);

		//리스트 조회 검증
		List<Member> all = memberJpaRepository.findAll();
		assertThat(all.size()).isEqualTo(2);

		//카운트
		long count = memberJpaRepository.count();

		//삭제
		memberJpaRepository.delete(member1);
		memberJpaRepository.delete(member2);

		long deletedCount = memberJpaRepository.count();
		assertThat(deletedCount).isEqualTo(0);
	}


}