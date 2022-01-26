package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	static class Calculator{
		public int add(int a,int b){
			return a+b;
		}
	}
	Calculator underTest = new Calculator();
	@Test
	void checkTest() {
		//given
		int i = 2;
		int j = 3;
		//when
		int expected = underTest.add(i,j);
		//then
		assertEquals(5,expected);
	}

}
