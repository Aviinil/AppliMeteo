package dataTypes;

import javax.validation.constraints.NotNull;

public final class Temperature {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	
	@NotNull
	final private double value;
	@NotNull
	final private UOMTemp UOM;
	
	public Temperature(double value, UOMTemp UOM) {
		if(UOM.equals(UOMTemp.CELSIUS)) {
			assert(value < 65.0 && value > -100.0);
		} else if (UOM.equals(UOMTemp.FAHRENHEIT)) {
			assert(value < 149.0 && value > -148.0);
		} else if (UOM.equals(UOMTemp.KELVIN)) {
			assert(value < 338.15 && value > 173.15);
		}
		this.value = value;
		this.UOM = UOM;
	}

	public double getValue() {
		return value;
	}


	public UOMTemp getUOM() {
		return UOM;
	}

	@Override
	public String toString() {
		String uom;
		switch (UOM) {
			case CELSIUS:
				uom = " °C";
				break;
			case FAHRENHEIT:
				uom = " °F";
				break;
			case KELVIN:
				uom = " K";
				break;
			default: uom ="erreur";
		}
		return value + uom;
	}
	
	public boolean estInferieure(Temperature t) {
		
		return this.getValue() < t.convertTemp(this.getUOM());
	}
	public double convertTemp(UOMTemp voulu) {
		if (voulu.equals(UOMTemp.CELSIUS)) {
			return this.convertToCelsius();
		} else if (voulu.equals(UOMTemp.FAHRENHEIT)) {
			return this.convertToFahrenheit();
		} else {
			return this.convertToKelvin();
		}

	}
	
	public double convertToCelsius() {
		if (this.getUOM().equals(UOMTemp.FAHRENHEIT)) {
			return (this.getValue()-32) /1.8;
		} else if (this.getUOM().equals(UOMTemp.KELVIN)) {
			return this.getValue() - 273.15;
		} else {
			return this.getValue();
		}
	}
	
	public double convertToFahrenheit() {
		if (this.getUOM().equals(UOMTemp.CELSIUS)) {
			return this.getValue()*1.8+32;
		} else if (this.getUOM().equals(UOMTemp.KELVIN)) {
			return (this.getValue() - 273.15)*1.8+32;
		} else {
			return this.getValue();
		}
	}
	
	public double convertToKelvin() {
		if (this.getUOM().equals(UOMTemp.FAHRENHEIT)) {
			return ((this.getValue()-32) /1.8)+273.15;
		} else if (this.getUOM().equals(UOMTemp.CELSIUS)) {
			return (this.getValue()-32) /1.8;
		} else {
			return this.getValue();
		}
	}
}
