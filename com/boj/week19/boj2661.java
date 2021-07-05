package com.boj.week19;

import java.util.Scanner;
/*
작은수 구하기 여서 1로 시작한다면
1 - 2 -1 -3 - 1 -
      -3 -1

  - 3
 */
public class boj2661 {
    static int N;//80깊이만큼 들어가지만 각 자리에서 최대 2개의 숫자만 고를수있어서 재귀함수로 구현가능

    static boolean find=false;//답을 찾으면 그 답이 정답!
    //왜냐하면 1부터가능한지 보고 그다음 2 순으로 차례로 해보기 때문에
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        String s="1234567";
//        System.out.println(s.substring(s.length()-3-3+1,s.length()-3+1));
//        System.out.println(s.substring(s.length()-3+1)+"1");
        recusion("1");

    }
    private static void recusion(String s){
        if(s.length()==N){
            System.out.println(s);
            find=true;
            return;
        }

        for(int i=1;i<4;i++){
            boolean can=true;
            if(find==false){
                int len=(s.length()+1)/2-1;
                for(int j=0;j<=len;j++){
                    String f=s.substring(s.length()-j-j-1,s.length()-j);
                    String b=s.substring(s.length()-j)+Integer.toString(i);
//                    System.out.println("f"+f+"b"+b);
                    if(f.compareTo(b)==0){
                        //비교했는데 같으면
                        can=false;
                        break;
                    }
                }
                if(can){
                    recusion(s+Integer.toString(i));
                }
            }
        }
    }

}
