package com.boj.week16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ5014 {
    static int F,S,G,U,D;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        F=sc.nextInt();
        S=sc.nextInt();
        G=sc.nextInt();
        U=sc.nextInt();
        D=sc.nextInt();
        //input

        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(S,0);
        q.add(S);
        while(q.size()>0){
            int now=q.poll();
            if(now-D>0){
                if(!hm.containsKey(now-D)) {
                    hm.put(now - D, hm.get(now) + 1);
                    q.add(now - D);
                }
                if(now-D==G){
                    break;
                }
            }
            if(now+U<=F){
                if(!hm.containsKey(now+U)) {
                    hm.put(now + U, hm.get(now) + 1);
                    q.add(now + U);
                }
                if(now+U==G){
                    break;
                }
            }
        }
        if (hm.containsKey(G)){
            System.out.println(hm.get(G));
        }else{
            System.out.println("use the stairs");
        }
    }
}
