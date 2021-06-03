package com.boj.week10binarySearch;

import java.util.Scanner;

public class BOJ10504_3 {
	/*
	 * 종은님 설명!
	1. 등차수열을 합에 대한 식으로 바꿈
	- n은 요소 개수, a는 시작 숫자, N은 등차수열의 합
	- n^2 + 2an - n = 2N
	2. 등차수열을 시작 숫자에 대한 식으로 바꿈
	- a = (2N - n^2 + n)/2n
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N=sc.nextInt();
			int ans=-1;
			int len=Math.min(4600,N);
			for(int n=2;n<=len;n++) {
				int a=(2*N-n*n+n)/(2*n);
				int sum=n*(2*a+n-1)/2;
				if(sum==N) {
					ans=a;
					System.out.print(N+" = "+a);
					for(int i=1;i<n;i++) {
						System.out.print(" + "+(a+i));
					}
					System.out.println();
					break;
				}
				
			}
			if(ans==-1)
				System.out.println("IMPOSSIBLE");
		}
	}
}
