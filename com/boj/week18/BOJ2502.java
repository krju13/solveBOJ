package com.boj.week18;

import java.util.Scanner;

public class BOJ2502 {
    static int AB[][];
    static int D;
    static int K;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        D=sc.nextInt();K=sc.nextInt();
        //input
        AB=new int[31][2];
        AB[1][0]=1;
        AB[2][1]=1;
        for(int day=3;day<=D;day++){
            AB[day][0]=AB[day-1][0]+AB[day-2][0];
            AB[day][1]=AB[day-1][1]+AB[day-2][1];
        }
        int A=0,B=0;
        for(int a=1;a<=K;a++){
            int sum=0;
            sum=AB[D][0]*a;
            if((K-sum)%AB[D][1]==0){
                A=a;
                B=(K-sum)/AB[D][1];
                break;
            }
        }
        System.out.println(A);
        System.out.println(B);
    }
}
/*
* 1 =A
* 2 = B
* 3 = A+B
* 4= A+2B
* 5= 2A+3B
* 6 = 3A+5B
* 7 = 5A+8B
*
* */