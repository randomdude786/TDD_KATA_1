package testDrivenDevelopment;

import java.util.Arrays;

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
	public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        return Arrays.stream(numbers.split(","))
                     .mapToInt(Integer::parseInt)
                     .sum();
    }

}

