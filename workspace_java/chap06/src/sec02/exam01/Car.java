package sec02.exam01;

public class Car {
	
	String company = "현대자동차";
	String model = "그랜저";
	String Color = "검정";
	int maxSpeed = 350;
	int speed;
	
	Car(String Color, String model){
		System.out.println("모델명 : " + model);
		System.out.println("색깔 : " + Color);
		System.out.println("========= 초기화 =========");
		this.Color = Color;
		this.model = model;
		
	};

}
