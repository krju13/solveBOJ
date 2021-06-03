package com.boj.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ14621_1 {
	static int N;
	static int map[][]; // 1평당 대여비 
	static boolean visit[][];
	static int mincost=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		map=new int[N][N];
		visit=new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(mincost);
	}
	private static void dfs(int deep,int sum) {
		if(deep==3) {
			if(mincost>sum)mincost=sum;
			return;
		}
		for(int h=1;h<N-1;h++) {
			for(int w=1;w<N-1;w++) {
				if(isAvailable(h,w)) {//대여 가능한 곳인가? 
					setstate(h,w,true);// 대여가능하면 그곳 대여한 곳이라고 표시 
					dfs(deep+1,sum+Sum(h,w));// 재귀 타고 가기 
					setstate(h,w,false);//대여한 곳 
				}
				
			}
		}
		
	}
	private static int Sum(int i, int j) {
		return map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1]+map[i][j+1];
	}
	private static boolean isAvailable(int i, int j) {
		return !(visit[i][j]||visit[i-1][j]||visit[i+1][j]||visit[i][j-1]||visit[i][j+1]);
	}
	private static void setstate(int i, int j, boolean b) {
		visit[i][j]=b;
		visit[i-1][j]=b;
		visit[i+1][j]=b;
		visit[i][j-1]=b;
		visit[i][j+1]=b;
	}
	
}
