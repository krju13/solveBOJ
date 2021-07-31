package com.boj.week23;

import java.util.*;
import java.io.*;

public class BOJ12738 {
    static int N;
    static int arr[];
    static int last;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0]=Integer.MIN_VALUE;
        arr[1]=Integer.parseInt(st.nextToken());
        last = 1;
        for(int i=1;i<N;i++){
            int input=Integer.parseInt(st.nextToken());
            if(arr[last]<input){
                arr[++last]=input;
                continue;
            }
            int left=0,right=last;
            while(left<right){
                int mid=(left+right)/2;
                if(arr[mid]<input){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            arr[right]=input;

        }
        System.out.println(last);
    }
}
