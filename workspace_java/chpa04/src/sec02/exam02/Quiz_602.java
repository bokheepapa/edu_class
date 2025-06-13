package sec02.exam02;

import java.util.Scanner;

public class Quiz_602 {

	public static void main(String[] args) {
		/*
		문제 3
		가위바위보게임 0이 입력될 때 까지 반복
		*/
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("가위(1), 바위(2), 보(3)를 선택하세요 (종료: 0): ");
			int num = scan.nextInt();
			
			int compare_num = (int)(Math.random() * 3) + 1;
			
			if((num == 1 && compare_num == 3) ||
				(num == 2 && compare_num == 1) ||
				(num == 3 && compare_num == 2)) {
				System.out.println("플레이어 승!!");
			}
			else if((num == 1 && compare_num == 1) ||
					(num == 2 && compare_num == 2) ||
					(num == 3 && compare_num == 3)) {
				System.out.println("비김!!");
			}
			else if((num == 1 && compare_num == 2) ||
					(num == 2 && compare_num == 3) ||
					(num == 3 && compare_num == 1)) {
				System.out.println("컴퓨터 승!!");
			}
			else if(num == 0){
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("에러!!");
			}
			System.out.println("===========================");
		}
		
	}

}
