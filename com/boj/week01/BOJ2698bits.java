package com.boj.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2698bits {
	static int N,K;
	static int dp[][][]=new int[103][102][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		solve();
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			sb.append(sum(N,K)+"\n");
		}
		System.out.print(sb);
	}
	static void solve() {
		dp[1][0][0]=1;//0
		dp[1][1][1]=1;//1
		dp[2][0][0]=2;//00 10
		dp[2][0][1]=1;//01
		dp[2][1][0]=0;
		dp[2][1][1]=1;//11
		for(int n=3;n<101;n++) {
			for(int k=0;k<n;k++) {
					dp[n][k][0]=dp[n-1][k][0]+dp[n-1][k][1];
					if(k==0)dp[n][k][1]=dp[n-1][k][0];
					else dp[n][k][1]=dp[n-1][k][0]+dp[n-1][k-1][1];
			}
		}
	}
	static int sum(int N,int K) {
		return dp[N][K][0]+dp[N][K][1];
	}
}
