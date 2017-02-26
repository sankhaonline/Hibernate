package com.sankha.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sankha.hibernate.beans.Movie;
import com.sankha.hibernate.util.HibernateConnectionUtil;

public class HibernateMovieManager {
	final static Logger logger = LoggerFactory.getLogger(HibernateMovieManager.class);

	public static void persistMovie(Movie movie) {
		Session session = HibernateConnectionUtil.initSessionFactory().openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		logger.info("Movie persisted successfully!");
	}

	public static void findMovie(int movieId) {
		Session session = HibernateConnectionUtil.initSessionFactory().openSession();
		session.beginTransaction();
		Movie movie = session.load(Movie.class, movieId);
		logger.info("Movie:" + movie);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static void findAllMovies() {
		Session session = HibernateConnectionUtil.initSessionFactory().openSession();
		session.beginTransaction();
		List<Movie> movies = session.createQuery("from Movie").list();
		session.getTransaction().commit();
		logger.info("All Movies:" + movies);
	}

}
