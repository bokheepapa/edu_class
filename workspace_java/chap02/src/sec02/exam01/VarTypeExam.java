package sec02.exam01;

public class VarTypeExam {

	public static void main(String[] args) {

		byte b1;
		b1 = 127;
		System.out.println("b1 : " + b1);
		
		char c1 = 65;
		System.out.println("c1 : " + c1);
		
		c1 = (char) (c1 + 2);
		System.out.println("c1 : " + c1);
		
		char c2 = 'F';
		System.out.println("c2 : " + c2);
		System.out.println("c2-c1 : " + (c2-c1));
		
		char c3 = '★';
		System.out.println("c3 : " + c3);
		System.out.println("c3 : " + (c3+1));
		
		char c4 = 'ご';
		System.out.println("c4 : " + (c4+1));
		
		char c5 = 'ㄱ';
		System.out.println("c5 : " + (c5+1));
		
		char c6 = '語';
		System.out.println("c6 : " + (c6+1));
		
		char c7 = 35486;
		c7 = (char) (c7 + 1);
		System.out.println("c7 : " + c7);
		
		String s1 = "복희";
		System.out.println("s1 : " + s1);
		System.out.println("s1 : " + (s1 +1));
		
		String s2 = "\"복희\"";
		System.out.println("s2 : " + s2);
		
		String s3 = "\"복\t희\"\n";
		System.out.println("s3 : " + s3);
		
		String s4 = s3 + "는 고양이 이름";
		System.out.println("s4 : " + s4);
		
//		int i = 0;
//		while(true) {
//			c7 = (char) (c7 + i);
//			System.out.println(c7);
//			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			i = i + 1;
//			
//			if(i == 10) {
//				break;
//			}				
//		}
		
		long l1 = 1L;
		int i1 = 120;
		l1 = i1;
		
		System.out.println("l1 : " + l1);
		
		float f1 = 3.1448486513f;
		double d1 = 3.1234567891234567;
		System.out.println("f1 : " + f1);
		System.out.println("d1 : " + d1);
		
		byte b2 = 127;
		short sh1 = 32767;
		
		boolean car = true;
		byte phone = 2;
		String name = "이동주";
		
		double area1 = 5 * 3.3;
		float area2 = 5 * 3.3f;
		
		double d4 = 5e2;
		System.out.println("d4 : " + d4);
		
		int a, b;
		a = 3;
		b = 4;
		System.out.println(a + "과 " + b);
		
		System.out.println("");
		
		// 퀴즈 1
		/*
		 *  1-1 : 두 변수 a,b에 각각 3,4를 넣고
		 *  출력 결과 : "3  > 4의 결과는 false입니다."
		 *  1-2 : 두 변수의 값을 6, 5 변경
		 *  출력 결과 : "6 > 5의 결과는 true입니다."
		 */		
		// 1-1
		System.out.println(a + " > " + b + "결과는 " + (a > b) + "입니다.");
		
		// 1-2
		a = 6;
		b = 5;
		System.out.println(a + " > " + b + "결과는 " + (a > b) + "입니다.");
		
		System.out.println("");
		
		// 퀴즈 2
		/*
		 * 두 변수 h, m에 각각 시간과 분을 넣습니다.
		 * +35분 한 결과를 출력
		 */
		
		int h = 4;
		int m = 50;
		int add = 11;
		System.out.println("시간 : " + (h + (m + add) / 60) + "\n" + "분 : " + (m + add) % 60 );
		
		System.out.println("");
		
		// 퀴즈 3
		/*
		 * 숫자 132
		 * 출력 결과
		 * "백의 자리 : 1"
		 * "십의 자리 : 3"
		 * "일의 자리 : 2"
		*/ 
		int num = 751;
		System.out.println("백의 자리 : " + num / 100);
		System.out.println("십의 자리 : " + num % 100 / 10);
		System.out.println("일의 자리 : " + num % 100 % 10);
		
		double doubleValue = 3.74;
		int intValue = (int)doubleValue;
		System.out.println("intValue : " + intValue);
		
	}

}
