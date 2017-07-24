package leetcode;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("", ""));
	}

	public static boolean isMatch(String s, String p) {
		// 判断s或者p是否已经初始化
		if (s == null || p == null) {
			return false;
		}
		
		// 使用动态规划来解决，最小的问题就是s和p都为空
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i-1]) {
				dp[0][i+1] = true;
			}
		}
		// dp[i+1][j+1]存储着前i个字符是否匹配的判断
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i+1][j+1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i+1][j+1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
						dp[i+1][j+1] = dp[i+1][j-1];
					} else {
						dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
