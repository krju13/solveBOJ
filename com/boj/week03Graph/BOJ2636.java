package com.boj.week03Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//cheese
public class BOJ2636 {
	static int dh[]= {-1,0,1,0};
	static int dw[]= {0,1,0,-1};
	static int H,W;
	static int map[][]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map=new int[H][W];
		for(int h=0;h<H;h++) {
			st=new StringTokenizer(br.readLine());
			for(int w=0;w<W;w++) {
				map[h][w]=Integer.parseInt(st.nextToken());
			}
		}//input 
		int precount = cheeseCoount();
		int count=precount;
		int hour=0;
		//air bfs
		Queue<pair> air=new LinkedList<>();
		Queue<pair> lastmelt=new LinkedList<>();
		air.add(new pair(0,0));
		map[0][0]=2;//visited mark

		for(;(count=cheeseCoount())>0;hour++) {
			precount=count;
			while(air.size()>0) {
				pair p=air.poll();
				for(int d=0;d<4;d++) {
					int nh=p.h+dh[d];
					int nw=p.w+dw[d];
					if(nh<0||nw<0||nh>=H||nw>=W)continue;
					if(map[nh][nw]==2)continue;
					if(map[nh][nw]==0) {
						map[nh][nw]=2;
						air.add(new pair(nh,nw));
					}else if(map[nh][nw]==1) {
						map[nh][nw]=2;
						lastmelt.add(new pair(nh,nw));
					}
				}
			}//while air bfs
			air.clear();
			while(lastmelt.size()>0) {
				air.add(lastmelt.poll());
			}

		}
		System.out.println(hour);
		System.out.println(precount);

	}


	private static int cheeseCoount() {
		int cnt=0;
		for(int i=1;i<H;i++) {
			for(int j=1;j<W;j++) {
				if(map[i][j]==1)cnt++;
			}
		}
		return cnt;
	}
}
class pair{
	int h,w;
	pair(){}
	pair(int h,int w){
		this.h=h; this.w=w;
	}
}
