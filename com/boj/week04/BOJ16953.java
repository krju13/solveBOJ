package com.boj.week04;

import java.util.Scanner;

public class BOJ16953 {
	public static void main(String[] args) {
		int A,B;
		Scanner sc=new Scanner(System.in);
		A=sc.nextInt();
		B=sc.nextInt();
		int cnt=0;
		while(A<B) {
			if(A==B) {
				break;
			}
			if(B%10==1) {// 끝이 1일때 
				B=B/10;
			}
			else if((B%2)==0) {// 짝수일때 
				B=B/2;
			}
			else {// 3,5 7, 9 가끝일때 는 나눌수 없다.
				cnt=-1;
				break;
			}
			cnt++;
		}
		
		if(B<A)cnt=-1;
		if(cnt!=-1)cnt++;
		System.out.println(cnt);
	}
}
