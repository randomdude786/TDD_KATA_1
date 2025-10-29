package testDrivenDevelopment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyStringReturnsZero() {
	    assertEquals(0, StringCalculator.add(""));
	}
	@Test
	public void testSingleNumberReturnsValue() {
	    assertEquals(5, StringCalculator.add("5"));
	}
	@Test
	public void testTwoNumbersReturnsSum() {
	    assertEquals(3, StringCalculator.add("1,2"));
	}
	@Test
	public void testUnknownAmountOfNumbers() {
	    assertEquals(10, StringCalculator.add("1,2,3,4"));
	}
	@Test
	public void testNewlineAsDelimiter() {
	    assertEquals(6, StringCalculator.add("1\n2,3"));
	}


}
