package hello.dao;

import java.util.Map;

import hello.model.Movie;

public interface RedisRepository {
	Map<Object, Object> findAllMovies();

	void add(Movie movie);

	void delete(String id);

	Movie findMovie(String id);
}
