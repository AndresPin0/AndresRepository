package model;

public class GestorMovies {
	private int cont;
	private GestorMovies[] productMovies;

	public GestorMovies() {
		cont = 0;
		productMovies = new GestorMovies[85];
	}

	public boolean checkSpace() {
		if (cont < 50) {
			return true;
		} else {
			return false;
		}
	}

	public void addMovie(String movieDate, String movieTitle, String director, String sinopsis, String productorName,
			String trailer, TypeMovie typeMovie, int minAge) {
		productMovies[cont] = new GestorMovies();
		cont++;
	}

	public int getAmountMovies() {
		return cont;
	}

	public GestorMovies[] getAllMovies() {
		return productMovies;
	}
	/*
	 * public void moviesList(){ for(GestorMovies productMovies1 : productMovies){
	 * if(productMovies1 != null){ System.out.println("\nThe date is: " +
	 * productMovies1.movieDate + "\nThe title is: " + productMovies1.getMovieTitle;
	 * } } }
	 */
}