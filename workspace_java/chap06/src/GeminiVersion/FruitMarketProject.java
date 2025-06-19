package GeminiVersion;

import java.sql.SQLException;
import java.util.InputMismatchException; // Import for robust input handling
import java.util.Scanner;

public class FruitMarketProject {

    public static void main(String[] args) { // Changed to not throw generic Exception

        FruitMarket fruitmarket = new FruitMarket("두정동 과일 가게");
        Scanner mainScanner = new Scanner(System.in); // Single Scanner for the main menu

        try {
            // Establish database connection
            fruitmarket.connectDB();

            // Display initial market information
            fruitmarket.marketInfo();

            int menuNum;

            while (true) {
                System.out.println("===================================");
                System.out.println("1. 전체 과일 리스트");
                System.out.println("2. 과일 찾기");
                System.out.println("3. 구매");
                System.out.println("4. 배송상태");
                System.out.println("5. 항목 추가");                
                System.out.println("6. 종료");
                System.out.println("===================================");
                System.out.print("메뉴를 선택해주세요: ");

                try {
                    menuNum = mainScanner.nextInt();
                    mainScanner.nextLine(); // Consume the newline character

                    switch (menuNum) {
                        case 1:
                            fruitmarket.displayAllFruits(); // Using the optimized method
                            break;
                        case 2:
                            fruitmarket.initiateFruitSearch(); // Using the optimized method
                            break;
                        case 3:
                            fruitmarket.sellFruit(); // Using the optimized method
                            break;
                        case 4:
                            fruitmarket.displaySellState(); // Using the optimized method
                            break;
                        case 5:
                        	fruitmarket.addFruit(); // Using the optimized method
                        	break;
                        case 6:
                            System.out.println("프로그램을 종료합니다.");
                            return; // Exit the program
                        default:
                            System.out.println("잘못된 메뉴 번호입니다. 1부터 6까지의 숫자를 입력해주세요.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    mainScanner.nextLine(); // Consume the invalid input
                }
            }
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결 또는 작업 중 오류 발생: " + e.getMessage());
        } finally {
            // Ensure database connection and scanner are closed when the program finishes or an error occurs
            fruitmarket.closeDB();
            if (mainScanner != null) {
                mainScanner.close();
            }
        }
    }
}