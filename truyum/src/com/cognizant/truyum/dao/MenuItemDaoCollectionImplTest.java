package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Item list for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
			// System.out.println(new
			// DateUtil().convertToString(menuItem.getDateOfLaunch()));
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("\nItem list for Customer");
		// 1.Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 2.Invoke menuItemDao.getMenuItemListCustomer() and obtain the menuItemList
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		// 3.Iterate through the menuItemList and display all attributes of each menu
		// item
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		// 1.Create an instance for Menu Item with id matching with one of the menu item
		// already added to the menuItemList.
		// menu item already
		MenuItem item = new MenuItem(5L, "Biriyani", 52.00f, true, new DateUtil().convertToDate("02/12/2022"),
				"Dessert", true);
		// 2.Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 3.Invoke MenuItemDao.modifyMenuItem(menuItem) by passing the menu item
		// created in the first step.
		menuItemDao.modifyMenuItem(item);
		System.out.println("\n*** Modified Menu Item List***");
		testGetMenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getMenuItem(item.getId());
		System.out.println("\nModified ITEM Detail\n" + modified_item);
	}

	public static void main(String args[]) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

		/*
		 * List<MenuItem> menuItemList = new
		 * MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		 * 
		 * System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Name", "Price",
		 * "Active", "Date of Launch", "Category", "Free Delivery");
		 * 
		 * for (MenuItem menuItem : menuItemList) { String active;
		 * if(menuItem.getActive() == true) { active = "Yes"; } else { active="No"; }
		 * 
		 * System.out.format("%-20s%-20s%-20%s%-20s%-20s%-20s\n", menuItem.getName(),
		 * menuItem.getPrice(), menuItem.getActive(), menuItem.getDateOfLaunch(),
		 * menuItem.getCategory(), menuItem.getFreeDelivery()); }
		 */
	}

}
