package genieprojet.annuaire;

import java.io.Serializable;

/**
 * Created by coylter on 11/11/2014.
 */
public class Directeur extends Utilisateur implements Serializable{

    private int NIVEAUACCES = 3;

    public Directeur() {

    }

    public String getNomRole() {
        return "Directeur";
    }

    @Override
    public int getNiveauAcces() {
        return NIVEAUACCES;
    }

    @Override
    public String getNiveauString() {
        return "Directeur";
    }
}
