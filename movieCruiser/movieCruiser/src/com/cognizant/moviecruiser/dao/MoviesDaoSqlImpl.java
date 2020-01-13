package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

import com.cognizant.moviecruiser.dao.ConnectionHandler;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String MOVIE_LIST_ADMIN = "select * from movies";
	public static final String UPDATE_MOVIES = "update movies set " + "mo_title= ?," + "mo_box_office= ?,"
			+ "mo_active= ?," + "mo_date_of_launch= ?," + "mo_genre= ?," + "mo_has_teaser= ? where mo_id=?";
	public static final String MOVIE_LIST_CUSTOMER = "select * from movies where mo_active='1'and mo_date_of_launch > (SELECT CURDATE())";
	public static final String GET_MOVIES = "select * from movies where mo_id=?";

	@Override
	public ArrayList<Movies> getMovieListAdmin() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(MOVIE_LIST_ADMIN);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setName(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {

		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(MOVIE_LIST_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setName(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// if (resultSet != null)
				// resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public void modifyMovies(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_MOVIES);
			preparedStatement.setString(1, movies.getName());
			preparedStatement.setLong(2, movies.getGross());
			preparedStatement.setBoolean(3, movies.getActive());
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setBoolean(6, movies.getHasTeaser());
			preparedStatement.setLong(7, movies.getId());
			preparedStatement.executeUpdate();
			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows > 0) {
				System.out.println("Movie Updated Sucessfully");
			} else {
				System.out.println("Movie not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
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
	public Movies getMovies(Long movies) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movie = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES);
			preparedStatement.setLong(1, movies);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movie = new Movies();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setName(resultSet.getString("mo_title"));
				movie.setGross(resultSet.getLong("mo_box_office"));
				movie.setActive(resultSet.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// if (resultSet != null)
				// resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(movies);
		return movie;
	}

}
