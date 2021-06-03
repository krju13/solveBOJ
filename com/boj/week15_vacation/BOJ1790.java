package com.boj.week15_vacation;

import java.util.Scanner;

public class BOJ1790 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        int place;
        for(int i=1;i<=N;i++){
            //i의 자릿수 구하기
            place= (int) Math.log10(i)+1;
            if(K<=place){
                char num=Integer.toString(i).charAt(K-1);
                System.out.println(num);
                K=0;
                break;
            }else{
                K-=place;
            }
        }
        if(K!=0){
            System.out.println(-1);
        }
    }
}
