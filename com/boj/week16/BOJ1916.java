package com.boj.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Vertex implements Comparable<Vertex>{
    int index;
    int cost;
    Vertex(){}
    Vertex(int index,int cost){
        this.index=index;this.cost=cost;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.cost-o.cost;
    }
}
public class BOJ1916 {
    static int city[];
    static int visited[];
    static ArrayList<Vertex> grape[];
    static int N,M;
    static final int INIT=Integer.MAX_VALUE-1;
    static int start,dest;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine())+1;//1~N
        city=new int[N];
        visited=new int[N];
        grape=new ArrayList[N];
        for(int i=0;i<N;i++){
            city[i]=INIT;
            grape[i]=new ArrayList<>();
        }
        M=Integer.parseInt(br.readLine());
        int s,d,cost;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            cost=Integer.parseInt(st.nextToken());
            grape[s].add(new Vertex(d,cost));
        }
        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        dest=Integer.parseInt(st.nextToken());
        //input
        PriorityQueue<Vertex> pq=new PriorityQueue<>();
        pq.add(new Vertex(start,0));
        city[start]=0;
        while(pq.size()>0){
            int nowMinCity=pq.poll().index;
            if(visited[nowMinCity]>0)continue;
            visited[nowMinCity]=1;
            for(int i=0;i<grape[nowMinCity].size();i++){
                int sum=city[nowMinCity]+grape[nowMinCity].get(i).cost;
                int index=grape[nowMinCity].get(i).index;
                if(city[index]>sum){
                    city[index]=sum;
                    pq.add(new Vertex(index,sum));
                }
            }
        }
        System.out.println(city[dest]);

    }
}
