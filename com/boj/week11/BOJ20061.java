package com.boj.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20061 {
	static int N;
	static int map[][][]=new int[2][10][4];//x,y
	static int score=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int t,x,y;
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			t=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			move(t,x,y);
		}
		System.out.println(score);
		System.out.println(counttile());
	}
	private static void move(int t, int x, int y) {
		// place tile 
		int x1,y1,t1=1;
		x1=y;y1=3-x;
		
		if(t==2) {
			x1=x1+1;
			t1=3;
		}else if(t==3) {
			x=x+1;
			y1=y1-1;
			t1=2;
		}
		//move down
		movedown(0,t,x,y);
		movedown(1,t1,x1,y1);
		//score
		//move down all
		score();
	}
	private static void score() {
		for(int lev=0;lev<2;lev++) {
			for(int h=6;h<10;h++) {
				if(map[lev][h][0]==1&&map[lev][h][1]==1&&map[lev][h][2]==1&&map[lev][h][3]==1) {
					map[lev][h][0]=0;
					map[lev][h][1]=0;
					map[lev][h][2]=0;
					map[lev][h][3]=0;
					score++;h--;
				}
			}
			for(int h=9;h>5;h--) {
				if(map[lev][h][0]==0&&map[lev][h][1]==0&&map[lev][h][2]==0&&map[lev][h][3]==0) {
					map[lev][h][0]=map[lev][h-1][0];
					map[lev][h][1]=map[lev][h-1][1];
					map[lev][h][2]=map[lev][h-1][2];
					map[lev][h][3]=map[lev][h-1][3];
					
					map[lev][h-1][0]=0;
					map[lev][h-1][1]=0;
					map[lev][h-1][2]=0;
					map[lev][h-1][3]=0;
				}
			}
		}
		
	}
	private static void movedown(int i, int t, int x, int y) {
		int h=0;int c=1;
		if(t==1) {
			for(h=4;h<10;h++) {
				if(map[i][h][y]==1) {
					map[i][h-1][y]=1;
					if(h==6)h=4;
					break;
				}
			}
			if(h==10) {
				map[i][9][y]=1;
			}
		}else if(t==3){
			for( h=4;h<10;h++) {
				if(map[i][h][y]==1) {
					map[i][h-1][y]=1;
					map[i][h-2][y]=1;
					if(h==6)h=4;c=2;
					break;
				}
			}
			if(h==10) {
				map[i][9][y]=1;
				map[i][8][y]=1;
			}
		}else if(t==2) {
			for( h=4;h<10;h++) {
				if(map[i][h][y]==1||map[i][h][y+1]==1) {
					map[i][h-1][y]=1;
					map[i][h-1][y+1]=1;
					if(h==6)h=4;
					break;
				}
			}
			if(h==10) {
				map[i][9][y]=1;
				map[i][9][y+1]=1;
			}
		}
		if(h==4) {
			for(int hi=9;hi>3;hi--) {
				map[i][hi][0]=map[i][hi-c][0];
				map[i][hi][1]=map[i][hi-c][1];
				map[i][hi][2]=map[i][hi-c][2];
				map[i][hi][3]=map[i][hi-c][3];
			}
		}
	}
	private static int counttile() {
		int sum=0;
		for(int i=4;i<10;i++) {
			for(int j=0;j<4;j++) {
				sum+=map[0][i][j];
				sum+=map[1][i][j];
			}
		}
		return sum;
	}
}
