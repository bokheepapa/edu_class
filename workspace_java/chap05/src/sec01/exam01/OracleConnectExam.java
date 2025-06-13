package sec01.exam01;

import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleConnectExam {

	public static void main(String[] args) throws Exception {

		
		Statement oracle1 = null;
		
		// DB 접속
		try {
			oracle1 = ConnDB();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

        ArrayList<User> empList = new ArrayList<User>();

        String sql = "select e.empno, e.ename, d.dname from emp e, dept d where e.deptno = d.deptno";
        ResultSet rs = oracle1.executeQuery(sql);
        
        while(rs.next()) {
        	empList.add(new User(rs.getInt("empno"),rs.getString("ename"), rs.getString("dname")));
        }

        System.out.println("=======================================");

        for(int i = 0;i < empList.size();i++) {
//        	System.out.println(empList.get(i).empno + " | " + empList.get(i).ename + " | " + empList.get(i).dname);
        	System.out.printf("%d | %6s | %10s \n", empList.get(i).empno, empList.get(i).ename, empList.get(i).dname);
        }
        
        File file1 = new File("D:\\Temp\\MyTextFile.txt");
        
        try(PrintWriter writer = new PrintWriter(new FileWriter(file1))){
        	writer.printf("%s | %10s | %10s \n", "사원번호", "사원명", "부서명");
        	for(int i = 0;i < empList.size();i++) {
            	writer.printf("%10d | %10s | %10s \n", empList.get(i).empno, empList.get(i).ename, empList.get(i).dname);
            }
        }catch(IOException e) {
        	e.printStackTrace();
        }

	}
	
	static Statement ConnDB() throws Exception{
		
		Connection conn;
		
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe"; 
        String user = "scott4_7";   
        String password = "tiger"; 
        
        conn = DriverManager.getConnection(url, user, password);
        
        Statement oracle1 = conn.createStatement();
        
        System.out.println("Oracle 데이터베이스 연결 성공!");
		
        return oracle1;
	}

}

class User {
    int empno;
    String ename, dname;

    public User(int empno, String ename, String dname) {
        this.empno = empno;
        this.ename = ename;
        this.dname = dname;
    }


//    @Override
//    public String toString() {
//        return "User{empno = " + empno + ", ename = '" + ename + "', dname = '" + dname + "'}";
//    }
}


