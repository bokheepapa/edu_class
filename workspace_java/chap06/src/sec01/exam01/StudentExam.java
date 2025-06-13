package sec01.exam01;

public class StudentExam {

	public static void main(String[] args) {

//		new Student(); 
		
		Student s1 = new Student("학생1");
		Student s2 = new Student("학생2");
		Student s3 = new Student();
		Student s5 = new Student();
		Student s4 = null;
		StudentChild s6 = new StudentChild();
		
		System.out.println(s3 == s5);
		
		
//		s1.num = 0;
//		s2.num = 1;
		
		System.out.println("s1.num = " + s1.num);
		System.out.println("s2.num = " + s2.num);
		System.out.println("s3.num = " + s3.num);

		s1 = s3;
		
		System.out.println(s1 == s3);
		
		s1 = null;
		s3 = null;
		
		System.out.println(s1 == s3);
		
		System.out.println(s2);
		System.out.println(System.identityHashCode(s2));
		
		System.out.println("s6.num = " + s6.num);
	}

}
