package com.boj.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7579 {
	static int cost[],memory[],dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int size=100*100;
		cost=new int[N];
		memory=new int[N];
		dp=new int[size+1];//dp[cost]=memory 
		st=new StringTokenizer(br.readLine());
		StringTokenizer st1=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			memory[i]=Integer.parseInt(st.nextToken());
			cost[i]=Integer.parseInt(st1.nextToken());
		}
		for(int i=0;i<size+1;i++) {
			dp[i]=-1;
		}
		dp[0]=0;
		
		for(int i=0;i<N;i++) {
			for(int j=size;j>=0;j--) {
				if(dp[j]>=0&&j+cost[i]<size+1) {
					dp[j+cost[i]]=Math.max(dp[j+cost[i]], dp[j]+memory[i]);
				}
			}
			//System.out.println(Arrays.toString(dp));
		}
		
		int MinC=0;
		for(int i=0;i<size+1;i++) {
			if(dp[i]>=M) {
				MinC=i;
				break;
			}
		}
		System.out.println(MinC);
	}

}
