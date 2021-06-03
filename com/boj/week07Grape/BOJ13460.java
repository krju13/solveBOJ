package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13460 {
	static char board[][];
	static int visited[][];
	static int N,M;
	static int hole[],originred[],originblue[];
	static int red[],blue[];
	static int min=Integer.MAX_VALUE;
	static int dh[]= {-1,0,1,0};
	static int dw[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		board=new char[N][M];
		visited=new int[N][M];
		
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j]=s.charAt(j);
				if(board[i][j]=='O') {
					hole=new int[] {i,j};
				}else if(board[i][j]=='R') {
					
					originred=new int[] {i,j};
					red=new int[] {i,j};
				}else if(board[i][j]=='B') {
					board[i][j]='.';
					originblue=new int[] {i,j};
					blue=new int[] {i,j};
				}
			}
		}
		//input
		for(int d=0;d<4;d++) {
			int nowR[]=red;
			int nowB[]=blue;
			int result=move(nowR,nowB,d);
			if(result==1)
				dfs(2,d);
			else if(result==2)min=1;
			else if(result==3)continue;
			moveback(nowR,nowB,(d+2)%4);
		}
		if(min==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	private static void dfs(int deep,int d) {
		if(deep==11) {
			return;
		}
		int nowR[]=new int[] {red[0],red[1]};
		int nowB[]=new int[] {blue[0],blue[1]};
		for(int nd=0;nd<4;nd++) {
			if(d%2==1&&nd%2==0) {//같은 방향이나 반대방향은 빼고 가게 만들기 
				int result=move(nowR,nowB,nd);
				if(result==1)//just go
					dfs(deep+1,nd);
				else if(result==2)//dead only red
				{
					min=Math.min(min, deep);
					return;
				}else if(result==3) {//both dead
					return;
				}
				moveback(nowR,nowB,(d+2)%4);//backing
			}else if(d%2==0&&nd%2==1) {
				int result=move(nowR,nowB,nd);
				if(result==1)//just go
					dfs(deep+1,nd);
				else if(result==2)//dead only red
				{
					min=Math.min(min, deep);
					return;
				}else if(result==3) {//both dead or blue dead
					return;// or red already moved this way
				}
				moveback(nowR,nowB,(d+2)%4);//backing
			}
		}
	}private static int move(int oR[],int oB[],int d) {
		//both dead?
		//both in same line so next position is same?
		//dead only red?
		//just can move is direction?
		//marking just red ball's road ='2'
		int nR[]=nextPosR(oR,d);
		int nB[]=nextPos(oB,d);
		if(nR[0]==-1&&nB[0]==-1)return 3;//both dead
		if(nB[0]==-1)return 3;//blue dead
		if(nR[0]==-1)return 2;//red dead
		if(nR[0]==0)return 3;//red already moved this way
		//just go 
		if(nR[0]==nB[0]&&nR[1]==nB[1]) {//next position is same
			switch (d) {
			case 0://up
				if(oR[0]>oB[0]) {
					nR[0]-=dh[d];
				}else {
					nB[0]-=dh[d];
				}
				break;
			case 1://right
				if(oR[1]<oB[1]) {
					nR[1]-=dw[d];
				}else {
					nB[1]-=dw[d];
				}
				break;
			case 2://down
				if(oR[0]>oB[0]) {
					nB[0]-=dh[d];
				}else {
					nR[0]-=dh[d];
				}
				break;
			case 3://left
				if(oR[1]<oB[1]) {
					nB[1]-=dw[d];
				}else {
					nR[1]-=dw[d];
				}
				break;
			}
		}
		blue=new int[] {nB[0],nB[1]};
		while(true) {
			if(red[0]==nR[0]&&red[1]==nR[1])break;
			board[red[0]][red[1]]='R';
			red[0]+=dh[d];
			red[1]+=dw[d];
		}
		return 1;
	}
	private static int[] nextPos(int o[],int d) {
		//just return next position
		int nh=o[0]+dh[d];
		int nw=o[1]+dw[d];
		while(true) {
			if(board[nh][nw]=='#')break;
			else if(board[nh][nw]=='O')return new int[] {-1,-1};//dead ball
			nh+=dh[d];
			nw+=dw[d];
		}
		nh-=dh[d];
		nw-=dw[d];
		return new int[] {nh,nw};
	}
	private static int[] nextPosR(int o[],int d) {
		//just return next position
		int nh=o[0]+dh[d];
		int nw=o[1]+dw[d];
		while(true) {
			if(board[nh][nw]=='#')break;
			else if(board[nh][nw]=='R')return new int[] {0,0};
			else if(board[nh][nw]=='O')return new int[] {-1,-1};//dead ball
			nh+=dh[d];
			nw+=dw[d];
		}
		nh-=dh[d];
		nw-=dw[d];
		return new int[] {nh,nw};
	}
	
	private static void moveback(int oR[],int oB[],int d) {
		blue=new int[] {oB[0],oB[1]};
		while(true) {
			if(red[0]==oR[0]&&red[1]==oR[1])break;
			board[red[0]][red[1]]='.';
			red[0]+=dh[d];
			red[1]+=dw[d];
		}
		
	}
}
