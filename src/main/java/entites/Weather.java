package entites;

import java.util.Date;

import javax.validation.constraints.NotNull;

import dataTypes.QualiteAir;
import dataTypes.Temperature;
import dataTypes.VitesseVent;

public class Weather {
	@NotNull
	final private Temperature temperature;
	@NotNull
	final private QualiteAir air;
	
	@NotNull
	final private VitesseVent vent;
	@NotNull
	final private Date date;


	// Le lieu est cr�� dans l'application, puisqu'il peut �tre r�utilisable dans
	// d'autres "weather"
	// Temp�rature et VitesseVent ont besoin d'�tre cr�� ds l'appli pour la
	// s�lection de l'UOM
	// Qualit� d'air, peu importe, mais par coh�rence, lui aussi
	// Le weather est cr�� au moment d'enregistrement dc new Date()
	public Weather(Temperature temp, QualiteAir air, VitesseVent vent, Date d) {
		this.date = d;
		this.temperature = temp;
		this.air = air;
		this.vent = vent;


	}

	@Override
	public String toString() {
		String s = "A la date du " + date.toString() + ", il fait " + temperature.toString()
				+ ", avec une qualité d'air de " + air.toString() + " et un vent soufflant à " + vent.toString() + ".";

		return s;
	}
	public Temperature getTemperature() {
		return temperature;
	}

	public QualiteAir getAir() {
		return air;
	}

	public VitesseVent getVent() {
		return vent;
	}

	public Date getDate() {
		return date;
	}


}
