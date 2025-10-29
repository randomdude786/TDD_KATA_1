package testDrivenDevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
	/*public static int add(String numbers) {
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
	}*/
	private static String extractDelimiter(String input) {
	    if (!input.startsWith("//")) return ",|\n";
	    int newlineIndex = input.indexOf("\n");
	    String custom = Pattern.quote(input.substring(2, newlineIndex));
	    return custom + "|\n"; // allow newlines too
	}


	private static String extractBody(String input) {
	    if (!input.startsWith("//")) return input;
	    int newlineIndex = input.indexOf("\n");
	    return input.substring(newlineIndex + 1);
	}

	public static int add(String numbers) {
	    if (numbers == null || numbers.isEmpty()) return 0;

	    String delimiterRegex = extractDelimiter(numbers);
	    String body = extractBody(numbers);

	    String[] tokens = body.split(delimiterRegex);
	    List<Integer> negatives = new ArrayList<>();

	    int sum = 0;
	    for (String token : tokens) {
	        if (token.isEmpty()) continue;
	        int n = Integer.parseInt(token);
	        if (n < 0) negatives.add(n);
	        sum += n;
	    }

	    if (!negatives.isEmpty()) {
	        String message = negatives.stream()
	                                  .map(String::valueOf)
	                                  .collect(Collectors.joining(","));
	        throw new IllegalArgumentException("Negatives not allowed: " + message);
	    }


	    return Arrays.stream(tokens)
	            .filter(s -> !s.isEmpty())
	            .mapToInt(Integer::parseInt)
	            .filter(n -> n <= 1000)        // ✅ ignore > 1000
	            .sum();

	}


	private static String getFirstDelimiter(String regex) {
	    // In case of multiple delimiters like ,|\n or [;]
	    return regex.contains("|") ? regex.split("\\|")[0].replace("\\Q", "").replace("\\E", "") : regex;
	}

	private static void checkForNegatives(List<Integer> negatives) {
	    if (negatives.isEmpty()) return;

	    String message = negatives.stream()
	            .map(String::valueOf)
	            .collect(Collectors.joining(","));
	    throw new IllegalArgumentException("Negatives not allowed: " + message);
	}



}

