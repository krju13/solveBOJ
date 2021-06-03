package com.boj.week03Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Binary Search Tree
class node{
	int num;
	node left,right;
	node(){
	}
	node(int num){
		this.num=num;
	}
}
class Tree{
	node root;
	Tree(){root=null;}
	public void add(node n) {
		if(root==null) {
			root=n;
			return;
		}
		node now=root;
		node pre=root;
		while(now!=null) {
			if(now.num<n.num) {
				pre=now;
				now=now.right;
			}
			else {
				pre=now;
				now=now.left;
			}
		}
		if(pre.num<n.num) {
			pre.right=n;
		}else {
			pre.left=n;
		}
	}
	public void order() {
		postorder(this.root);
	}
	public void postorder(node n) {
		if(n.left!=null)postorder(n.left);
		if(n.right!=null)postorder(n.right);
		System.out.println(n.num);
	}
	
}
public class BOJ5639 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Tree tree=new Tree();
		String input="";
		while((input=br.readLine())!=null) {
			int N=Integer.parseInt(input);
			tree.add(new node(N));
		}
		tree.order();
	}
}
