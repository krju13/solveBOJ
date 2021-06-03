package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2206_3 {
	static int N,M;
	static int map[][];
	static int visited[][][];//break h w
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visited=new int[2][N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}//input;
		cnt=0;
		bfs();
		if(visited[0][N-1][M-1]>0&&visited[1][N-1][M-1]>0)
			cnt=Math.min(visited[0][N-1][M-1], visited[1][N-1][M-1]);
		else if(visited[1][N-1][M-1]>0)
			cnt=visited[1][N-1][M-1];
		else if(visited[0][N-1][M-1]>0)
			cnt=visited[0][N-1][M-1];
		if(cnt==0)cnt=-1;
		System.out.println(cnt);
	}
	static int dh[]= {0,0,1,-1};
	static int dw[]= {1,-1,0,0};
	private static void bfs() {
		LinkedList<int[]> que=new LinkedList<>();  
		que.add(new int[] {0,0,0,1});//wall,h,w, len
		visited[0][0][0]=1;
		while(que.size()>0) {
			int []now=que.poll();
			//System.out.println("["+now[0]+","+now[1]+","+now[2]+","+now[3]+"]");
			int isBreak=now[0];
			int ch=now[1];
			int cw=now[2];
			int clen=now[3];
			for(int d=0;d<4;d++) {
				int nh=ch+dh[d];
				int nw=cw+dw[d];
				if(nh<0||nw<0||nh>=N||nw>=M)continue;
				if(visited[isBreak][nh][nw]>0&&visited[isBreak][nh][nw]<clen)continue;
				if(map[nh][nw]==1&&isBreak==0) {
					if(visited[1][nh][nw]>0)continue;
					visited[1][nh][nw]=clen+1;
					que.add(new int[] {1,nh,nw,clen+1});
				}
				else if(visited[isBreak][nh][nw]>0)continue;//last mistake
				else if(map[nh][nw]==0) {
					visited[isBreak][nh][nw]=clen+1;
					que.add(new int[] {isBreak,nh,nw,clen+1});
				}
			}
		}
	}
	
}
