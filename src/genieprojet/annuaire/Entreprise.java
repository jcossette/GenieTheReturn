package genieprojet.annuaire;

import java.io.Serializable;

public class Entreprise extends Client implements Serializable{

    private String nomResponsable;

    public Entreprise(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    @Override
    public void setNom2(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    @Override
    public String getPrenom() {
        return nomResponsable;
    }

    @Override
    public String getType() {
        return "Entreprise";
    }

    @Override
    public String getAge() {
        return "";
    }
    
    @Override
    public String toString() {
        return getType() + " - " + getNom();
    }
}
