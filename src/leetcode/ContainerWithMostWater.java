package leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 3, 1};
		System.out.println(maxArea(a));
	}

	public static int maxArea(int[] height) {
		int maxarea = 0;
		//暴力解法
//		for (int i = 0; i < height.length; i++) {
//			for (int j = i + 1; j < height.length; j++) {
//				maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
//			}
//		}
		
		// 两端靠近法。
		int l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxarea;
	}
}
