package co.gc.Lab26.repo;

import java.util.ArrayList;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gc.Lab26.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public ArrayList<Movie> findByCategory(String c);
	
	@Query("SELECT DISTINCT category FROM Movie")
	public TreeSet<String> findDistinctCategory();
	
	public Movie findByTitle(String t);
	
	public ArrayList<Movie> findByTitleContaining(String s);
}
