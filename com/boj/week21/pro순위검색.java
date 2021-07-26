package com.boj.week21;

import java.util.*;

public class pro순위검색 {
    static ArrayList<String> key=new ArrayList<>();
    static Map<String,ArrayList<Integer>> map=new HashMap<>();
    static public int[] solution(String[] info, String query[]){
        initMap();//map init
        for(int i=0;i<info.length;i++){
            makeCombi(info[i]);//사람에 대한 정보로 map에 각 경우마다 점수 넣어주기
        }
        //map 안의 arrayList score로 정렬하기
        for(int i=0;i<key.size();i++){
            Collections.sort(map.get(key.get(i)));
        }
        int answer[]=new int[query.length];
        for(int i=0;i< query.length;i++) {
            String res[]=query[i].replace(" and "," ").split(" ");
            String str=res[0]+res[1]+res[2]+res[3];
            int cost = Integer.parseInt(res[4]);
            //2진탐색
            ArrayList<Integer> al=map.get(str);
            int mid=0,left=0,right = al.size();
            while(left<right){
                mid=left+(right-left)/2;
                if(al.get(mid)<cost){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            answer[i]=al.size()-mid-1;
        }
        return answer;
    }
    static public void initMap(){
        String [][]input={{"cpp","java","python","-"},{"backend","frontend","-"},{"junior","senior","-"},{"chicken","pizza","-"}};
        for(int i=0;i<input[0].length;i++){
            String res="";
            for(int j=0;j<input[1].length;j++){
                for(int k=0;k<input[2].length;k++){
                    for(int l=0;l<input[3].length;l++){
                        res=input[0][i]+input[1][j]+input[2][k]+input[3][l];
                        key.add(res);
                        map.put(res,new ArrayList<Integer>());
                    }
                }
            }
        }
    }
    static public void makeCombi(String info){
        String arr[]=info.split(" ");
        int score=Integer.parseInt(arr[4]);
        String arr1[][]={{arr[0],"-"},{arr[1],"-"},{arr[2],"-"},{arr[3],"-"}};
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    for(int l=0;l<2;l++){
                        map.get(arr1[0][i]+arr1[1][j]+arr1[2][k]+arr1[3][l]).add(score);
                    }
                }
            }
        }
    }
    static String []combi;
    public static void main(String[] args) {
        String info[]={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String query[]={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int answer[]=solution(info,query);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }

}
