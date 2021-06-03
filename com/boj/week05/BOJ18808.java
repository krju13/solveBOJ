package com.boj.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ18808 {
	static int N,M,K;
	static int note[][];
	static int turned[][];
	static ArrayList<int[][]> sticker=new ArrayList<>();;//all of sticker arrays
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		note=new int[N][M];//notebook
		for(int k=0;k<K;k++) {
			st=new StringTokenizer(br.readLine());
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			int [][]stickey=new int[R][C];
			for(int r=0;r<R;r++) {
				st=new StringTokenizer(br.readLine());
				for(int c=0;c<C;c++) {
					stickey[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			sticker.add(stickey);
		}
	 	for(int index=0;index<K;index++) {
			for(int i=0;i<4;i++) {// try 4 direction
				if(isCanAttach(index)) {//is can attach? then attach the sticker
					break;//and stop and go to next one
				}
				turn90(index);// can't attach? turn the sticker 90 degree.
			}
		}
		//when you tried the last thing 
		//count the notebook's space
		System.out.println(counting());
	}
	private static int counting() {
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				if(note[i][j]==1)sum++;
		}
		return sum;
	}
	private static boolean isCanAttach(int index) {
		boolean flag=true;
		int NN=N-sticker.get(index).length;
		int MM=M-sticker.get(index)[0].length;
		for(int i=0;i<=NN;i++) {
			for(int j=0;j<=MM;j++) {
					flag=true;
					for(int h=0;h<sticker.get(index).length;h++) {
						for(int w=0;w<sticker.get(index)[0].length;w++) {
							if(sticker.get(index)[h][w]==1&&note[i+h][j+w]==1) {
								flag=false;break;
							}
						}//w
						if(!flag)break;
					}//h
					if(flag) {//여기까지 flag가 참이면 스티커를 붙일수 있다.
						//attach the sticker
						for(int h=0;h<sticker.get(index).length;h++) {
							for(int w=0;w<sticker.get(index)[0].length;w++) {
									if(sticker.get(index)[h][w]==1)
									note[i+h][j+w]=sticker.get(index)[h][w];
								}
							}//w
						return true;
						}//h
					
				}
			}
		return false;
	}
	private static void turn90(int indexOfArray) {
		//turned = new int [C][R]
		turned=new int[sticker.get(indexOfArray)[0].length][sticker.get(indexOfArray).length];
		/*
		 * 2 5			5 2
		 * 1 1 1 1 1	0 1
		 * 0 0 0 1 0	0 1
		 * 				0 1
		 * 				1 1
		 * 				0 1
		 */
		int R=sticker.get(indexOfArray).length;
		int C=sticker.get(indexOfArray)[0].length;
		for(int oc=0;oc<C;oc++) {//original column==next row
			for(int or=R-1,nc=0;or>=0;or--,nc++) {
				//or=original row, nc=next column
				turned[oc][nc]=sticker.get(indexOfArray)[or][oc];
			}
		}
		sticker.set(indexOfArray, turned);
	}
}
