package com.boj.week17;

import java.util.Arrays;
import java.util.Scanner;

class alpha implements Comparable<alpha>{
    char w;
    int cost;
    alpha(char w,int cost){
        this.w=w;this.cost=cost;
    }
    @Override
    public int compareTo(alpha o) {
        return o.cost-this.cost;
    }
}
public class BOJ1339_2 {
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
            for(int j=word[i].length()-1,m=1;j>=0;j--,m*=10){
                exist[word[i].charAt(j)-'A']+=m;
            }
        }//input
        alpha al[]=new alpha[27];
        for(int i=0;i<27;i++){
            al[i]=new alpha((char)('A'+i),exist[i]);
        }
        Arrays.sort(al);
        int NN=9;
        for(int i=0;i<27;i++){
            if(NN==-1)break;
            matching[al[i].w-'A']=NN;
            NN--;
        }
        makenumber();
        System.out.println(MAX);
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
