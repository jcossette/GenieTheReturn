package genieprojet;

import genieprojet.annuaire.Utilisateur;

public class Session {
	
	private static Session instance;
	private Utilisateur utilisateur;
	
	private Session() {}
	
	public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        } 
        return instance;
    }
	
	public void setUser(Utilisateur utilisateur){
		this.utilisateur = utilisateur;
	}
	
	public int getNiveauAcces(){
		if (utilisateur != null){
			return utilisateur.getNiveauAcces();
		} else {
			return -1;
		}
	}
}
