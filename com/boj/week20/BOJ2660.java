package com.boj.week20;

import java.util.*;

class Person implements Comparable<Person>{
    int level,index;
    Person(){}
    Person(int index,int level){
        this.index=index;
        this.level=level;
    }
    @Override
    public int compareTo(Person o) {
        if(this.level==o.level)
            return this.index-o.index;//레벨이 같으면 작은 번호순
        return this.level-o.level;//작은 레벨 순
    }
}
public class BOJ2660 {
    static int N;//사람
    static ArrayList<Integer> grape[];//인접리스트
    static PriorityQueue<Person> pq=new PriorityQueue<>();//최종 결과를 위해
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        grape=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            grape[i]=new ArrayList<>();//만들어주기
        }
        int a,b;
        while(true){
            a=sc.nextInt();
            b=sc.nextInt();
            if(a==-1)break;//그만
            grape[a].add(b);//서로 연결
            grape[b].add(a);
        }
        //input
        for(int i=1;i<=N;i++){
            BFS(i);//사람별로 bfs
        }
        ArrayList<Integer> result=new ArrayList<>();
        int condition=pq.peek().level;
        while(pq.size()>0){
            int index=pq.peek().index;
            int level=pq.peek().level;
            if(level>condition)break;
            result.add(index);
            pq.poll();
        }
        System.out.println(condition+" "+ result.size());
        for (int res:result) {
            System.out.print(res+" ");
        }

    }
    private static void BFS(int i){
        boolean visited[]=new boolean[N+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(i);q.add(0);
        visited[i]=true;
        int min=Integer.MAX_VALUE;
        if(pq.size()!=0)
            min=pq.peek().level;
        int MAX=0;
        int now,deep;
        while (q.size()>0){
            now=q.poll();
            deep=q.poll();
            MAX=Math.max(MAX,deep);
            if(MAX>min)break;
            for(int j=0;j<grape[now].size();j++){
                int next=grape[now].get(j);
                if(visited[next])continue;
                visited[next]=true;
                q.add(next);q.add(deep+1);
            }
        }
        pq.add(new Person(i,MAX));
    }
}
