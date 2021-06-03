package com.boj.week01;

import java.util.Scanner;

public class Boj2491Array {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int now=sc.nextInt(),pre;
		int lonIn=1;int lonDe=1;
		int maxIn=1;int maxDe=1;
		for(int i=1;i<N;i++) {
			pre=now;
			now=sc.nextInt();
			//increase
			if(pre<=now) {
				lonIn++;
				maxIn=maxIn>lonIn?maxIn:lonIn;
			}
			else {
				lonIn=1;
			}
			//decrease
			if(pre>=now){
				lonDe++;
				maxDe=maxDe>lonDe?maxDe:lonDe;
			}else {
				lonDe=1;
			}
		}
		System.out.println(maxIn>maxDe?maxIn:maxDe);
		
	}

}
