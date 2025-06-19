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
    private Statement statement; // Renamed 'oracle' to 'statement' for clarity
    private Scanner scanner = new Scanner(System.in); // Initialized once for the class

    // FruitMarket 생성자
    public FruitMarket(String marketName) {
        this.marketName = marketName;
    }

    // --- Database Connection & Resource Management ---
    /**
     * Establishes a connection to the Oracle database.
     * @throws SQLException if a database access error occurs.
     */
    public void connectDB() throws SQLException {
        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
        String user = "scott4_7";
        String password = "tiger";

        conn = DriverManager.getConnection(url, user, password);
        statement = conn.createStatement();
        System.out.println("Oracle 데이터베이스 연결 성공!");
    }

    /**
     * Closes all database-related resources (Statement, Connection) and the Scanner.
     */
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

    // --- Data Loading & Synchronization ---
    /**
     * Loads fruit data from the database into the in-memory list.
     * @throws SQLException if a database access error occurs.
     */
    private void loadFruitsFromDB() throws SQLException {
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
                try {
                    rs.close(); // Ensure ResultSet is closed
                } catch (SQLException e) {
                    System.err.println("ResultSet 닫기 오류: " + e.getMessage());
                }
            }
        }
    }

    // --- Fruit Management Operations ---

    /**
     * Prompts user to add a new fruit to the market and database.
     */
    public void addFruit() {
        String fname;
        int fprice;
        int fcnt;

        System.out.println("===================================");
        System.out.print("추가할 과일 이름을 입력해주세요. : ");
        fname = scanner.nextLine().trim(); // Trim whitespace

        // Input validation for price
        try {
            System.out.print("추가할 과일의 가격을 입력해주세요. : ");
            fprice = Integer.parseInt(scanner.nextLine());
            if (fprice <= 0) {
                System.out.println("가격은 0보다 커야 합니다.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 가격 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        // Input validation for count
        try {
            System.out.print("추가할 과일의 수량을 입력해주세요. : ");
            fcnt = Integer.parseInt(scanner.nextLine());
            if (fcnt < 0) {
                System.out.println("수량은 0 이상이어야 합니다.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 수량 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        try {
            // Check if fruit already exists in DB to prevent duplicates
            Optional<Fruit> existingFruit = searchFruit(fname); // Search in current in-memory list

            if (existingFruit.isPresent()) {
                System.out.println("해당 과일은 이미 존재합니다.");
            } else {
                String sql = "INSERT INTO FRUIT (FRUIT_NAME, FRUIT_PRICE, FRUIT_COUNT) VALUES(?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, fname);
                    pstmt.setInt(2, fprice);
                    pstmt.setInt(3, fcnt);
                    int affectedRows = pstmt.executeUpdate(); // Use executeUpdate for INSERT

                    if (affectedRows > 0) {
                        System.out.println("과일이 추가되었습니다.");
                        loadFruitsFromDB(); // Reload data to reflect changes in local list
                    } else {
                        System.out.println("과일 추가에 실패했습니다.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("과일 추가 중 데이터베이스 오류 발생: " + e.getMessage());
        }
    }

    /**
     * Updates an existing fruit's price or count in the market and database.
     */
    public void updateFruit() {
        System.out.println("===================================");
        System.out.print("수정할 과일 이름을 입력해주세요. : ");
        String fname = scanner.nextLine().trim();

        Optional<Fruit> existingFruit = searchFruit(fname);

        if (!existingFruit.isPresent()) {
            System.out.println("해당 과일은 시장에 없습니다.");
            return;
        }

        System.out.println("현재 정보: " + existingFruit.get().getFruitName() + " | " + existingFruit.get().getFruitPrice() + "원 | " + existingFruit.get().getFruitCount() + "개");
        System.out.print("새로운 가격을 입력해주세요 (변경 없으면 현재 가격 입력): ");
        int newPrice;
        try {
            newPrice = Integer.parseInt(scanner.nextLine());
            if (newPrice <= 0) {
                System.out.println("가격은 0보다 커야 합니다.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 가격 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        System.out.print("새로운 수량을 입력해주세요 (변경 없으면 현재 수량 입력): ");
        int newCount;
        try {
            newCount = Integer.parseInt(scanner.nextLine());
            if (newCount < 0) {
                System.out.println("수량은 0 이상이어야 합니다.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 수량 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        try {
            String sql = "UPDATE FRUIT SET FRUIT_PRICE = ?, FRUIT_COUNT = ? WHERE FRUIT_NAME = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, newPrice);
                pstmt.setInt(2, newCount);
                pstmt.setString(3, fname);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println(fname + " 과일 정보가 업데이트 되었습니다.");
                    loadFruitsFromDB(); // Reload data to reflect changes
                } else {
                    System.out.println("과일 정보 업데이트에 실패했습니다.");
                }
            }
        } catch (SQLException e) {
            System.err.println("과일 정보 업데이트 중 데이터베이스 오류 발생: " + e.getMessage());
        }
    }


    // --- Display & Search Operations ---

    /**
     * Displays all fruits currently in the market by loading from DB.
     */
    public void displayAllFruits() {
        System.out.println("===================================");
        System.out.println("전체 과일 목록");
        System.out.println("===================================");
        try {
            loadFruitsFromDB(); // Always load fresh data
            if (fruits.isEmpty()) {
                System.out.println("등록된 과일이 없습니다.");
                return;
            }
            for (Fruit fruit : fruits) {
                System.out.printf("%s | %d원 | %d개%n", fruit.getFruitName(), fruit.getFruitPrice(), fruit.getFruitCount());
            }
        } catch (SQLException e) {
            System.err.println("과일 목록 조회 중 오류 발생: " + e.getMessage());
        }
    }

    /**
     * Displays market information, including its name and all fruits.
     */
    public void marketInfo() {
        System.out.println("===================================");
        System.out.println("시장 이름: " + marketName);
        displayAllFruits(); // Reusing the displayAllFruits method
        System.out.println("===================================");
    }

    /**
     * Searches for a fruit by name in the in-memory list.
     * @param fruitName The name of the fruit to search for.
     * @return An Optional containing the Fruit if found, otherwise an empty Optional.
     */
    public Optional<Fruit> searchFruit(String fruitName) {
        // It's good practice to ensure the local list is up-to-date before searching.
        // However, if search is called frequently, it might be better to load once and then refresh periodically.
        // For this example, let's assume `loadFruitsFromDB()` is called before menu loop.
        return fruits.stream()
                     .filter(f -> f.getFruitName().equalsIgnoreCase(fruitName))
                     .findFirst();
    }

    /**
     * Prompts the user for a fruit name and displays its details if found.
     */
    public void initiateFruitSearch() {
        System.out.println("===================================");
        System.out.print("과일 이름을 입력해주세요. : ");
        String fruitName = scanner.nextLine().trim();

        try {
            loadFruitsFromDB(); // Ensure local list is fresh for search
            Optional<Fruit> result = searchFruit(fruitName);
            if (result.isPresent()) {
                Fruit fruit = result.get();
                System.out.printf("%s | %d원 | %d개%n", fruit.getFruitName(), fruit.getFruitPrice(), fruit.getFruitCount());
            } else {
                System.out.println("입력하신 과일은 시장에 없습니다.");
            }
        } catch (SQLException e) {
            System.err.println("과일 검색 중 데이터베이스 오류 발생: " + e.getMessage());
        }
        System.out.println("===================================");
    }

    // --- Selling Operations ---

    /**
     * Handles the fruit selling process, including quantity check and database update.
     */
    public void sellFruit() {
        System.out.println("===================================");
        System.out.print("구매할 과일 이름을 입력해주세요. : ");
        String fruitName = scanner.nextLine().trim();

        try {
            loadFruitsFromDB(); // Ensure local list is fresh for selling
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
                quantity = Integer.parseInt(scanner.nextLine());
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

            System.out.println("총 " + (long) fruitToSell.getFruitPrice() * quantity + "원 입니다.");

            System.out.print("구매하시겠습니까? (y or n): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if ("y".equals(confirmation)) {
                int newCount = fruitToSell.getFruitCount() - quantity;
                String sql = "UPDATE FRUIT SET FRUIT_COUNT = ? WHERE FRUIT_NAME = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, newCount);
                    pstmt.setString(2, fruitName);
                    int affectedRows = pstmt.executeUpdate();

                    if (affectedRows > 0) {
                        System.out.println("구매가 완료되었습니다.");
                        fruitToSell.setFruitCount(newCount); // Update local object
                    } else {
                        System.out.println("구매 처리 중 오류가 발생했습니다.");
                    }
                }
            } else if ("n".equals(confirmation)) {
                System.out.println("구매가 취소되었습니다.");
            } else {
                System.out.println("잘못 입력하셨습니다. 'y' 또는 'n'을 입력해주세요.");
            }
        } catch (SQLException e) {
            System.err.println("과일 판매 중 데이터베이스 오류 발생: " + e.getMessage());
        }
    }

    /**
     * Simulates and displays a random sell state (packaging, shipping, delivered).
     */
    public void displaySellState() {
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
}

// Fruit class (remains largely the same, but fields are private for encapsulation)
class Fruit {
    private String fruitName;
    private int fruitPrice;
    private int fruitCount;

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

    // Setters (useful for updating in-memory count after a sale)
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
