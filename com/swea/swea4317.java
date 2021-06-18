package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4317 {
    static int T;
    static int H,W;
    static int wafer[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            st=new StringTokenizer(br.readLine());
            H=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            wafer=new int[H][W];
            for(int i=0;i<H;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    wafer[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            //input
            int cnt=0;
            for(int j=0;j<W-1;j++){
                for(int i=0;i<H-1;i++)
                {
                    if(wafer[i][j]+wafer[i+1][j]+wafer[i][j+1]+wafer[i+1][j+1]==0){
                        wafer[i][j]=2;
                        wafer[i+1][j]=2;
                        wafer[i][j+1]=2;
                        wafer[i+1][j+1]=2;
                        cnt++;
                    }
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
