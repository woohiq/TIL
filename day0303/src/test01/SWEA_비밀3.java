package test01;

import java.util.Scanner;

public class SWEA_비밀3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testpossible = sc.nextInt();
		for (int tc = 1; tc<=testpossible; tc++) {
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			
			int[] scores = new int[100];
			
			for (int i = 0; i<N; i++) {
				int score = sc.nextInt();
				scores[score-1]++;
			}
			int left = 0;
			int right = 99;
			int leftSum = scores[0];
			int rightSum = scores[99];
			int middleSum = N - leftSum - rightSum;
			int tmpMax = (leftSum>middleSum) ? leftSum : middleSum;
			tmpMax = (rightSum>tmpMax) ? rightSum : tmpMax;
			int tmpMin = (leftSum<middleSum) ? leftSum : middleSum;
			tmpMin = (rightSum<tmpMin) ? rightSum : tmpMin;
			
			int ans;
			if (middleSum < min || middleSum > max || rightSum < min || leftSum < min || rightSum > max || leftSum > max) ans = Integer.MAX_VALUE;
			else ans = tmpMax-tmpMin;
			
			while(left <= right && middleSum >= min) {
				
				if (leftSum < min) {leftSum += scores[++left]; middleSum -= scores[left]; continue;}
				if (rightSum < min) {rightSum += scores[--right]; middleSum -= scores[right]; continue;}
				
				if (leftSum < rightSum) {
					leftSum += scores[++left];
				} else if (leftSum > rightSum) {
					leftSum += scores[--right];
				} else {
					if (scores[left+1] > scores[right-1]) leftSum += scores[++left];
					else rightSum += scores[--right];
				}
				
				middleSum = N - leftSum - rightSum;
				if (middleSum < min || rightSum > max || leftSum > max) break;
				
				tmpMax = (leftSum>middleSum) ? leftSum : middleSum;
				tmpMax = (rightSum>tmpMax) ? rightSum : tmpMax;
				tmpMin = (leftSum<middleSum) ? leftSum : middleSum;
				tmpMin = (rightSum<tmpMin) ? rightSum : tmpMin;
				
				if ((tmpMax-tmpMin) < ans ) ans = tmpMax-tmpMin;
			}
			
			if (ans == Integer.MAX_VALUE) ans = -1;
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
