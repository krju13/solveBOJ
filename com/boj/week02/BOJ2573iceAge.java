package com.boj.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573iceAge {
	static int N,M;
	static int map[][];
	static int dh[]= {-1,0,1,0};
	static int dw[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		int iceCnt=0;//ice counting 
		st=new StringTokenizer(br.readLine());//첫줄 무시 
		for(int i=1;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>0)iceCnt++;
			}
		}
		st=new StringTokenizer(br.readLine());//막줄 무시 
		//input
		int year,blockCnt=1;
		for(year=0;iceCnt>0;year++) {
			blockCnt=BlockCnt();
			if(blockCnt>1)break;
			iceCnt=melt();
		}
		if(iceCnt==0)year=0;
		System.out.println(year);
	}
	static int melt() {
		int mel[][]=new int[N][M];
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				if(map[i][j]==0)continue;//바다물이면 pass
				for(int d=0;d<4;d++) {
					//한 방향이 바다물이면서 얼음이면 녹이기 
					if(map[i+dh[d]][j+dw[d]]==0&&map[i][j]>0)mel[i][j]++;
				}
			}
		}
		int cnt=0;
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				map[i][j]-=mel[i][j];
				if(map[i][j]<0)map[i][j]=0;
				if(map[i][j]>0)cnt++;
			}
		}
		return cnt;
	}
	static int BlockCnt() {
		int check[][]=new int[N][M];
		int block=0;
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				if(map[i][j]>0&&check[i][j]==0) {
					dfs(check,i,j);
					block++;
				}
			}
		}
		return block;
	}
	static void dfs(int check[][],int h,int w) {
		check[h][w]=1;
		for(int i=0;i<4;i++) {
			int nh=h+dh[i];
			int nw=w+dw[i];
			if(map[nh][nw]>0&&check[nh][nw]==0) {
				dfs(check,nh,nw);
			}
		}
		 
	}
}
