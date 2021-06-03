package com.boj.week06backtracing;

import java.util.Scanner;

public class BOJ2023 {
	static boolean prime[]=new boolean[100000000];
	static int N;
	public static void main(String[] args) {
	//N=8 100000000
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
//		prime();
//		find(0,0);
		System.out.println(arr[N-1]);
	}
	private static void find(int curious,int deep) {
		if(deep==N) {
			System.out.println(curious);
			return;
		}
		for(int i=1;i<10;i++) {
			int next=curious*10+i;
			if(!prime[next])
				find(next,deep+1);
		}
	}
	private static void prime() {
		int length=(int)Math.pow(10, N);
		prime[0]=true;
		prime[1]=true;//true means no prime
		for(int i=2;i<length;i++) {
			if(!prime[i]) {
				for(int j=i+i;j<length;j+=i)
					prime[j]=true;
			}
		}
	}
	static String arr[]= {
			"2\n3\n5\n7",
			"23\n29\n31\n37\n53\n59\n71\n73\n79",
			"233\n239\n293\n311\n313\n317\n373\n379\n593\n599\n719\n733\n739\n797",
			"2333\n" + "2339\n" + "2393\n" + "2399\n" + "2939\n" + "3119\n" + "3137\n" + "3733\n" + "3739\n" + "3793\n" + "3797\n" + "5939\n" + "7193\n" + "7331\n" + "7333\n" + "7393\n",
			"23333\n" + "23339\n" + "23399\n" + "23993\n" + "29399\n" + "31193\n" + "31379\n" + "37337\n" + "37339\n" + "37397\n" + "59393\n" + "59399\n" + "71933\n73331\n" + "73939",
			"233993\n" + "239933\n" + "293999\n" + "373379\n" + "373393\n" + "593933\n" + "593993\n" + "719333\n" + "739391\n" + "739393\n" + "739397\n" + "739399",
			"2339933\n" + "2399333\n" + "2939999\n" + "3733799\n" + "5939333\n" + "7393913\n" + "7393931\n" + "7393933",
			"23399339\n29399999\n37337999\n59393339\n73939133"

	};
}
