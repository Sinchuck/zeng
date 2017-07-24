package leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(04240 + "");
		System.out.println(isPalindrome(04240));
	}
	
	public static boolean isPalindrome(int x) {
		
/**
 * 使用字符串解决，但不符合题目的空间需求
 */
//		boolean result = true;
//		String string = x + "";
//		for (int i = 0, length = string.length(); i < length; i++, length--) {
//			if (string.charAt(i) != string.charAt(length - 1)) {
//				result = false;
//				break;
//			}
//		}
//		return result;
		
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        
        return (x == reverse || x == reverse / 10);
	}
}
