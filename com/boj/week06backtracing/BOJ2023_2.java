package com.boj.week06backtracing;

import java.util.Scanner;

public class BOJ2023_2 {
	static int N;
	public static void main(String[] args) {
	//N=8 100000000
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		find(2,1);
		find(3,1);
		find(5,1);
		find(7,1);
	}
	private static void find(int curious,int deep) {
		if(deep==N) {
			System.out.println(curious);
			return;
		}
		for(int i=1;i<10;i+=2) {
			int next=curious*10+i;
			if(isprime(next))
				find(next,deep+1);
		}
	}
	private static boolean isprime(int n) {
		if(n<2)return false;
		if((n&1)==0)return false;
		
		for(int i=3;i<=(int)Math.pow(n,0.5);i+=2) {
			if(n%i==0)return false;
		}
		return true;
	}
}
