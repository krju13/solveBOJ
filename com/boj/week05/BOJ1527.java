package com.boj.week05;

import java.util.Scanner;

public class BOJ1527 {
	static int A,B;
	static int result=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		A=sc.nextInt();
		B=sc.nextInt();
		dfs((long)0);
		System.out.println(result);
	}
	private static void dfs(long a) {
		if(a>Integer.MAX_VALUE)return;
		if(a>B) {
			return;
		}
		if(a>=A) {
			result++;
		}
		dfs(a*10+4);
		dfs(a*10+7);
	}
}
