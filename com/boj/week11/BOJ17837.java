package com.boj.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Horse{
	int h,w,d;

	public Horse(int h, int w, int d) {
		super();
		this.h = h;
		this.w = w;
		this.d = d;
	}
	
}
public class BOJ17837 {
	static int dh[]= {0,0,-1,1};
	static int dw[]= {1,-1,0,0};
	static int N,K;
	static int map[][];// 0 white 1 red 2 blue
	static ArrayList<Integer> board[][];
	static Horse horse[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		board=new ArrayList[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=new ArrayList<>();
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//map
		int h,w,d;
		horse=new Horse[K+1];
		
		for(int i=1;i<=K;i++) {
			st=new StringTokenizer(br.readLine());
			h=Integer.parseInt(st.nextToken())-1;
			w=Integer.parseInt(st.nextToken())-1;
			d=Integer.parseInt(st.nextToken());
			horse[i]=new Horse(h,w,d-1);
			board[h][w].add(i);
		}//horse input
		
		int turn=1;
		int ch,cw,nh,nw;
		for(;turn<=1000;turn++) {
			for(int i=1;i<=K;i++) {
				ch=horse[i].h;
				cw=horse[i].w;
				nh=horse[i].h+dh[horse[i].d];
				nw=horse[i].w+dw[horse[i].d];
				if(nh<0||nw<0||nh>=N||nw>=N||map[nh][nw]==2) {
					horse[i].d=changeD(horse[i].d);
					nh=horse[i].h+dh[horse[i].d];
					nw=horse[i].w+dw[horse[i].d];
					if(nh<0||nw<0||nh>=N||nw>=N||map[nh][nw]==2)
						continue;
				}
				if(map[nh][nw]==0) {
					int index=board[ch][cw].indexOf(i);
					for(int j=index;j<board[ch][cw].size();) {
						board[nh][nw].add(board[ch][cw].get(j));
						horse[board[ch][cw].get(j)].h=nh;
						horse[board[ch][cw].get(j)].w=nw;
						board[ch][cw].remove(j);
					}
				}else if(map[nh][nw]==1) {
					int index=board[ch][cw].indexOf(i);
					for(int j=board[ch][cw].size()-1;j>=index;j--) {
						board[nh][nw].add(board[ch][cw].get(j));
						horse[board[ch][cw].get(j)].h=nh;
						horse[board[ch][cw].get(j)].w=nw;
						board[ch][cw].remove(j);
					}
				}
				
				if(board[nh][nw].size()>=4) {//end condition
					System.out.println(turn);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	private static int changeD(int d) {
		if(d==0)
			return 1;
		else if(d==1)
			return 0;
		else if(d==2)
			return 3;
		else if(d==3)
			return 2;
		return 0;
	}
}
