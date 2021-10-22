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
		//Axe d'amelioration => Faire les conversions si les UOM sont différentes
		if (t.getUOM() == this.getUOM()) {
			return this.getValue() < t.getValue();
		}
		return false;
	}
	
	
	
	
}
