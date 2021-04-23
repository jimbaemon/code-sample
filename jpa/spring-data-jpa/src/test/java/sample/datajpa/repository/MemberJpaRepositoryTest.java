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

	@Test
	public void findByUsernameAndAgeGreateThen(){
		Member m1 = new Member("AAA", 10);
		Member m2 = new Member("AAA", 20);
		memberJpaRepository.save(m1);
		memberJpaRepository.save(m2);

		var findMember = memberJpaRepository.findByUsernameAndAgeGreaterThen("AAA", 15);

		assertThat(findMember.get(0)).isEqualTo(m2);
		assertThat(findMember.size()).isEqualTo(1);
	}


	@Test
	public void testNamedQuery(){
		Member m1 = new Member("AAA", 10);
		Member m2 = new Member("BBB", 20);
		memberJpaRepository.save(m1);
		memberJpaRepository.save(m2);

		List<Member> findMember = memberJpaRepository.findByUsername("AAA");
		assertThat(findMember.get(0)).isEqualTo(m1);
		assertThat(findMember.size()).isEqualTo(1);
	}

	@Test
	public void paging(){
		//given
		memberJpaRepository.save(new Member("Member1", 10));
		memberJpaRepository.save(new Member("Member2", 10));
		memberJpaRepository.save(new Member("Member3", 10));
		memberJpaRepository.save(new Member("Member4", 10));
		memberJpaRepository.save(new Member("Member5", 10));

		int age = 10;
		int offset = 0;
		int limit = 3;

		//when
		List<Member> members = memberJpaRepository.findByPage(age, offset, limit);
		long totalCount = memberJpaRepository.totalCount(age);

		//then
		assertThat(members.size()).isEqualTo(3);
		assertThat(totalCount).isEqualTo(5);

	}

	@Test
	public void bulkUpdate(){
		//given
		memberJpaRepository.save(new Member("Member1", 10));
		memberJpaRepository.save(new Member("Member2", 19));
		memberJpaRepository.save(new Member("Member3", 20));
		memberJpaRepository.save(new Member("Member4", 21));
		memberJpaRepository.save(new Member("Member5", 40));

		//when
		int resultCount = memberJpaRepository.bulkAgePlus(20);

		assertThat(resultCount).isEqualTo(3);

	}
}