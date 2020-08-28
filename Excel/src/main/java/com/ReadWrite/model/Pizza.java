package com.ReadWrite.model;

public class Pizza {
	
	private int pizzaId;
	private String pizzaName;
	private int price;
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "{pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", price=" + price+"}" ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if((obj instanceof Pizza)&&(((Pizza)obj).getPizzaId()==this.pizzaId)&&(((Pizza)obj).getPizzaName().equals(this.pizzaName))&&(((Pizza)obj).getPrice()==this.price))
			return true;
		else
			return false;
	}
	
	
}
