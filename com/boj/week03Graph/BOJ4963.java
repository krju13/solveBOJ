package com.boj.week03Graph;

import java.util.Scanner;

//섬의 개수
public class BOJ4963 {
	static int dh[]= {-1,-1,-1,0,1,1,1,0};
	static int dw[]= {-1,0,1,1,1,0,-1,-1};
	static int W,H;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		while(true) {
			W=sc.nextInt();
			if(W==0)break;
			H=sc.nextInt();
			int map[][]=new int[H][W];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			sb.append(count(map)).append("\n");
		}
		System.out.println(sb);
	}
	static int count(int map[][]) {
		boolean visited[][]=new boolean[H][W];
		int cnt=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(map[i][j]==1&&visited[i][j]==false) {
					cnt++;
					dfs(visited,map,i,j);
				}
			}
		}
		return cnt;
	}
	static void dfs(boolean visited[][],int map[][],int h,int w ) {
		visited[h][w]=true;
		for(int d=0;d<8;d++) {
			int nh=h+dh[d];
			int nw=w+dw[d];
			if(nh<0||nw<0||nh>=H||nw>=W)continue;
			if(map[nh][nw]==1&&visited[nh][nw]==false)dfs(visited,map,nh,nw);
		}
	}
}
