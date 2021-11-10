package model;

public class ProductSeries {
	private String seriesName;
	private String firstEmision;
	private String nameProtagonist;
	private String director;
	private String sinopsis;
	private String censoredOrNo;

	public ProductSeries(String seriesName, String firstEmision, String nameProtagonist, String director,
			String sinopsis, String censoredOrNo) {
		this.seriesName = seriesName;
		this.firstEmision = firstEmision;
		this.nameProtagonist = nameProtagonist;
		this.director = director;
		this.sinopsis = sinopsis;
		this.censoredOrNo = censoredOrNo;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setFirstEmision(String firstEmision) {
		this.firstEmision = firstEmision;
	}

	public String getFirstEmision() {
		return firstEmision;
	}

	public void setNameProtagonist(String nameProtagonist) {
		this.nameProtagonist = nameProtagonist;
	}

	public String getNameProtagonist() {
		return nameProtagonist;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setCensoredOrNo(String censoredOrNo) {
		this.censoredOrNo = censoredOrNo;
	}

	public String getCensoredOrNo() {
		return censoredOrNo;
	}

}