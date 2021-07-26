package com.boj.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1240 {
    static int tree[][];
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        tree=new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                if(i==j)continue;
                tree[i][j]=10001;
            }
        }
        int x,y,z;
        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            z=Integer.parseInt(st.nextToken());
            tree[x][y]=z;
            tree[y][x]=z;
        }
        for(int s=1;s<=N;s++){
            for(x=1;x<=N;x++){
                for(y=1;y<=N;y++){
                    tree[x][y]=Math.min(tree[x][y],tree[x][s]+tree[s][y]);
                }
            }
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken()) ;
            y=Integer.parseInt(st.nextToken());
            System.out.println(tree[x][y]);
        }
    }
}
