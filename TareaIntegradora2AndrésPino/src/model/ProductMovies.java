package model;

public class ProductMovies {
    private String movieDate;
    private String movieTitle;
    private String productorName;
    private String trailer;
    private String director;
    private String sinopsis;
    private TypeMovie typeMovie;
    public int minAge;

    public ProductMovies(String movieDate, String movieTitle, String director, String sinopsis, String productorName,
            String trailer, TypeMovie typeMovie, int minAge) {
        this.director = director;
        this.sinopsis = sinopsis;
        this.movieDate = movieDate;
        this.movieTitle = movieTitle;
        this.productorName = productorName;
        this.trailer = trailer;
        this.setTypeMovie(typeMovie);
        this.minAge = minAge;
    }

    public TypeMovie getTypeMovie() {
        return typeMovie;
    }

    public void setTypeMovie(TypeMovie typeMovie) {
        this.typeMovie = typeMovie;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}