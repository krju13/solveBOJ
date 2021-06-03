package com.boj.week10binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ9753 {
	static int Ache[]=new int[50001];
	//0 = prime 1 = non_prime;
	static int T,K;
	static ArrayList<Integer> prime=new ArrayList<>(),mul=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		primes();
		Collections.sort(mul);
		for(int t=0;t<T;t++) {
			K=sc.nextInt();
			int low=0,high=mul.size(),middle;
			while(low<high) {
				middle=(low+high)/2;
				if(mul.get(middle)<K) {
					low=middle+1;
				}else {
					high=middle;
				}
			}
			System.out.println(mul.get(high));
		}
	}
	private static void primes() {
		Ache[0]=1;
		Ache[1]=1;
		Ache[2]=0;
		prime.add(2);
		for(int j=4;j<50001;j+=2)
			Ache[j]=1;
		for(int i=3;i<50001;i+=2) {
			if(Ache[i]==1)continue;
			prime.add(i);
			for(int j=i+i;j<50001;j+=i) {
				Ache[j]=1;
			}
		}
		for(int i=0;i<prime.size()-1;i++) {
			for(int j=i+1;j<prime.size();j++) {
				int result=prime.get(i)*prime.get(j);
				if(result<100010)
					mul.add(result);
			}
		}
	}
	

}
