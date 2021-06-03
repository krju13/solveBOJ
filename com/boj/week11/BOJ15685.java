package com.boj.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {
	static int N;
	static int map[][]=new int[101][101];//(0.0) x (0.1)  x ... x (0.99) x (0.100)  
	static int dy[]= {0,-1,0,1};
	static int dx[]= {1,0,-1,0};
	static ArrayList<Integer>  dragon[]=new ArrayList[20];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			dragon[i]=new ArrayList<>();// save d
			make(i,d,g);
			draw(i,x,y);
		}
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arond(i,j))
					cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static boolean arond(int x, int y) {
		if(map[y][x]==0)
			return false;
		
		if(map[y+1][x]==0)
			return false;
		
		if(map[y][x+1]==0)
			return false;
		
		if(map[y+1][x+1]==0)
			return false;
		return true;
			
	}
	private static void draw(int i, int x, int y) {
		int cx=x,cy=y,d;
		map[cy][cx]=1;
		for(int g=0;g<dragon[i].size();g++) {
			d=dragon[i].get(g);
			cx+=dx[d];
			cy+=dy[d];
			map[cy][cx]=1;
		}
		
	}
	private static void make(int s,int d,int level) {
		dragon[s].add(d);
		for(int g=1;g<=level;g++) {
			int len=dragon[s].size();
			for(int j=len-1;j>=0;j--) {
				int direc=dragon[s].get(j);
				dragon[s].add((direc+1)%4);
			}
		}
	}
}
