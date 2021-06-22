package com.boj.week18;

import java.util.Scanner;

public class BOJ2529 {
    static int N;
    static char str[];
    static int num[];
    static int used[];
    static String min="9999999999",max="0";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        str=new char[N];
        num=new int[N+1];
        used=new int[10];
        for(int i=0;i<N;i++){
            str[i]=sc.next().charAt(0);
        }
        //input
        for(int i=0;i<10;i++){
            num[0]=i;
            used[i]=1;
            recusion(0);
            used[i]=0;
        }
        System.out.println(max);
        System.out.println(min);
    }
    private static void recusion(int deep){
        if(deep==N){
            makenum();
            return;
        }
        if(str[deep]=='<'){
            for(int i=0;i<10;i++){
                if(num[deep]<i&&used[i]==0){
                    used[i]=1;
                    num[deep+1]=i;
                    recusion(deep+1);
                    used[i]=0;
                }
            }
        }else{
            for(int i=0;i<10;i++){
                if(num[deep]>i&&used[i]==0){
                    used[i]=1;
                    num[deep+1]=i;
                    recusion(deep+1);
                    used[i]=0;
                }
            }
        }
    }
    private static void makenum(){
        long result=0;
        for(int i=0;i<N+1;i++){
            result=result*10+num[i];
        }
        long Min=Long.parseLong(min);
        long Max=Long.parseLong(max);
        if(result<Min) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < N + 1; i++) {
                sb.append(num[i]);
                min = sb.toString();
            }
        }
        if(result>Max){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<N+1;i++){
                sb.append(num[i]);
                max=sb.toString();
            }
        }
    }
}
