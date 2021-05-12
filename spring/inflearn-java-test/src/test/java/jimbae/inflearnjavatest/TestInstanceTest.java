package jimbae.inflearnjavatest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestInstanceTest {

	int value = 1;

	@Test
	@Order(1)
	void valueTest1(){
		System.out.println("value1 = " + value++);
	}

	@Test
	@Order(3)
	void valueTest2(){
		System.out.println("value2 = " + value++);
	}

	@Test
	@Order(2)
	void valueTest3(){
		System.out.println("value3 = " + value++);
	}
}
