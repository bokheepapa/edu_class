package GeminiVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Changed to PreparedStatement for security and efficiency
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; // Using List interface for better practice
import java.util.Optional; // Added for safer handling of search results
import java.util.Scanner;

public class FruitMarket {

    private List<Fruit> fruits = new ArrayList<>(); // Renamed for clarity and using List interface
    private String marketName;
    private Connection conn;
    private Statement statement; // Renamed for clarity
    private Scanner scanner = new Scanner(System.in); // Initialized once for the class

    // FruitMarket 생성자
    public FruitMarket(String marketName) {
        this.marketName = marketName;
    }

    // Connect to the Oracle database
    public void connectDB() throws SQLException { // Changed to public and throws SQLException directly
        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
        String user = "scott4_7";
        String password = "tiger";

        conn = DriverManager.getConnection(url, user, password);
        statement = conn.createStatement();
        System.out.println("Oracle 데이터베이스 연결 성공!");
    }

    // Close database resources
    public void closeDB() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (scanner != null) {
                scanner.close(); // Close the scanner when done
            }
            System.out.println("데이터베이스 및 자원 연결 해제 완료.");
        } catch (SQLException e) {
            System.err.println("데이터베이스 자원 해제 중 오류 발생: " + e.getMessage());
        }
    }

    // Populate fruits from the database
    private void loadFruitsFromDB() throws SQLException { // Changed to private as it's an internal helper
        ResultSet rs = null;
        String sql = "SELECT FRUIT_NAME, FRUIT_PRICE, FRUIT_COUNT FROM FRUIT";

        try {
            rs = statement.executeQuery(sql);
            fruits.clear(); // Clear existing data before loading
            while (rs.next()) {
                fruits.add(new Fruit(rs.getString("FRUIT_NAME"), rs.getInt("FRUIT_PRICE"), rs.getInt("FRUIT_COUNT")));
            }
        } finally {
            if (rs != null) {
                rs.close(); // Ensure ResultSet is closed
            }
        }
    }

    // Display all fruits
    public void displayAllFruits() { // Renamed for clarity
        System.out.println("===================================");
        System.out.println("전체 과일 목록");
        System.out.println("===================================");
        try {
            loadFruitsFromDB();
            if (fruits.isEmpty()) {
                System.out.println("등록된 과일이 없습니다.");
                return;
            }
            for (Fruit fruit : fruits) { // Enhanced for loop
                System.out.printf("%s | %d원 | %d개%n", fruit.getFruitName(), fruit.getFruitPrice(), fruit.getFruitCount());
            }
        } catch (SQLException e) {
            System.err.println("과일 목록 조회 중 오류 발생: " + e.getMessage());
        }
    }

    // Display market information
    public void marketInfo() {
        System.out.println("===================================");
        System.out.println("시장 이름: " + marketName);
        displayAllFruits(); // Reusing the displayAllFruits method
        System.out.println("===================================");
    }

    // Search for a specific fruit by name
    public Optional<Fruit> searchFruit(String fruitName) { // Returns Optional for safer handling of non-existent fruit
        return fruits.stream()
                     .filter(f -> f.getFruitName().equalsIgnoreCase(fruitName)) // Case-insensitive search
                     .findFirst();
    }

    // Handle fruit selling logic
    public void sellFruit() {
        System.out.println("===================================");
        System.out.print("구매할 과일 이름을 입력해주세요. : ");
        String fruitName = scanner.nextLine();

        Optional<Fruit> foundFruit = searchFruit(fruitName);

        if (!foundFruit.isPresent()) {
            System.out.println("해당 과일은 시장에 없습니다.");
            return;
        }

        Fruit fruitToSell = foundFruit.get();

        System.out.println("===================================");
        System.out.print("구매할 과일의 수량을 입력해주세요. : ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine()); // Read as line, then parse to avoid issues with nextInt()
            if (quantity <= 0) {
                System.out.println("수량은 1개 이상이어야 합니다.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 수량 입력입니다. 숫자를 입력해주세요.");
            return;
        }


        if (fruitToSell.getFruitCount() < quantity) {
            System.out.println("재고가 부족합니다. 현재 재고: " + fruitToSell.getFruitCount() + "개");
            return;
        }

        System.out.println("총 " + (long) fruitToSell.getFruitPrice() * quantity + "원 입니다."); // Use long for total price to prevent overflow

        System.out.print("구매하시겠습니까? (y or n): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if ("y".equals(confirmation)) {
            try {
                int newCount = fruitToSell.getFruitCount() - quantity;
                String sql = "UPDATE FRUIT SET FRUIT_COUNT = ? WHERE FRUIT_NAME = ?"; // Using PreparedStatement for update
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, newCount);
                    pstmt.setString(2, fruitName);
                    int affectedRows = pstmt.executeUpdate(); // Use executeUpdate for DML operations

                    if (affectedRows > 0) {
                        System.out.println("구매가 완료되었습니다.");
                        fruitToSell.setFruitCount(newCount); // Update local object as well
                    } else {
                        System.out.println("구매 처리 중 오류가 발생했습니다.");
                    }
                }
            } catch (SQLException e) {
                System.err.println("과일 판매 중 데이터베이스 오류 발생: " + e.getMessage());
            }
        } else if ("n".equals(confirmation)) {
            System.out.println("구매가 취소되었습니다.");
        } else {
            System.out.println("잘못 입력하셨습니다. 'y' 또는 'n'을 입력해주세요.");
        }
    }

    // Simulate sell state (packaging, shipping, delivered)
    public void displaySellState() { // Renamed for clarity
        System.out.println("===================================");
        int state = (int) (Math.random() * 3 + 1);

        switch (state) {
            case 1:
                System.out.println("포장 중입니다.");
                break;
            case 2:
                System.out.println("배송 중입니다.");
                break;
            case 3:
                System.out.println("배송 완료");
                break;
            default:
                System.out.println("알 수 없는 상태입니다.");
        }
        System.out.println("===================================");
    }

    // Method to initiate a fruit search
    public void initiateFruitSearch() {
        System.out.println("===================================");
        System.out.print("과일 이름을 입력해주세요. : ");
        String fruitName = scanner.nextLine();
        Optional<Fruit> result = searchFruit(fruitName);
        if (result.isPresent()) {
            Fruit fruit = result.get();
            System.out.printf("%s | %d원 | %d개%n", fruit.getFruitName(), fruit.getFruitPrice(), fruit.getFruitCount());
        } else {
            System.out.println("입력하신 과일은 시장에 없습니다.");
        }
        System.out.println("===================================");
    }
}

// Fruit class
class Fruit {
    private String fruitName;
    private int fruitPrice;
    private int fruitCount;

    // Constructor
    public Fruit(String fruitName, int fruitPrice, int fruitCount) {
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitCount = fruitCount;
    }

    // Getters
    public String getFruitName() {
        return fruitName;
    }

    public int getFruitPrice() {
        return fruitPrice;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    // Setters (only if modification is intended, otherwise remove for immutability)
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setFruitPrice(int fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }
}
