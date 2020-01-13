package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEMS_TO_CART = "INSERT INTO Cart(ct_us_id, ct_me_id) values(?,?)";
	public static final String GET_ALL_CART_ITEMS = "select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from truyum.menu_item inner join truyum.cart on menu_item.me_id=cart.ct_me_id where ct_us_id=? ";
	public static final String GET_TOTAL_PRICE = "select sum(me_price) as Total from truyum.menu_item inner join truyum.cart on menu_item.me_id=cart.ct_me_id where ct_us_id=?";
	public static final String REMOVE_CART_ITEM = "Delete from cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MENUITEMS_TO_CART);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Cart cart = new Cart();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_CART_ITEMS);
			preparedStatement.setLong(1, userId);
			resultSetList = preparedStatement.executeQuery();
			while (resultSetList.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem = new MenuItem();
				menuItem.setId(resultSetList.getLong("me_id"));
				menuItem.setName(resultSetList.getString("me_name"));
				menuItem.setPrice(resultSetList.getFloat("me_price"));
				menuItem.setActive(resultSetList.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSetList.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSetList.getString("me_category"));
				menuItem.setFreeDelivery(resultSetList.getString("me_free_delivery").equals("1"));

				menuItemList.add(menuItem);
			}
			cart.setMenuItemList(menuItemList);
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL_PRICE);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery(); 
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}
			//cart.setMenuItemList(menuItemList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSetList != null)
					resultSetList.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSetList != null)
					resultSetList.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		try {
////			preparedStatementTotal = connection.prepareStatement(GET_TOTAL_PRICE);
////			preparedStatementTotal.setLong(1, userId);
////			resultSetTotal = preparedStatementTotal.executeQuery();
//			// double total = 0.0;
//			if (menuItemList.size() == 0) {
//				System.out.println("Cart is empty");
//			}
//			while (resultSetTotal.next()) {
//				cart.setTotal(resultSetTotal.getDouble("Total"));
//			}
//
//		} catch (Exception e) {
//
//		} finally {
//			try {
////				if (resultSetTotal != null)
////					resultSetTotal.close();
////				if (preparedStatement != null)
////					preparedStatement.close();
////				if (connection != null)
////					connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(REMOVE_CART_ITEM);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}

	}

}
