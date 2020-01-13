package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void testAddCartItem() {

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(1L, 3L);
		System.out.println("\n\nItem added to cart successfully\n\n");
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart cart =  cartDaoSqlImpl.getAllCartItems(1L);
		System.out.println(cart.getMenuItemList());
		System.out.println("\n\nTotal price= "+cart.getTotal());
		
	}

	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(1L, 2L);
		System.out.println("\n\nItem is removed from cart");

	}

	public static void main(String args[]) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}
}
