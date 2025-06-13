package sec01.exam01;

import java.util.ArrayList;
import java.util.Calendar;

public class EnumExam04 {

	public static void main(String[] args) {

		Week week;
		
		System.out.println(Week.FRIDAY);
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		
		System.out.println(year);
		System.out.println(now.get(Calendar.MONTH)+1);
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
		
		ArrayList list = new ArrayList();
		ArrayList<ArrayList> list2 = new ArrayList<ArrayList>();
		
		list.add(2);
		list.add("복희");
		list.add(true);
		list2.add(list);
		list2.add(list);
		list2.add(list);
		list2.add(list);
		list2.add(list);
		
		System.out.println(list2);
		
		for(int i = 0 ; i < list2.get(0).size(); i++) {
			System.out.println(list2.get(0).get(i));
		}
	}

}
