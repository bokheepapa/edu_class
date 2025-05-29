package sec01.exam02;

import java.util.Scanner;

public class quiz_529 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("############################");
			System.out.print("문제의 번호를 입력하세요 : ");			
			int quizNum = scanner.nextInt();
			System.out.println("############################");
			
			switch(quizNum) {
			case 1:
				//1번 함수 호출
				quiz1();
				System.out.println("");
				break;
			case 2:
				// 2번 함수 호출
				quiz2();
				System.out.println("");
				break;
			case 3:
				// 3번 함수 호출
				quiz3();
				System.out.println("");
				break;
			case 4:
				// 4번 함수 호출
				quiz4();
				System.out.println("");
				break;
			case 0:
				// 0번 함수 호출
				System.out.print("######## 종료 ########");
				return;
			}
		}
		
	}
	
	public static void quiz1() {
		/*
		 * 문제 1.,
		 * int 변수에 임의의 수를 넣고
		 * 그 수가 "양수", "0", "음수" 구분하여 출력
		 */
		System.out.println("##### 1번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 임의의 숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		
		if(num > 0)
			System.out.print("양수");
		else if(num < 0)
			System.out.print("음수");
		else
			System.out.print("0");
		
//		scanner.close();
	}
	
	public static void quiz2() {		
		/*
		 * 문제 2.,
		 * a와 b 두 수 중에서 큰 값을 출력
		 */
		System.out.println("##### 2번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# a의 숫자를 입력하세요 : ");
		int num_a = scanner.nextInt();
		System.out.print("# b의 숫자를 입력하세요 : ");
		int num_b = scanner.nextInt();
		
		if(num_a > num_b)
			System.out.print("a가 b보다 큰 수입니다. : " + num_a);
		else if(num_a < num_b)
			System.out.print("b가 a보다 큰 수입니다. : " + num_b);
		else
			System.out.print("a와 b는 같은 수입니다.");
		
//		scanner.close();
	}
	
	public static void quiz3() {
		/*
		 * 문제 3.,
		 * 시간 과 분이 있을 때
		 * 35분이 지난 시간을 출력
		 */
		System.out.println("##### 3번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 시간을 입력하세요 : ");
		int hour = scanner.nextInt();
		System.out.print("# 분을 입력하세요 : ");
		int minute = scanner.nextInt();
		
		int result_hour = hour + ((minute + 35) / 60);
		int result_minute = (minute + 35) % 60;
		
		System.out.print("35분 후 시간은 " + result_hour + "시 " + result_minute + "분 입니다.");
		
//		scanner.close();
	}
	
	public static void quiz4() {
		/*
		 * 문제 4.,
		 * 어떤 수가
		 * 15와 20 사이(포함)에 있는가?
		 */
		System.out.println("##### 4번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 임의의 숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		String answer;
		
		if(num >= 15 && num <= 20)
			answer = "Yes";
		else
			answer = "No";
		
		System.out.print("입력한 수가 15와 20 사이(포함)에 있는가? : " + answer);
		
//		scanner.close();
	}

}
