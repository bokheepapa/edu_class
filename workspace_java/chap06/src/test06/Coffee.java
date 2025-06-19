package test06;

import java.util.ArrayList;

public class Coffee {
	
	String coffeeName;
	ArrayList<CoffeeSub> coffeesub = new ArrayList<CoffeeSub>();
	
	Coffee(String cname){
		coffeeName = cname;
	}
	
	void showMenu() {
		for(int i = 0; i < coffeesub.size(); i++) {
			System.out.printf("%d : %s  |  %d  \n" , i, coffeesub.get(i).getName(), coffeesub.get(i).getPrice());
		}
	}
}

class CoffeeSub{
	private String subName;
	private int price;
	
	CoffeeSub(String subName, int price){
		setName(subName);
		setPrice(price);
	}
	
	public String getName() {
		return subName;
	}
	public void setName(String name) {
		this.subName = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
		
}