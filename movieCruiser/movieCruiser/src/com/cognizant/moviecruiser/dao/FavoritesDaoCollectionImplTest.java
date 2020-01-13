package com.cognizant.moviecruiser.dao;

import java.util.List;
import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoriteMovies(1, 2L);
		favoritesDao.addFavoriteMovies(1, 4L);
		favoritesDao.addFavoriteMovies(2, 1L);
		favoritesDao.addFavoriteMovies(2, 3L);
		// Favorites favorites = favoritesDao.getAllFavoriteMovies(1);
		@SuppressWarnings("unchecked")
		List<Movies> movieListCustomer = (List<Movies>) favoritesDao.getAllFavoriteMovies(1);
		System.out.println("User Added Favorites List for Checkout");
		for (Movies movies : movieListCustomer) {
			System.out.println(movies);
		}
		// System.out.println("Total number of favorites: " + movieListCustomer.size());
	}

	public static void testRemoveFavoriteMovies() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("\nItem List for Customer after Remove");
		try {
			favoritesDao.removeFavoriteMovies(1, 2L);
			favoritesDao.removeFavoriteMovies(2, 1L);
			// favoritesDao.removeFavorites(1, 5L);
			// Favorites favorites = favoritesDao.getAllFavoriteMovies(1);
			@SuppressWarnings("unchecked")
			List<Movies> movieListCustomer = (List<Movies>) favoritesDao.getAllFavoriteMovies(1);
			// System.out.println("Total number of favorites: " + movieListCustomer.size());
			for (Movies movie : movieListCustomer) {
				System.out.println(movie);
			}
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoriteMovies() {

	}

	public static void main(String args[]) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
	}

}
