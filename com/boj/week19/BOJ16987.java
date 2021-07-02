package com.boj.week19;

import java.util.Scanner;

public class BOJ16987 {
    static int N;
    static int egg[][];
    static int eggBreak[];
    static int Max=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        egg=new int[N][2];//0 = 내구도 1 = 무게
        eggBreak=new int[N];
        for(int i=0;i<N;i++){
            egg[i][0]=sc.nextInt();
            egg[i][1]=sc.nextInt();
        }
        recusion(0,0);

        System.out.println(Max);
    }
    private static void recusion(int left,int Break){
        if(left==N){
            Max=Math.max(Max,Break);
            return;
        }
        if(eggBreak[left]==1){
            recusion(left+1,Break);
        }else{
            boolean allbreak=true;
            for(int i=0;i<N;i++){
                if(i==left)continue;//같은 계란은 깰수 없다.
                if(eggBreak[i]==0){  //아직 안 깨졌으면 깬다.
                    allbreak=false;// 깨지지 않은 계란이 있다.
                    egg[left][0]=egg[left][0]-egg[i][1];
                    egg[i][0]=egg[i][0]-egg[left][1];

                    //계란 깬거 확인
                    int result=0;
                    if(egg[left][0]<=0){
                        result++;
                        eggBreak[left]=1;
                    }
                    if(egg[i][0]<=0){
                        result++;
                        eggBreak[i]=1;
                    }
                    // 리커전
                    recusion(left+1,Break+result);
                    //상태 복원
                    egg[left][0]=egg[left][0]+egg[i][1];
                    egg[i][0]=egg[i][0]+egg[left][1];
                    eggBreak[left]=0;
                    eggBreak[i]=0;
                }
            }
            if(allbreak){
                recusion(left+1,Break);
            }
        }
    }

}
