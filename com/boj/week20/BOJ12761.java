package com.boj.week20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ12761 {
    static int N,M,A,B,tmp1,tmp2;
    static boolean arrived=false;
    static int MinMove=1000000;
    static int visited[]=new int[100001];
    static final int MAX=100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tmp1=sc.nextInt();
        tmp2=sc.nextInt();
        A=Math.max(tmp1,tmp2);
        B=Math.min(tmp1,tmp2);
        N=sc.nextInt();
        M=sc.nextInt();
        //input
        int arr[]={-1,1,A,B,-1*A,-1*B};
        Queue<Integer> q=new LinkedList<>();
        q.add(N);visited[N]=1;
        while(q.size()>0){
            int now=q.poll();
            if(now*A==M){
                visited[now*A]=visited[now]+1;
                break;
            }
            if(now*A<MAX&&visited[now*A]==0){
                q.add(now*A);
                visited[now*A]=visited[now]+1;
            }
            if(now*B==M){
                visited[now*B]=visited[now]+1;
                break;
            }
            if(now*B<MAX&&visited[now*B]==0){
                q.add(now*B);
                visited[now*B]=visited[now]+1;
            }
            boolean flag=false;
            int next;
            for(int i=0;i<6;i++){
                next=now+arr[i];
                if(next==M){
                    flag=true;
                    visited[next]=visited[now]+1;
                    break;
                }
                if(next>=0&&next<MAX&&visited[next]==0){
                    q.add(next);
                    visited[next]=visited[now]+1;
                }
            }
            if(flag)break;
        }
        System.out.println(visited[M]-1);

    }

}
