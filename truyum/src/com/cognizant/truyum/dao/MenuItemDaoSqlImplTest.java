package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Item List for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		String active, freeDelivery;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), menuItem.getActive(), sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), menuItem.getFreeDelivery());

		}

	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Item List for Customer");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("####.00");
		System.out.println("Item List for Customer");
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		String active, freeDelivery;
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), menuItem.getActive(), sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), menuItem.getFreeDelivery());

		}

	}

	public static void testModifyMenuItem() {
		System.out.println("Modified Menu List");
		MenuItem menuItem = new MenuItem(1L, "Noodles", 400.00f, true, new DateUtil().convertToDate("15/01/2020"),
				"Main Course", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();

		menuItemDaoSqlImpl.modifyMenuItem(menuItem);

	}

	public static void testGetMenuItem() {
		System.out.println("Get menu Item");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("####.00");
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		long menuItemId = 3;
		MenuItem menuItem = menuItemDaoSqlImpl.getMenuItem(menuItemId);
		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		//String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
		//String price = df.format(menuItem.getPrice());
		System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", menuItem.getId(), menuItem.getName(),
				menuItem.getPrice(), menuItem.getActive(), sdf.format(menuItem.getDateOfLaunch()),
				menuItem.getCategory(), menuItem.getFreeDelivery());
	}

	public static void main(String args[]) {
		Connection connection = ConnectionHandler.getConnection();
	System.out.println("Connection-> "+connection);
		testGetMenuItemListAdmin();		
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		//testGetMenuItem();
	
	}

}
