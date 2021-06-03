package com.boj.week01;

import java.util.Scanner;

public class BOJ11060JumpJump {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int dp[]=new int[N+5];
		
		int jmp,can;
		for(int i=0;i<N;i++) {
			jmp=sc.nextInt();
			if(i>=1&&dp[i]==0)continue;
			if(jmp==0)continue;
			can=dp[i]+1;
			for(int j=1;j<=jmp&&j+i<N;j++) {
				if(dp[i+j]==0)
					dp[i+j]=can;
				else
					dp[i+j]=Math.min(can, dp[i+j]);
			}
		}
		//1칸 짜리일 때 가만히 있어도 점프수가 0회인것 을 체크해야한다.
		if(N==1)System.out.println(0);
		else if(dp[N-1]==0)
			System.out.println(-1);
		else
			System.out.println(dp[N-1]);
		
	}
}