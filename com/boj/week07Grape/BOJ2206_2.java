package com.boj.week07Grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2206_2 {
	static int map[][];
	static int len[][];
	static int wall[][];
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		len=new int[N+1][M+1];// 지금까지의 최단경로 
		wall=new int[N+1][M+1];//벽 부셨는지 확인 한다. 
		
		for(int i=1;i<N+1;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}//입력 
		
		bfs();
		if(len[N][M]==0)System.out.println(-1);
		else
			System.out.println(len[N][M]);
	}

	static int dh[]= {-1,1,0,0};
	static int dw[]= {0,0,-1,1};
	private static void bfs() {
		LinkedList<int[]> que=new LinkedList<>();
		que.add(new int[]{1,1});
		len[1][1]=1;
		while(que.size()>0) {
			int[] first=que.pollFirst();
			for(int d=0;d<4;d++) {
				int ch=first[0];
				int cw=first[1];
				int nh=first[0]+dh[d];
				int nw=first[1]+dw[d];
				if(nh<1||nw<1||nh>N||nw>M)continue;//범위 밖이면 
				if(len[nh][nw]!=0&&len[nh][nw]<len[ch][cw]+1)continue;
				if(map[nh][nw]==1&&wall[ch][cw]==0) {
					//벽부순적 없는데 그다음에 벽이면 그 벽도 갈 수 있음
					if(len[nh][nw]==0) {
						len[nh][nw]=len[ch][cw]+1;
					}else {
						if(len[nh][nw]>len[ch][cw]+1) {
							len[nh][nw]=len[ch][cw]+1;
						}
					}
					que.add(new int[] {nh,nw});
					wall[nh][nw]=1;
				}else if(map[nh][nw]==1&&wall[ch][cw]==1)continue;//벽으로 못가면 안들어
				else {
					if(len[nh][nw]==0) {//벽 아닌데 처음 온 곳 이면 
						len[nh][nw]=len[ch][cw]+1;//갱신 
						wall[nh][nw]=wall[ch][cw];//갱신 
						que.add(new int[] {nh,nw});//이 위치 넣어준다. 
					}else {//벽 아닌데 이미 온 곳이면  이전 값이랑 비교한다. 
						if(len[nh][nw]>len[ch][cw]+1) {//더 짧은 길이 이번 길이면 
							len[nh][nw]=len[ch][cw]+1;//갱신 
							wall[nh][nw]=wall[ch][cw];//갱신 
							que.add(new int[] {nh,nw});//이 위치 넣어준다. 
						}
					}
				}
				
			}
		}
	}

}

//4 4
//0101
//0101
//0001
//1110

/*
5 9
000110000
110000110
011111110
011111110
000000000
*/

/*
 5 8
01000000
01010000
01010000
01010011
00010010
 
 
 
 * */
