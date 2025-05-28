package sec02.exam02;

public class IncreaseDecreaseOperatorExample {

	public static void main(String[] args) {

		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("-----------------------");
		x++;
		System.out.println("x = " + x); // x = 11
		++x;
		System.out.println("x = " + x); // x = 12
		
		System.out.println("-----------------------");
		y--;
		System.out.println("y = " + y); // y = 9
		--y;
		System.out.println("y = " + y); // y = 8
		
		System.out.println("-----------------------");
		z = x++; // x = 12
		System.out.println("z = " + z); // z = 12
		System.out.println("x = " + x); // x = 13
		
		System.out.println("-----------------------");
		z = ++x;
		System.out.println("z = " + z); // z = 14
		System.out.println("x = " + x); // x = 14
		
		System.out.println("-----------------------");
		z = ++x + y++; // x = 15, y = 8, z = 23
		System.out.println("z = " + z); // z = 23
		System.out.println("x = " + x); // x = 15
		System.out.println("y = " + y); // y = 9
		
		System.out.println("-----------------------");
		z = x++ + ++x; // x = 15 -> x = 17
		System.out.println("z = " + z); // z = 32
		System.out.println("x = " + x); // x = 17
		
		System.out.println("-----------------------");
		x = 1;
		z = x++ - --x * x++ - x--;
//		z = x++ - --x * x++ - x--;	
		//  1 - 1 * 1 - 2 = -2
		System.out.println("z = " + z); // z = -2
		System.out.println("x = " + x); // x = 1
		
		// 3 = 0011
		// 4 = 0100
		System.out.println("3 | 4 : " + (3 | 4));
		System.out.println("3 & 4 : " + (3 & 4));
		
		int num = 245;
		String binaryNumber = Integer.toBinaryString(num);
		System.out.println(num + " = " + binaryNumber);
		
		System.out.println("-----------------------\n");
		
		// 문자열 비교
		String s1 = "s1";
		String s2 = "s2";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals("s1"));
		System.out.println("s1".equals(s2));
		
		System.out.println("-----------------------\n");
		
		// 1.
		System.out.println(10000 / 4500 + "잔을 살수있습니다.");
		// 2.
		System.out.println(10000 % 4500 + "원이 남았습니다.");
		
		System.out.println("-----------------------\n");
		
		int score = 90;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은 " + grade + "등급입니다.");
		
		System.out.println((score >= 80) ? (score <= 90) ? "true" : "false" : "false");
		
		System.out.println(8000 * 0.85);
		
		// v1과 v2를 소수점 3자리까지 출력
		double v1 = 1000.0;
		double v2 = 794.0;
		
		double result = v1 / v2;
		int v3 = (int)(result * 1000);
		double v4 = v3 / 1000.0;
		System.out.println("result : " + result);
		System.out.println("v4 : " + v4);
		
	}

}
