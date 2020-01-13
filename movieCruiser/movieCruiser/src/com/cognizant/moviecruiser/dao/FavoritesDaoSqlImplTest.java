package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.addFavoriteMovies(1L, 5);
		System.out.println("\n\nMovies added to Favorites successfully\n\n");
	}

	public static void testRemoveFavoriteMovies() {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.removeFavoriteMovies(1L, 5);
		System.out.println("\n\nMovie removed from favorites");
	}

	public static void testGetAllFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDaoSqlImpl favoriteDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorites = favoriteDaoSqlImpl.getAllFavoriteMovies(1L);
		System.out.println(favorites.getMovieList());
		System.out.println("\n\nTotal number of movies= " + favorites.getTotal());
	}

	public static void main(String args[]) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
		testGetAllFavoriteMovies();
	}
}
