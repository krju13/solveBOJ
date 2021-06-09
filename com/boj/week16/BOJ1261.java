package com.boj.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class room implements Comparable<room>{
    int h,w,cost;

    public room(int h, int w, int cost) {
        this.h = h;
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(room o) {
        return this.cost-o.cost;
    }
}
public class BOJ1261 {
    static int N,M;
    static int maze[][];
    static int visited[][];
    static int offset[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        maze=new int[N][M];
        visited=new int[N][M];
        char line[];
        for(int i=0;i<N;i++){
            line=br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                maze[i][j]=Integer.parseInt(String.valueOf(line[j]));
                visited[i][j]=-1;
            }
        }
        PriorityQueue<room> pq=new PriorityQueue<>();
        pq.add(new room(0,0,0));
        visited[0][0]=0;
        while (pq.size()>0){
            room now=pq.poll();
            int nh,nw;
            for(int d=0;d<4;d++){
                nh=now.h+offset[d][0];
                nw=now.w+offset[d][1];
                if(nh<0||nw<0||nh>=N||nw>=M)
                    continue;
                if(visited[nh][nw]==-1){
                    if(maze[nh][nw]==0)
                        visited[nh][nw]=now.cost;
                    else
                        visited[nh][nw]=now.cost+1;
                    pq.add(new room(nh,nw,visited[nh][nw]));
                }else{
                    if (maze[nh][nw]==0&&visited[nh][nw]>now.cost){
                        visited[nh][nw]=now.cost;
                        pq.add(new room(nh,nw,visited[nh][nw]));
                    }else if(maze[nh][nw]==1&&visited[nh][nw]>now.cost+1){
                        visited[nh][nw]=now.cost+1;
                        pq.add(new room(nh,nw,visited[nh][nw]));
                    }

                }
            }
        }
        System.out.println(visited[N-1][M-1]);

    }
}
