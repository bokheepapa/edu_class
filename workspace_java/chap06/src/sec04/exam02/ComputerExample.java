package sec04.exam02;

public class ComputerExample {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		
		int[] values1 = {0x02, 0x1A, 0xDD};
		int result1 = myCom.sum1(values1);
		System.out.println("result1 : " + result1);
		
		int result2 = myCom.sum2(values1);
		System.out.println("result2 : " + result2);
		
		int result3 = myCom.sum2(1, 2, 3, 4, 5);
		System.out.println("result3 : " + result3);
	}
	
	

}
