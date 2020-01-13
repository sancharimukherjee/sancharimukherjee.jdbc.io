package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;

import com.cognizant.moviecruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MoviesDao;

import com.cognizant.moviecruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movies;

/**
 * Servlet implementation class AddToFavoritesServlet
 */
@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long userId = 1L;
		long moviesId = Long.parseLong(request.getParameter("id"));
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		favoritesDao.addFavoriteMovies(userId, moviesId);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> moviesListCustomer = moviesDao.getMovieListCustomer();
		// System.out.println(moviesListCustomer);
		request.setAttribute("movieList", moviesListCustomer);
		request.setAttribute("addFavoritesStatus", true);

		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
