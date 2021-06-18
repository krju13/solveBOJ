package com.boj.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class student implements Comparable<student>{
    int paper,interview;

    @Override
    public int compareTo(student o) {
        return this.paper-o.paper;//내림차순
    }
}
//일단 하라는 데로 해보는 코드
public class BOJ1946 {
    static int T;//max = 20
    static int N;//max 100000
    static student stu[];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        while(T-->0){
            N=Integer.parseInt(br.readLine());
            stu=new student[N];
            StringTokenizer st;
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                stu[i]=new student();
                stu[i].paper=Integer.parseInt(st.nextToken());
                stu[i].interview=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(stu);
            int nowInterviewMin=stu[0].interview;
            int cnt=1;
            for(int i=1;i<N;i++){
                if(stu[i].interview>nowInterviewMin){
                    //not selected

                }else{
                    cnt++;
                    nowInterviewMin=Math.min(nowInterviewMin,stu[i].interview);
                }
            }
            System.out.println(cnt);
        }
    }
}
/*
* 1 4
* 2 3
* 3 2
* 4 1
* 5 5
*
* */

/*
* 1 4    now interview min = 4
* 2 5 x  now interview min = 4
* 3 6 x  now interview min = 4
* 4 2    now interview min = 2
* 5 7 x  now interview min = 2
* 6 1    now interview min = 1
* 7 3 x  now interview min = 1
*
*
* */