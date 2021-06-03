package com.boj.week08String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	String s;
	ArrayList<Node> child;
	Node(){
		child=new ArrayList<Node>();
	}
	Node(String s){
		this.s=s;
		child=new ArrayList<Node>();
	}
	@Override
	public int compareTo(Node o) {
		return s.compareTo(o.s);
	}
}
public class BOJ14725 {
	static Node root=new Node();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			Node now=root;
			for(int j=0;j<M;j++) {
				String s=st.nextToken();
				boolean flag=false;
				for(int n=0;n<now.child.size();n++) {
					if(s.equals(now.child.get(n).s)) {
						now=now.child.get(n);
						flag=true;
						break;
					}
				}
				if(!flag)
				{
					now.child.add(new Node(s));
					now=now.child.get(now.child.size()-1);
				}
			}
		}//input 
		//dfs 
		Collections.sort(root.child);
		for(int i=0;i<root.child.size();i++)
			dfs(root.child.get(i),"");
		
		
	}
	private static void dfs(Node now,String str) {
		System.out.println(str+now.s);
		Collections.sort(now.child);
		for(int i=0;i<now.child.size();i++)
			dfs(now.child.get(i),str+"--");
	}
}
