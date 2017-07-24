package leetcode;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInteger("DCXXI"));
	}

	public static int romanToInteger(String s) {
		int result = 0;
		if (s.indexOf("IV") != -1 || s.indexOf("IX") != -1) {
			result -= 2;
		}
		if (s.indexOf("XL") != -1 || s.indexOf("XC") != -1) {
			result -= 20;
		}
		if (s.indexOf("CD") != -1 || s.indexOf("CM") != -1) {
			result -= 200;
		}
		
		char c[] = s.toCharArray();
		int count = 0;
		
		for(; count < s.length(); count++) {
			if (c[count] == 'M') result += 1000;
			if (c[count] == 'D') result += 500;
			if (c[count] == 'C') result += 100;
			if (c[count] == 'L') result += 50;
			if (c[count] == 'X') result += 10;
			if (c[count] == 'V') result += 5;
			if (c[count] == 'I') result += 1;
		}
		
		return result;
	}
}
