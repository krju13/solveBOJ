package com.boj.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20061_2 {
	static int N;
	static int map[][][]=new int[2][6][4];//[], x,y
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
	private static int counttile() {
		int sum=0;
		for(int i=2;i<6;i++) {
			for(int j=0;j<4;j++) {
				sum+=map[0][i][j];
				sum+=map[1][i][j];
			}
		}
		return sum;
	}
	private static void move(int t, int x, int y) {
		//
		
		int y2=3-x,t2=t;
		tile(0,t,y);
		if(t==2) {
			t2=3;
		}
		else if(t==3) {
			t2=2;
			x=x+1;
		}
		tile(1,t2,3-x);
		
		
		
	}
	private static void tile(int i, int t, int y) {
		for(int h=2;h<6;h++) {// top -> bottom
			if(t==1) {
				if(map[i][h][y]==1) {
					map[i][h-1][y]=1;
					if(map[i][h-1][0]==1&&map[i][h-1][1]==1&&map[i][h-1][2]==1&&map[i][h-1][3]==1) {
						score++;
						map[i][h-1][0]=0;
						map[i][h-1][1]=0;
						map[i][h-1][2]=0;
						map[i][h-1][3]=0;
					}
					break;
				}
			}else if(t==2) {
				if(map[i][h][y]==1||map[i][h][y+1]==1) {
					map[i][h-1][y]=1;
					map[i][h-1][y+1]=1;
					break;
				}
			}else if(t==3) {
				if(map[i][h][y]==1) {
					map[i][h-1][y]=1;
					map[i][h-2][y]=1;
					break;
				}
			}
		}
		
	}
	
}
