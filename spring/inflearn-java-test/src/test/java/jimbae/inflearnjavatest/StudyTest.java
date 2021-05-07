package jimbae.inflearnjavatest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import net.bytebuddy.implementation.bind.annotation.Empty;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

	@Test
	@DisplayName("스터디 만들기")
	void create(){
		// TODO : ThreadLocal 사용시 예상치 못한 오류 발생가능
		assertTimeout(Duration.ofMillis(100), () -> {
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
	@EnabledOnOs(OS.WINDOWS)
	@EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
	void create1(){
		String test_env = System.getenv("TEST_ENV");
		System.out.println(test_env);
		assumeTrue("LOCAL".equalsIgnoreCase(test_env));

		assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
			System.out.println("create1");
		});


	}

	@Test
	@EnabledOnOs(OS.LINUX)
	void create2(){
		String test_env = System.getenv("TEST_ENV");
		System.out.println(test_env);
		assumeTrue("LOCAL".equalsIgnoreCase(test_env));

		assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
			System.out.println("create1");
		});


	}

	@Test
	@DisplayName("태그 그룹1")
	@Tag("group1")
	void create_group1_1(){
		System.out.println("group1");
	}

	@Test
	@DisplayName("태그 그룹2")
	@Tag("group2")
	void create_group2_1(){
		System.out.println("group2");
	}

	@DisplayName("스터디 만들기")
	@RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
	void repeatTest(RepetitionInfo repetitionInfo){
		System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
	}

	@DisplayName("스터디 만들기")
	@ParameterizedTest(name = "[{index}] {displayName} message={0}")
	@ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
	@EmptySource
	@NullSource
	@NullAndEmptySource
	void parameterizedTest(String message){
		System.out.println(message);
	}

	@DisplayName("스터디 만들기2")
	@ParameterizedTest(name = "[{index}] {displayName} message={0}")
	@ValueSource(ints = {10, 20,30})
	void parameterizedTest2(@ConvertWith(StudyConverter.class) Study study){
		System.out.println(study.getLimit());
	}

	@DisplayName("스터디 만들기3")
	@ParameterizedTest(name = "[{index}] {displayName} message={0}")
	@CsvSource({"10, '자바 스터디'", "20, 스프링" })
	void parameterizedTest3(ArgumentsAccessor argumentsAccessor){
		Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
		System.out.println(study);
	}

	static class StudyConverter extends SimpleArgumentConverter{

		@Override
		protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
			assertEquals(Study.class, targetType, "can only convert to Study");
			return new Study(Integer.parseInt(source.toString()));
		}
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