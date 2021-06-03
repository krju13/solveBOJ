package com.boj.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
	static int H,W,K;//N,M
	static int order[];
	static int turn[][];
	static int origin[][];
	static int tmparr[][];
	static int Min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		order=new int[K];
		turn=new int[K][3];
		origin=new int[H][W];
		tmparr=new int[H][W];
		int select[]=new int[K];
		
		for(int i=0;i<H;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				origin[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			turn[i][0]=Integer.parseInt(st.nextToken())-1;
			turn[i][1]=Integer.parseInt(st.nextToken())-1;
			turn[i][2]=Integer.parseInt(st.nextToken());
		}
		permu(0,select);
		System.out.println(Min);
	}
	private static void permu(int deep,int select[]) {
		if(deep==K) {
			play();
		}
		for(int i=0;i<K;i++) {
			if(select[i]==0) {
				select[i]=1;
				order[deep]=i;
				permu(deep+1,select);
				select[i]=0;
			}
		}
	}
	private static void play() {
		int r,c,s;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				tmparr[i][j]=origin[i][j];
			}
		}
		for(int i=0;i<K;i++) {
			r=turn[order[i]][0];
			c=turn[order[i]][1];
			s=turn[order[i]][2];
			
			for(int j=1;j<=s;j++) {
				turning(r-j,c-j,r+j,c+j);
			}
		}
		Min=Math.min(Min, minsumrow());
	}
	private static void turning(int sh,int sw,int dh,int dw) {
		int tmp=tmparr[sh][sw];
		for(int i=sh;i<dh;i++) {
			tmparr[i][sw]=tmparr[i+1][sw];
		}
		for(int i=sw;i<dw;i++) {
			tmparr[dh][i]=tmparr[dh][i+1];
		}
		for(int i=dh;i>sh;i--) {
			tmparr[i][dw]=tmparr[i-1][dw];
		}
		for(int i=dw;i>sw+1;i--) {
			tmparr[sh][i]=tmparr[sh][i-1];
		}
		tmparr[sh][sw+1]=tmp;
	}
	private static int minsumrow() {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<H;i++) {
			min=Math.min(min, sumrow(i));
		}
		return min;
	}
	private static int sumrow(int r) {
		int sum=0;
		for(int i=0;i<W;i++) {
			sum+=tmparr[r][i];
		}
		return sum;
	}
}
