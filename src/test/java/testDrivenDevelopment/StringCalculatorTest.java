package testDrivenDevelopment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyStringReturnsZero() {
	    assertEquals(0, StringCalculator.add(""));
	}

}
