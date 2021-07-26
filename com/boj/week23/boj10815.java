package com.boj.week23;

import java.util.*;
import java.io.*;
public class boj10815 {
    public static void main(String[] args) throws Exception{
        HashSet<Integer> set=new HashSet<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
        }
    }
}
