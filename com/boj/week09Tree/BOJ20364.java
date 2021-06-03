package com.boj.week09Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20364 {
    //원하는 땅이 들어오면 그 땅의 부모들 확인하면서 루트까지 점유한 사람 없으면 자기자리 라고 표시하고
	//점유한 사람 있으면 그 사람  프린트 하기
	static int N,Q;
	static HashMap<Integer,Integer> map=new  HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		for(int i=0;i<Q;i++){
			int input=Integer.parseInt(br.readLine().trim());
			goRoot(input);
		}
		Queue<Integer> q=new LinkedList<>();
		q.add(0);
		int c=q.poll();
		ArrayList<Integer> al=new ArrayList<>();
		al.add(0);
		
	}
	private static void goRoot(int input) {
		int tmp=input;
		int met=0;
		while(tmp>0) {//root가아닌 동안
			if(map.containsKey(tmp)) {//누군가 점유한 경우 
				met=tmp;//그자리를 갱신 
				//break 하면 안되는 이유 지금 밑에서부터 올라오기 때문에
				//출력은 처음 마주치는 땅이여서 여러개의 점유한 땅 중에서 제일 나중에 만나는 애가
				//처음 만나는 애임
			}
			tmp/=2;
		}
		if(met>0) {//누군가 점유한 경우
			System.out.println(met);
		}else {// 아무도 안만나고 루트까지 가면 자기 땅 점유 가능 
			System.out.println(0);
			map.put(input, 1);//점유하기 
		}
	}
}
