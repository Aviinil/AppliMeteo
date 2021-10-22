package dataTypes;

import javax.validation.constraints.*;

public final class QualiteAir {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	
	@Min(0)
	@Max(10)
	@NotNull
	final private int value;
	
	public QualiteAir(int value) {
		assert(value<=10 && value > 0);
		this.value=value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "" + value + "/10";
	}
	

}
