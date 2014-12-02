package genieprojet.annuaire;

import java.io.Serializable;

public class Personne extends Client implements Serializable{

    private String prenom;
    private TrancheAge tranche;

    public Personne(String prenom, int age) {
        this.prenom = prenom;

        setTrancheAge(age);
    }

    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public void setNom2(String prenom) {
        this.prenom = prenom;
    }

    public void setTrancheAge(int age) {
        if (age < 18) {
            tranche = TrancheAge.ENFANT;
        } else if (age < 60) {
            tranche = TrancheAge.ADULTE;
        } else {
            tranche = TrancheAge.VIELLARD;
        }
    }

    @Override
    public String getType() {
        return "Particulier";
    }

    @Override
    public String getAge() {
        return tranche.toString();
    }
    
    @Override
    public String toString() {
        return getType() + " - " + getPrenom() + " " + getNom();
    }
}
