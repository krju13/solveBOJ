package com.boj.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class lesson implements Comparable<lesson>{
	int s,end;
	public lesson(){}
	public lesson(int s,int end){
		this.s=s;this.end=end;
	}
	//시작시간 순으로 수업을 정렬하는데 
	//같은 시간에 시작하면 끝나는 시간이 작은 시간부터 정렬한다. 
	@Override
	public int compareTo(lesson o) {
		if(this.s==o.s)return this.end-o.end;
		return this.s-o.s;
	}
}
public class BOJ11000 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		lesson []al=new lesson[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			al[i]=new lesson(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(al);
		PriorityQueue<lesson>pq=new PriorityQueue<>(N,(o1,o2)->o1.end-o2.end);
		pq.add(al[0]);
		for(int i=1;i<N;i++) {
			lesson top=pq.peek();
			if(top.end<=al[i].s) {
				pq.poll();
				pq.add(al[i]);
			}
			else if(al[i].s<top.end) {
				pq.add(al[i]);
			}
		}
		System.out.println(pq.size());
		
	}
}
