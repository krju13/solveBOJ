package com.boj.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int K;
	static LinkedList<Integer> ll[]=new LinkedList[4];
	public static void main(String[] args) throws IOException {
		for(int i=0;i<4;i++) {
			ll[i]=new LinkedList<>();
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++) {
			char input[]=br.readLine().toCharArray();
			for(int j=0;j<input.length;j++) {
				ll[i].add(input[j]-'0');
			}
		}
		K=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int k=0;k<K;k++) {
			st=new StringTokenizer(br.readLine());
			int s =Integer.parseInt(st.nextToken())-1;
			int turn =Integer.parseInt(st.nextToken());
			Turn(s,turn);
		}
		int sum=0;int mul=1;
		for(int i=0;i<4;i++) {
			if(ll[i].get(0)==1) {
				sum+=mul;
			}
			mul*=2;
		}
		System.out.println(sum);
	}
	private static void Turn(int s,int turn) {
		if(s>0&&ll[s].get(6)!=ll[s-1].get(2)) {
			left(s-1,turn*-1);
		}
		if(s<3&&ll[s].get(2)!=ll[s+1].get(6)) {
			right(s+1,turn*-1);
		}
		if(turn==-1) {
			ll[s].add(ll[s].pollFirst());
			
		}else if(turn==1) {
			ll[s].addFirst(ll[s].pollLast());
		}
	}
	private static void right(int s, int turn) {
		if(s<3&&ll[s].get(2)!=ll[s+1].get(6)) {
			right(s+1,turn*-1);
		}
		if(turn==-1) {
			ll[s].add(ll[s].pollFirst());
			
		}else if(turn==1) {
			ll[s].addFirst(ll[s].pollLast());
		}
	}
	private static void left(int s,int turn) {
		if(s>0&&ll[s].get(6)!=ll[s-1].get(2)) {
			left(s-1,turn*-1);
		}
		if(turn==-1) {
			ll[s].add(ll[s].pollFirst());
			
		}else if(turn==1) {
			ll[s].addFirst(ll[s].pollLast());
		}
	}
}
