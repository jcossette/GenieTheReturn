package genieprojet.annuaire;

import java.io.Serializable;

public enum TrancheAge implements Serializable{

    ENFANT(18),
    ADULTE(60),
    VIELLARD(150);

    int ageMaximum;

    TrancheAge(int ageMaximum) {
        this.ageMaximum = ageMaximum;
    }

    public int getAge() {
        return ageMaximum;
    }
}
