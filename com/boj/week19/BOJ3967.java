package com.boj.week19;

import java.util.Scanner;

/*
....0....
.1.2.3.4.
..5...6..
.7.8.9.10.
....11....


....1....
.2.4.12.8.
..10...6..
.11.5.3.7.
....9....

....A....
.B.D.x.H.
..x...F..
.x.E.C.G.
....I....
 */


public class BOJ3967{
    static int used[];
    static int num[];
    static int result[];
    static int check[][]={{1,2,3,4},{0,2,5,7},{0,3,6,10},{7,8,9,10},{1,5,8,11},{4,6,9,11}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        used=new int[13];//해당 숫자가 사용되었는가?  1~12
        num=new int[12];//해당위치에 숫자가 있는가?  0~11
        result=new int[12];//해당 위치에 조건에 맞는 수 중에서 사전순으로 가장 작은 경우
        int n=0;
        for(int i=0;i<5;i++){
            String a=sc.next();
            for(int j=0;j<9;j++){
                if(a.charAt(j)=='x'){
                    num[n++]=0;
                }else if(a.charAt(j)!='.'){
                    num[n++]=(int)(a.charAt(j)-'A'+1);
                    used[num[n-1]]++;
                }
            }
        }//input
        recusion(0);

        System.out.println("...."+(char)(result[0]+'A'-1)+"....");
        System.out.println("."+(char)(result[1]+'A'-1)+"."+(char)(result[2]+'A'-1)+"."+(char)(result[3]+'A'-1)+"."+(char)(result[4]+'A'-1)+".");
        System.out.println(".."+(char)(result[5]+'A'-1)+"..."+(char)(result[6]+'A'-1)+"..");
        System.out.println("."+(char)(result[7]+'A'-1)+"."+(char)(result[8]+'A'-1)+"."+(char)(result[9]+'A'-1)+"."+(char)(result[10]+'A'-1)+".");
        System.out.println("...."+(char)(result[11]+'A'-1)+"....");
    }
    private static void recusion(int deep){
        if(deep==12){
            makeResult();
            return;
        }
        if(result[0]>0)return;
        if(num[deep]>0){
            //해당위치에 이미 숫자가 있으면
            //다음위치 숫자 정하러 들어간다.
            recusion(deep+1);
        }else{
            for(int i=1;i<=12;i++){
                if(used[i]==0){
                    //아직 사용안된 경우면
                    used[i]=1;
                    num[deep]=i;
                    recusion(deep+1);
                    num[deep]=0;
                    used[i]=0;
                }
            }
        }

    }
    private static void makeResult(){
        boolean answer=true;
        for(int i=0;i<6;i++){
            if(num[check[i][0]]+num[check[i][1]]+num[check[i][2]]+num[check[i][3]]!=26)
            {   //조건에 맞는 경우가 아니면 답이 아니다.
                answer=false;
                break;
            }
        }
        if(!answer)return;
            for(int i=0;i<12;i++)
                result[i]=num[i];


    }
}


