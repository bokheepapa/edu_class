package sec01.exam01;

public class RefExam {

	public static void main(String[] args) {

		int a = 10;
		int b = a;
		
		System.out.println(a + ", " + b);
		
		b = 12;
		System.out.println(a + ", " + b);
		
		String name = "이동주";
		String name2 = new String("이동주");
		
		System.out.println(name == name2 ? "같다" : "다르다");
		System.out.println(name.equals(name2) ? "같다" : "다르다");
		
		String e = name;
		System.out.println("e : " + e);

		String f = "이" + "동주";
		System.out.println(e == f ? "같다" : "다르다");
		
		String g = null;
		System.out.println(g);
		System.out.println(g + "abc");
		
		String h = "";
		System.out.println(h + "abc");
		
		System.out.println(h.equals(g) ? "같다" : "다르다");
		
		try {
			System.out.println(g.equals(h) ? "같다" : "다르다");
			
		}catch(Exception err){
			System.out.println("에러");
		}
	}

}
