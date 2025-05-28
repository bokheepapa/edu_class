package sec03.exam02;

import java.io.IOException;

public class TypeCastingExam03 {

	public static void main(String[] args) throws Exception {
		
		double doubleValue = 3.74;
		int intValue = (int)doubleValue;
		System.out.println("intValue : " + intValue);
		
		intValue = 129;
		byte byteValue = (byte)intValue;
		
		System.out.println("byteValue : " + byteValue);
				
		char c1 = 'A';
		int charToInt = c1;
		System.out.println("chartoint : " + charToInt);
		
		double d1 = 10.0 / 4;
		System.out.println("d1 : " + d1);
		
		// 문자를 숫자로
		String s1 = "123";
		int i1 = Integer.parseInt(s1);
		double d2 = Double.parseDouble(s1);
		System.out.println("i1 : " + i1);
		System.out.println("d2 : " + d2);
		
		int i2 = 456;
		String s2 = Integer.toString(i2);
		String s4 = String.valueOf(i2);
		String s3 = "" + i2;
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		System.out.println("================");
		System.out.printf("%s %s %s \n", s1, s2, s3);
		System.out.println("================");
		
		System.out.println(" ");
		
		double x1 = 4.3;
		int cnt = 4;
		// 1
		System.out.println((int)((x1 / cnt) * 10000) + "원");
		// 2
		System.out.println(((int)x1 / cnt) * 10000 + "원");
		// 3
		double result =  x1 - (((int)x1 / cnt) * (cnt -1));
		System.out.println( (int)Math.ceil(result * 10000) + "원" );
		
		int won = 1532150;
		System.out.println(won / 1000000 + "," + won % 1000000 / 1000 + "," + won % 1000000 % 1000 + "원");
		
		int keyCode;
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
	}

}