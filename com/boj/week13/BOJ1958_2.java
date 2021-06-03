package com.boj.week13;

import java.util.Scanner;

public class BOJ1958_2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char s1[]=sc.next().toCharArray();
		char s2[]=sc.next().toCharArray();
		char s3[]=sc.next().toCharArray();
		int len1=s1.length;
		int len2=s2.length;
		int len3=s3.length;
		int dp[][][]=new int[len1+1][len2+1][len3+1];
		for(int i=1;i<len1+1;i++) {
			for(int j=1;j<len2+1;j++) {
				for(int k=1;k<len3+1;k++) {
					if(s1[i-1]==s2[j-1]&&s2[j-1]==s3[k-1]) {
						dp[i][j][k]=dp[i-1][j-1][k-1]+1;
					}else {
						dp[i][j][k]=Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
				}
			}
		}
		System.out.println(dp[len1][len2][len3]);
	}
}
