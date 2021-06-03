package com.boj.week06backtracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16197 {
	static int N,M;
	static char board[][];
	static ArrayList<int[]>al=new ArrayList<>();
	static int dh[]= {-1,1,0,0};
	static int dw[]= {0,0,-1,1};
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		board=new char[N][M];
		
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j]=s.charAt(j);
				if(board[i][j]=='o') {
					al.add(new int[]{i,j});
					board[i][j]='.';//동전 있는 위치를 그냥 빈칸으로 만들어 버리기
				}
			}
		}//input
		dfs(al.get(0)[0],al.get(0)[1],al.get(1)[0],al.get(1)[1],0);
		if(min==Integer.MAX_VALUE)min=-1;
		System.out.println(min);
	}
	private static void dfs(int h1,int w1,int h2,int w2,int deep) {
		if(deep>10) {//button을 10번 넘게 누른 경우 
			return;
		}
		boolean c1live=isOnBoard(h1,w1);
		boolean c2live=isOnBoard(h2,w2);
		if(!c1live&&!c2live) {
			//둘다 죽었다.
			return;
		}else if(c1live&&c2live) {
			//둘다 살았다.
			for(int d=0;d<4;d++) {
				int nh1=h1+dh[d];
				int nw1=w1+dw[d];
				if(nh1>=0&&nh1<N&&nw1>=0&&nw1<M&&board[nh1][nw1]=='#') {
					nh1=h1;nw1=w1;
				}//벽이면 자기자리로 이
				int nh2=h2+dh[d];
				int nw2=w2+dw[d];
				if(nh2>=0&&nh2<N&&nw2>=0&&nw2<M&&board[nh2][nw2]=='#') {
					nh2=h2;nw2=w2;
				}
				
				dfs(nh1,nw1,nh2,nw2,deep+1);
			}
		}else {
			//하나가 죽었다.
			min=min>deep?deep:min;
			return;
		}
		
		
		
		
	}
	private static boolean isOnBoard(int h,int w) {
		if(h<0||w<0||h>=N||w>=M)
			return false;//fail
		return true;// on board 
	}
}
