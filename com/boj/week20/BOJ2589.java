package com.boj.week20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2589 {
    static int offset[][]={{0,1},{0,-1},{1,0},{-1,0}};
    static int H,W;
    static char map[][];
    static int cost[][];
    static int Long=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        H=sc.nextInt();W=sc.nextInt();
        map=new char[H][W];

        for(int i=0;i<H;i++){
            map[i]=sc.next().toCharArray();
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j]=='L'){
                    bfs(i,j);
                }
            }
        }
        System.out.println(Long-1);
    }
    private static void bfs(int h,int w){
        cost=new int[H][W];
        Queue<Integer> q=new LinkedList<>();
        q.add(h);q.add(w);
        cost[h][w]=1;

        //현위치에서 제일 먼 곳 찾기

        // 제일 먼 곳까지 거리 계산하기


        while(q.size()>0){
            int ch=q.poll();int cw=q.poll();
            for(int d=0;d<4;d++){
                int nh=ch+offset[d][0];
                int nw=cw+offset[d][1];
                if(nh<0||nw<0||nh>=H||nw>=W){
                    continue;
                }
                if(map[nh][nw]=='L'){
                    if(cost[nh][nw]>0)continue;
                    q.add(nh);q.add(nw);
                    cost[nh][nw]=cost[ch][cw]+1;
                    Long=Math.max(Long,cost[nh][nw]);
                }
            }
        }

    }
}
