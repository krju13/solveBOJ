package com.boj.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2116 {
	static int N;
	static int dice[][];
	static int Maxsum=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dice=new int[N][6];
		//0 - 3 A-F
		//1 - 4 B-D
		//2 - 5 C-E
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			dice[i][0]=Integer.parseInt(st.nextToken());//A
			dice[i][1]=Integer.parseInt(st.nextToken());//B
			dice[i][2]=Integer.parseInt(st.nextToken());//C
			dice[i][4]=Integer.parseInt(st.nextToken());//D
			dice[i][5]=Integer.parseInt(st.nextToken());//E
			dice[i][3]=Integer.parseInt(st.nextToken());//F
		}
		//주사위N개 중에서 4개를 고르고 
		//1번주사위의 밑면을 고르면 자동으로 윗면이 골라진다.
		//이때 옆면중에서 가장 큰 수를 더하면 합의 최대값이 된다.
		//문제에서 궁금한 점: 5C4에서 고르는 건지 5C5에서 고르는 건지....
		//예제를 보면 5C5인듯하다.
		//1번 주사위의 1~6까지 계산하면 모든 경우를 구할 수 있다.
		dfs(0,0,1);
		dfs(0,0,2);
		dfs(0,0,3);
		dfs(0,0,4);
		dfs(0,0,5);
		dfs(0,0,6);
		System.out.println(Maxsum);
	}
	private static void dfs(int deep,int sum,int pre) {
		if(deep==N) {
			Maxsum=Maxsum<sum?sum:Maxsum;
			return;
		}
		//해당 다이스에서 밑면과윗면을 찾고 나머지에서 제일 큰 수를 sum+하기
		int underindex=underindex(deep,pre);
		int topindex=topindex(deep, pre);
		int max=0;
		for(int i=0;i<6;i++) {
			if(i==underindex||i==topindex)continue;
			max=max<dice[deep][i]?dice[deep][i]:max;
		}
		dfs(deep+1,sum+max,dice[deep][topindex]);
		
	}
	private static int underindex(int deep,int under) {
		//return under index;
		for(int i=0;i<6;i++) {
			if(dice[deep][i]==under) {
				return i;
			}
		}
		return -1;
		
	}
	private static int topindex(int deep,int under) {
		//return top index;
		for(int i=0;i<6;i++) {
			if(dice[deep][i]==under) {
				return (i+3)%6;
			}
		}
		return -1;
	}
}
