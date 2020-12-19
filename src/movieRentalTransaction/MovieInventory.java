package movieRentalTransaction;

//Super-User class to organize movie inventory into a database
public class MovieInventory {

	private int movieID;
	private String movieName;
	private String movieGenre;
	private Double rentalCharge;
	private String synopsis;
	private MovieInventory link;
	
	// Default constructor
	MovieInventory() {}
	
	// Constructor
	MovieInventory(int id, String name, String genre, double charge, String description, MovieInventory link) {	
		movieID = id;
		movieName = name;
		movieGenre = genre;
		rentalCharge = charge;
		synopsis = description;
		this.link = link;
	}
	
	// Getters and Setters
	public int getMovieID() {
		return movieID;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public Double getRentalCharge() {
		return rentalCharge;
	}

	public String getSynopsis() {
		return synopsis;
	}
	
	public MovieInventory getLink() {
		return link;
	}
	
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public void setRentalCharge(Double rentalCharge) {
		this.rentalCharge = rentalCharge;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public void setLink(MovieInventory link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "HorrorMovie [movieName=" + movieName + ", movieGenre=" + movieGenre + ", rentalCharge=" + rentalCharge
				+ ", synopsis=" + synopsis + "]";
	}
} // end Class

