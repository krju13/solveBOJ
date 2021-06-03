package com.boj.week06backtracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	static int L,C;
	static char pass[];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		pass=new char[C];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			pass[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(pass);//문자들 정렬 a to z 
		dfs("",0);
		System.out.println(sb.toString().trim());
	}
	private static void dfs(String str,int start) {
		if(str.length()==L) {
			if(isVowels(str)&&isConsonants(str))
				sb.append(str).append('\n');
			return;
		}
		if(pass.length-start<L-str.length()) {
			//고를 수 있는 남은 문자들을 다 골라도 L의 길이가 안되면 
			return;
		}
		for(int i=start;i<pass.length;i++) {
			dfs(str+pass[i],i+1);
		}
		
	}
	private static boolean isVowels(String res) {
		//모음이 한개 있는지 체크 
		for(int i=0;i<res.length();i++) {
			char c=res.charAt(i);
			if(c=='a'||c=='e'||c=='o'||c=='i'||c=='u')
				return true;
		}
		return false;
	}
	private static boolean isConsonants(String res) {
		//자음이 두개 있는지 체크 
		int cnt=0;
		for(int i=0;i<res.length();i++) {
			char c=res.charAt(i);
			if(c=='a'||c=='e'||c=='o'||c=='i'||c=='u')
				continue;
			cnt++;
			if(cnt>1)return true;
		}
		return false;
	}
	
}
