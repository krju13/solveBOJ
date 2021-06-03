package com.boj.week10binarySearch;

import java.util.Scanner;

public class BOJ10504_2 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N=sc.nextInt();
			int ans=-1;
			int l=0;
			for(int n=2;n<N/2;n++) {
				int aleft=1;
				int aright=N;
				int mid;
				while(aleft<=aright) {
					mid=(aleft+aright)/2;
					int sum=cal(mid,n);
					if(sum>N) {
						aright=mid-1;
					}else if(sum==N){
						ans=mid;
						l=n;
						break;
					}else {
						aleft=mid+1;
					}
				}
				if(ans!=-1)break;
			}
			if(ans==-1) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.print("N = "+ans);
				for(int i=1;i<l;i++) {
					System.out.print(" + "+(ans+i));
				}
				System.out.println();
			}
		}
	}
	private static int cal(int a,int n) {
		return (n*(2*a+n-1))/2;
	}
}
