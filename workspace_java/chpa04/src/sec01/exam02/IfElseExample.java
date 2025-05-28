package sec01.exam02;

import java.util.Scanner;

public class IfElseExample {

	public static void main(String[] args) {

		int cnt = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("몇 층으로 만들까요? ");

		cnt = scan.nextInt();
		
		for( int i = 1; i <= cnt; i++) {
			
					
			for( int j = 1; j <= cnt * 2; j++) {
				
				if(j >= cnt - (i - 1) && j <= cnt + (i - 1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
