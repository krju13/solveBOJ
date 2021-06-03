package com.boj.week08String;

import java.util.Scanner;

public class BOJ12904 {
	static int result;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String S=sc.next();
		String T=sc.next();
		String rT=reverse(T);
		dfs(S,T,rT);
		System.out.println(result);
		
	}
	private static void dfs(String s,String t,String rt) {
		//System.out.println(s);
		if(s.compareTo(t)==0) {
			result=1;
			return;
		}
		if(s.length()>t.length())return;
		if(t.contains(s)||rt.contains(s)) {
			dfs(s+'A',t,rt);
			dfs(reverse(s)+'B',t,rt);
		}
		return;
	}
	private static String reverse(String T) {
		char[] c=T.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=c.length-1;i>=0;i--) {
			sb.append(c[i]);
		}
		return sb.toString();
	}
}
