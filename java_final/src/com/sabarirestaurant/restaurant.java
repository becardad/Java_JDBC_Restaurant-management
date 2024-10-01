package com.sabarirestaurant;

public class restaurant {

	 private String table_no;
		private String name;
	  private String food;
	  private int price;
	 
	  
	public String getTable_no() {
		return table_no;
	}
	public void setTable_no(String table_no) {
		this.table_no = table_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public restaurant()
	{
	}
	public restaurant(String table_no, String name, String food,int price) {
		this.table_no = table_no;
		this.name=name;
		this.food=food;
		this.price=price;
	}
	@Override
	public String toString() {
		return "restaurant [table_no=" + table_no + ", name=" + name + ", food=" + food + ", price=" + price + "]";
	}
	


	  
	}


