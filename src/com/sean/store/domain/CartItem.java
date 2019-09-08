package com.sean.store.domain;

//购物车中的购物项
//属性：商品图片，商品名称，商品价格（用Product对象携带这三者信息）
//购买数量，小计  删除操作
public class CartItem {
	private Product product;
	private int num;//购买数量
	private double subTotol;//购物项小计
	
	public double getSubTotol(){
		return subTotol*num;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Product product, int num, double subTotol) {
		super();
		this.product = product;
		this.num = num;
		this.subTotol = subTotol;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", num=" + num + ", subTotol=" + subTotol + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setSubTotol(double subTotol) {
		this.subTotol = subTotol;
	}
	
}
