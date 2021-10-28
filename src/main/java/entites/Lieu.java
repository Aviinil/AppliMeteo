package entites;

import java.util.Date;
import java.util.HashMap;

import javax.validation.constraints.NotNull;

import dataTypes.CodePostal;
import dataTypes.NomVille;

public class Lieu {
	
	static int compteur = 0;
	@NotNull
	final private int id;
	@NotNull
	final private NomVille nom;
	@NotNull
	final private CodePostal codePostal;
	final private double latitude;
	final private double longitude;
	private HashMap<Date, Weather> weathers;
	
	public Lieu(String nomVille, int codePostal, double lat, double lon) {
		this.id = ++compteur;
		this.nom = new NomVille(nomVille);
		this.codePostal = new CodePostal(codePostal);
		this.latitude = lat;
		this.longitude = lon;
		weathers = new HashMap<>();

	}

	@Override
	public String toString() {
		return  nom.getNom() + " (" + codePostal.getCode()+")";
	}

	public int getId() {
		return id;
	}
	
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public HashMap<Date,Weather> getWeathers() {
		return weathers;
	}

	public void addWeather(Weather w) {
		weathers.put(w.getDate(), w);
	}
	
	public void deleteWeather() {
		//todo
	}
}
