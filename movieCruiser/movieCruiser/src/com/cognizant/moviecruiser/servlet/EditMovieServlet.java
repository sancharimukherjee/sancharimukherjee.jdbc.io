package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MoviesDao;

import com.cognizant.moviecruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movies;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("title");
		long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("inStock").equals("yes");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfLaunch = null;

		try {
			dateOfLaunch = simpleDateFormat.parse(request.getParameter("dateOfLaunch"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		Movies movies = new Movies(id, name, gross, active, dateOfLaunch, genre, hasTeaser);
		System.out.println(movies);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		moviesDao.modifyMovies(movies);
		request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
		// doGet(request, response);
	}

}
