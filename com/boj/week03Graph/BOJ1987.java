package com.boj.week03Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Alphabet board
public class BOJ1987 {
	static int R,C;
	static char board[][];
	static int check[]=new int[26];
	static int dh[]= {-1,0,1,0};
	static int dw[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		board=new char[R][];
		for(int i=0;i<R;i++) {
			board[i]=br.readLine().toCharArray();
		}
		System.out.println(dfs(0,0,0));
	}
	static int dfs(int len,int ch,int cw) {
		if(check[board[ch][cw]-'A']==1) {
			return len;
		}
		check[board[ch][cw]-'A']=1;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<4;i++) {
			int nh=ch+dh[i];
			int nw=cw+dw[i];
			if(nh<0||nw<0||nh>=R||nw>=C)
				continue;
			
			max=Math.max(max, dfs(len+1,nh,nw));
		}
		check[board[ch][cw]-'A']=0;
		return max;
	}
}
