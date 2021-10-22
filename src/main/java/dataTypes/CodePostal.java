package dataTypes;

import javax.validation.constraints.*;

public final class CodePostal {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	@Min(01000)
	@Max(99999)
	@NotNull
	final private int code;
	
	public CodePostal(int code) {
		assert(code<99999 && code > 1000);
		this.code=code;
	}

	public String getCode() {
		if (code < 9999) {
			//faire apparaitre le code postal avec 5 chiffres
			return "0"+code;
		} else
			return ""+code;
	}
	
}
