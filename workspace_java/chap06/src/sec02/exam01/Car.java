package sec02.exam01;

public class Car {
	
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	Car(String color, String model){
		System.out.println("========= 생성자 호출 =========");
//		System.out.println("모델명 : " + this.model);
//		System.out.println("색깔 : " + this.color);
//		System.out.println("모델명 : " + model);
//		System.out.println("색깔 : " + Color);
		
		this.color = color;
		this.model = model;
		
	};
	
	Car(){
		
		this("흰색", "싼타페");
//		model = "싼타페";
//		color = "흰색";
		System.out.println("========= 기본 생성자 호출 =========");
//		System.out.println("모델명 : " + this.model);
//		System.out.println("색깔 : " + this.Color);
//		System.out.println("모델명 : " + model);
//		System.out.println("색깔 : " + Color);
		
		intCar();
		intCar2(250);
	};
	
	public void intCar() {
		System.out.println("========= 기본 생성자에서 메소드 호출 =========");
		company = "기아";
		model = "쏘렌토";
		color = "회색";
	}
	
	public void intCar2(int maxSpeed) {
		System.out.println("========= 기본 생성자에서 메소드2 호출 =========");
		this.maxSpeed = maxSpeed;
	}

}
