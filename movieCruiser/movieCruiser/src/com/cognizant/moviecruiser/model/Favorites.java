package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

	private List<Movies> movieList;

	private int total;

	public Favorites() {
		super();
	}

	public Favorites(List<Movies> movieList, int total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", total=" + total + "]";
	}

	public Object size() {
		// TODO Auto-generated method stub
		return null;
	}

}
