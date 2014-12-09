package genieprojet.annuaire;

import java.io.Serializable;

/**
 * Created by coylter on 11/11/2014.
 */
public abstract class Utilisateur implements Serializable{

    private String ID;
    private String nom;
    private String prenom;
    private String password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public abstract int getNiveauAcces();

    public abstract String getNiveauString();
}
