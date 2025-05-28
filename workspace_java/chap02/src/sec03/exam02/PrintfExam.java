package sec03.exam02;

import java.util.Scanner;

public class PrintfExam {

	public static void main(String[] args) {

//		System.out.printf("이름 : %s\n", "김자바");
//		System.out.printf("1. 이름 : %s, 나이 : %d\n", "김자바", 25);
//		System.out.printf("2. 이름 : %6s, 나이 : %04d\n", "김자바", 25);
		
		//////////////////////////////////////////////////////////////////
		
//		int value = 123;
//		System.out.printf("상품의 가격 : %d원\n", value);
//		System.out.printf("상품의 가격 : %6d원\n", value);
//		System.out.printf("상품의 가격 : %-6d원\n", value);
//		System.out.printf("상품의 가격 : %06d원\n", value);
//		
//		double area = 3.14159 * 10 *10;
//		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n", 10, area);
		
		// 입력
//		int keyCode;
//		
//		while(true) {
//		
//			try {
//			
//				keyCode = System.in.read();
//							
//				if(keyCode == 'q')
//					break;
//				else
//					System.out.println("keyCode : " + keyCode);
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// Scanner
//		try (Scanner scan = new Scanner(System.in)) {
//			String inputData;
//			
//			while(true) {
//				
//				inputData = scan.nextLine();
//				System.out.println("입력된 문자열 : \"" + inputData + "\"");
//				
//				if(inputData.equals("q")) {
//					break;
//				}
//			}
//		}
//		System.out.println("종료");
		
		int x = 1;
		
		System.out.println(x);
		System.out.println(x++ * 10);
		System.out.println(x++ * 10);
		System.out.println(x++ * 10);
		System.out.println(x++ * 10);
		
		System.out.println("========");
		
		int y = 1;
		System.out.println(y);
		System.out.println(++y * 10);
		System.out.println(++y * 10);
		System.out.println(++y * 10);
		System.out.println(++y * 10);
	}

}
