package test_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil { // 클래스 이름을 'ConnDB' 대신 'DatabaseUtil' 등으로 변경하는 것이 더 의미 있습니다.

    // JDBC 드라이버, URL, 사용자, 비밀번호는 상수로 정의하는 것이 좋습니다.
    private static final String DB_URL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
    private static final String DB_USER = "scott4_7";
    private static final String DB_PASSWORD = "tiger";
    // private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; // Java 7 이상에서는 대부분 불필요

    /**
     * 데이터베이스 연결을 생성하고 반환합니다.
     * @return Connection 객체
     * @throws SQLException 데이터베이스 연결 중 오류 발생 시
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // Class.forName(JDBC_DRIVER); // Java 7 이상에서는 대부분 자동 로드되므로 주석 처리
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Oracle 데이터베이스 연결 성공!");
        } catch (SQLException e) {
            System.err.println("Oracle 데이터베이스 연결 실패!");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            throw e; // 호출자에게 예외를 다시 던져 처리하도록 함
        }
        return conn;
    }

    /**
     * JDBC 자원을 닫는 유틸리티 메서드.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     * @param rs ResultSet 객체
     */
    public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            System.err.println("ResultSet 닫기 실패: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Statement 닫기 실패: " + e.getMessage());
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.err.println("Connection 닫기 실패: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null; // 결과 셋을 사용한다면 필요

        try {
            // 1. Connection 얻기 (try-with-resources 사용도 가능)
            conn = getConnection();
            stmt = conn.createStatement();

            // 2. 쿼리 실행 예시 (주석 처리된 부분에서 FRUIT 테이블을 읽어오던 로직을 가정)
            String sql = "SELECT FRUIT_NAME, FRUIT_PRICE, FRUIT_COUNT FROM FRUIT"; // 실제 FRUIT 테이블이 있다고 가정
            rs = stmt.executeQuery(sql);

            System.out.println("--- FRUIT 테이블 데이터 ---");
            while (rs.next()) {
                String name = rs.getString("FRUIT_NAME");
                int price = rs.getInt("FRUIT_PRICE");
                int count = rs.getInt("FRUIT_COUNT");
                System.out.println("이름: " + name + ", 가격: " + price + "원, 수량: " + count + "개");
            }
            System.out.println("-------------------------");

        } catch (SQLException e) { // SQLException만 catch (getConnetion()에서 이미 처리)
            System.err.println("데이터베이스 작업 중 오류 발생!");
            e.printStackTrace();
        } finally {
            // 3. 자원 해제 (필수)
            closeResources(conn, stmt, rs);
        }
    }
}
