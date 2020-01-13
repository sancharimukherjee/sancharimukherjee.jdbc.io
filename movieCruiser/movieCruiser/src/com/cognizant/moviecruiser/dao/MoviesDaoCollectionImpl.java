package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {

	private static List<Movies> movieList;

	public MoviesDaoCollectionImpl() {
		super();
		if (movieList == null) {
			movieList = new ArrayList<Movies>();
			Movies One = new Movies(1L, "Avatar", 2787965087L, true, new DateUtil().convertToDate("15/03/2021"),
					"Science Fiction", true);
			Movies Two = new Movies(2L, "The Avengers", 1518812988L, true, new DateUtil().convertToDate("23/12/2017"),
					"Superhero", false);
			Movies Three = new Movies(3L, "Titanic", 2187463944L, true, new DateUtil().convertToDate("21/08/2021"),
					"Romance", true);
			Movies Four = new Movies(4L, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("02/07/2017"), "Science Fiction", true);
			Movies Five = new Movies(5L, "Avengers: End Game", 2750760348L, true,
					new DateUtil().convertToDate("02/11/2022"), "Superhero", true);
			movieList.add(One);
			movieList.add(Two);
			movieList.add(Three);
			movieList.add(Four);
			movieList.add(Five);
		}
	}

	@Override
	public List<Movies> getMovieListAdmin() {
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> filteredMovies = new ArrayList<Movies>();
		for (Movies movies : movieList) {
			if (movies.getDateOfLaunch().after(new Date())) {
				if (movies.getActive()) {
					filteredMovies.add(movies);
				}
			}
		}
		return filteredMovies;
	}

	@Override
	public void modifyMovies(Movies movies) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
			}
		}
	}

	@Override
	public Movies getMovies(Long moviesId) {
		for (Movies movies : movieList) {
			if (movies.getId() == moviesId) {
				return movies;
			}
		}
		return null;
	}

}
