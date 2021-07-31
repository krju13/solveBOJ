package com.boj.week23;

import java.util.*;
import java.io.*;

public class boj2467 {
    static int N;
    static int arr[];
    public static void main(String args[])throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int left = 0, right = N-1;
        int minabs=Integer.MAX_VALUE;
        int res1=0,res2=0;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(Math.abs(sum)<minabs){
                minabs=Math.abs(sum);
                res1=arr[left];
                res2=arr[right];
            }
            if(sum<0){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(res1+" "+res2);
    }

}
