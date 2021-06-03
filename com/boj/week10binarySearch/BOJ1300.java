package com.boj.week10binarySearch;

import java.util.Scanner;

public class BOJ1300 {
	static long N,K;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		long low=1,high=N*N,middle;
		long ans=0;
		while(low<=high) {
			long sum=0;
			middle=(low+high)/2;
			int i=1;
			while(i<=N) {
				sum+=Math.min(N,(middle/i));
				i++;
			}
			if(sum<K) {
				low=middle+1;
			}
			else {
				ans=middle;
				high=middle-1;
			}
		}
		System.out.println(ans);
	}
}
