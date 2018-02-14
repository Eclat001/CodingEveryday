package facebook;

public class IntegerToWords {
	private final String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",                                 "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] units = {"", "Thousand", "Million", "Billion"};
	private String help(int num) {
	    if (num == 0) {
	        return "";
	    }
	    else if (num < 20) {
	        return less20[num] + " ";
	    }
	    else if (num < 100) {
	        return tens[num / 10] + " " + help(num % 10);
	    }
	    else {
	        return less20[num / 100] + " Hundred " + help(num % 100);
	    }
	}
	public String numberToWords(int num) {
	    if (num == 0) {
	        return "Zero";
	    }
	    int i = 0;
	    String rst = "";
	    
	    while (num > 0){
	        if (num % 1000 != 0) {
	            rst = help(num % 1000) + units[i] + " "+ rst;
	            }
	            num /= 1000;
	            i++;
	        }
	        return rst.trim();
	    }
	public static void main(String[] args) {
		int num1 = 123;
		int num2 = 12345;
		int num3 = 1234567;
		IntegerToWords it = new IntegerToWords();
		System.out.println(it.numberToWords(num1));
		System.out.println(it.numberToWords(num2));
		System.out.println(it.numberToWords(num3));
	}
	
	
	}
