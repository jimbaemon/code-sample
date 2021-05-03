package jimbae.inflearnjavatest;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

	@Test
	@DisplayName("스터디 만들기")
	void create(){
		// TODO : ThreadLocal 사용시 예상치 못한 오류 발생가능
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			new Study(10);
			Thread.sleep(5000);
		});

		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> new Study(-10));

		assertEquals("limit 은 0 보다 커야 한다." ,illegalArgumentException.getMessage());

		Study study = new Study(10);
		assertAll(
			() -> assertNotNull(study),
			() -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 DRAFT 상태여야 한다."),
			() -> assertTrue(study.getLimit() > 0, () -> "스터디 참가자는 0명 이상이여야 한다.")
		);
	}

	@Test
	@Disabled
	void create1(){
		System.out.println("create1");
	}

	@BeforeAll
	static void beforeAll(){
		System.out.println("before all");
	}

	@AfterAll
	static void afterAll(){
		System.out.println("after all");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("before each");
	}

	@AfterEach
	void afterEach(){
		System.out.println("after each");
	}
}