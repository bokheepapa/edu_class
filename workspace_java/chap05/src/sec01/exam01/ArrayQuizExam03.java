package sec01.exam01;

public class ArrayQuizExam03 {

	public static void main(String[] args) {
		
		/*
		 * 문제 0
		 배열 깊은 복사 : {1,2,3} -> {1,2,3}
		 */
		
		int [] arr0 = {1, 2, 3};
		int [] arr01 = new int[arr0.length];
		
		for(int i = 0; i < arr0.length; i++) {
			arr01[i] = arr0[i];
		}
		
		for(int i = 0; i < arr0.length; i++) {
			System.out.println(arr01[i]);
		}
		
		/*
		 * 문제1
		 배열 뒤집기 : {1,2,3} -> {3,2,1}
		 */
		arr01 = new int[arr0.length];
		
		for(int i = 0; i < arr0.length; i++) {
			arr01[i] = arr0[arr0.length - 1 - i];
		}
		
		for(int i = 0; i < arr0.length; i++) {
			System.out.println(arr01[i]);
		}
		
		
		System.out.println("========================");
		/*
		 * 여기서 = {3,4,7,5,1,9,4}
		 문제2
		 여기서 홀수의 개수 찾기
		 */
		
		int [] arr02 = {3,4,7,5,1,9,4};
		
		for(int i = 0; i < arr02.length; i++) {
			if(arr02[i] % 2 != 0) {
				System.out.println(arr02[i]);
			}
		}
		
		System.out.println("========================");
		/*
		 * 문제3
		 여기서 4보다 큰 수의 개수 구하기
		 */
		
		int cnt = 0;
		
		for(int i = 0; i < arr02.length; i++) {
			if(arr02[i] > 4) {
				cnt++;
			}
		}
		System.out.println("cnt = " + cnt);
		
		
		System.out.println("========================");
		/*
		 * 문제4
		여기서 최대값을 출력하시오
		 */
		int max_num = 0;
		
		for(int i = 0; i < arr02.length; i++) {
			if(arr02[i] > max_num) {
				max_num = arr02[i];
			}
		}
		System.out.println("max_num = " + max_num);
		
		
		System.out.println("========================");
		/*
		 * 문제5
		 여기서 두번째 큰 수 구하기
		 */
		
		int sec_max_num = 0;
		
		for(int i = 0; i < arr02.length; i++) {
			if(arr02[i] != max_num && arr02[i] > sec_max_num) {
				sec_max_num = arr02[i];
			}
		}
		System.out.println("sec_max_num = " + sec_max_num);
		
		System.out.println("========================");
		/*
		 * 문제6
		 오른쪽으로 한칸 밀기(왼쪽은 0으로 채우기)
		 예시 : {3,4,7,5,1,9,4} -> {0,3,4,7,5,1,9,4}
		 */
		
		int [] arr03 = {3,4,7,5,1,9,4};
		int [] arr04 = new int[arr03.length +1];
		
		for(int i = 0; i < arr03.length; i++) {
			if(i == 0) {
				arr04[i] = 0;
			}
			arr04[i+1] = arr03[i];
		}

		for(int i = 0; i < arr03.length; i++) {
			System.out.print(arr03[i]);
		}
		System.out.println();
		for(int i = 0; i < arr04.length; i++) {
			System.out.print(arr04[i]);
		}
		
		System.out.println();
		System.out.println("========================");
		/*
		 * 문제7
		 오른쪽이 이동 하는데 맨 끝에 값을 맨 처음으로 보내기
		 {3,4,7,5,1,9,4} -> {4,3,4,7,5,1,9}
		 */

		int [] arr05 = new int[arr03.length];
		
		for(int i = 1; i < arr03.length; i++) {
			if(i == 1) {
				arr05[i - 1] = arr03[arr03.length - 1];
			}
			arr05[i] = arr03[i - 1];
		}
		
		for(int i = 0; i < arr05.length; i++) {
			System.out.print(arr05[i]);
		}
		
		System.out.println();
		System.out.println("========================");
		/*
		 * 문제8
		 임시비밀번호 8자리 생성
    	 + 8-1 : 숫자만
    	 + 8-2 : 소문자만
    	 + 8-3 : 숫자2개 이상, 대/소문자 각 1개 이상
		 */
		
		int [] arr8 = new int[8];
		
		for(int i = 0; i < arr8.length; i++) {
			arr8[i] = (int)(Math.random() * 10);
		}
		
		for(int i = 0; i < arr8.length; i++) {
			System.out.print(arr8[i] + " ");
		}
		
		System.out.println();
		System.out.println("========================");
		
		// 8-2
		char[] arr8_2 = new char[8];
		
		for(int i = 0; i < arr8_2.length; i++) {
			arr8_2[i] = (char)((int)(Math.random() * 26) + 97);
		}
		
		for(int i = 0; i < arr8_2.length; i++) {
			System.out.print(arr8_2[i] + " ");
		}
	}

}
