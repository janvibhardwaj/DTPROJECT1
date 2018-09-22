package com.niit.fairdealbackend.dao;

import java.util.List;

import com.niit.fairdealbackend.dto.Item;

public interface ItemDAO {
	
	boolean addItem(Item item);
	boolean updateItem(Item item);
	Item getItemByProductIdAndCustomerId(int productid,String customerId);
	List<Item> getItemsListByCart(int cartId);
	boolean increaseQuantity(int itemId);
	boolean decreaseQuantity(int itemId);
	boolean deleteItem(int itemId);
	
}
