package testDrivenDevelopment;

public class StringCalculator {
    /*public static int add(String numbers) {
        return 0; 
    }
   */ 
    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return Integer.parseInt(numbers);
    }
}

