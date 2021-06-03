package com.boj.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17281 {
	static int N;
	static int order[]=new int[9];
	static int ening[][]=new int[50][9];
	static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				ening[i][j]=Integer.parseInt(st.nextToken());
			}
		}//input;
		ordering(0,new int[9]);
		System.out.println(max);
		
	}
	private static void ordering(int deep, int[] js) {
		if(deep==9) {
			play();
			return ;
		}
		if(deep==3) {
			order[deep]=0;
			ordering(deep+1,js);
			return;
		}
		for(int i=1;i<9;i++) {
			if(js[i]==0) {
				js[i]=1;
				order[deep]=i;
				ordering(deep+1,js);
				js[i]=0;
			}
		}
	}
	private static void play() {
		int score=0;
		int out=0;
		int ord=0;
		int loo[]=new int[4];//0loo, 1loo, 2loo, 3loo
		for(int turn=0;turn<N;turn++) {
			out=0;
			loo[0]=0;loo[1]=0;loo[2]=0;loo[3]=0;
			while(out<3) {
				loo[0]=1;
				int move=ening[turn][order[ord]];
				if(move==0) {
					out++;
					
				}else if(move==1) {
					if(loo[3]==1) {
						score++;
					}
					loo[3]=loo[2];
					loo[2]=loo[1];
					loo[1]=loo[0];
					loo[0]=0;
				}else if(move==2) {
					if(loo[3]==1) {
						score++;
					}
					if(loo[2]==1) {
						score++;
					}
					loo[3]=loo[1];
					loo[2]=loo[0];
					loo[1]=0;
					loo[0]=0;
				}else if(move==3) {
					if(loo[3]==1) {
						score++;
					}
					if(loo[2]==1) {
						score++;
					}
					if(loo[1]==1) {
						score++;
					}
					loo[3]=loo[0];
					loo[2]=0;
					loo[1]=0;
					loo[0]=0;
				}else if(move==4) {
					if(loo[3]==1) {
						score++;
					}
					if(loo[2]==1) {
						score++;
					}
					if(loo[1]==1) {
						score++;
					}
					if(loo[0]==1) {
						score++;
					}
					loo[3]=0;
					loo[2]=0;
					loo[1]=0;
					loo[0]=0;
				}
				ord=(ord+1)%9;
			}
		}
		max=Math.max(max, score);
	}
	
}
