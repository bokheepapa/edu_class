package sec02.exam02;

public class ArgumentExam {

	public static void main(String[] args) {
		String arr_string[] = {"프로그램","사용자","반복"}; 
		
		call(arr_string);
		
		Week today = null;
		
		today = Week.FRIDAY;
		String today_temp = today.toString();
		
		System.out.println("today : " + today);
		System.out.println(today_temp);
		
		/////////////////////////////////////////////////////////////
		 
		String name = "이동주";
		System.out.println(name + System.identityHashCode(name));
		
		String name2 = "이동주";
		System.out.println(name2 + System.identityHashCode(name2));
		
		String name3[] = {"이동주", "동주"};
		System.out.println(name3[0] + System.identityHashCode(name3[0]));
		
		String name4 = new String("이동주");
		System.out.println(name4 + System.identityHashCode(name4));
		
		System.out.println();
		// == 연산
		System.out.println("== 연산");
		System.out.println(name == name2 ? "같다" : "다르다");
		System.out.println(name == name3[0] ? "같다" : "다르다");
		System.out.println(name2 == name3[0] ? "같다" : "다르다");
		System.out.println(name == name4 ? "같다" : "다르다");
		
		System.out.println();
		// equlas 연산
		System.out.println("equlas 연산");
		System.out.println(name.equals(name2) ? "같다" : "다르다");
		System.out.println(name.equals(name3[0]) ? "같다" : "다르다");
		System.out.println(name2.equals(name3[0]) ? "같다" : "다르다");
		System.out.println(name.equals(name4) ? "같다" : "다르다");

	}
	
	public  static void call(String[] args) {
		int length = args.length;
		System.out.println(length);
		for(int i = 0 ; i < args.length ; i++) {
			System.out.println(args[i]);
		}
		
	}

}
