package com.boj.week09Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class BOJ15900 {
	static int N;//정점의 갯수
	static ArrayList<Integer> grape[];
	static int visited[];
	static int sum=0;
	public static void main(String[] args) throws IOException {
		//문제의 모든 리프노드의 깊이를 다 더해서 홀수면 이기고 짝수면 진다.
		//tree dfs해서 자식 없는 애의 깊이를 다 더하면 되지 않을까?
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		
		visited=new int[N+1];//for dfs
		grape=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			grape[i]=new ArrayList<>();//.....50만개 하면 메모리 초과 안생길까....??
		}//init
		
		StringTokenizer st;
		for(int i=1;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			grape[a].add(b);
			grape[b].add(a);
		}
		visited[1]=1;
		dfs(1,0);
		if((sum&1)>0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	private static void dfs(int node,int deep) {
		boolean flag=false;
		for(int i=0;i<grape[node].size();i++) {
			int tmp=grape[node].get(i);
			if(visited[tmp]==0) {
				visited[tmp]=1;//다시 방문하지 않기 위해서 
				dfs(tmp,deep+1);
				flag=true;
			}
		}
		if(flag==false)
		{
			sum+=deep;
		}
	}
}
