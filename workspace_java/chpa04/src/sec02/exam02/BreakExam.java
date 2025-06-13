package sec02.exam02;

import java.util.Scanner;

public class BreakExam {

	public static void main(String[] args) {
		
		int cnt = 0;
		while(true) {
			int num = (int)(Math.random() * 6) + 1;
			
			System.out.println("주사위 : " + num);
			cnt++;
			if(num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료 (반복 횟수 : " + cnt + "회)");
		
		Label : for(int i = 0; i < 5 ; i++) {
			
			System.out.println("i : " + i);
			
			for(int j = 0; j < 20;j++) {
				
				System.out.println("j : " + j);
				
				if(j >= 2) {
					System.out.println("break");
					break Label;
				}
			}
		}
		
		boolean isStop = false;
		
		for(int i = 1; i <= 5 ; i++) {
			for(int j = 1; j <= 3;j++) {
				int num2 = (int)(Math.random() * 6) + 1;
				System.out.println(i + "번의 주사위 : " + num2);
				
				if(num2 == 6) {
					isStop = true;
					break;
				}
			}
			if(isStop) {
				break;
			}
		}
		
		System.out.println("============");
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
		
		System.out.println("============");
		
		String[] logs = {
            "INFO: Server started",
            "DEBUG: Connection established",
            "ERROR: Database connection failed",
            "INFO: User logged in",
            "DEBUG: Cache refreshed"
        };

        for (String log : logs) {
            if (log.startsWith("DEBUG")) {
                continue; // DEBUG 로그는 출력하지 않음
            }
            System.out.println(log);
        }
        
        System.out.println("============");

        
        // p183 문제 7
        boolean run = true;
        int balance = 0;
        Scanner scan = new Scanner(System.in);
        int selec_num;
        int money = 0;
        int num;
        
        while(run) {
        	System.out.println("--------------------------------");
        	System.out.println("1.예금 | 2.출금| 3.잔고 | 4.종료");
        	System.out.println("--------------------------------");
        	System.out.print("선택> ");
        	selec_num = scan.nextInt();
        	
        	if(selec_num == 1) {
        		System.out.print("예금액> ");
        		num = scan.nextInt();
        		
        		if(num <= 0) {
        			System.out.println("금액 입력이 오류!!");
        		}
        		else {
        			money = money + num;
        		}
        	}
        	else if(selec_num == 2) {
        		System.out.print("출금액> ");
        		num = scan.nextInt();
        		
        		if(money < num) {
        			System.out.println("잔액이 부족합니다.");
        		}
        		else if(num <= 0) {
        			System.out.println("금액 입력이 오류!!");
        		}
        		else {
        			money = money - num;
        		}
        	}
        	else if(selec_num == 3) {
        		System.out.print("잔고> ");
        		System.out.println(money);
        	}
        	else if(selec_num == 4) {
        		System.out.print("프로그램 종료");
        		break;
        	}
        	else {
        		System.out.print("메뉴를 확인해주세요.");
        	}
        }
	}

}
