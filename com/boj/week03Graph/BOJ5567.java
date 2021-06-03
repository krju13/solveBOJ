package com.boj.week03Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//결혼식 .
public class BOJ5567 {
	static boolean friend[][];//인접 행열 
	static boolean invite[];// 이미 방문한 친구인지확인 
	static int count=0; // 최종 친구 수 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		friend=new boolean[N+1][N+1];
		invite=new boolean[N+1]; // 친구 수는 1~N 이여서 N+1크기로 만듬 
		int M=Integer.parseInt(br.readLine());
		for(int m=0;m<M;m++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			friend[i][j]=true;
			friend[j][i]=true;
		}
		invite[1]=true;// 자기자신은 일단 체크하고 시작하기 
		Queue<Integer> queue=new LinkedList<>(); // bfs를 위한 큐 
		for(int i=1;i<friend.length;i++) {
			if(friend[1][i]) { //상근이 자신과 친구인 사람 
				invite[i]=true;// 초대 한다고 체크하고 ( 나중에 다시 카운트 안하기 위해서)  
				count++;
				queue.add(i);  // 큐에 삽입 
			}
		}
		while(!queue.isEmpty()) {  // 큐를 다 도는 동안 
			int first=queue.poll();// 큐에서 하나 꺼내서 그 친구의 친구 검사하기 
			for(int i=2;i<friend.length;i++) {  // 1은 자기 자신이니까 넘기고 계산한다. 
				if(friend[first][i]&&!invite[i]) {
					count++;
					invite[i]=true;
				}
				//친구랑 친구인 사람이면서 이미 초대한 사람 아니면 초대한다 
				//초대한 사람은 초대한 사람인거 
			}
		}
		System.out.println(count);// 결과 출력! 
	}
	
}
