package com.boj.week18;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ2262 {
    static int N;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList<Integer> ll=new LinkedList<>();
        N=sc.nextInt();
        for(int i=0;i<N;i++){
            ll.add(sc.nextInt());
        }
        int sum=0;
        while(ll.size()>1){
            int rank=0,index=0;
            for(int i=0;i<ll.size();i++){
                if(rank<ll.get(i)) {
                    rank = ll.get(i);
                    index=i;
                }
            }
                if(index==0){
                    sum+=(ll.get(index)-ll.get(index+1));
                    ll.pollFirst();
                }else if(index==ll.size()-1){
                    sum+=(ll.get(index)-ll.get(index-1));
                    ll.pollLast();
                }else{
                    int max=Math.max(ll.get(index-1),ll.get(index+1));
                    sum+=ll.get(index)-max;
                    ll.remove(index);
                }
        }

        System.out.println(sum);
    }
}

