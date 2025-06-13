package sec03.exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class FruitMarket {

	//FruitMarket class 필드
	ArrayList<Fruit> fruit = new ArrayList<Fruit>();
	String marketName;
	Connection conn;
	Statement oracle;
//	Scanner scan = new Scanner(System.in);
	
	// FruitMarket 생성자
	FruitMarket(String marketName){
		this.marketName = marketName;
	}
	
	void ConnDB() throws Exception{

		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe"; 
        String user = "scott4_7";   
        String password = "tiger"; 
        
        conn = DriverManager.getConnection(url, user, password);
        
        oracle = conn.createStatement();
        
        System.out.println("Oracle 데이터베이스 연결 성공!");
		      
	}
	
	void addFruit() throws Exception{
		String fname;
		int fprice, fcnt;
		ResultSet rs = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("===================================");
		System.out.print("추가할 과일 이름을 입력해주세요. : ");
		fname = scan.nextLine();
		System.out.println("===================================");
		System.out.print("추가할 과일의 가격을 입력해주세요. : ");
		fprice = scan.nextInt();
		System.out.println("===================================");
		System.out.print("추가할 과일의 수량을 입력해주세요. : ");
		fcnt = scan.nextInt();
		
		boolean f_exist = false;
		for(int i = 0; i < fruit.size(); i++) {
			if(fruit.get(i).getFruitName().equals(fname)) {
				f_exist = true;
				break;
			}
		}
		
		if(!f_exist) {
			String sql = "INSERT INTO FRUIT VALUES('" + fname + "', " + fprice + ", " + fcnt + ")";
			oracle.executeQuery(sql);
			
			System.out.println("과일이 추가 되었습니다.");
		}
		else {
			System.out.println("해당 과일은 존재합니다.");
		}

	}
	
	void selectDB() throws Exception {
		ResultSet rs = null;
		
		String sql = "SELECT FRUIT_NAME, FRUIT_PRICE, FRUIT_COUNT FROM FRUIT"; // 실제 FRUIT 테이블이 있다고 가정
        rs = oracle.executeQuery(sql);

        fruit.clear();
//        System.out.println("--- FRUIT 테이블 데이터 ---");
        while (rs.next()) {
        	fruit.add(new Fruit(rs.getString("FRUIT_NAME"),rs.getInt("FRUIT_PRICE"),rs.getInt("FRUIT_COUNT")));
        }
	}

	// DB 전체 과일 항목 조회
	void allFruit() throws Exception {
		System.out.println("===================================");
		selectDB();
		for(int i = 0 ; i < this.fruit.size(); i++ ) {
			
			System.out.println(this.fruit.get(i).getFruitName() + " | " + this.fruit.get(i).getFruitPrice() + "원 | " + this.fruit.get(i).getFruitCount() + "개");
		}
	}
	
	void marketInfo() throws Exception{
		System.out.println("===================================");
		System.out.println("marketName : " + marketName);
		System.out.println("===================================");
		allFruit();
	}
	
	void searchFruit(String fruitName) {
		System.out.println("===================================");
		for(int i = 0 ; i < this.fruit.size(); i++) {
			if (this.fruit.get(i).getFruitName().equals(fruitName)) {
				System.out.println(this.fruit.get(i).getFruitName() + " | " + this.fruit.get(i).getFruitPrice() + "원 | " + this.fruit.get(i).getFruitCount() + "개");
				break;
			}
		}
	}
	
	void sellFruit() throws Exception{
		int position = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("===================================");
		System.out.print("구매할 과일 이름을 입력해주세요. : ");
		String fname = scan.nextLine();
		System.out.println("===================================");
		System.out.print("구매할 과일의 수량을 입력해주세요. : ");
		int fcnt = scan.nextInt();
		
		for(int i = 0 ; i < this.fruit.size(); i++) {
			if (this.fruit.get(i).getFruitName().equals(fname)) {
				position = i;
				break;
			}
		}
		
		System.out.println("총 " + this.fruit.get(position).getFruitPrice() * fcnt + "원 입니다.");
		
		
		System.out.print("구매하시겠습니까? (y or n): ");
		String yn = scan.nextLine();
		
		if(yn.equals("y")) {
			
			int rs_cnt = this.fruit.get(position).getFruitCount() - fcnt;
			
			String sql = "UPDATE FRUIT SET fruit_count = " + rs_cnt + " WHERE fruit_name = '" + fname + "'";
			
			oracle.executeQuery(sql);
			
			System.out.println("구매가 완료 되었습니다.");
			
		}
		else if(yn.equals("n")){
			System.out.println("구매가 취소 되었습니다.");
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}
	
	void sellState() {
		int state = (int)(Math.random() * 3 + 1);
		
		if(state == 1) {
			System.out.println("포장중입니다.");
		}
		else if(state == 2) {
			System.out.println("배송중입니다.");
		}
		else if(state == 3) {
			System.out.println("배송완료");
		}
	}
	
	void search() {
		System.out.println("===================================");
		System.out.print("과일 이름을 입력해주세요. : ");
		Scanner scan = new Scanner(System.in);
		String fname = scan.nextLine();
		searchFruit(fname);
	}	
	
}

// Fruit class
class Fruit {

	String fruitName;
	int fruitPrice;
	int fruitCount;
	
	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getFruitPrice() {
		return fruitPrice;
	}

	public void setFruitPrice(int fruitPrice) {
		this.fruitPrice = fruitPrice;
	}

	public int getFruitCount() {
		return fruitCount;
	}

	public void setFruitCount(int fruitCount) {
		this.fruitCount = fruitCount;
	}

	Fruit(String fruitName, int fruitPrice, int fruitCount){
		this.fruitName = fruitName;
		this.fruitPrice = fruitPrice;
		this.fruitCount = fruitCount;
	}
}