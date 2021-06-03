package com.boj.week06backtracing;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1174 {
	static int N;
	static Long result=(long) 0;
	static int count=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		PriorityQueue<Long> que=new PriorityQueue<Long>();//작은 수 부터 넣기 
		for(Long i=(long) 0;i<10;i++) {
			que.add(i);//0~9
		}
		Long pop=(long) 0;//제일 작은 
		while(que.size()>0) {//큐에아무것도 없으면 수를 다 구한거 
			pop=que.poll();//하나뺀다 
			count++;// 카운트를 올리고 
			if(count==N) {//카운트랑 같으면 
				result=pop;//결과에 뺀거 저장하고 break; 
				break;
			}
			int end=(int) (pop%10);//뺀거의 끝자리 
			for(int i=end-1;i>=0;i--) {//끝자리보다 작은 수를 뒤에 붙여서 큐에 넣는다. 
				que.add(pop*10+i);
			}
		}
		if(count<N)result=(long) -1;//N이 count보다 크면 -1을 출력 .
		System.out.println(result);
	}
	
}
