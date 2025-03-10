package com.company.ex2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input[] = new int[3];

		for(int i=0;i<input.length;i++) {
			input[i] = sc.nextInt();
		}
		
		int n = input[0];	// 팀 수
		int k = input[1];	// 합 
		int l = input[2];	// 개인
		int tot=0;int cnt=0;
		boolean lswitch = true;
		
		int arr[][] = new int[n][3];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				tot += arr[i][j];
				if(arr[i][j] < l) {
					lswitch = false;
				}
			}
			if(tot>k && lswitch) {
				cnt++;
				for(int j=0;j<arr[i].length;j++) {

				}
			}
			tot=0;
			lswitch = true;
		}
		
		System.out.println(cnt);

		sc.close();
	}
}

//https://www.acmicpc.net/problem/20299