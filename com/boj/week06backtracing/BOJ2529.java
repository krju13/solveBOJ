package com.boj.week06backtracing;

import java.util.Scanner;

public class BOJ2529 {
	static int k;
	static char s[];
	static boolean select[]=new boolean[11];
	static String Min="9999999999";
	static String Max="0000000000";
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		k=sc.nextInt();
		s=new char[k];
		for(int i=0;i<k;i++) {
			s[i]=sc.next().charAt(0);
		}
		for(int i=0;i<10;i++) {
			select[i]=true;
			dfs(String.valueOf(i),0);
			select[i]=false;
		}
		System.out.println(Max);
		System.out.println(Min);
	}
	private static void dfs(String str,int deep) {
		if(deep==k) {
			int a=compareStr(str,Min);
			if(a==1) {//str<Min
				Min=str;
			}
			a=compareStr(str,Max);
			if(a==-1) {//str>Max
				Max=str;
			}
			return;
		}
		int front=Integer.parseInt(str.substring(str.length()-1));
		for(int i=0;i<10;i++) {
			if(!select[i]) {//not used
				if(s[deep]=='<'&&front<i) {
					select[i]=true;
					dfs(str+i,deep+1);
					select[i]=false;
				}else if(s[deep]=='>'&&front>i){
					select[i]=true;
					dfs(str+i,deep+1);
					select[i]=false;
				}
			}
		}
	}
	private static int compareStr(String s1,String s2) {
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)<s2.charAt(i))//s1<s2
				return 1;
			else if(s1.charAt(i)>s2.charAt(i))//s1>s2
				return -1;
		}
		return 0;
	}
}
