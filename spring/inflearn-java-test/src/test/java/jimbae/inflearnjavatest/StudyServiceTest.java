package jimbae.inflearnjavatest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
/*@MockitoSettings(strictness = Strictness.LENIENT)*/
class StudyServiceTest {

	@Mock
	MemberService memberService;

	@Mock
	StudyRepository studyRepository;

	@Test
	void createStudyService(/*@Mock MemberService memberService, @Mock StudyRepository studyRepository*/){
		/*MemberService memberService = mock(MemberService.class);
		StudyRepository studyRepository = mock(StudyRepository.class);*/
		StudyService studyService = new StudyService(memberService, studyRepository);
		assertNotNull(studyService);

		Member member = new Member();
		member.setId(1L);
		member.setEmail("keesun@gmail.com");

		/*when(memberService.findById(1L)).thenReturn(Optional.of(member));
		when(memberService.findById(1L)).thenThrow(IllegalArgumentException.class);*/

		Study study = new Study(10, "java");

		Optional<Member> findMember = memberService.findById(1L);
		assertEquals(member, findMember.get());
	}

	@Test
	void mockStubbingExercise(){
		StudyService studyService = new StudyService(memberService, studyRepository);
		Study study = new Study(10, "테스트");

		//memberService 객체에 findById 메소드를 1L 값으로 호출하면 member 객체를 리턴하도록 Stubbing
		Member member = new Member();
		study.setOwner(member);

		when(memberService.findById(1L)).thenReturn(Optional.of(member));

		//studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 stubbing
		when(studyRepository.save(study)).thenReturn(study);

		studyService.createNewStudy(1L, study);

		verify(memberService, times(1)).notify();

		assertNotNull(study.getOwner());
		assertEquals(member, study.getOwner());


	}
}