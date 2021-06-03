package com.boj.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3019 {
	static int block[][][]= {
			{{0}},
			{
				{0},{0,0,0,0}
			},
			{
				{0,0}
			},
			{
				{1,1,0},{0,1}
			},
			{
				{0,1,1},{1,0}
			},
			{
				{0,0,0},{1,0},{0,1},{0,1,0}
			},
			{
				{0,0,0},{1,0,0},{0,0},{0,2}
			},
			{
				{0,0,0},{0,0},{0,0,1},{2,0}
			},
	};
	static int height[];
	static int C,P;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		C=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		height=new int[C];
		for(int i=0;i<C;i++){
			height[i]=Integer.parseInt(st.nextToken());
		}
		int Cnt=0;
		for(int t=0;t<block[P].length;t++) {
			for(int i=0;i+block[P][t].length<=C;i++) {
				int init=height[i]+block[P][t][0];
				int next=init;
				int j=1;
				for(j=1;j<block[P][t].length;j++) {
					next=height[i+j]+block[P][t][j];
					if(init!=next)break;
				}
				if(j==block[P][t].length) {
					Cnt++;
				}
			}
		}
		System.out.println(Cnt);
	}
}
