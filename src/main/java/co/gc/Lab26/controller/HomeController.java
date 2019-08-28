package co.gc.Lab26.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.gc.Lab26.entity.Movie;
import co.gc.Lab26.repo.MovieRepository;

@RestController
public class HomeController {
	Random randy = new Random();
	
	@Autowired
	MovieRepository mr;
	
	@GetMapping("/")
	public List<Movie> listMovies(){
		List<Movie> movieList = mr.findAll();
		return movieList;
	}
	
	@GetMapping("get-by-category/{category}")
	public List<Movie> listByCategory(@PathVariable("category") String cat){
		List<Movie> movieList = mr.findByCategory(cat);
		return movieList;
	}
	
	@GetMapping("random")
	public Movie randoMovie() {
		List<Movie> movieList = mr.findAll();
		int numMovies = movieList.size();
		int movieIndex = randy.nextInt(numMovies);
		return movieList.get(movieIndex);
	}
	
	@GetMapping("random/{category}")
	public Movie randoFromCat(@PathVariable("category") String cat) {
		List<Movie> movieList = mr.findByCategory(cat);
		int numMovies = movieList.size();
		int movieIndex = randy.nextInt(numMovies);
		return movieList.get(movieIndex);
	}
	
	@GetMapping("random-list/{quantity}")
	public List<Movie> randoList(@PathVariable("quantity") int quant){
		List<Movie> allMovies  = mr.findAll();
		int [] arr = new int [quant];
		for(int i=0; i < quant; i++) {
			arr[i] = randy.nextInt(allMovies.size());
		}
		List<Movie> selectedMovies = new ArrayList<>();
		for(int choice: arr) {
			selectedMovies.add(allMovies.get(choice));
		}
		return selectedMovies;
	}
	
	@GetMapping("get-all-categories")
	public TreeSet<String> allCategories(){
		return mr.findDistinctCategory();
	}
	
	@GetMapping("get-by-title/{title}")
	public Movie findByTitle(@PathVariable("title") String title) {
		Movie movie = mr.findByTitle(title);
		return movie;
	}
	
	@GetMapping("search-containing/{search}")
	public ArrayList<Movie> searchKeyword(@PathVariable("search") String search){
		ArrayList<Movie> movieList = mr.findByTitleContaining(search);
		return movieList;
	}
}
