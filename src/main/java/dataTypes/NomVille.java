package dataTypes;


public final class NomVille {

	// Les records etant en preview pour Java, nous n'arrivions pas a en creer
	// Pour ne pas perdre de temps, nous avons fait des classes.
	final static private String regex = "[ A-Za-z'-]{1,60}";
	final private String nom;
	
	public NomVille(String nom) {
		assert(nom.matches(regex));
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}
	
}
