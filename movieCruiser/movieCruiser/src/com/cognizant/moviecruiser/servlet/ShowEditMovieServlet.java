package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MoviesDao;

import com.cognizant.moviecruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movies;

/**
 * Servlet implementation class ShowEditMovieServlet
 */
@WebServlet("/ShowEditMovie")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		Long moviesId = Long.parseLong(request.getParameter("id"));
		Movies movies = moviesDao.getMovies(moviesId);
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("edit-movies.jsp").forward(request, response);
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
