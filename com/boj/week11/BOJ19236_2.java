package com.boj.week11;

import java.util.Scanner;

class Fish2{
	int h,w,d;
	boolean dead=false;//true= dead
	public Fish2() {};
	public Fish2(int h, int w, int d) {
		this.h = h;
		this.w = w;
		this.d = d;
	}
	public Fish2(int h, int w, int d, boolean dead) {
		super();
		this.h = h;
		this.w = w;
		this.d = d;
		this.dead = dead;
	}
}

public class BOJ19236_2 {
	static int dh[]= {-1,-1,0,1,1,1,0,-1};
	static int dw[]= {0,-1,-1,-1,0,1,1,1};
	static int N=4;
	static int Max=0;
	public static void main(String[] args) {
		Fish2 f[]=new Fish2[N*N+1];
		int map[][]=new int[N][N];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				f[map[i][j]]=new Fish2();
				f[map[i][j]].h=i;
				f[map[i][j]].w=j;
				f[map[i][j]].d=sc.nextInt()-1;
			}
		}
		DFS(0,0,f[map[0][0]].d,map,f,0);
		System.out.println(Max);
	}
	private static void DFS(int h, int w, int d, int[][] map, Fish2[] f, int sum) {
		
		if(h<0||w<0||h>=N||w>=N||map[h][w]==0) {
			Max=Math.max(Max, sum);
			return;//go home
		}
		
		
		int cmap[][]=new int[N][N];
		Fish2 cf[]=new Fish2[N*N+1];
		//copy
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				cmap[i][j]=map[i][j];
			}
		}
		for(int i=1;i<N*N+1;i++) {
			cf[i]=new Fish2(f[i].h,f[i].w,f[i].d,f[i].dead);
		}
		//eat fish
		int fish=cmap[h][w];
		cmap[h][w]=-1;
		cf[fish].dead=true;
		int eat=sum+fish;
		int nd=cf[fish].d;
		
		//move fish
		for(int i=1;i<N*N+1;i++) {
			if(cf[i].dead)
				continue;
			int ch=cf[i].h;
			int cw=cf[i].w;
			int nh=cf[i].h+dh[cf[i].d];
			int nw=cf[i].w+dw[cf[i].d];
			int cntTurn=0;
			while(nh<0||nw<0||nh>=N||nw>=N||cmap[nh][nw]==-1) {
				if(cntTurn==8)break;
				cntTurn++;
				cf[i].d=(cf[i].d+1)%8;
				nh=cf[i].h+dh[cf[i].d];
				nw=cf[i].w+dw[cf[i].d];
			}
			if(cntTurn==8)continue;
			if(cmap[nh][nw]==0) {
				cmap[nh][nw]=i;
				cf[i].h=nh;
				cf[i].w=nw;
				cmap[ch][cw]=0;
			}
			else {
				int tmp=cmap[nh][nw];
				cmap[nh][nw]=i;
				cmap[ch][cw]=tmp;
				cf[i].h=nh;
				cf[i].w=nw;
				cf[tmp].h=ch;
				cf[tmp].w=cw;
			}
		}//move fish
		cmap[h][w]=0;
		for(int d1=1;d1<=3;d1++) {
			int nh=h+dh[nd]*d1;
			int nw=w+dw[nd]*d1;
			DFS(nh,nw,nd,cmap,cf,eat);
		}
	}
}
