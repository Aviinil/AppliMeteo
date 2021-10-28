package entites;

import java.util.ArrayList;

import dataTypes.Login;
import dataTypes.MDP;

public class Utilisateur {

	
	private final Login login;
	private MDP mdp;

	private ArrayList<Lieu> prefs;
	private ArrayList<Alerte> alertes;

	
	public Utilisateur(String login, String mdp) {
		this.login= new Login(login);
		this.mdp = new MDP(mdp);
		prefs = new ArrayList<>();
		alertes = new ArrayList<>();
	}
	
	
	public Login getLogin() {
		return login;
	}
	
	public void setMdp(String mdp) {
		this.mdp = new MDP(mdp);
	}
	
	public void ajoutPref(Lieu l) {
		prefs.add(l);
	}
	
	public ArrayList<Lieu> getPreferences() {
		return prefs;
	}
	
	public void ajoutAlerte(Alerte a) {
		alertes.add(a);
	}
	
	public ArrayList<Alerte> getAlertes() {
		return alertes;
	}

	public MDP getMdp() {
		return mdp;
	}



	
	
}
