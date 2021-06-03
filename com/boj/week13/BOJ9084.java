package com.boj.week13;

import java.util.Scanner;

public class BOJ9084 {
	static int dp[][];
	static int T;
	static int coin[];
	static int N,money;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			N=sc.nextInt();
			coin=new int[N];
			for(int i=0;i<N;i++) {
				coin[i]=sc.nextInt();
			}
			money=sc.nextInt();
			dp=new int[money+1][N];//won 을 맨 마지막에 coin[i]으로 만드는 방법
			//init
			for(int i=0;i<N;i++) {
				if(coin[i]<=money)
					dp[coin[i]][i]=1;
			}
			int now;
			for(int m=1;m<=money;m++) {
				for(int i=0;i<N;i++) {
					now=coin[i];
					if(m-now>=0) {
						for(int j=0;j<=i;j++) {
							dp[m][i]+=dp[m-now][j];
						}
						
					}
				}
			}
			int sum=0;
			for(int i=0;i<N;i++) {
				sum+=dp[money][i];
			}
			System.out.println(sum);
		}
	}
}
