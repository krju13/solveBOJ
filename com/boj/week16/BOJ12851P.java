package com.boj.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851P {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        if(N==K)
        {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        Queue<Integer> q=new LinkedList<>();
        int visited[][]=new int[100001][2];//visited time, cnt
        int cntSecond=100001;
        q.add(0);q.add(N);//second, current position
        while (q.size()>0){
            if(q.peek()<=cntSecond){
                int now=q.poll();
                int position=q.poll();
                if(position-1>=0&&(visited[position-1][0]==0||visited[position-1][0]==now+1)){
                    q.add(now+1);
                    q.add(position-1);
                    visited[position-1][0]=now+1;
                    visited[position-1][1]+=1;
                    if(position-1==K){
                        cntSecond=now+1;
                    }
                }
                if(position+1<100001&&(visited[position+1][0]==0||visited[position+1][0]==now+1)){
                    q.add(now+1);
                    q.add(position+1);
                    visited[position+1][0]=now+1;
                    visited[position+1][1]+=1;
                    if(position+1==K){
                        cntSecond=now+1;
                    }
                }
                if(position*2<100001&&(visited[position*2][0]==0||visited[position*2][0]==now+1)){
                    q.add(now+1);
                    q.add(position*2);
                    visited[position*2][0]=now+1;
                    visited[position*2][1]+=1;
                    if(position*2==K){
                        cntSecond=now+1;
                    }
                }
            }
            else
                break;
        }
        System.out.println(cntSecond);
        System.out.println(visited[K][1]);

    }
}
