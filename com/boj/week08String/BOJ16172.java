package com.boj.week08String;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ16172 {
	static char s1[],s2[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		s1=sc.next().toCharArray();
		s2=sc.next().toCharArray();
		delNum();
		if(find()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	private static boolean find() {
		//make fail function
		int fail[]=new int[s2.length];
		int i=0,j=0;
		fail[i++]=0;
		for(i=1;i<s2.length;i++){
			while(j>0&&s2[i]!=s2[j])
				j=fail[j-1];
			if(s2[i]==s2[j])
				fail[i]=++j;
		}
		//make fail array
		//kmp
		for(i=0;i<s1.length;i++) {
			while(j>0&&s1[i]!=s2[j])
				j=fail[j-1];
			if(s1[i]==s2[j]) {
				if(j==s2.length-1) {
					return true;
				}else {
					j++;
				}
			}
		}
		
		return false;
	}
	private static void delNum() {
		int i=0,j=0;
		while(i<s1.length) {
			if(Character.isAlphabetic(s1[i])) {
				s1[j++]=s1[i++];
			}else {
				i++;
			}
		}
	}
}
