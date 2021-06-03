package com.boj.week09Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ6416 {
	static int T=1;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			int A=sc.nextInt(),B=sc.nextInt();
			if(A==-1&&B==-1)break;
			boolean flag=true;
				int parent[]=new int[100];
				for(int i=0;i<100;i++)
					parent[i]=-1;
			
				while(A!=0&&B!=0) {
					if(parent[B]==-1||parent[B]==0) {
						parent[B]=A;
						parent[A]=0;//들어온거 티내기 
						// 아예 안들어 온 애는 -1 
					}
					else {
						flag=false;
					}
					A=sc.nextInt();B=sc.nextInt();
				}
			if(flag)
				flag=checkTree(parent);
			
			
			if(flag)
				System.out.println("Case "+T+" is a tree.");
			else
				System.out.println("Case "+T+" is not a tree.");
			T++;
		}
	}

	private static boolean checkTree(int []arr) {
		int rootCnt=0,root=0,len=arr.length;
		for(int i=0;i<len;i++) {
			if(arr[i]==0) {
				root=i;
				rootCnt++;
			}
		}
		for(int i=0;i<len;i++) {
			if(arr[i]>0) {//부모가 있으면 
				int f=findroot(arr,i);//조상을 찾는다. 
				if(f!=root) {
					return false;//바른 루트 못 찾음 추트로 가는 길은 한개 뿐이여서무조건 루트로 가야한다. 
				}
			}
		}
		if(rootCnt>1)return false;
		
		return true;
	}

	private static int findroot(int[] arr, int i) {
		if(arr[i]==0)return i;//루트를 찾으면 루트 반환 
		return findroot(arr,arr[i]);// 부모의 루트 반환 
		
	}
	
}
