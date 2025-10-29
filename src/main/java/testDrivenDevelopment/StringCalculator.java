package testDrivenDevelopment;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    /*public static int add(String numbers) {
        return 0; 
    }
   */ 
    /*public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return Integer.parseInt(numbers);
    }
    */
	/*public static int add(String numbers) {
	    if (numbers.isEmpty()) return 0;
	    String[] parts = numbers.split(",");
	    int sum = 0;
	    for (String p : parts) {
	        sum += Integer.parseInt(p);
	    }
	    return sum;
	}
	*/
	/*public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        return Arrays.stream(numbers.split(","))
                     .mapToInt(Integer::parseInt)
                     .sum();
    }
	*/
	/*public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;

        String[] parts = numbers.split(",");
        return Arrays.stream(parts) 
                     .filter(s -> !s.isEmpty()) //added filter for empty input
                     .mapToInt(Integer::parseInt)
                     .sum();
    }
    */
	/*public static int add(String numbers) {
	    if (numbers == null || numbers.isEmpty()) return 0;

	    // Replace newline with comma so both work as delimiters
	    String sanitized = numbers.replace("\n", ",");

	    return Arrays.stream(sanitized.split(","))
	                 .filter(s -> !s.isEmpty())
	                 .mapToInt(Integer::parseInt)
	                 .sum();
	}
	*/
	public static int add(String numbers) {
	    if (numbers == null || numbers.isEmpty()) return 0;

	    String delimiter = ",";
	    if (numbers.startsWith("//")) {
	        int newlineIndex = numbers.indexOf("\n");
	        delimiter = numbers.substring(2, newlineIndex);
	        numbers = numbers.substring(newlineIndex + 1);
	    }

	    String[] tokens = numbers.replace("\n", delimiter).split(Pattern.quote(delimiter));

	    return Arrays.stream(tokens)
	                 .filter(s -> !s.isEmpty())
	                 .mapToInt(Integer::parseInt)
	                 .sum();
	}


}

