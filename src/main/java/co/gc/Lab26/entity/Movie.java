package co.gc.Lab26.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String category;
	String title;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String category, String title) {
		super();
		this.category = category;
		this.title = title;
	}

	public Movie(Integer id, String category, String title) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", category=" + category + ", title=" + title + "]";
	}
	
	
}
