package dataTypes;

public final class Login {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	final static private String regex = "[A-Za-z]{5,25}";
	final private String value;
	
	public Login(String val) {
		//assert(val.length()<=25 && val.length() >= 5);
		assert(val.matches(regex));
		value = val;
	}

	@Override
	public String toString() {
		return value;
	}
	
}
