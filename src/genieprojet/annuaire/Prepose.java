package genieprojet.annuaire;

import java.io.Serializable;

/**
 * Created by coylter on 11/11/2014.
 */
public class Prepose extends Utilisateur implements Serializable{

    private int NIVEAUACCES = 1;

    public Prepose() {

    }

    public String getNomRole() {
        return "Préposé";
    }

    @Override
    public int getNiveauAcces() {
        return NIVEAUACCES;
    }

    @Override
    public String getNiveauString() {
        return "Prepose";
    }
}
