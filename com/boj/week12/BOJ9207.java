package com.boj.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9207 {
	static int T;
	static int minpin,mindeep;
	static int dh[]= {-1,0,1,0};
	static int dw[]= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		char map[][];
		int pin=0;
		for(int t=0;t<T;t++) {
			map=new char[5][];
			pin=0;
			minpin=8;mindeep=10;
			for(int i=0;i<5;i++) {
				map[i]=br.readLine().toCharArray();
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j]=='o') {
						pin++;
					}
				}
			}
			dfs(map,pin,0);
			System.out.println(minpin+" "+mindeep);
			if(t==T-1)break;
			br.readLine();
		}
		
	}
	private static void dfs(char[][] map, int pin,int deep) {
		int nh,nw,nnh,nnw;
		int W=map[0].length;
		int move=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<W;j++) {
				if(map[i][j]=='o') {
					for(int d=0;d<4;d++) {
						nh=i+dh[d];
						nw=j+dw[d];
						if(nh<0||nw<0||nh>=5||nw>=W)continue;
						if(map[nh][nw]=='o') {
							nnh=nh+dh[d];
							nnw=nw+dw[d];
							if(nnh<0||nnw<0||nnh>=5||nnw>=W)continue;
							if(map[nnh][nnw]=='.') {
								move++;
								map[i][j]='.';
								map[nh][nw]='.';
								map[nnh][nnw]='o';
								dfs(map,pin-1,deep+1);
								map[i][j]='o';
								map[nh][nw]='o';
								map[nnh][nnw]='.';		
							}
						}
					}
				}
			}
		}
		if(move==0) {
			if(minpin>pin) {
				minpin=pin;
				mindeep=deep;
			}
			else if(minpin==pin&&mindeep>deep) {
				mindeep=deep;
			}
		}
		
	}
}
