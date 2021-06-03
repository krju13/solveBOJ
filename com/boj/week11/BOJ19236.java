package com.boj.week11;

import java.util.Scanner;

class fish{
	int h,w,d,z;
	boolean dead=false;
	public fish() {}
	public fish(int h, int w, int d, int z) {
		super();
		this.h = h;
		this.w = w;
		this.d = d;
		this.z = z;
	}
}
public class BOJ19236 {
	static fish arr[]=new fish[17];//0 = null
	static int dh[]= {-1,-1,0,1,1,1,0,-1};
	static int dw[]= {0,-1,-1,-1,0,1,1,1};
	static int Max=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int map[][]=new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				int n=sc.nextInt();
				int d=sc.nextInt()-1;
				map[i][j]=n;
				arr[n]=new fish(i,j,d,n);
			}
		}//input
		turn(0,0,0,map);//상어 다음 위치(h,w,d) 지금까지 먹은 물고기합
		System.out.println(Max);
	}
	private static void turn(int sh,int sw,int sum,int map[][]) {
		if(map[sh][sw]==0) {
			Max=Math.max(Max, sum);
			return;
		}
		int catched=map[sh][sw];
		map[sh][sw]=0;
		int eat=sum+catched;
		arr[catched].dead=true;
		int sharkd=arr[catched].d;
		
		int copy[][]=new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				copy[i][j]=map[i][j];
			}
		}
		for(int f=1;f<=16;f++) {
			if(arr[f].dead)continue;
			move(f,copy);
		}
		
		int nh=sh+dh[sharkd];
		int nw=sw+dw[sharkd];
		boolean into=false;
		while(nh>=0&&nw>=0&&nh<4&&nw<4&&map[nh][nw]!=0) {
			turn(nh,nw,eat,copy);
			nh+=dh[sharkd];
			nw+=dw[sharkd];
			into=true;
		}
		if(into==false) {
			Max=Math.max(Max, eat);
		}
		arr[catched].dead=false;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				int num=map[i][j];
				if(num==0)continue;
				arr[num].h=i;
				arr[num].w=j;
			}
		}	// return state
	}
	private static void move(int f, int[][] map) {
		int ch=arr[f].h;
		int cw=arr[f].w;
		int nh,nw,firstnh,firstnw;
		firstnh=nh=arr[f].h+dh[arr[f].d];
		firstnw=nw=arr[f].w+dw[arr[f].d];
		while(nh<0||nw<0||nh>3||nw>3||map[nh][nw]==0) {
			arr[f].d=(arr[f].d+1)%8;
			nh=arr[f].h+dh[arr[f].d];
			nw=arr[f].w+dw[arr[f].d];
			if(nh==firstnh&&nw==firstnw)return;
			//아무대도 못간 물고기는 그냥 리턴
		}
		int tmp=map[nh][nw];
		map[nh][nw]=f;
		arr[f].h=nh;
		arr[f].w=nw;
		map[ch][cw]=tmp;
		arr[tmp].h=ch;
		arr[tmp].w=cw;
		return;
	}
	
}
