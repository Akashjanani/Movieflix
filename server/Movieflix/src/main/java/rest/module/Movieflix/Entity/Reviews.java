package rest.module.Movieflix.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name= "Reviews.findReviewByMovieId", query= "SELECT e FROM Reviews e WHERE e.movie.id=:Id"),
})
public class Reviews {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private String userComments;
	
	private int userRatings;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movies movie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserComments() {
		return userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

	public int getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(int userRatings) {
		this.userRatings = userRatings;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", userComments=" + userComments + ", userRatings=" + userRatings + ", movie="
				+ movie + ", user=" + user + "]";
	}
}
