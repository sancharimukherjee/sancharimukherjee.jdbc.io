package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testGetMovieListAdmin() {
		System.out.println("\n\nMovie List for Admin");
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		String active, hasTeaser;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Box Office", "Active", "Date of Launch",
				"Genre", "Has Teaser");
		for (Movies movies : movieList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getHasTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			// String date =
			// sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", movies.getId(), movies.getName(), movies.getGross(),
					active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasTeaser);
		}

	}

	public static void testGetMovieListCustomer() {
		// System.out.println("Movie List for Customer");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// DecimalFormat df = new DecimalFormat("####.00");
		// System.out.println("Movie List for Customer");
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		System.out.println("\n");
		System.out.println("Movie List for customer\n");
		String active, hasTeaser;
		List<Movies> movieList = moviesDao.getMovieListCustomer();
		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Box Office", "Active", "Date of Launch",
				"Genre", "Has Teaser");
		for (Movies movies : movieList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getHasTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			// String date =
			// sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", movies.getId(), movies.getName(), movies.getGross(),
					active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasTeaser);
		}

	}

	public static void testModifyMovies() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// DecimalFormat df = new DecimalFormat("####.00");
		System.out.println("\n");
		System.out.println("Modified Movie List\n");
		Movies movies = new Movies(1L, "Spiderman7", 5676324500L, true, new DateUtil().convertToDate("04/01/2020"),
				"Superhero", true);
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();

		moviesDaoSqlImpl.modifyMovies(movies);

		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Box Office", "Active", "Date of Launch",
				"Genre", "Has Teaser");
		// String date =
		// sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
		System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", movies.getId(), movies.getName(), movies.getGross(),
				movies.getActive(), sdf.format(movies.getDateOfLaunch()), movies.getGenre(), movies.getHasTeaser());
	}

	public static void testGetMovies() {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// DecimalFormat df = new DecimalFormat("####.00");
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		Movies movies = moviesDao.getMovies(3L);
		System.out.format("\n%15s%20s%15s%15s%25s%15s%25s", "Id", "Name", "Box Office", "Active", "Date of Launch",
				"Genre", "Has Teaser");
		//String date =sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
				System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", movies.getId(), movies.getName(), movies.getGross(),
						movies.getActive(), sdf.format(movies.getDateOfLaunch()), movies.getGenre(), movies.getHasTeaser());
	}

	public static void main(String args[]) {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println("Connection-> " + connection);
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovies();
		testGetMovieListAdmin();
		// testGetMovies();
	}

}
