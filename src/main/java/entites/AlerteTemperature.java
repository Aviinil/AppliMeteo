package entites;

import java.util.Date;

import dataTypes.Temperature;

public class AlerteTemperature implements Alerte {

	private Temperature seuil;
	private Lieu lieu;
	
	public AlerteTemperature(Temperature temp, Lieu l ) {
		seuil = temp;
		lieu = l;
	}
	
	public boolean declencherAlerte(Date d) {
		//a affiner la date par jour et / ou heure
		if(lieu.getWeathers().containsKey(d)) {
			Weather w = lieu.getWeathers().get(d);
			
			return w.getTemperature().estInferieure(seuil);

		}
		return false;
		
	}

	public String toString() {
		return "Alerte enregistrée à " + lieu.toString() + " pour une température de " + seuil.toString();
	}
	
	public Lieu getLieu() {
		return lieu;
	}

}
