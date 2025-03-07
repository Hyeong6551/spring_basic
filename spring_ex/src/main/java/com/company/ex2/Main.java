package com.company.ex2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input[] = new int[3];

		for(int i=0;i<input.length;i++) {
			input[i] = sc.nextInt();
		}
		
		int n = input[0];
		int k = input[1];
		int l = input[2];
		int tot=0;int cnt=0;
		
		int arr[][] = new int[n][3];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				tot += arr[i][j];
			}
			if(tot>k) {
				cnt++;
			}
			tot=0;
		}
		
		sc.close();
		
	}
}

//https://www.acmicpc.net/problem/20299