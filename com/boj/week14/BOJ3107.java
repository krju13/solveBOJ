package com.boj.week14;

import java.util.Scanner;

public class BOJ3107 {
	static String add[]= {"0000","000","00","0",""};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char s[]=sc.next().toCharArray();
		int len=s.length;
		String next[]=new String[8];
		int i=0;
		int index=0;
		StringBuilder sb=new StringBuilder();
		for(i=0;i<len;i++) {
			if(s[i]==':') {
				if(sb.length()>0)
					next[index++]=new String(add[sb.length()]+sb.toString());
				sb=new StringBuilder();
				if(i+1<len&&s[i+1]==':') {
					break;
				}
			}else {
				sb.append(s[i]);
			}
		}
		if(i<len) {// meet ::
			index=7;
			for(i=len-1;i>=0;i--) {
				if(s[i]==':') {
					if(sb.length()>0)
						next[index--]=new String(add[sb.length()]+sb.toString());
					sb=new StringBuilder();
					if(i-1>=0&&s[i-1]==':') {
						break;
					}
				}
				else {
					sb.insert(0, s[i]);
				}
			}
		}else {
			if(sb.length()>0)
				next[index++]=new String(add[sb.length()]+sb.toString());
		}
		for(i=0;i<7;i++) {
			if(next[i]==null) {
				System.out.print("0000:");
			}
			else{
				System.out.print(next[i]+":");
			}
		}
		if(next[i]==null) {
			System.out.print("0000");
		}
		else{
			System.out.print(next[i]);
		}
		
	}
}


/*
 * input 1::
 * input ::1
 * input 1::1
 * input 1::1:0:0 
 * 
 * 
 */
