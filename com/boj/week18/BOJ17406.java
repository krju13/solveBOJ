package com.boj.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
    static int H,W;
    static int K;
    static int map[][],tmp[][];
    static int A[][];
    static int order[];
    static int select[];
    static int Min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new int[H][W];
        tmp=new int[H][W];
        A=new int[K][3];
        order=new int[K];
        select=new int[K];

        for(int i=0;i<H;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            A[i][0]=Integer.parseInt(st.nextToken());
            A[i][1]=Integer.parseInt(st.nextToken());
            A[i][2]=Integer.parseInt(st.nextToken());
        }
        //input & init

        permu(0);

        System.out.println(Min);

    }
    private static void permu(int deep){
        if(deep==K){
            turnMap();
            Min=Math.min(Min,minHangSum());
            return;
        }
        for(int i=0;i<K;i++){
            if(select[i]==0){
                select[i]=1;
                order[deep]=i;
                permu(deep+1);
                select[i]=0;
            }
        }
    }
    private static void turnMap(){
        //copy
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                tmp[i][j]=map[i][j];
            }
        }
        // turn
        for(int k=0;k<K;k++){
            int sh=A[order[k]][0]-1;
            int sw=A[order[k]][1]-1;
            int layer=A[order[k]][2];

            for(int lay=1;lay<=layer;lay++){
                int temp=tmp[sh-lay][sw-lay];
                for(int h=sh-lay+1;h<=sh+lay;h++){
                    tmp[h-1][sw-lay]=tmp[h][sw-lay];
                }
                for(int w=sw-lay+1;w<=sw+lay;w++){
                    tmp[sh+lay][w-1]=tmp[sh+lay][w];
                }
                for(int h=sh+lay-1;h>=sh-lay;h--){
                    tmp[h+1][sw+lay]=tmp[h][sw+lay];
                }
                for(int w=sw+lay-1;w>=sw-lay;w--){
                    tmp[sh-lay][w+1]=tmp[sh-lay][w];
                }
                tmp[sh-lay][sw-lay+1]=temp;
            }
        }
    }
    private static int minHangSum(){
        int min=500000;
        int Hang=0;
        for(int h=0;h<H;h++){
            Hang=0;
            for(int w=0;w<W;w++){
                Hang+=tmp[h][w];
            }
            min=Math.min(min,Hang);
        }
        return min;
    }
}
