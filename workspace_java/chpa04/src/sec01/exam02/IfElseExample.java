package sec01.exam02;

import java.util.Scanner;
import java.util.Timer;

public class IfElseExample {

	public static void main(String[] args) {

//		int cnt = 0;
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("몇 층으로 만들까요? ");
//
//		cnt = scan.nextInt();
//		
//		scan.close();
//		
//		for( int i = 1; i <= cnt; i++) {
//			
//					
//			for( int j = 1; j <= cnt * 2; j++) {
//				
//				if(j >= cnt - (i - 1) && j <= cnt + (i - 1))
//					System.out.print("*");
//				else
//					System.out.print(" ");
//			}
//			System.out.println();
//		}
		
		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("숫자를 입력하세요. ");
//		
//		int num = 0;
//		num = scan.nextInt();
//		
//		if(num % 2 == 0)
//			System.out.println("짝수 입니다.");
//		else
//			System.out.println("홀수 입니다.");
		
		
		
//		while(true) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Math.random() * 6);
//			System.out.println((int) (Math.random() * 6) + 1);
//		}
		
		
		
//		Scanner scanner = new Scanner(System.in);
//        System.out.print("피라미드 높이를 입력하세요: ");
//        int height = scanner.nextInt();
//        scanner.close();
//
//        for (int i = 1; i <= height; i++) {
//            // 공백 출력
//            for (int j = height - i; j > 0; j--) {
//                System.out.print(" ");
//            }
//            // 별 출력
//            for (int k = 0; k < (2 * i - 1); k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
		
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("몇 단을 출력 할까요? : ");
//		int num = scanner.nextInt();
//		scanner.close();
//		
//		for(int i = 1 ; i < 10 ; i++ ) {
//			System.out.println(num + " * " + i + " = " + (num * i));
//		}
		
//		int num = 1;
//		switch(num) {
//		case 1 :
//			System.out.println("1switch num 은 " + num);
//			break;
//		case 2 :
//			System.out.println("2switch num 은 " + num);
//			break;
//		default :
//			System.out.println("3switch num 은 " + num);
//			break;
//		}
		
		// 계절이 뭐야
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇월달이야? : ");
		int month = scanner.nextInt();
		scanner.close();
		
//		if(month == 3 || month == 4 || month == 5) {
//			System.out.println(month + "월은 봄이야!!");
//		}
//		else if(month == 6 || month == 7 || month == 8) {
//			System.out.println(month + "월은 여름이야!!");
//		}
//		else if(month == 9 || month == 10 || month == 11) {
//			System.out.println(month + "월은 가을이야!!");
//		}
//		else if(month == 12 || month == 1 || month == 2) {
//			System.out.println(month + "월은 겨울이야!!");
//		}
//		else {
//			System.out.println("12개월 중에 말해 줄래?");
//		}
		
		switch (month) {
		case 3 :
		case 4 :
		case 5 :
			System.out.println(month + "월은 봄이야!!");
			break;
		case 6 :
		case 7 :
		case 8 :
			System.out.println(month + "월은 여름이야!!");
			break;
		case 9 :
		case 10 :
		case 11 :
			System.out.println(month + "월은 가을이야!!");
			break;
		case 12 :
		case 1 :
		case 2 :
			System.out.println(month + "월은 겨울이야!!");
			break;
		default :
			System.out.println("12개월 중에 말해 줄래?");
			break;
		}
	}

}
