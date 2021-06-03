package com.boj.week13;

import java.util.Scanner;

public class BOJ5582 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char s1[]=sc.next().toCharArray();
		char s2[]=sc.next().toCharArray();
		int dp[][]=new int[s1.length+1][s2.length+1];
		int Max=0;
		for(int i=1;i<s1.length+1;i++) {
			for(int j=1;j<s2.length+1;j++) {
				if(s1[i-1]==s2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
					Max=Math.max(Max, dp[i][j]);
				}
			}
		}
		System.out.println(Max);
	}
}
