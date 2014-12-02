package genieprojet.system;

import genieprojet.annuaire.Annuaire;
import genieprojet.vente.Catalogue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Julien Cossette
 */
public class DBManager {

    private static DBManager instance;

    private DBManager() {

    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
            return instance;
        } else {
            return instance;
        }
    }

    public void saveCatalogue(Catalogue toSave) {
        try {
            FileOutputStream myOutputStream = new FileOutputStream("simulatedCatalogue.db");
            ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myOutputStream);
            myObjectOutputStream.writeObject(toSave);
            myObjectOutputStream.close();
            myOutputStream.close();
        } catch (IOException ie) {
            System.out.println("Error outputing DB save file: " + ie.getMessage());
        }
    }

    public Catalogue loadCatalogue() {
        Catalogue toReturn = null;
        try {
            FileInputStream myInputStream = new FileInputStream("simulatedCatalogue.db");
            ObjectInputStream myObjectInputStream = new ObjectInputStream(myInputStream);
            toReturn = (Catalogue) myObjectInputStream.readObject();
            myObjectInputStream.close();
            myInputStream.close();
        } catch (IOException ie) {
            System.out.println("Error loading DB save file.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found.");
        }
        return toReturn;
    }
    
    public void saveAnnuaire(Annuaire toSave) {
        try {
            FileOutputStream myOutputStream = new FileOutputStream("simulatedAnnuaire.db");
            ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myOutputStream);
            myObjectOutputStream.writeObject(toSave);
            myObjectOutputStream.close();
            myOutputStream.close();
        } catch (IOException ie) {
            System.out.println("Error outputing DB save file: " + ie.getMessage());
        }
    }

    public Annuaire loadAnnuaire() {
        Annuaire toReturn = null;
        try {
            FileInputStream myInputStream = new FileInputStream("simulatedAnnuaire.db");
            ObjectInputStream myObjectInputStream = new ObjectInputStream(myInputStream);
            toReturn = (Annuaire) myObjectInputStream.readObject();
            myObjectInputStream.close();
            myInputStream.close();
        } catch (IOException ie) {
            System.out.println("Error loading DB save file.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found.");
        }
        return toReturn;
    }
}
