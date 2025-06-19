package sec05.exam05;

import sec03.exam03.*;

public class Person {
	
	final String nation = "Korea";
	final String ssn;
	String name;
	
	public Person() {
		this.ssn = "주민번호";
		this.name = "이름";
//		this.nation = "다른나라";
		
		this.name = "이름2";
//		this.ssn = "주민번호2";
	}
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	void print () {
		System.out.println(this.ssn);
	}
	
}
