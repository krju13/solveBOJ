//give up.....
package com.boj.week10binarySearch;

import java.util.Scanner;

public class BOJ10504 {
	static long DPsum[]=new long[10000001];
	public static void main(String[] args) {
	
		int i=1;
		while(true) {
			DPsum[i]=DPsum[i-1]+i;
			if(i==10000000)break;
			i++;
		}//make DP sum = 현재 수까지의 모든 수의 합 
		final int arrend=i;
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			StringBuilder sb=new StringBuilder();
			//맨 오른쪽 수는 N/2-1에서 부터 시작해서
			//DP[right]-DP[left]==N인 left를 찾으면 된다. 
			//right는 큰거부터 작아지기 때문에 한번 찾으면 제일 짧은 결과가 나온다. 
			//left를 찾을 때 이분탐색으로 찾는다. 
			int N=sc.nextInt();
			int right=0,left=0;
			if(N>arrend)right=arrend;
			else right=N/2+1;
			for(;right>1;right--) {
				left=find(right,N)+1;
				if(DPsum[right]-DPsum[left-1]==N) {
					break;
				}
			}
			//System.out.println("right:"+right+"left:"+left+"sum:"+(DPsum[right]-DPsum[left-1]));
			if(right<2||right<=left) {//impossible
				sb.append("IMPOSSIBLE");
				
			}else {
				sb.append(N).append(" = ").append(left);
				for(i=left+1;i<=right;i++) {
					sb.append(" + ").append(i);
				}
				
			}
			System.out.println(sb);
		}
		
		sc.close();
	}
	private static int find(int right,int N) {
		int low=0,high=right,middle=0;
		while(low<high) {
			middle=(low+high)/2;
			long sum=DPsum[right]-DPsum[middle];
			if(sum==N) {
				return middle;
			}
			else if(sum>N) {
				low=middle+1;
			}else if(sum<N) {
				high=middle-1;
			}
		}
		return low;
	}
}
