package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BIJ11657 {
	static int INF=987654321;
	static long map[];
	static ArrayList<int []> edges=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		map=new long[V+1];
		for(int i=0;i<=V;i++) {
			map[i]=INF;
		}
		
		map[1]=0;int A,B,C;
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			edges.add(new int[] {A,B,C});
		}//input
		
		for(int v=1;v<=V;v++) {//500x6000=3000000=300만 가능할까??? 
			for(int e=0;e<E;e++) {
				int edge[]=edges.get(e);
				A=edge[0];
				B=edge[1];
				C=edge[2];
				if(map[A]==INF)continue;
				map[B]=Math.min(map[B], map[A]+C);
			}
		}//벨만포드 돌기 
		for(int e=0;e<E;e++) {//엣지 다시 검사하면서 
			int edge[]=edges.get(e);
			A=edge[0];
			B=edge[1];
			C=edge[2];
			if(map[A]==INF)continue;
			if(map[B]>map[A]+C) {//더 작아지는 경우 생기면 음수사이클이 생기는 경우 
				System.out.println(-1);
				return;
			}
		}//아니면 출력해주기! 
		for(int v=2;v<=V;v++) {
			if(map[v]==INF) {
				System.out.println(-1);
			}else {
				System.out.println(map[v]);
			}
		}
		
		
	}
}
