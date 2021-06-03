package com.boj.week11;

import java.util.Scanner;

public class BOJ20061_3 {
	static int N;
	static int map[][][];
	static int sum=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int t,h,w;
		map=new int[2][10][4];
		for(int i=0;i<N;i++) {
			t=sc.nextInt();
			h=sc.nextInt();
			w=sc.nextInt();
			move(0,t,h,w);
			if(t==1) {
				move(1,t,w,3-h);
			}else if(t==2) {
				move(1,3,w,3-h);
			}else if(t==3) {
				move(1,2,w,2-h);
			}
			score();//먼저 sum++, 밑으로 땡기기,4,5라인에 있으면 다시 그만큼 내리기  
			
		}
		System.out.println(sum);
		System.out.println(cont());
	}
	private static int cont() {
		int cnt=0;
		for(int i=0;i<2;i++) {
			for(int h=6;h<10;h++) {
				for(int w=0;w<4;w++) {
					cnt+=map[i][h][w];
				}
			}
		}
		return cnt;
	}
	private static void score() {
		for(int i=0;i<2;i++) {
			for(int h=6;h<10;h++) {
				if(map[i][h][0]==0||map[i][h][1]==0||map[i][h][2]==0||map[i][h][3]==0)continue;
				for(int nh=h;nh>4;nh--) {
					map[i][nh][0]=map[i][nh-1][0];
					map[i][nh][1]=map[i][nh-1][1];
					map[i][nh][2]=map[i][nh-1][2];
					map[i][nh][3]=map[i][nh-1][3];
				}
				sum++;h--;
			}//
			int cnt=0;
			if(map[i][4][0]==1||map[i][4][1]==1||map[i][4][2]==1||map[i][4][3]==1)
				cnt++;
			if(map[i][5][0]==1||map[i][5][1]==1||map[i][5][2]==1||map[i][5][3]==1)
				cnt++;
			if(cnt==0)continue;
			for(int nh=9;nh>3;nh--) {
				map[i][nh][0]=map[i][nh-cnt][0];
				map[i][nh][1]=map[i][nh-cnt][1];
				map[i][nh][2]=map[i][nh-cnt][2];
				map[i][nh][3]=map[i][nh-cnt][3];
			}
		}
		
	}
	private static void move(int i, int t, int h, int w) {
		if(t==1||t==3) {
			int nh;
			for(nh=6;nh<=9;nh++) {
				if(map[i][nh][w]==1) {
					map[i][nh-1][w]=1;
					if(t==3)
						map[i][nh-2][w]=1;
					break;
				}
			}
			if(nh==10) {
				map[i][9][w]=1;
				if(t==3)
					map[i][8][w]=1;
			}
		}else if(t==2) {
			int nh;
			for(nh=6;nh<=9;nh++) {
				if(map[i][nh][w]==1||map[i][nh][w+1]==1) {
					map[i][nh-1][w]=1;
					map[i][nh-1][w+1]=1;
					break;
				}
			}
			if(nh==10) {
				map[i][9][w]=1;
				map[i][9][w+1]=1;
			}
		}
	}
}
