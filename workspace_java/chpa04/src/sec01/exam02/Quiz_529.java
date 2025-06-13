package sec01.exam02;

import java.util.Scanner;

public class Quiz_529 {

	public static void main(String[] args) {
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("############################");
			System.out.print("문제의 번호를 입력하세요 : ");			
			int quizNum = scanner.nextInt();
			System.out.println("############################");
			
			switch(quizNum) {
			case 1:
				// 1번 함수 호출
				quiz1(scanner);
				System.out.println("");
				break;
			case 2:
				// 2번 함수 호출
				quiz2(scanner);
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
			case 5:
				// 5번 함수 호출
				quiz5();
				System.out.println("");
				break;
			case 6:
				// 6번 함수 호출
				quiz6();
				System.out.println("");
				break;
			case 7:
				// 7번 함수 호출
				quiz7();
				System.out.println("");
				break;
			case 8:
				// 8번 함수 호출
				quiz8();
				System.out.println("");
				break;
			case 9:
				// 9번 함수 호출
				quiz9();
				System.out.println("");
				break;
			case 0:
				// 종료
				System.out.print("######## 종료 ########");
				scanner.close();
				return;
			}
		}
		
	}
	
	public static void quiz1(Scanner scanner) {
		/*
		 * 문제 1.,
		 * int 변수에 임의의 수를 넣고
		 * 그 수가 "양수", "0", "음수" 구분하여 출력
		 */
		System.out.println("##### 1번 문제 시작 #####");
		
//		Scanner scanner = new Scanner(System.in);
		System.out.print("# 임의의 숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		
		if(num > 0)
			System.out.println("양수");
		else if(num < 0)
			System.out.println("음수");
		else
			System.out.println("0");
		
//		scanner.close();
	}
	
	public static void quiz2(Scanner scanner) {		
		/*
		 * 문제 2.,
		 * a와 b 두 수 중에서 큰 값을 출력
		 */
		System.out.println("##### 2번 문제 시작 #####");
		
//		Scanner scanner = new Scanner(System.in);
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
		 * 문제 3.
		 * 시간 과 분이 있을 때
		 * 35분이 지난 시간을 출력
		 */
		System.out.println("##### 3번 문제 시작 #####");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("# 시간을 입력하세요 : ");
		int hour = scan.nextInt();
		System.out.print("# 분을 입력하세요 : ");
		int minute = scan.nextInt();
		
		int result_hour = hour + ((minute + 35) / 60);
		int result_minute = (minute + 35) % 60;
		
		System.out.println("35분 후 시간은 " + result_hour + "시 " + result_minute + "분 입니다.");
		
//		scan.close();
	}
	
	public static void quiz4() {
		/*
		 * 문제 4.
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
		
		System.out.println("입력한 수가 15와 20 사이(포함)에 있는가? : " + answer);
		
//		scanner.close();
	}
	
	public static void quiz5() {
		/*
		 * 문제 5.
		 * 통장 잔액이 10000원 있을 때
		 * 출금액에 따라
		 * "잔액이 부족합니다", "얼마 출금 했고 얼마 남았습니다", "정확히 입력 해주세요"
		 */
		System.out.println("##### 5번 문제 시작 #####");
		int cur_won = 10000;
		System.out.println("##### 현재 잔액은 " + cur_won + "원 입니다. #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 출금액을 입력하세요 : ");
		int num = scanner.nextInt();
				
		if(cur_won < num){
			System.out.println("잔액이 부족합니다.");
		}
		else if(cur_won > num){
			if(num < 0){
				System.out.println("정확히 입력 해주세요.");	
			}
			else {
				cur_won = cur_won - num;
				System.out.println(num + "원을 출금 했고 " + cur_won + "원이 남았습니다.");
			}
		}
		else{
			System.out.println("Error.");
		}

//		scanner.close();
	}
	
	public static void quiz6() {
		/*
		 * 문제 6.
		 * 값에 따라(예를 들어 125)(단, 0은 양수+짝수)
		 * "100 보다 큰 수이며, 양수이고, 홀수입니다"
		 * 예를들어 -6
		 * "100 보다 작은 수이며, 음수이고, 짝수입니다"
		 */
		System.out.println("##### 6번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 임의의 숫자를 입력하세요 : ");
		int num = scanner.nextInt();
				
//		if(num < 100){
//			if(num < 0){
//				if(num % 2 == 0){
//					System.out.println("100 보다 작은 수이며, 음수이고, 짝수입니다.");
//				}
//				else{
//					System.out.println("100 보다 작은 수이며, 음수이고, 홀수입니다.");
//				}
//			}
//			else{
//				if(num % 2 == 0){
//					System.out.println("100 보다 작은 수이며, 양수이고, 짝수입니다.");
//				}
//				else{
//					System.out.println("100 보다 작은 수이며, 양수이고, 홀수입니다.");
//				}
//			}
//		}
//		else if(num == 0){
//			System.out.println("100 보다 작은 수이며, 양수이고, 짝수입니다.");
//		}
//		else{
//			if(num % 2 == 0){
//				System.out.println("100 보다 큰 수이며, 양수이고, 짝수입니다.");
//			}
//			else{
//				System.out.println("100 보다 큰 수이며, 양수이고, 홀수입니다.");
//			}
//		}
		
		String size = (num < 100) ? "100 보다 작은 수" : "100 보다 큰 수";
		String parity = (num % 2 == 0) ? "짝수" : "홀수";
		String sign;
		
		if(num < 100) {
			sign = (num < 0) ? "음수" : "양수";
		} else {
			sign = "양수";
		}
		
		System.out.println(size + "이며, " + sign + "이고, " + parity + "입니다.");
		
//		scanner.close();
	}
	
	public static void quiz7() {
		/*
		 * 문제 7.
		 * 어제 온도, 오늘 온도 변수 두개
		 * 2, -3
		 * "오늘 온도는 영하 3도 입니다. 어제보다 5도 낮습니다" 
		 */
		System.out.println("##### 7번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 오늘 온도를 입력하세요 : ");
		int num_a = scanner.nextInt();
		System.out.print("# 어제 온도를 입력하세요 : ");
		int num_b = scanner.nextInt();
				
//		if(num_a < 0){
//			if(num_b > num_a){
//				System.out.println("오늘 온도는 영하 " + num_a + "도 입니다. 어제보다 " + (num_b - num_a) + "도 낮습니다.");
//			}
//			else if(num_b == num_a){
//				System.out.println("오늘 온도는 영하 " + num_a + "도 입니다. 어제와 같은 온도 입니다.");
//			}
//			else{
//				System.out.println("오늘 온도는 영하 " + num_a + "도 입니다. 어제보다 " + (num_a - num_b) + "도 높습니다.");
//			}
//		}
//		else{
//			if(num_b > num_a){
//				System.out.println("오늘 온도는 " + num_a + "도 입니다. 어제보다 " + (num_b - num_a) + "도 낮습니다.");
//			}
//			else if(num_b == num_a){
//				System.out.println("오늘 온도는 " + num_a + "도 입니다. 어제와 같은 온도 입니다.");
//			}
//			else{
//				System.out.println("오늘 온도는 " + num_a + "도 입니다. 어제보다 " + (num_a - num_b) + "도 높습니다.");
//			}
//		}
		
		String todayTemp = (num_a < 0) ? "영하 " + num_a + "도" : num_a + "도";
		String comparison;

		if (num_b > num_a) {
		    comparison = "어제보다 " + (num_b - num_a) + "도 낮습니다.";
		} else if (num_b == num_a) {
		    comparison = "어제와 같은 온도 입니다.";
		} else {
		    comparison = "어제보다 " + (num_a - num_b) + "도 높습니다.";
		}

		System.out.println("오늘 온도는 " + todayTemp + " 입니다. " + comparison);


//		scanner.close();
	}
	
	public static void quiz8() {
		/*
		 * 문제 8.
		 * 변수에 두자리 숫자(10~99)가 있을 때
		 * 10의 자리와 1의 자리가 같은 수인지 판단
		 */
		System.out.println("##### 8번 문제 시작 #####");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# 임의의 두자리 숫자를 입력하세요(10~99) : ");
		int num = scanner.nextInt();
				
		if(num > 9 && num < 100){
			int front_num, back_num;
			front_num = num / 10;
			back_num = num % 10;
			
			if(front_num == back_num){
				System.out.println("10의 자리와 1의 자리가 같은 수 입니다.");
			}
			else{
				System.out.println("10의 자리와 1의 자리가 다른 수 입니다.");
			}
		}
		else{
			System.out.println("두자리 숫자가 아닙니다.");
		}

//		scanner.close();
	}
	
	public static void quiz9() {
		/*
		 * 문제 9번.,
		 * 사각형의 한쪽 모서리 x1:10, y1:20
		 * 대각선 모서리       x2:90, y2:100
		 * 이럴 때 새로운 점 x3, y3는 사각형에 포함되는가?
		 */
		System.out.println("##### 9번 문제 시작 #####");
		int x1 = 10, x2 = 90;
		int y1 = 20, y2 = 100;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("# x 값을 입력하세요 : ");
		int x = scanner.nextInt();
		System.out.print("# y 값을 입력하세요 : ");
		int y = scanner.nextInt();
						
		if(x > x1 && x < x2){
			if(y > y1 && y < y2){
				System.out.println("입력한 점은 사각형에 포함 됨");
			}
			else{
				System.out.println("입력한 점은 사각형에 포함 되지 않음(y축 에러)");
			}
		}
		else{
			if(y > y1 && y < y2){
				System.out.println("입력한 점은 사각형에 포함 되지 않음(x축 에러)");
			}
			else{
				System.out.println("입력한 점은 사각형에 포함 되지 않음(x축 y축 에러)");
			}
		}

//		scanner.close();
	}

}