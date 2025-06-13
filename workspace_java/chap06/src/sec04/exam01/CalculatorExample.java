package sec04.exam01;

import java.util.ArrayList;

public class CalculatorExample {

	public static void main(String[] args) {
		
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 15);
		System.out.println("result1 : " + result1);
		
		
		byte x = 10;
		byte y = 3;
		double result2 = myCalc.divide(x, y);
		
		System.out.println("result2 : " + result2);
		
		myCalc.powerOff();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(40);
		
		System.out.println(arr.get(0));
		
		myCalc.callByReference(arr);
		
		System.out.println(arr.get(0));
		
		myCalc.callByValue(arr);
		
		System.out.println(arr.get(0));
		
	}

}
