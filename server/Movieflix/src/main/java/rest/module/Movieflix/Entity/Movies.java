package rest.module.Movieflix.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movies.findAll", query = "SELECT e FROM Movies e ORDER BY e.title ASC"),
	@NamedQuery(name = "Movies.findByType", query = "SELECT e FROM Movies e WHERE e.type=:pType"),
	@NamedQuery(name = "Movies.findByYear", query = "SELECT e FROM Movies e WHERE e.year=:pYear"),
	@NamedQuery(name = "Movies.findByGenre", query = "SELECT e FROM Movies e WHERE e.genre=:pGenre"),
	@NamedQuery(name = "Movies.findByTitle", query = "SELECT e FROM Movies e WHERE e.title=:pTitle"),
	@NamedQuery(name = "Movies.sortByYear", query = "SELECT e FROM Movies e ORDER BY e.year DESC"),
	@NamedQuery(name = "Movies.sortByimdbRatings", query = "SELECT e FROM Movies e ORDER BY e.imdbRatings DESC"),
	@NamedQuery(name = "Movies.sortByimdbVotes", query = "SELECT e FROM Movies e ORDER BY e.imdbVotes DESC"),
})
public class Movies {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@Column(unique=true)
	private String title;
	private String year;
	private String rated;
	private Date released;
	private String runtime;
	private String genre;
	private String Director;
	private String writer;
	private String plot;
	private String actors;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private float imdbRatings;
	private Long imdbVotes;
	private String imdbID;
	private String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public float getImdbRatings() {
		return imdbRatings;
	}
	public void setImdbRating(float imdbRatings) {
		this.imdbRatings = imdbRatings;
	}
	public Long getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", Director=" + Director + ", writer="
				+ writer + ", plot=" + plot + ", actors=" + actors + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", imdbRating=" + imdbRatings + ", imdbVotes="
				+ imdbVotes + ", imdbID=" + imdbID + ", type=" + type + "]";
	}
}
