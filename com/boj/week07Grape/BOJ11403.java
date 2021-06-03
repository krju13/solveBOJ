package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11403 {
	static int INF=100000;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					map[i][j]=INF;
				}
			}
		}//input 
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][k]+map[k][j], map[i][j]);
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=INF) {
					System.out.print(0);
				}else {
					System.out.print(1);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
