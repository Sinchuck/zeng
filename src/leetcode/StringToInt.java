package leetcode;

public class StringToInt {

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}

	public static int myAtoi(String str) {
//		String str1 = "";
//		for (int i = 0, length = str.length(); i < length; i++) {
//			if (str.charAt(i) != ' ') {
//				str1 = str.substring(i);
//				break;
//			}
//		}
//		if (str1 == "" || str1 == "+" || str1 == "-") {
//			return 0;
//		}
//		long result = Long.parseLong(str1);
//		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
//			return 0;
//		}
//		return (int)result;
		System.out.println(str);
		int index = 0, sign = 1, total = 0, length = str.length();
		// First step: empty string
		if (length == 0) {
			return 0;
		}
		
		// Second step: remove spaces
		while (str.charAt(index) == ' ' && index < length) {
			index++;
		}
		
		// Third step: handle signs
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}
		
		//Fourth step: convert number and avoid overflow
		while (index < length) {
			int digit = str.charAt(index) - '0';
			if (digit < 0 || digit > 9) {
				break;
			}
			
			// check if total will be overflow after 10 times and add digit
			if ((Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total)
					&& Integer.MAX_VALUE % 10 < digit) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			
			total = 10 * total + digit;
			index++;
		}
		return total * sign;
	}
}
