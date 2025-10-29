package testDrivenDevelopment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;



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
	@Test
	public void testCustomDelimiterSyntax() {
	    assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	@Test
	public void testDefaultDelimiterStillWorks() {
	    assertEquals(6, StringCalculator.add("1,2,3"));
	}

	@Test
	public void testNewlineStillWorksWithDefaultDelimiter() {
	    assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test
	public void testCustomDelimiterWithNewline() {
	    assertEquals(10, StringCalculator.add("//;\n1;2\n3;4"));
	}
	@Test
	public void testNegativeNumberThrowsException() {
	    Exception ex = assertThrows(IllegalArgumentException.class, 
	        () -> StringCalculator.add("1,-2,3"));
	    assertEquals("Negatives not allowed: -2", ex.getMessage());
	}
	@Test
	public void testIgnoreNumbersGreaterThanThousand() {
	    assertEquals(2, StringCalculator.add("2,1001"));
	}
	@Test
	public void testDelimiterOfAnyLength() {
	    assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void testMultipleDelimiters() {
	    assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void testMultipleDelimitersOfDifferentLengths() {
	    assertEquals(6, StringCalculator.add("//[**][%%]\n1**2%%3"));
	}

	@Test
	public void testMultipleDelimitersWithNewlines() {
	    assertEquals(10, StringCalculator.add("//[*][%]\n1*2\n3%4"));
	}
	@Test
	public void testGetCalledCountTracksInvocations() {
	    int before = StringCalculator.getCalledCount();

	    StringCalculator.add("1,2");
	    StringCalculator.add("1,2,3");

	    assertEquals(before + 2, StringCalculator.getCalledCount());
	}



}
