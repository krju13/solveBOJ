package com.boj.week18;

import java.util.Scanner;

public class BOJ14391 {
    static int H,W;
    static int num[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        H=sc.nextInt();
        W=sc.nextInt();
        num=new int[H][W];
        for(int h=0;h<H;h++){
            String s=sc.next();
            for(int w=0;w<W;w++){
                num[h][w]=(s.charAt(w)-'0');
            }
        }
        int sum=sero();
        sum=Math.max(sum,garo());
        System.out.println(sum);
    }
    private static int sero(){
        int sum=0;
        int tmp;
        for(int w=0;w<W;w++){
            tmp=0;
            for(int h=0;h<H;h++){
                tmp=tmp*10+num[h][w];
            }
            sum+=tmp;
        }
        return sum;
    }
    private static int garo(){
        int sum=0;
        int tmp;
        for(int h=0;h<H;h++){
            tmp=0;
            for(int w=0;w<W;w++){
                tmp=tmp*10+num[h][w];
            }
            sum+=tmp;
        }
        return sum;
    }
}
