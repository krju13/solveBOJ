package com.boj.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
    static int N;
    static int board[][];
    static int offset[][]={{0,1},{1,0},{1,1}};
    static int nextD[][]={{0,2},{1,2},{0,1,2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        board=new int[20][20];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recusion(0,0,1));
    }
    private static int recusion(int d,int ch,int cw){
        //마지막 방향, 마지막 파이프 위치

        if(ch==N-1&&cw==N-1){//목적지 도착
            return 1;
        }else if(ch>=N||cw>=N){//범위 밖
            return 0;
        }
        else if(d==0&&cw==N-1){//더 못가는 경우
            return 0;
        }else if(d==1&&ch==N-1){//더 못가는 경우
            return 0;
        }
        int sum=0;
        for (int next :nextD[d]) {//각 방향별로 다음 설치 가능한 방향만 검사
            if(caninstall(next,ch,cw)){//벽이 없는지 확인해서 없는 경우만
                sum+=recusion(next,ch+offset[next][0],cw+offset[next][1]);
            }
        }
        return sum;
    }
    private static boolean caninstall(int d,int ch,int cw){
        if(d==2){
            if(board[ch+offset[0][0]][cw+offset[0][1]]==0&&
            board[ch+offset[1][0]][cw+offset[1][1]]==0&&
            board[ch+offset[2][0]][cw+offset[2][1]]==0)
                return true;
        }
        if(d==1){
            if(board[ch+offset[1][0]][cw+offset[1][1]]==0)
                return true;
        }
        if (d==0){
            if(board[ch+offset[0][0]][cw+offset[0][1]]==0)
                return true;
        }
        return false;
    }
}
