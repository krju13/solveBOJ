package com.boj.week09Tree;

public class kakao1 {
	public static void main(String[] args) {
		int N=10;
		int gift[]=new int[N];
		int want[]=new int[N];
		for(int i=0;i<N;i++) {
			if(gift[i]==want[i])continue;
			for(int j=i+1;j<N;j++) {
				if(gift[j]==want[j])continue;
				if(want[i]==gift[j]) {
					gift[j]=gift[i];
					gift[i]=want[i];break;
				}
			}
		}
	}
}
