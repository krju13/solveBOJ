package com.boj.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		int num[]=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int dis[]=new int[N-1];
		for(int i=0;i<N-1;i++) {
			dis[i]=num[i+1]-num[i];
		}
		Arrays.sort(dis);
		int sum=0;
		for(int i=0;i<N-K;i++) {
			sum+=dis[i];
		}
		System.out.println(sum);
	}
}
