package com.boj.week09Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1068 {
	static int N,Del,sum=0;
	static ArrayList<Integer> tree[]=new ArrayList[50];
	static ArrayList<Integer>  root=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for(int i=0;i<N;i++) {
			tree[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			int input=sc.nextInt();//parent
			if(input==-1) {
				root.add(i);//save the root 
			}
			else {
				tree[input].add(i);//connect child
			}
		}
		Del=sc.nextInt();
		for(int i=0;i<root.size();i++)
			dfs(root.get(i));
		System.out.println(sum);
	}
	private static void dfs(int now) {
		if(now==Del)return;
		if(tree[now].size()==0) {
			//leaf
			sum++;
			return;
		}
		boolean flag=false;
		for(int i=0;i<tree[now].size();i++) {
			int child=tree[now].get(i);
			if(child==Del)continue;
			dfs(tree[now].get(i));
			flag=true;
		}
		if(flag==false) {//leaf
			sum++;
		}
	}
}
