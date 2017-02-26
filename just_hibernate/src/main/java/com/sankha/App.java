package com.sankha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sankha.hibernate.HibernateMovieManager;
import com.sankha.hibernate.beans.Movie;
import com.sankha.vanilla.VanillaMovieManager;

/**
 * Hello world!
 *
 */
public class App {
	final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		// vanillaMoviesToolkit();
		hibernateMoviesToolkit();
	}

	private static void vanillaMoviesToolkit() {
		VanillaMovieManager.persistMovie();
		logger.info("-----------------------------------");
		VanillaMovieManager.queryMovie();
	}

	private static void hibernateMoviesToolkit() {
		Movie movie = new Movie();
		movie.setId(1003);
		movie.setName("Hacksaw Ridge");
		movie.setDirector("Mel Gibson");
		movie.setGenre("War, History");

		HibernateMovieManager.persistMovie(movie);
		logger.info("-----------------------------------");
		HibernateMovieManager.findMovie(movie.getId());
		logger.info("-----------------------------------");
		HibernateMovieManager.findAllMovies();
	}
}
