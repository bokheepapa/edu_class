package sec01.exam01;

import java.util.ArrayList;

public class ArrayExam {

	public static void main(String[] args) {

		/*
		 * 배열 array
		 * 한번에 여러 변수를 만들는 방법
		 * 같은 타입만 선언할 수 있음
		 * 생성할 때 전체 크기를 지전해줘야 함
		 * 생성된 여러 변수들은 index로 관리한다(index는 0부터 시작)
		 */
		
		int[] arr_int = new int[6];
		char[] arr_char = {'안','녕','하','세','요','.'};
		
		for(char temp : arr_char) {
			System.out.print(temp);
		}
		System.out.println();
		
		arr_int[0] = 90; 
		arr_int[1] = 85; 
		arr_int[2] = 75; 
		arr_int[3] = 65; 
		arr_int[4] = 70; 
		arr_int[5] = 60; 
		
		for(int temp : arr_int) {
			System.out.println(temp);
		}
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> int_list = new ArrayList<Integer>();
		ArrayList<Integer> int_list2 = new ArrayList<Integer>();
		
		int_list.add(90);
		int_list.add(85);
		int_list.add(75);
		int_list.add(65);
		int_list.add(70);
		int_list.add(60);
		
		int_list2.add(55);
		int_list2.add(45);
		int_list2.add(40);
		int_list2.add(50);
		int_list2.add(35);
		int_list2.add(30);
		int_list2.remove(2);
		
		
		list.add(int_list);
		list.add(int_list2);
		

		System.out.println(int_list);
		System.out.println(int_list.get(0));
		System.out.println(list);
		System.out.println("list size : " + list.size());
		System.out.println("list1 size : " + list.get(0).size());
		System.out.println("list2 size : " + list.get(1).size());
		boolean flag = list.get(0).contains(20);
		System.out.println(flag);
		System.out.println(System.identityHashCode(list));
		System.out.println(System.identityHashCode(list.get(0)));
		System.out.println(System.identityHashCode(list.get(0).get(0)));
		System.out.println(System.identityHashCode(list.get(0).get(1)));
		System.out.println(System.identityHashCode(list.get(1)));
		
		int num = list.get(0).get(0);
		System.out.println(num);
		
//		int[] arr_num = new int[3];
//		arr_num[0] = 80;
//		arr_num[1] = 85;
		
		int[] arr_num = {80, 80};
		int[] arr_num1 = new int[] {80, 80};
		int num1 = 80;
		
		System.out.println(System.identityHashCode(arr_num[0]));
		System.out.println(System.identityHashCode(arr_num[1]));
		System.out.println(System.identityHashCode(arr_num1[0]));
		System.out.println(System.identityHashCode(arr_num1[1]));
		System.out.println(System.identityHashCode(num1));
		
	}

}
