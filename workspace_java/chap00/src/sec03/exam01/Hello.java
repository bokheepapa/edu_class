package sec03.exam01;

// 한줄 주석
/* 범위 주석 */
/*
 * 여러줄
 * 주석
 */

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int x = 2; x < 10; x++)
		{
			for(int y = 1; y < 10; y++) 
			{
				System.out.print(x + " * " + y + " = " + (x * y) + "  ");
			}
			
			System.out.println(" ");
			System.out.println(" ");
		}
		
		System.out.println("Hello, Java!!");
		
	}

}
