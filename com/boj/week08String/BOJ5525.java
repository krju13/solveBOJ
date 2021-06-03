package com.boj.week08String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
	static String pn;
	static int N,M;
	static char[] S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		S=br.readLine().toCharArray();
		
		//101010101 = p4 = 4p1 = 3p2 = 2p3
		System.out.println(solve());
	}
	private static int solve() {
		int len=0;//IOI의 길이, Plen에 몇개의 pN이 들어있는지 계산을 위해서 
		int sum=0;
		for(int i=0;i+2<M;i++) {
			if(S[i]=='I'&&S[i+1]=='O'&&S[i+2]=='I') {
				len++;
				i++;//IOI -> I 로 만들기 위한 증가 
			}else {
				if(len+1-N>0)//양수일때만 더하기 
					sum+=(len+1-N);
				len=0;//길이 초기화 
			}
		}
		if(len>0&&len+1-N>0)//다 돌았는데 아직 길이남아있는채로 끝나면한번더 계산해주기 
			sum+=(len+1-N);
		return sum;
	}
}
