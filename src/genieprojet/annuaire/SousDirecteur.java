package genieprojet.annuaire;

import java.io.Serializable;

/**
 * Created by coylter on 11/11/2014.
 */
public class SousDirecteur extends Utilisateur implements Serializable{

    private int NIVEAUACCES = 2;

    public SousDirecteur() {

    }

    public String getNomRole() {
        return "Sous-Directeur";
    }

    @Override
    public int getNiveauAcces() {
        return NIVEAUACCES;
    }

    @Override
    public String getNiveauString() {
        return "Sous-directeur";
    }
}
