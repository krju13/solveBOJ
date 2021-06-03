package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1707 {
	static int T;
	static int V,E;
	static ArrayList<Integer> g[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			g=new ArrayList[V+1];
			for(int i=0;i<V+1;i++) {
				g[i]=new ArrayList<Integer>();
			}
			int from,to;
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(br.readLine());
				from=Integer.parseInt(st.nextToken());
				to=Integer.parseInt(st.nextToken());
				if(from==to)continue;
				g[from].add(to);
				g[to].add(from);
			}
			boolean result=bfs();

			if(result) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	private static boolean bfs() {
		LinkedList<Integer> l=new LinkedList<>();
		int color[]=new int[V+1];
		for(int v=1;v<=V;v++) {
			if(color[v]>0)continue;
			l.add(v);
			color[v]=1;
			while(l.size()>0) {
				int node=l.pollFirst();
				int thecolor=color[node];
				if(thecolor==1) {
					for(int i=0;i<g[node].size();i++) {
						int next=g[node].get(i);
						if(thecolor==color[next])
							return false;
						else if(color[next]==0) {
							color[next]=2;
							l.add(next);
						}
					}
				}else if(thecolor==2){
					for(int i=0;i<g[node].size();i++) {
						int next=g[node].get(i);
						if(thecolor==color[next])
							return false;
						else if(color[next]==0) {
							color[next]=1;
							l.add(next);
						}
					}
				}
			}
		}
		return true;
	}
}
