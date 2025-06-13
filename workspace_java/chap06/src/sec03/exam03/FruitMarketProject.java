package sec03.exam03;

import java.util.Scanner;

public class FruitMarketProject {

	public static void main(String[] args) throws Exception{

		FruitMarket fruitmarket = new FruitMarket("두정동 과일 가게");

		fruitmarket.ConnDB();
//		fruitmarket.selectDB();


		// DB 접속

//		fruitmarket.fruit.add(new Fruit("사과", 500, 84));
//		fruitmarket.fruit.add(new Fruit("배", 1200, 89));
//		fruitmarket.fruit.add(new Fruit("바나나", 1800, 21));
//		fruitmarket.fruit.add(new Fruit("수박", 5300, 92));
//		fruitmarket.fruit.add(new Fruit("샤인머스킷", 7000, 45));
		
		fruitmarket.marketInfo();
		
		int menuNum;

		while(true) {
	
			System.out.println("===================================");
			System.out.println("1. 전체 과일 리스트");
			System.out.println("2. 과일 찾기");
			System.out.println("3. 구매");
			System.out.println("4. 배송상태");
			System.out.println("5. 과일 추가");
			System.out.println("6. 종료");
			System.out.println("===================================");
			
			Scanner scan = new Scanner(System.in);
			menuNum = scan.nextInt();
			
			switch (menuNum) {
			case 1:
				fruitmarket.allFruit();
				break;
			case 2:
				fruitmarket.search();
				break;
			case 3:
				fruitmarket.sellFruit();
				break;
			case 4:
				fruitmarket.sellState();
				break;
			case 5:
				fruitmarket.addFruit();
				break;
			case 6:
				return;
			
			}

		}
	}
	
	
	
	

}
