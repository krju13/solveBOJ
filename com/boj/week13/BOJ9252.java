package com.boj.week13;

import java.util.Scanner;

public class BOJ9252 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char s1[]=sc.next().toCharArray();
		char s2[]=sc.next().toCharArray();
		StringBuilder sb=new StringBuilder();
		int dp[][]=new int[s1.length+1][s2.length+1];
		String dpString[][]=new String[s1.length+1][s2.length+1];
		int Max=0;
		for(int i=1;i<s1.length+1;i++) {
			for(int j=1;j<s2.length+1;j++) {
				if(i==0||j==0) {
					dpString[i][j]=new String();
					continue;
				}
				if(s1[i-1]==s2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
					Max=Math.max(Max, dp[i][j]);
					dpString[i][j]=dpString[i-1][j-1]+s1[i-1];
				}else {
					if(dp[i-1][j]< dp[i][j-1]) {
						dp[i][j]=dp[i][j-1];
						dpString[i][j]=dpString[i][j-1];
					}else {
						dp[i][j]=dp[i-1][j];
						dpString[i][j]=dpString[i-1][j];
						
					}
				}
			}
		}
		System.out.println(dp[s1.length][s2.length]);
		System.out.println(dpString[s1.length][s2.length]);
	}
}
