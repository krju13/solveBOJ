package com.boj.week18;

import java.util.Scanner;

public class BOJ16198 {
    static int N;
    static int W[];
    static int Max=0;
    static int used[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        W=new int[N];
        for(int i=0;i<N;i++){
            W[i]=sc.nextInt();
        }
        //input
        used=new int[N];
        recusion(0,0);
        System.out.println(Max);
    }
    private static void recusion(int deep,int sum)
    {
        if(deep==N-2){//양끝 빼고 다 골랐으면
            Max=Math.max(Max,sum);//현재 값이 최대인지 확인
            return;
        }
        for(int i=1;i<N-1;i++){// 양 끝 빼고 하나씩 없애본다
            if(used[i]==1)continue;//이미 없앤 거면 패쓰
            used[i]=1;
            int left=findleft(i);//왼쪽에 살아있는거 찾는 함수
            int right=findright(i);//오른쪽에 살아있는거
            recusion(deep+1,sum+left*right);//재귀
            used[i]=0;// 다시 안 없앤거라고 표시하기
        }
    }
    private static int findleft(int now){
        for(int i=now-1;i>=0;i--){
            if(used[i]==0)
                return W[i];
        }
        return 0;
    }
    private static int findright(int now){
        for(int i=now+1;i<N;i++){
            if(used[i]==0)
                return W[i];
        }
        return 0;
    }
}
