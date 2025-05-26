package src01.exam02;


public class VariableUseExample {

	public static void main(String[] args) {

		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간 " + minute + "분");
		
		int totalMinute = (hour * 60) + minute;
		System.out.println("총 " + totalMinute + "분");
		
		int i = 1;
		while(true) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i = i + 1;
			
			if(i == 5) {
				break;
			}				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		int x1 = 745813;
		int x2 = 684684;
		
		System.out.println("변경 전");
		System.out.println("x1 : " + x1);
		System.out.println("x2 : " + x2);
		
		int temp;
		
		temp = x1;
		x1 = x2;
		x2 = temp;
		
		System.out.println("변경 후");
		System.out.println("x1 : " + x1);
		System.out.println("x2 : " + x2);
	}

}
