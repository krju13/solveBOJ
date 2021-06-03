package com.boj.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken())*2;
		boolean tape[]=new boolean[2004];
		int cnt=0;
		st=new StringTokenizer(br.readLine());
		int pos[]=new int[N];
		for(int i=0;i<N;i++) {
			pos[i]=Integer.parseInt(st.nextToken())*2;

		}
		Arrays.sort(pos);
		for(int i=0;i<N;i++) {
			if(tape[pos[i]-1]&&tape[pos[i]]&&tape[pos[i]+1]) {//already taping
				continue;
			}
			//taping 
			cnt++;
			for(int l=0;l<=L;l++) {
				if(pos[i]-1+l<0||pos[i]-1+l>=2004)continue;
				tape[pos[i]-1+l]=true;
			}

		}
		System.out.println(cnt);

	}
}
