package main;

import java.util.Scanner;

public class UpDown {
	public static void main(String[] args) {
		
		int randomNum = (int)(Math.random() * 9 + 1);
		int inputNum;
		int cnt = 0;
//		System.out.println(random_num);
		
		Scanner scan = new Scanner(System.in);
		int rs;
		
		
		System.out.println("0-9까지 중에서");
		while(true) {
			System.out.print("찍어보자 : ");
			inputNum = scan.nextInt();
			
			rs = compare (randomNum, inputNum);
			
			switch(rs) {
				case 1:
					cnt++;
					System.out.println(">> up -시도 " + cnt);
					break;
				case 2:
					cnt++;
					System.out.println(">> down -시도 " + cnt);
					break;
				case 3:
					cnt++;
					System.out.println(">> 정답 -시도 " + cnt);
					return;
			}
		}

	}
	
	static int compare (int rNum, int iNum) {
		
		int result;
		
		if(rNum > iNum) {
			result = 1;
		}
		else if(rNum < iNum) {
			result = 2;
		}
		else if(rNum == iNum) {
			result = 3;
		}
		else {
			result = 0;
		}
		
		return result;
	}
}
