package sec02.exam02;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
//		int sum = 0;
//		for(int i = 1 ; i <= 100 ; i++) {
//			sum = sum + i;
//		}
//		System.out.println("sum : " + sum);
//		
//		int sum1 = 0;
//		for(int i = 1 ; i <= 10 ; i++) {
//			sum1 = sum1 + 1;
//		}
//		System.out.println("sum1 : " + sum1);
		
		// 구구단
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("몇 단을 출력 할까요? : ");
//		int num = scanner.nextInt();
//		scanner.close();
		
//		for(int i = 1 ; i < 10 ; i++ ) {
//			System.out.println(num + " * " + i + " = " + (num * i));
//		}
		
		// 짝수 출력
		////////////////////////////////////////////
//		for(int i = 2 ; i <= 10 ; i++) {
//			if(i % 2 == 0) {
//				System.out.println(i);
//			}
//		}
//		
//		System.out.println("============");
//		
//		for(int i = 2 ; i <= 10 ; i += 2) {
//			System.out.println(i);
//		}
//		
//		System.out.println("============");
//		
//		int num = 0;
//		for(int i = 1 ; i <= 5 ; i++) {
//			num += 2;
//			System.out.println(num);
//		}
		////////////////////////////////////////////
		
		// 2. 10 ~ 1 출력
		for(int i = 0; i < 10; i++) {
			System.out.println(10 - i);
		}
		
		System.out.println("============");
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		
		System.out.println("============");
		
		// 3. 1 ~ 10까지 다음과 같이 출력
		//		1 : 홀수
		//		2 : 짝수
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + " : " + ((i % 2 == 0) ? "짝수" : "홀수"));
		}
		
		System.out.println("============");
		
		// 4. 구구단 2단 출력
		for(int i = 1; i < 10; i++) {
			System.out.println("2 * " + i + " = " + (2 * i));
		}
		
		System.out.println("============");
		
		/*
		 * 5. 1 ~ 10까지 3개씩 옆으로 찍기
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * 10
		 */
		for(int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
			
			if(i % 3 == 0) {
				System.out.println("");
			}
		}
		System.out.println("");
		System.out.println("============");
		
		for(int i = 1 ; i <= 10; i +=3) {
			if( i == 10) {
				System.out.println(i);
			}else {
				System.out.println(i + " " + (i + 1) + " " + (i + 2));
			}	
		}
			
		
		System.out.println("============");
		
		// 6. 1부터 100까지 홀수의 개수
		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1) {
				cnt++;
			}
		}
		System.out.println("cnt : " + cnt);
		
		System.out.println("============");
		
		// 7. 구구단 전체 출력 (2단부터 9단까지)
		for(int x = 1; x < 10; x++)
		{
			for(int y = 2; y < 10; y++) 
			{
				System.out.print(y + " x " + x + " = " + (y * x));
				
				if((y * x) / 10 == 0) {
					System.out.print("   |  ");
				}
				else {
					System.out.print("  |  ");
				}
			}
			
			System.out.println("");
		}
		
		System.out.println("============");
		
		// 8. 한줄 1단 씩 출력
		for(int x = 2; x < 10; x++)
		{
			for(int y = 1; y < 10; y++) 
			{
				System.out.print(x + " x " + y + " = " + (x * y));
				
				if((y * x) / 10 == 0) {
					System.out.print("   |  ");
				}
				else {
					System.out.print("  |  ");
				}
			}
			
			System.out.println(" ");
		}
		
		System.out.println("============");
		
		// 9. 두단씩 옆으로 출력
		for(int i = 2; i < 10; i+=2){
			for(int j = 1; j < 10; j++) {
//				System.out.println(i + " x " + j + " = " + (i * j) + "   | " + (i + 1) + " x " + j + " = " + ((i+1) * j));
				System.out.print(i + " x " + j + " = " + (i * j));
				
				if((i * j) / 10 == 0) {
					System.out.print("   |  ");
				}
				else {
					System.out.print("  |  ");
				}
				
				System.out.println((i + 1) + " x " + j + " = " + ((i + 1) * j));
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 10. 피라미드
		int high = 5;
		int row = (high * 2) + 1;
		int mid = row / 2 + 1;
		
		for(int i = 0; i <= high ; i++) {
			for(int j = 1; j <= row; j++) {
				if(j >= mid - i && j <= mid + i){
					System.out.print("+");
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 5단계
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i ; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 6단계
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i ; j++) {
				System.out.print("+");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 7단계
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= i ; j++) {
				System.out.print(6 - i);
			}
			System.out.println();
		}
		
//		for(int i = 1; i <= 5; i++) {
//			for(int j = 1; j <= 6 - i ; j++) {
//				System.out.print(6 - i);
//			}
//			System.out.println();
//		}
		
		System.out.println("============");
		
		// 8단계
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("+");
			}
			for(int k = 1 ; k <= 5 - i ; k++) {
				System.out.print(".");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 9단계
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5 - i ; j++) {
				System.out.print(".");
			}
			for(int k = 1; k <= i ; k++) {
				System.out.print("+");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 10단계
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5 - i ; j++) {
				System.out.print(".");
			}
			for(int k = 1; k <= (i * 2) - 1 ; k++) {
				System.out.print("+");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 11단계
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5 - i ; j++) {
				System.out.print(".");
			}
			for(int k = 1; k <= (i * 2) - 1 ; k++) {
				System.out.print("+");
			}
			for(int j = 1; j <= 5 - i ; j++) {
				System.out.print(".");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 12단계
//		Scanner scan = new Scanner(System.in);
//		System.out.print("피라미드 층수를 입력하세요. : ");
//		int height = scan.nextInt();
//		
//		for(int i = 1; i <= height; i++) {
//			for(int j = 1; j <= height - i ; j++) {
//				System.out.print(".");
//			}
//			for(int k = 1; k <= (i * 2) - 1 ; k++) {
//				System.out.print("+");
//			}
//			for(int j = 1; j <= height - i ; j++) {
//				System.out.print(".");
//			}
//			System.out.println();
//		}
//		scan.close();
		
		// 11단계
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3 - i ; j++) {
				System.out.print(".");
			}
			for(int k = 1; k <= (i * 2) - 1 ; k++) {
				System.out.print("+");
			}
			for(int j = 1; j <= 3 - i ; j++) {
				System.out.print(".");
			}
			for(int j = 1; j <= 3 - i ; j++) {
				System.out.print(".");
			}
			for(int k = 1; k <= (i * 2) - 1 ; k++) {
				System.out.print("+");
			}
			for(int j = 1; j <= 3 - i ; j++) {
				System.out.print(".");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 문제 1
		// 주사위 2개를 굴려서 나올 수  있는 모든 조합을 출력
		// [1, 1] [1, 2]
		System.out.println("====== 문제 1 ======");
		for(int i = 1 ; i <= 6 ; i++) {
			for(int j = 1 ; j <= 6 ; j++) {
				System.out.print("[" + i + ", " + j + "]");
			}
			System.out.println();
		}
		
		System.out.println("============");
		
		// 문제 2
		// 주사위 2개의 합 별로 나올 수 있는 조합
		// 합2 : [1, 1]
		// 합3 : [1, 2] [2, 1]
		System.out.println("====== 문제 2 ======");
		for(int i = 2 ; i <= 12 ; i++) {
			if(i / 10 > 0) {
				System.out.print("합" + i + " : ");
			}
			else {
				System.out.print("합" + i + "  : ");
			}
			
			for(int j = 1; j <= 6; j++) {
				for(int k = 1; k <= 6; k++) {
					if(i == j + k) {
						System.out.print("[" + j + ", " + k + "]");
					}
				}
			}
			System.out.println();
		}

		System.out.println("============");
		
		// 문제 3
		// 합 별 조합의 수 출력
		System.out.println("====== 문제 3 ======");
		int mix_cmt;
		for(int i = 2 ; i <= 12 ; i++) {
			mix_cmt = 0;
			if(i / 10 > 0) {
				System.out.print("합" + i + " : ");
			}
			else {
				System.out.print("합" + i + "  : ");
			}
			for(int j = 1; j <= 6; j++) {
				for(int k = 1; k <= 6; k++) {
					if(i == j + k) {
						System.out.print("[" + j + ", " + k + "]");
						mix_cmt++;
					}
				}
			}
			System.out.println(" : " + mix_cmt + "개");
		}
		
		System.out.println("============");
		
		
		// 문제 4
		// 순서에 관계 없이 중복 제거
		// 합2 : [1, 1]
		// 합3 : [1, 2] [2, 1]는 같음
		System.out.println("====== 문제 4 ======");
//		for(int i = 2 ; i <= 12 ; i++) {
//			if(i / 10 > 0) {
//				System.out.print("합" + i + " : ");
//			}
//			else {
//				System.out.print("합" + i + "  : ");
//			}
//			
//			for(int j = 1; j <= 6; j++) {
//				for(int k = 1; k <= 6; k++) {
//					if(i == j + k) {
//						if(j <= k) {
//							System.out.print("[" + j + ", " + k + "]");
//						}
//					}
//				}
//			}
//			System.out.println();
//		}
		
		int mix_cmt1;
		for(int i = 2 ; i <= 12 ; i++) {
			mix_cmt1 = 0;
			if(i / 10 > 0) {
				System.out.print("합" + i + " : ");
			}
			else {
				System.out.print("합" + i + "  : ");
			}
			for(int j = 1; j <= 6; j++) {
				for(int k = 1; k <= 6; k++) {
					if(i == j + k) {
						if(j <= k) {
							System.out.print("[" + j + ", " + k + "]");
							mix_cmt1++;
						}
					}
				}
			}
			System.out.println(" : " + mix_cmt1 + "개");
		}
		
		System.out.println("============");
		
		System.out.println("====== 문제 4 - 수정 ======");
		
		int mix_cmt2;
		for(int i = 2 ; i <= 12 ; i++) {
			mix_cmt2 = 0;
			if(i / 10 > 0) {
				System.out.print("합" + i + " : ");
			}
			else {
				System.out.print("합" + i + "  : ");
			}
			for(int j = 1; j <= 6; j++) {
				for(int k = j; k <= 6; k++) {
					if(i == j + k) {
							System.out.print("[" + j + ", " + k + "]");
//							System.out.printf("[%d, %d]", j, k);
							mix_cmt2++;
					}
				}
			}
			System.out.println(" : " + mix_cmt2 + "개");
		}
		
		System.out.println("============");
		
		// 입력받은 정수에 따라 다음과 같이 출력
        /* 3
         * 00 01 02
         * 10 11 12
         * 20 21 22
         */
        /* 4
         * 00 01 02 03
         * 10 11 12 13
         * 20 21 22 23
         * 30 31 32 33
         */
//		System.out.println("====== 문제 5 ======");
//		Scanner scan = new Scanner(System.in);
//		System.out.print("숫자를 입력 하세요 : ");
//		int num_cnt = scan.nextInt();
//		
//		for(int i = 0; i < num_cnt; i++) {
//			for(int j = 0; j < num_cnt; j++) {
//				System.out.print("" + i + j + " ");
//			}
//			System.out.println();
//		}

		
        // 문제 6
        // 입력받은 정수에 따라 다음과 같이 출력
        // (정사각형)
        /* 3
         * +++
         * +.+
         * +++
         */
        /* 5
         * +++++
         * +...+
         * +...+
         * +...+
         * +++++
         */
		System.out.println("====== 문제 6 ======");
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력 하세요 : ");
		int nemo_cnt = scan.nextInt();
		
		for(int i = 1; i <= nemo_cnt; i++) {
			if(i == 1 || i == nemo_cnt) {
				for(int j = 1; j <= nemo_cnt ; j++) {
					System.out.print("+");
				}
			}
			else {
				System.out.print("+");
				for(int j = 1; j <= nemo_cnt -2 ; j++) {
					System.out.print(".");
				}
				System.out.print("+");
			}
			System.out.println();
		}
		scan.close();
		
	}

}
