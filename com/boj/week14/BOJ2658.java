package com.boj.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2658 {
	static char map[][];
	static int cnt1row[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new char[10][10];
		for(int i=0;i<10;i++) {
			map[i]=br.readLine().toCharArray();
		}
		//웅....
		// 8개 모양 다 확인 하는게 맞는거야? 진짜? 
		//아니면 긴 변 한개만 확인해서 그걸로 만들 수 있는 삼각형으로 줄여서 생각하는게 맞는거야??
		//정말 귀찮은 문젠거같당. 
		
		
		
	}

}