package com.boj.week10binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
	static int N,M;
	static int lesson[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int sum=0;
		lesson=new int[N];
		for(int i=0;i<N;i++) {
			lesson[i]=Integer.parseInt(st.nextToken());
			sum+=lesson[i];
		}//input
		
		int low=0,high=sum,middle;
		
		while(low<high) {
			middle=(low+high)/2;
			int result=canmake(middle);
			if(result==1) {//용량 부족 
				low=middle+1;
			}
			else if(result==3) {//묶음 수 맞고 용량도 맞음 미들 이하크기로 만들 수 있다. 
				high=middle;
			}
		}
		System.out.println(high);
		
		
	}
	private static int canmake(int m) {
		int cnt=1,sum=0;
		for(int i=0;i<N;i++) {
			if(sum+lesson[i]<=m) {
				sum+=lesson[i];
			}else {
				cnt++;
				if(lesson[i]>m)return 1;
				sum=lesson[i];
			}
			if(cnt>M)return 1;
		}
		return 3;
		
	}
}
