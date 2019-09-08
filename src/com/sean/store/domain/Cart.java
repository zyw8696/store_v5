package com.sean.store.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//购物车
//要有不确定的集合用于承装购物项//list   or   map
//不确定的总计/积分，添加购物项，清空购物车，删除购物项。。。
public class Cart {
	private double total;//总计
	
	
	Map<String,CartItem>map = new HashMap<String,CartItem>();//key:pid    value：购物项
	
	
	//计算总计
	public double getTotal(){
		Collection<CartItem> values = map.values();//返回所有购物项对象的一个集合
		for (CartItem cartItem : values) {
			total+=cartItem.getSubTotol();
		}
		return total;
	}
	//添加购物项  由客户端发起添加请求， 
	public void addCartItemToCart(CartItem cartItem){
		//判断是否之前存在该商品的记录，是：修改商品的购买数量和小计，否：添加该购物项
		String pid = cartItem.getProduct().getPid();
		
		if(map.containsKey(pid)){
			CartItem CartItemOld = map.get(pid); //存在 则获取该购物项
			CartItemOld.setNum(CartItemOld.getNum()+cartItem.getNum());
		}
		else{
			map.put(pid, cartItem);
		}
	}
	public void clearCart(){
		map.clear();
	}
	public void remote(String pid){
		map.remove(pid);
	}

}
