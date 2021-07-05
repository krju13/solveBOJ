package com.boj.week19;

import java.util.Scanner;

public class BOJ14888 {
    static int N;
    static int num[];
    static int oper[];//+ - x %
    static int Min=Integer.MAX_VALUE,Max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        N=sc.nextInt();
        num=new int[N];
        for(int i=0;i<N;i++){
            num[i]=sc.nextInt();
        }
        oper=new int[4];
        for(int i=0;i<4;i++){
            oper[i]=sc.nextInt();
        }
        //input
        recusion(1,oper[0],oper[1],oper[2],oper[3],num[0] );
        System.out.println(Max);
        System.out.println(Min);
    }
    private static void recusion(int deep,int sum,int cha,int mul,int div,int result){
        if(deep==N){
            Min=Math.min(Min,result);
            Max=Math.max(Max,result);
            return;
        }
        if(sum>0){
            recusion(deep+1,sum-1,cha,mul,div,result+num[deep]);
        }
        if(cha>0){
            recusion(deep+1,sum,cha-1,mul,div,result-num[deep]);
        }
        if(mul>0){
            recusion(deep+1,sum,cha,mul-1,div,result*num[deep]);
        }
        if(div>0&&num[deep]>0){
            recusion(deep+1,sum,cha,mul,div-1,result/num[deep]);
        }
    }

}
