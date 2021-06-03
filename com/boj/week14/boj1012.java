package com.boj.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {
	static int T;
	static int W,H;
	static int K;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map=new int[H][W];
			int w,h;
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				w=Integer.parseInt(st.nextToken());
				h=Integer.parseInt(st.nextToken());
				map[h][w]=1;
			}
			int cnt=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]==1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void dfs(int h,int w) {
		if(map[h][w]==1) {
			map[h][w]=2;
			if(h-1>=0) {
				dfs(h-1,w);
			}
			if(h+1<H) {
				dfs(h+1,w);
			}
			if(w-1>=0) {
				dfs(h,w-1);
			}
			if(w+1<W) {
				dfs(h,w+1);
			}
		}
		else {
			return;
		}
	}
}
