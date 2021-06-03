package com.boj.week09Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2533 {
	static int N;
	static ArrayList<Integer> G[];
	static ArrayList<Integer> Tree[];
	static boolean visit[];
	static int DP[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		G=new ArrayList[N+1];
		Tree=new ArrayList[N+1];
		visit=new boolean[N+1];
		DP=new int[N+1][2];
		//DP[1][0]=1번정점이 얼리어답터가 아닐때 얼리어답터 수 
		//DP[1][1]=1번정점이 얼리어답터일때 얼리어답터 수 
		for(int i=0;i<N+1;i++) {
			G[i]=new ArrayList<>();
			Tree[i]=new ArrayList<>();
			DP[i][0]=-1;DP[i][1]=-1;
		}
	
		
		StringTokenizer st;
		int A,B;
		for(int i=1;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			G[A].add(B);
			G[B].add(A);//무향 그래프 만들기 
		}
		makeTree(1);//1을 루트로 하는 그래프 만들기
		DFS(1,0);DFS(1,1);
		System.out.println(Math.min(DP[1][0], DP[1][1]));
		
	}
	private static void makeTree(int now) {
		visit[now]=true;
		for(int i=0;i<G[now].size();i++) {
			int next=G[now].get(i);
			if(visit[next]==false) {
				Tree[now].add(next);
				makeTree(next);
			}
		}
	}
	private static int DFS(int now,int state) {
		if(DP[now][state]>-1)return DP[now][state];
		if(state==0) {
			DP[now][state]=0;
			for(int i=0;i<Tree[now].size();i++) {
				int next=Tree[now].get(i);
				DP[now][state]+=DFS(next,1);
			}
		}else if(state==1){
			DP[now][state]=1;
			for(int i=0;i<Tree[now].size();i++) {
				int next=Tree[now].get(i);
				DP[now][state]+=Math.min(DFS(next,0),DFS(next,1));
			}
		}
		return DP[now][state];
	}
}
