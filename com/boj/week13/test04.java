package com.boj.week13;


class Solution {
    static int min=Integer.MAX_VALUE; 
    static int N;
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        N=n;
    	int graph[][]=new int[n+1][n+1];        
        for(int i=0;i<roads.length;i++){
        	if(graph[roads[i][0]][roads[i][1]]==0)
        		graph[roads[i][0]][roads[i][1]]=roads[i][2];
        	else {
        		graph[roads[i][0]][roads[i][1]]=Math.min(graph[roads[i][0]][roads[i][1]], roads[i][2]);
        	}
        }
    //dfs
    int visit[]=new int[n+1];
    for(int i=0;i<traps.length;i++){
        visit[traps[i]]=2;//trap = 2
    }
    dfs(visit,end,start,graph,0);
        return min;
    }
    public void dfs(int visit[],int end,int now,int graph[][],int nowcost){
        if(now==end){
            min=Math.min(min,nowcost);
            return;
        }
        if(nowcost>min){
            return;
        }
        if((visit[now]&1)==0){
            change(graph,now);
        }
        for(int i=0;i<graph.length;i++) {
        	if(graph[now][i]>0&&visit[i]!=1&&visit[i]<2*N) {
        		if(visit[i]==0)
        			visit[i]=1;
        		else{
        			visit[i]+=2;
        		}
        		dfs(visit,end,i,graph,nowcost+graph[now][i]);
        		if(visit[i]==1)
        			visit[i]=0;
        		else {
        			visit[i]-=2;
        		}
        	}
        }
        if((visit[now]&1)==0){
            change(graph,now);
        }
    }
	private void change(int[][] graph, int now) {
		int n=graph.length;
		int tmp[][]=new int[n][2];
		for(int i=0;i<n;i++) {
			tmp[i][0]=graph[now][i];
			tmp[i][1]=graph[i][now];
		}
		for(int i=0;i<n;i++) {
			graph[i][now]=tmp[i][0];
			graph[now][i]=tmp[i][1];
		}
	}
}