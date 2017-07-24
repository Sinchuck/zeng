package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(reverse(1534236469));
//		System.out.print(-1 << 31);
	}

	//以下是我的傻逼做法
//	public static int reverse(int x) {
//		Integer copy = x;
//		String string = copy.toString();
//		StringBuilder sb = new StringBuilder();
//		
//		if (string.charAt(0) == '-') {
//			sb.append(string.charAt(0));
//			for (int length = string.length(), i = length - 1; i > 0; i--) {
//				sb.append(string.charAt(i));
//			}
//			long result = Long.parseLong(sb.toString());
//			if (result > Integer.MAX_VALUE ||
//					result < Integer.MIN_VALUE) {
//				return 0;
//			} else {
//				return (int)result;
//			}
//		} else {
//			for (int length = string.length(), i = length - 1; i >= 0; i--) {
//				sb.append(string.charAt(i));
//			}
//			long result = Long.parseLong(sb.toString());
//			if (result > Integer.MAX_VALUE ||
//					result < Integer.MIN_VALUE) {
//				return 0;
//			} else {
//				return (int)result;
//			}
//		}
//	}
	
	//正确做法
	public static int reverse(int x) {
		int result = 0;
		
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			//这里处理溢出的情况
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}
		
		return result;
	}
}
