package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataTypes.QualiteAir;
import dataTypes.Temperature;
import dataTypes.UOMTemp;
import dataTypes.UOMWind;
import dataTypes.VitesseVent;
import entites.Alerte;
import entites.AlerteTemperature;
import entites.AlerteVent;
import entites.Lieu;
import entites.Utilisateur;
import entites.Weather;

public class Application {

	//pour faire fonctionner les assertions présentes en tant que contraintes
	//il faut bien ajouter -ea (enable assertions) à l'execution.
	
	public static void main (String[] args) throws ParseException {
		Utilisateur user = new Utilisateur("Melissa", "aaZZa44@E");
		System.out.println(user.getLogin());
		
		Lieu Besancon = new Lieu("Besancon", 25000, 47.237829, 6.0240539);
		user.ajoutPref(Besancon);
		Temperature tempAlerte = new Temperature(0.0, UOMTemp.CELSIUS);
		Alerte alerte = new AlerteTemperature(tempAlerte, Besancon);
		user.ajoutAlerte(alerte);
		VitesseVent ventAlerte = new VitesseVent(20, UOMWind.NOEUDS); //37km/h (pour déclencher)
		alerte = new AlerteVent(ventAlerte, Besancon);
		user.ajoutAlerte(alerte);
		user.getAlertes().forEach((a) -> System.out.println(a.toString()));

		
		//Temperature tempBesac = new Temperature(-5.0, UOMTemp.CELSIUS);
		Temperature tempBesac = new Temperature(28.0, UOMTemp.FAHRENHEIT);
		QualiteAir qualiBesac = new QualiteAir(4);
		VitesseVent ventBesac = new VitesseVent(48.0, UOMWind.KM_H);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = "22/10/2021";
		Date dateBesac = sdf.parse(date);
		
		Weather w = new Weather(tempBesac, qualiBesac, ventBesac, dateBesac);
		Besancon.addWeather(w);
		
		Besancon.getWeathers().forEach((k,weather) -> System.out.println(weather.toString()));
		//Si la date est changée, l'alerte ne se déclenche pas (ce qui est logique)
		//date = "24/10/2021";
		Date dateActuelle = sdf.parse(date);
		for(Alerte a : user.getAlertes()) {
			if(a.declencherAlerte(dateActuelle)) {
				//Alerte sur temperature se déclenche si la tempéature de la ville est inférieure au seuil
				//ALerte sur vitesse du vent se déclenche si la vitesse du vent dans la ville est supérieur au seuil
				System.out.println(a.toString()+ " déclenchée à " + a.getLieu().toString());
			}
		}

	}
}
