package entites;

import java.util.Date;

import dataTypes.VitesseVent;

public class AlerteVent implements Alerte {

	private VitesseVent seuil;
	private Lieu lieu;

	public AlerteVent(VitesseVent v, Lieu l) {
		seuil = v;
		lieu = l;
	}

	@Override
	public boolean declencherAlerte(Date d) {
		// a affiner la date par jour et / ou heure
		if (lieu.getWeathers().containsKey(d)) {
			Weather w = lieu.getWeathers().get(d);

			return w.getVent().estSupérieur(seuil);

		}
		return false;
	}

	public String toString() {
		return "Alerte pour une vitesse de vent de " + seuil.toString();
	}

	@Override
	public Lieu getLieu() {
		return lieu;
	}

}
