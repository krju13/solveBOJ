package com.boj.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2115 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int H,W;
		StringTokenizer st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		char map[][]=new char[H][];
		for(int i=0;i<H;i++) {
			map[i]=br.readLine().toCharArray();
		}
		int cnt1=0,cnt2=0;
		int result=0;
		for(int i=0;i<H-1;i++) {
			cnt1=0;cnt2=0;
			for(int j=0;j<W;j++) {
				//top
				if(map[i][j]=='X'&&map[i+1][j]=='.') {
					cnt1++;
				}else {
					result+=cnt1/2;
					cnt1=0;
				}
				//bottom
				if(map[i][j]=='.'&&map[i+1][j]=='X') {
					cnt2++;
				}else {
					result+=cnt2/2;
					cnt2=0;
				}
			}
		}
		for(int j=0;j<W-1;j++) {
			cnt1=0;cnt2=0;
			for(int i=0;i<H;i++) {
				//left
				if(map[i][j]=='X'&&map[i][j+1]=='.') {
					cnt1++;
				}else {
					result+=cnt1/2;
					cnt1=0;
				}
				//right
				if(map[i][j]=='.'&&map[i][j+1]=='X') {
					cnt2++;
				}else {
					result+=cnt2/2;
					cnt2=0;
				}
			}
		}
		System.out.println(result);
	}
}
