package dataTypes;

public final class MDP {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	final static private String regex ="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

	//Il devrait y avoir d'autres méthodes plus tard pour comparer le MDP lors d'une connexion.
	@SuppressWarnings("unused")
	final private String value;
	

	
	public MDP(String val) {
		
		assert(val.matches(regex));
		value = val;
	}
	

	
}
