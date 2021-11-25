package dataTypes;

import javax.validation.constraints.NotNull;

public final class VitesseVent {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	@NotNull
	final private double value;
	@NotNull
	final private UOMWind UOM;

	public VitesseVent(double value, UOMWind UOM) {
		if (UOM.equals(UOMWind.KM_H)) {
			assert (value > 0.0 && value < 450.0);
		} else if (UOM.equals(UOMWind.MILES_H)) {
			assert (value > 0.0 && value < 280.0);
		} else if (UOM.equals(UOMWind.NOEUDS)) {
			assert (value > 0.0 && value < 243.0);
		}

		this.value = value;
		this.UOM = UOM;
	}

	public double getValue() {
		return value;
	}

	public UOMWind getUOM() {
		return UOM;
	}

	@Override
	public String toString() {
		String uom;
		switch (UOM) {
		case KM_H:
			uom = " km/h";
			break;
		case MILES_H:
			uom = " miles/h";
			break;
		case NOEUDS:
			uom = " noeuds";
			break;
		default:
			uom = "erreur";
		}
		return value + uom;
	}

	public boolean estSupérieur(VitesseVent v) {
		return this.getValue() > v.convertWind(this.getUOM());
	}

	public double convertWind(UOMWind voulu) {
		if (voulu.equals(UOMWind.KM_H)) {
			return this.convertToKMH();
		} else if (voulu.equals(UOMWind.MILES_H)) {
			return this.convertToMilesH();
		} else {
			return this.convertToNoeuds();
		}
	}

	public double convertToKMH() {
		if (this.getUOM().equals(UOMWind.MILES_H)) {
			return this.getValue() * 1.609;
		} else if (this.getUOM().equals(UOMWind.NOEUDS)) {
			return this.getValue() * 1.852;
		} else {
			return this.getValue();
		}
	}

	public double convertToMilesH() {
		if (this.getUOM().equals(UOMWind.KM_H)) {
			return this.getValue() / 1.609;
		} else if (this.getUOM().equals(UOMWind.NOEUDS)) {
			return this.getValue() * 1.151;
		} else {
			return this.getValue();
		}
	}

	public double convertToNoeuds() {
		if (this.getUOM().equals(UOMWind.KM_H)) {
			return this.getValue() / 1.852;
		} else if (this.getUOM().equals(UOMWind.MILES_H)) {
			return this.getValue() / 1.151;
		} else {
			return this.getValue();
		}
	}

}
