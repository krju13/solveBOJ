package com.boj.week02;

import java.util.Scanner;

public class BOJ15683 {
	static int dh[]= {-1,0,1,0};// 위 오른쪽 아래 왼쪽 
	static int dw[]= {0,1,0,-1};
	//위 오른 아래 왼 기본적으로 보는 방향을 고르면 그 방향을 기준으로 생각한다. 
	//1번은 한 방향
	//2번은 뒤랑 같이
	//3번은 오른쪽이랑 같이
	//4번은 오른쪽 뒤랑 같이
	//5번은 모든 방향
	static int tvH[]=new int[8];  //tv들의 높이 위치
	static int tvW[]=new int[8];// tv들의 넓이 위치/
	static int tvD[]=new int[8];//tv 들의 방향 .
	static int minArea=Integer.MAX_VALUE;// 사각지대중 제일 작은 값 
	static int map[][];// 처음 들어오는 지도(?)
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int H=sc.nextInt();// 높이
		int W=sc.nextInt();// 넓이 
		map=new int[H][W];// 크기 정의 
		int cnt=0; // 카메라 
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				map[i][j]=sc.nextInt();// 입
				if(map[i][j]>0&&map[i][j]<6)//save cctv position 
				{
					tvH[cnt]=i;
					tvW[cnt]=j;
					cnt++;
				}
			}
		}//input
		System.out.println(permutation(0,cnt));
	}
	static int permutation(int deep,int cnt) {// 카메라의 바라보는 방향 세팅하는 모든 경우의 수 
		if(deep==cnt) { // 카메라 수와 같이 다 돌면 
			return solve(cnt); //  못 보는 곳 찾으러 감 
		}
		int min=Integer.MAX_VALUE; // min 값을 세팅하고 
		for(int i=0;i<4;i++) {// 0~3까지 카메라가 될 수 있는 방향을 선택 
			tvD[deep]=i;// 한 방향으로 세팅 
			min=Math.min(min,permutation(deep+1,cnt)); // 다른 카메라 방향 정하러 들어가던가 그전에 데려온  값이랑 비교해서 작은거 저장 
		}
		return min;
	}
	static int  solve(int cnt) {
		int copy[][]=Copy();// 배열 복사 하는 함수 
		for(int tv=0;tv<cnt;tv++) { // 카메라 별로 하나씩  
			int ch=tvH[tv];
			int cw=tvW[tv];
			int di=tvD[tv];
			look(copy,ch,cw,di); // 무조건 바라보는 한 방향은 다 상태 바꿔주고 
			switch (copy[ch][cw]) {
			case 2:
				look(copy,ch,cw,(di+2)%4);  // 뒤  
				break;
			case 3:
				look(copy,ch,cw,(di+1)%4);  // 바라보는 방향의 오른쪽 
				break;
			case 4:
				look(copy,ch,cw,(di+1)%4);//  오른쪽 
				look(copy,ch,cw,(di+2)%4);// 뒤 
				break;
			case 5:
				look(copy,ch,cw,(di+1)%4); // 오른쪽 
				look(copy,ch,cw,(di+2)%4); // 뒤 
				look(copy,ch,cw,(di+3)%4);// 왼 
				break;
			default:
				break;
			}
		}
		int sum=0;// 여전히 빈칸인 칸 수 세기 
		for(int i=0;i<copy.length;i++) {
			for(int j=0;j<copy[i].length;j++) {
				if(copy[i][j]==0)sum++;
			}
		}
		return sum;
	}
	static void look(int [][]map,int ch,int cw,int di) {
		for(int i=1;;i++) {
			ch+=dh[di];
			cw+=dw[di];
			//범위밖이면 
			if(ch<0||cw<0||ch>=map.length||cw>=map[0].length)break;
			// 벽을 만나면 
			if(map[ch][cw]==6)break;
			//빈칸이면 7로 바꾸고 카메라는 무시 
			if(map[ch][cw]==0)
				map[ch][cw]=7;
		}
	}
	static int[][] Copy(){
		int copy[][]=new int[map.length][map[0].length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				copy[i][j]=map[i][j];
			}
		}
		return copy;
	}
}
