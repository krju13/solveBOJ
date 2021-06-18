package com.boj.week17;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ2812 {
    static int N,K;
    static char num[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        num=sc.next().toCharArray();
        Stack<Integer> s=new Stack<>();
        s.add(num[0]-'0');
        int remove=0;
        for(int i=1;i<N;i++){
            while(s.size()>0&&s.peek()<num[i]-'0'){
                if(remove==K){
                    break;
                }
                s.pop();
                remove++;
            }
            s.add(num[i]-'0');
        }
        ArrayList<Integer> arr=new ArrayList<>();
        int cntlen=0;
        while(s.size()>0){
            arr.add(s.pop());

        }
        for(int i=arr.size()-1;cntlen<N-K&&i>=0;i--){
            System.out.print(arr.get(i));
            cntlen++;
        }

    }
}
