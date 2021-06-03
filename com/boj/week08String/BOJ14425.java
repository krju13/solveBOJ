package com.boj.week08String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map=new HashMap<>();
		for(int i=0;i<N;i++) {
			map.put(new String(br.readLine()), 1);
		}
		int cnt=0;
		String input;
		for(int i=0;i<M;i++) {
			input=br.readLine();
			if(map.containsKey(input))cnt++;
		}
		System.out.println(cnt);
	}

}
