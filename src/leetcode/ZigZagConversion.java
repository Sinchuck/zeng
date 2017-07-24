package leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(convert("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int numRows) {
		if(numRows < 1) {
			return "";
		} else if (numRows == 1) {
			return s;
		} else {
			//根据行数寻找规律，即每divide个字符为一个周期
			int divide = numRows*2 - 2;
			StringBuilder result = new StringBuilder();
			int length = s.length();
			for (int j = 0; j < numRows; j++) {
				int count = 1;
				//第一行和最后一行特殊处理
				if (j == 0 || j == numRows - 1) {
					for (int i = j; i < length; i += divide) {
						result.append(s.charAt(i));
					}
				} else {  //中间的行的规律
					for (int i = j; i < length; ) {
						result.append(s.charAt(i));
						i = count * divide - i;
						count++;
					}
				}
			}
			return result.toString();
		}
	}
}
