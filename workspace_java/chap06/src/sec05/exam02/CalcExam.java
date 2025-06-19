package sec05.exam02;

public class CalcExam {

	public static void main(String[] args) {

		Calc.cnt = 5;	
		Calc cal = new Calc();
		cal.cnt = 4;
		Calc cal2 = new Calc();
		cal2.cnt = 3;

		Calc.cnt = 6;	
		
		System.out.println("Calc.cnt : " + Calc.cnt);
		System.out.println("cal.cnt : " + cal.cnt);
		System.out.println("cal2.cnt : " + cal2.cnt);

	}

}
