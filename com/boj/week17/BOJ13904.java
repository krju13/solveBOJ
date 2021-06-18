package com.boj.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13904 {
    static int N;
    static LinkedList<Integer> day[]=new LinkedList[1001];// 각 마감일마다 과제 점수
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int d,w;
        for(int i=1;i<=1000;i++){
            day[i]=new LinkedList<>();
        }
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            d=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());

            day[d].add(w);
        }
        int sum=0,nowMax;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());//큰수부터 빼기 위한 pq
        for(d=1000;d>0;d--){
            for(int i=0;i<day[d].size();i++){
                pq.add(day[d].get(i));
            }
            if(pq.size()>0){
                sum+=pq.poll();
            }
        }
        System.out.println(sum);
    }
}
/*
* 1 20
* 2 50 2일
* 3 30 3일
* 4 10
* 4 40 4일
* 4 60 1일
* 6 5 5일
* sum = 185
*
* 1일 20 30 10 => 30
* 2일 50 10 30=> 50
* 3일 30 40 => 40
* 4일 60 => 60
* 6일 5 => 5
* 합 = 175
*
* 기한이 큰거부터 가는거야
* 그러면 1000일부터 겠지 1000일이 마감일인거 중에서 제일 큰거 선택하고 나머지는 다 999일로 가
* 999일에는 1000일에서 넘어온거랑 999일 마감인거 중에서 제일 큰거 고르고
* 998일에는 또 나머지 넘어온거랑 998에서 제일 큰거 고르고
* 이거 반복하면 되지 않을까????
* 그러면 priority queue 가 필요하겠당
*
*
*
* 9 9
* 9 9
* 9 9
* 1 10
* =>
* 이것도
* 9일에 9
* 8일에 9
* 7일에 9
* 1일에 10
* 이렇게 되는 거지
*
*
*  2 2 1일
*  2 2 2일
*  2 2
*  4 1
*  4 4
*  5 100 3일
*=>
* 5일에 100
* 4일에 4
* 3일에 1
* 2일에 2
* 1일에 2
* 이렇게
*

* */