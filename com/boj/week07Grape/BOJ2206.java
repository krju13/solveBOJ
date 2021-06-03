package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2206 {
	static int map[][];
	static int N,M;
	static int result=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		for(int i=1;i<N+1;i++) {
			String s=br.readLine();
			for(int j=1;j<M+1;j++) {
				map[i][j]=s.charAt(j-1)-'0';
			}
		}//입력 
		dfs(1,1,false,1);
		System.out.println(result);
	}
	static int dh[]= {-1,1,0,0};
	static int dw[]= {0,0,-1,1};
	private static void dfs(int ch,int cw,boolean flag,int len) {
		if(ch==N&&cw==M) {//맨 끝에 도착하면 
			if(result==-1) {//처음 도착하면 그냥 갱신 
				result=len;//
				return;
			}
			result=Math.min(result, len);//처음 아니면 작은 값으로 갱신 
			return;
		}
		int original=map[ch][cw];//현재 위치 값 저장 
		map[ch][cw]=2;// 방문한거 표시 
		for(int d=0;d<4;d++) {// 4방향으로 검사 
			int nh=ch+dh[d];
			int nw=cw+dw[d];
			if(nh<1||nw<1||nh>N||nw>M) {// 범위 밖이면 넘어감 
				continue;
			}
			if(map[nh][nw]==2)continue;//방문햇으면 넘어감 
			if(map[nh][nw]==1&&flag==false) {//벽인데 벽 안 뿌셨으면 뿌시면서 들어감 
				//can break the wall
				dfs(nh,nw,true,len+1);
				continue;
			}
			if(map[nh][nw]==1)continue;//벽이면 넘어감 
			dfs(nh,nw,flag,len+1);//갈 수 있으면 감 
			
		}
		map[ch][cw]=original;// 원래 값으로 바꿔주고 돌아감 
	}
}


