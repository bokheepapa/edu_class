package sec02.exam02;

import java.util.Scanner;

public class WhileExam {

	public static void main(String[] args) {
		
//		int i = 1;
//		while(i <= 10) {
//			System.out.println(i);
//			i++;
//		}
		Scanner scan = new Scanner(System.in);
		
		Label : while(true) {
			System.out.println("메뉴를 고를세요.");
			System.out.println("1 : 커피, 2 : 차, 0 : 종료");
			int menu = scan.nextInt();
			
			switch (menu) {
			case 1 : 
				System.out.println("커피 드릴께요");
				break;
			case 2 :
				System.out.println("차 드릴께요");
				break;
			case 0 :
				System.out.println("주문을 종료합니다. 다음에 뵈요.");
				break Label;
			default :
				System.out.println("주문을 확인하세요.");	
			}
		}

	}

}
