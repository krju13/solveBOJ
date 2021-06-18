package com.boj.week17;

import java.util.Scanner;

public class BOJ1339 {
    static int exist[]=new int[100];
    static int matching[]=new int[100];
    static int used[]=new int[10];
    static int N;
    static String word[];
    static int allcnt=0;
    static int MAX=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        word=new String[N];
        for(int i=0;i<N;i++){
            word[i]=sc.next();
            for(int j=0;j<word[i].length();j++){
                if(exist[word[i].charAt(j)-'A']==0){
                    exist[word[i].charAt(j)-'A']++;
                    allcnt++;
                }
            }
        }//input
        permutation(0,0);
        System.out.println(MAX);
    }
    private static void permutation(int deep,int order){
        if(deep==allcnt){
            makenumber();
            return;
        }
        if(order>=100)return;
        for(int i=order;i<100;i++){
            if(exist[i]>0){
                for(int j=0;j<10;j++){
                    if(used[j]==0){
                        used[j]=1;
                        matching[i]=j;
                        permutation(deep+1,i+1);
                        used[j]=0;
                    }
                }
            }
        }
    }

    private static void makenumber() {
        int sum=0;
        int wordnum=0;
        for(int i=0;i<N;i++){
            wordnum=0;
            for(int j=0;j<word[i].length();j++){
                wordnum=wordnum*10+matching[word[i].charAt(j)-'A'];
            }
            sum+=wordnum;
        }
        if(MAX<sum){
            MAX=sum;
        }
    }
}
