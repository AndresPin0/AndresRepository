package model;

public class GestorSeries {
	private int cont;
	private GestorSeries[] productSeries;

	public GestorSeries() {
		cont = 0;
		productSeries = new GestorSeries[85];

	}

	public boolean checkSpace() {
		if (cont < 85) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkName(String seriesName) {
		if (cont != 0) {
			for (int i = 0; i < cont; i++) {
				if (seriesName.equals(productSeries[i].getSeriesName())) {
					return false;
				}
			}
		}
		return true;
	}

	public int getAmountSeries() {
		return cont;
	}

	public void addSeries(String seriesName, String firstEmision, String nameProtagonist, String director,
			String sinopsis, String censoredOrNo) {
		productSeries[cont] = new GestorSeries();
		System.out.println(productSeries.length);
		cont++;
	}
}
