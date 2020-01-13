package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMovieListAdmin() {
		System.out.println("Item list for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testGetMovieListCustomer() {
		System.out.println("\nItem list for Customer");
		MoviesDao movieDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = movieDao.getMovieListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies item = new Movies(5L, "Spiderman", 5750760348L, true, new DateUtil().convertToDate("02/12/2022"),
				"Superhero", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(item);
		System.out.println("\n*** Modified Movie List***");
		testGetMovieListAdmin();
		Movies modified_item = moviesDao.getMovies(item.getId());
		System.out.println("\nModified Movie Detail\n" + modified_item);
	}

	public static void main(String args[]) {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovies();
	}

}
