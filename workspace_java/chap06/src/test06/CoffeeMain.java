package test06;

import java.util.Scanner;

public class CoffeeMain {

	public static void main(String[] args) {

		Coffee coffee = new Coffee("커피류");
		Coffee noncoffee = new Coffee("논카페인류");
		Coffee juice = new Coffee("주스류");
				
		coffee.coffeesub.add(new CoffeeSub("아메리카노", 1500));
		coffee.coffeesub.add(new CoffeeSub("카페라떼", 2500));
		coffee.coffeesub.add(new CoffeeSub("바닐라라떼", 3500));
		
		noncoffee.coffeesub.add(new CoffeeSub("말차라떼", 3000));
		noncoffee.coffeesub.add(new CoffeeSub("초코라떼", 3500));
		noncoffee.coffeesub.add(new CoffeeSub("딸기라떼", 4000));
		
		juice.coffeesub.add(new CoffeeSub("딸기바나나주스", 5000));
		juice.coffeesub.add(new CoffeeSub("비트사과주스", 5500));
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("=== 커피 생산 관리 ===");
			System.out.println("1. 커피 종류 선택");
	        System.out.println("2. 종료");
	        System.out.print("번호를 선택하세요: ");
	        int menu = scan.nextInt();
	        
	        switch(menu) {
		        case 1:
		        	System.out.println("== 커피 종류 선택 ==");
		            System.out.println("1. " + coffee.coffeeName);
		            System.out.println("2. " + noncoffee.coffeeName);
		            System.out.println("3. " + juice.coffeeName);
		            System.out.println("4. 처음으로 돌아가기");
		            System.out.println("5. 종료");
		            System.out.print("선택: ");
		            int type = scan.nextInt();
		            	switch(type) {
		            		case 1:
		            			coffee.showMenu();
		            			break;
		            		case 2:
		            			noncoffee.showMenu();
		            			break;
		            		case 3:
		            			juice.showMenu();
		            			break;
		            	}
		            break;
		        case 2:
		        	System.out.println("종료");
		        	return;
	        }
		}

	}

}
