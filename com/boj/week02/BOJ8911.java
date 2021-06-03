package com.boj.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8911 {
	static int dh[]= {-1,0,1,0};// 위 오른 아래 왼
	static int dw[]= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0) {
			int ch=0,cw=0,cdi=0;//거북이의 현재 위치와 방
			int minh=0,minw=0,maxh=0,maxw=0;//거북이 위치의 최대 최소 h,w 좌표
			
			//프로그램입력 
			String program=br.readLine();
			//프로그램을 배열로 
			char[]pro=new char[program.length()];
			pro=program.toCharArray();
			//프로그램을 길이만큼 반복
			for(int i=0;i<pro.length;i++) {
				if(pro[i]=='F') {
					ch=ch+dh[cdi];
					cw=cw+dw[cdi];//앞으로 전진한다.
				}else if(pro[i]=='B') {
					ch=ch+dh[(cdi+2)%4];
					cw=cw+dw[(cdi+2)%4];
					//뒤로 움직이는 방법은 현재방향+2하는 방법인데 방향배열은 0~3이여서 나머지 연산을 한다.
				}else if(pro[i]=='L') {
					cdi=(cdi+3)%4;
					//시계반대 방향으로 움직이는 방법은 -1도 있지만 계산이잘 안될 수도 있기 때문에 3을 더하고 
					//나머지 연산을 해준다.
				}else if(pro[i]=='R') {
					cdi=(cdi+1)%4;
					// 1을 더하고 나머지 연산하면 방향이된다.
				}
				minh=Math.min(minh, ch);
				minw=Math.min(minw, cw);
				maxh=Math.max(maxh, ch);
				maxw=Math.max(maxw,cw);
				//현재 위치가 최소나 최대 값이 되면 업데이트 해준다.
			}
			System.out.println(Math.abs(maxh-minh)*Math.abs(maxw-minw));
			//최소와 최대 높이차이와 넓이 차이를 구하면 직사각형이 된다.
		}
	}
}
