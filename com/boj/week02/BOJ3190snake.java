package com.boj.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position{
	int h,w;
	Position(int h,int w){
		this.h=h;this.w=w;
	}
}
class Move{
	int t;
	char s;
	Move(int t,char s){
		this.t=t;this.s=s;
	}
}
public class BOJ3190snake {
	static int dh[]= {-1,0,1,0};//위 오 아래 왼 
	static int dw[]= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		//map
		int map[][]=new int[N+1][N+1];
		//list 뱀 
		ArrayList<Position> snake = new ArrayList<>();
		snake.add(new Position(1,1));
		map[1][1]=2;// snake mark
		int K=Integer.parseInt(br.readLine());// input K
		int h=0,w=0;// input apple place 
		StringTokenizer st;
		for(int i=0;i<K;i++) {
			st =new StringTokenizer(br.readLine());
			h=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			map[h][w]=1;// apple mark
		}
		int X=Integer.parseInt(br.readLine());
		int time[]=new int[10002];// time array
		for(int i=0;i<X;i++) {
			st =new StringTokenizer(br.readLine());
			h=Integer.parseInt(st.nextToken());// time input
			char turn=st.nextToken().charAt(0);// character input
			time[h]=turn=='L'?3:1;// left turn is +3, right turn is +1
		}
		int T=1;
		int ch=1,cw=1,cd=1;
		for(;;T++) {
			int nh=ch+dh[cd];
			int nw=cw+dw[cd];
			//벽에 만나면 die 
			if(nh<1||nw<1||nh>N||nw>N)break;
			//meet snake-self die
			if(map[nh][nw]==2) {
				break;
			}
			//meet apple 
			if(map[nh][nw]==1) {
				snake.add(0, new Position(nh,nw));
				map[nh][nw]=2;
			}else {// just go front
				int backH=snake.get(snake.size()-1).h;
				int backW=snake.get(snake.size()-1).w;
				//befor array delete last one, save the info 
				snake.add(0, new Position(nh,nw));
				map[nh][nw]=2;
				// add the first one
				snake.remove(snake.size()-1);
				map[backH][backW]=0;
				// remove the last one
			}
			ch=nh;
			cw=nw;
			//after T time check turn infomation
			cd=(cd+time[T])%4;
		}
		System.out.println(T);
	}
}
