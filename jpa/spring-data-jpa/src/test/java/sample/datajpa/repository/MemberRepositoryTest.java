package sample.datajpa.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import sample.datajpa.dto.MemberDTO;
import sample.datajpa.entity.Member;
import sample.datajpa.entity.Team;

@SpringBootTest
@Transactional
class MemberRepositoryTest {


	@Autowired MemberRepository memberRepository;
	@Autowired TeamRepository teamRepository;

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

	@Test
	public void basicCRUD(){
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		memberRepository.save(member1);
		memberRepository.save(member2);

		//단건 조회
		Member findMember1 = memberRepository.findById(member1.getId()).get();
		Member findMember2 = memberRepository.findById(member2.getId()).get();
		assertThat(findMember1).isEqualTo(member1);
		assertThat(findMember2).isEqualTo(member2);

		//리스트 조회 검증
		List<Member> all = memberRepository.findAll();
		assertThat(all.size()).isEqualTo(2);

		//카운트
		long count = memberRepository.count();

		//삭제
		memberRepository.delete(member1);
		memberRepository.delete(member2);

		long deletedCount = memberRepository.count();
		assertThat(deletedCount).isEqualTo(0);
	}

	@Test
	public void findByUsernameAndAgeGreateThen(){
		Member m1 = new Member("AAA", 10);
		Member m2 = new Member("AAA", 20);
		memberRepository.save(m1);
		memberRepository.save(m2);

		var findMember = memberRepository.findByUsernameAndAgeGreaterThan("AAA", 15);

		assertThat(findMember.get(0)).isEqualTo(m2);
		assertThat(findMember.size()).isEqualTo(1);
	}

	@Test
	public void testNamedQuery(){
		Member m1 = new Member("AAA", 10);
		Member m2 = new Member("BBB", 20);
		memberRepository.save(m1);
		memberRepository.save(m2);

		List<Member> findMember = memberRepository.findByUsername("AAA");
		assertThat(findMember.get(0)).isEqualTo(m1);
		assertThat(findMember.size()).isEqualTo(1);
	}

	@Test
	public void testQueryAnnotation(){
		Member m1 = new Member("AAA", 10);
		Member m2 = new Member("AAA", 20);
		memberRepository.save(m1);
		memberRepository.save(m2);

		List<Member> findMember = memberRepository.findUser("AAA", 10);
		assertThat(findMember.get(0)).isEqualTo(m1);
		assertThat(findMember.size()).isEqualTo(1);
	}

	@Test
	public void testMemberDTO(){
		Team team = new Team("팀1");
		teamRepository.save(team);

		Member m1 = new Member("AAA", 10);
		m1.setTeam(team);
		memberRepository.save(m1);

		List<MemberDTO> memberDto = memberRepository.findMemberDto();
		for (MemberDTO memberDTO : memberDto) {
			System.out.println("memberDTO = " + memberDTO);
		}
	}

	@Test
	public void testfindByMemberNames(){
		Member m1 = new Member("AAA", 10);
		Member m2 = new Member("AAA", 20);
		memberRepository.save(m1);
		memberRepository.save(m2);

		List<Member> findMember = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));
		for (Member member : findMember) {
			System.out.println("member = " + member);
		}
	}

	@Test
	public void paging(){
		//given
		memberRepository.save(new Member("Member1", 10));
		memberRepository.save(new Member("Member2", 10));
		memberRepository.save(new Member("Member3", 10));
		memberRepository.save(new Member("Member4", 10));
		memberRepository.save(new Member("Member5", 10));

		int age = 10;
		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));//0~3개 가져와

		//when
		Page<Member> page = memberRepository.findByAge(age, pageRequest);
		//Slice<Member> slice = memberRepository.findByAge(age, pageRequest);

		Page<MemberDTO> toMap = page.map(m -> new MemberDTO(m.getId(), m.getUsername(), null));

		//then
		List<Member> content = page.getContent();
		long totalElements = page.getTotalElements();

		assertThat(content.size()).isEqualTo(3);
		assertThat(page.getTotalElements()).isEqualTo(5);
		assertThat(page.getNumber()).isEqualTo(0);
		assertThat(page.getTotalPages()).isEqualTo(2);
		assertThat(page.isFirst()).isTrue();
		assertThat(page.hasNext()).isTrue();

	}
}