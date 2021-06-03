package com.boj.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ14620 {
	static int N;
	static int map[][]; // 1평당 대여비 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<int[]> al=new ArrayList<>();
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<N-1;j++) {
				al.add(new int[]{i,j,sum(i,j)});
				// 살수있는 땅들 주변 5개까지의 가격을 저장하기 
			}
		}
		Collections.sort(al,(o1,o2)->o1[2]-o2[2]);
		//가격으로 오름차순 정리를 한다.
		/*
		 * 이렇게 풀면 안되는 이유
		 * 가격이 같은 것들이 몰려있으면 
		 * 그중에 최적의 해가 무엇인지 모르게 되기 때문이다. 
		 * 그래서 완탐으로 풀던지 백트래킹으로 풀어야 한다. 
		 * 아예 문제 접근을 잘못한 경우임
		 * 
		 */
		int cnt=0;//땅을 고른 갯수가 3이되면 그만한다.
		int index=0;
		int result=0;
		while(cnt<3) {
			int ch=al.get(index)[0];
			int cw=al.get(index)[1];
			int cost=al.get(index)[2];
			index++;
			if(map[ch][cw]==-1
				||map[ch-1][cw]==-1
				||map[ch+1][cw]==-1
				||map[ch][cw+1]==-1
				||map[ch][cw-1]==-1) {
				//이미 제일 작은 애로 사용되고 있으면 패쓰 
				continue;
			}
			cnt++;
			map[ch][cw]=-1;
			map[ch-1][cw]=-1;
			map[ch+1][cw]=-1;
			map[ch][cw+1]=-1;
			map[ch][cw-1]=-1;
			result+=cost;
		}
		System.out.println(result);
	}
	private static int sum(int i,int j) {
		int s=map[i][j];
		s+=map[i-1][j];
		s+=map[i+1][j];
		s+=map[i][j+1];
		s+=map[i][j-1];
		return s;
	}
}
