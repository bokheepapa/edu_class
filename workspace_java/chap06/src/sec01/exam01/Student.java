package sec01.exam01;

public class Student {

	int num;
	int cnt;
	
	Student(String s) {
		System.out.println(s + " 클래스 호출");
		num = 10;
	}
	
	Student() {
		System.out.println("기본 클래스 호출");
		num = 20;
	}

}
