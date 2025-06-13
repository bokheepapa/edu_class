package sec04.exam01;

import java.util.ArrayList;

public class Calculator {

	
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	/**
	 * 두 정수를 입력 받아서 나누기한 결과를 반환한다.
	 * y가 0일 경우 "안된다"를 출력하고 0을 반환한다.
	 *
	 * 메소드명: plus
	 * 전달인자: int x, int y
	 * 리턴타입: int
	 */
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	/**
	 * 두 정수를 입력 받아서 나누기한 결과를 반환한다.
	 * y가 0일 경우 "안된다"를 출력하고 0을 반환한다.
	 *
	 * 메소드명: divide
	 * 전달인자: int x, int y
	 * 리턴타입: double
	 */
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	void callByReference(ArrayList<Integer> arr) {
		arr.set(0, 3);
	}
	
	void callByValue(ArrayList<Integer> arr) {
		ArrayList<Integer> arr_temp = new ArrayList<Integer>(arr);
		
		arr_temp.set(0, 5);
	}

}
