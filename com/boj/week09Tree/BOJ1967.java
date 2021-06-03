package com.boj.week09Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1967 {
	static ArrayList<int[]> map[]=new ArrayList[10001];
	static int N;
	static int visit[];
	static int largeindex=0;static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<=10000;i++)
			map[i]=new ArrayList<>();
		
		StringTokenizer st;
		for(int i=1;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			map[a].add(new int[] {b,c});
			map[b].add(new int[] {a,c});
		}
		visit=new int[10001];//가중치 
		dfs(1,1);
		
		max=0;
		visit=new int[10001];
		dfs(largeindex,largeindex);
		System.out.println(max);
	}
	private static void dfs(int start, int now) {//start를 기준으로 가중치가 제일 큰 리프노드 찾기 
		boolean flag=true;
		for(int i=0;i<map[now].size();i++) {
			int index[]=map[now].get(i);
			if(index[0]==start)continue;
			if(visit[index[0]]==0) {
				visit[index[0]]=visit[now]+index[1];
				if(max<visit[index[0]]) {
					max=visit[index[0]];
					largeindex=index[0];
				}
				dfs(start,index[0]);
			}
		}
	}
	
}
