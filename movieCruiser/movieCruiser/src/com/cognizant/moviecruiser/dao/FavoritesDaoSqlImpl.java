package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

import com.cognizant.moviecruiser.dao.ConnectionHandler;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIES_TO_FAVORITES = "INSERT INTO Favorites(ft_us_id, ft_mo_id) values(?,?)";
	public static final String REMOVE_FAVORITES = "Delete from favorites where ft_us_id=? and ft_mo_id=? limit 1";
	public static final String GET_ALL_FAVORITES = "select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from moviecruiser.movies inner join moviecruiser.favorites on movies.mo_id=favorites.ft_mo_id where ft_us_id=? ";
	public static final String TOTAL_NUMBER_OF_MOVIES = "select count(mo_id) as Total_favorites from moviecruiser.movies inner join moviecruiser.favorites on movies.mo_id=favorites.ft_mo_id where ft_us_id=?";

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
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
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ArrayList<Movies> movieList = new ArrayList<Movies>();
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSetList = preparedStatement.executeQuery();
			while (resultSetList.next()) {
				Movies movies = new Movies();
				movies = new Movies();
				movies.setId(resultSetList.getLong("mo_id"));
				movies.setName(resultSetList.getString("mo_title"));
				movies.setGross(resultSetList.getLong("mo_box_office"));
				movies.setActive(resultSetList.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSetList.getDate("mo_date_of_launch"));
				movies.setGenre(resultSetList.getString("mo_genre"));
				movies.setHasTeaser(resultSetList.getString("mo_has_teaser").equals("1"));

				movieList.add(movies);
			}
			favorites.setMovieList(movieList);
			preparedStatementTotal = connection.prepareStatement(TOTAL_NUMBER_OF_MOVIES);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			if (movieList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			while (resultSetTotal.next()) {
				favorites.setTotal(resultSetTotal.getInt("Total_favorites"));
			}

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
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(REMOVE_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
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
