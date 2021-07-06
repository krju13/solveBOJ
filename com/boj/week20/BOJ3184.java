package com.boj.week20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ3184 {
    static int offset[][]={{0,1},{0,-1},{1,0},{-1,0}};
    static int H,W;
    static char map[][];
    static int sheep,fox;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        H=sc.nextInt();W=sc.nextInt();
        map=new char[H][W];
        String input;
        for(int i=0;i<H;i++){
            input=sc.next();
            map[i]=input.toCharArray();
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j]=='.'||map[i][j]=='v'||map[i][j]=='o'){
                    bfs(i,j);
                }
            }
        }
        System.out.println(sheep+" "+fox);
    }
    private static void bfs(int h,int w){
        boolean goOut=false;
        int sh=0,f=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(h);q.add(w);
        if(map[h][w]=='v')f++;
        else if(map[h][w]=='o')sh++;
        map[h][w]='u';

        while(q.size()>0){
            int ch=q.poll();
            int cw=q.poll();
            for(int d=0;d<4;d++){
                int nh=ch+offset[d][0];
                int nw=cw+offset[d][1];
                if(nh<0||nh>=H||nw<0||nw>=W){
                    goOut=true;
                    continue;
                }
                if(map[nh][nw]=='.'){
                    q.add(nh);q.add(nw);
                    map[nh][nw]='u';
                }else if(map[nh][nw]=='v'){
                    q.add(nh);q.add(nw);
                    map[nh][nw]='u';
                    f++;
                }else if(map[nh][nw]=='o'){
                    q.add(nh);q.add(nw);
                    map[nh][nw]='u';
                    sh++;
                }

            }
        }
        if(goOut)return;
        if(sh<=f){
            fox+=f;
        }else {
            sheep+=sh;
        }

    }
}
