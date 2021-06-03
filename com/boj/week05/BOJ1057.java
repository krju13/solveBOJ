package com.boj.week05;

import java.util.Scanner;

public class BOJ1057 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int A=sc.nextInt();
		int B=sc.nextInt();
		int round=1;
		int pA=A<B?A:B;
		int pB=A<B?B:A;
		while(N>1) {
			if((pA&1)==1&&pB-pA==1)break;
			pA=(pA+1)/2;
			pB=(pB+1)/2;
			N/=2;
			round++;
		}
		System.out.println(round);
	}
}
