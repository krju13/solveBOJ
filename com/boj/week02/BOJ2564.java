package com.boj.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2564 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int W,H;
	static int N;
	static int store[][];
	static int person[]=new int[2];
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine()," ");
		W=Integer.parseInt(st.nextToken());//가
		H=Integer.parseInt(st.nextToken());//세로 
		N=Integer.parseInt(br.readLine());//상점수 
		store=new int[N][2];//
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			store[i][0]=Integer.parseInt(st.nextToken());
			store[i][1]=Integer.parseInt(st.nextToken());
			
		}
		st=new StringTokenizer(br.readLine()," ");
		person[0]=Integer.parseInt(st.nextToken());
		person[1]=Integer.parseInt(st.nextToken());
		
		int sum=0;int min;
		for(int i=0;i<N;i++) {
			if(person[0]<store[i][0]) {
				min=calMin(person[0],person[1],store[i][0],store[i][1]);
			}
			else if(person[0]>store[i][0]) {
				min=calMin(store[i][0],store[i][1],person[0],person[1]);
			}else {//same side
				min=Math.abs(person[1]-store[i][1]);
			}
			sum+=min;
		}
		System.out.println(sum);
		
	}
	static int calMin(int side1,int dis1,int side2,int dis2) {//(side1<side2 )
		if(side1==1) {
			if(side2==2) {
				return Math.min(dis1+dis2+H, 2*W-dis1-dis2+H);
			}
			else if(side2==3) {
				return dis1+dis2;
			}else if(side2==4) {
				return W-dis1+dis2;
			}
		}else if(side1==2) {
			if(side2==3) {
				return H-dis2+dis1;
			}else if(side2==4) {
				return W-dis1+H-dis2;
			}
		}else if(side1==3) {
			if(side2==4) {
				return Math.min(dis1+W+dis2, 2*H-dis1-dis2+W);
			}
		}
		return 0;
	}
}
