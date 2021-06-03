package com.boj.week10binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13397 {
	static int N,M;
	static int number[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//구간합이 1~10000 중에서 c가 되게 배열 M구간으로 만들 수 있느냐?
		N=Integer.parseInt(st.nextToken());
		number=new int[N];
		M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			number[i]=Integer.parseInt(st.nextToken());
		}
		
		int low=0,high=10000,middle;
		while(low<high) {
			middle=(low+high)/2;
			if(make(middle)) {
				high=middle;
			}
			else {
				low=middle+1;
			}
		}
		System.out.println(high);
		
	}
	private static boolean make(int c) {
		int box=1;//
		int minInBox=number[0],maxInBox=number[0];
		for(int i=1;i<N;i++) {
			int c1=Math.abs(minInBox-number[i]);
			int c2=Math.abs(maxInBox-number[i]);
			if(c1<=c&&c2<=c) {
				minInBox=Math.min(minInBox, number[i]);
				maxInBox=Math.max(maxInBox, number[i]);
			}
			else {
				minInBox=number[i];
				maxInBox=number[i];
				box++;
			}
			if(box>M)return false;
		}
		return true;
		
	}
}
