package genieprojet.controleurs;

import genieprojet.annuaire.Adresse;
import genieprojet.annuaire.Annuaire;
import genieprojet.annuaire.Client;
import genieprojet.annuaire.Utilisateur;
import genieprojet.system.DBManager;
import java.util.ArrayList;
import genieprojet.util.Observable;

/**
 *
 * @author Benoit
 */
public class AnnuaireControleur extends Observable{

    Annuaire annuaire;

    public AnnuaireControleur() {
        this.annuaire = Annuaire.getInstance();
    }

    public void ajouterClient(String type, String nom, String nom2, Adresse adresse, String codePostal, String numTel, String age) {
        annuaire.ajouterClient(type, nom, nom2, adresse, codePostal, numTel, age);
        saveAnnuaire();
        notifier();
    }
    
    public void saveClient(Client toSave, String newNom, String newNom2, Adresse newAdresse, String newCodePostal, String newNumTel, String newAge){
        annuaire.saveClient(toSave, newNom, newNom2, newAdresse, newCodePostal, newNumTel, newAge);
        saveAnnuaire();
        notifier();
    }

    public void retirerClient(String ID) {
        annuaire.retirerClient(ID);
        saveAnnuaire();
        notifier();
    }

    public void ajouterUtilisateur(String niveau, String nom, String prenom) {
        annuaire.ajouterUtilisateur(niveau, nom, prenom);
        saveAnnuaire();
        notifier();
    }
    
    public void saveUtilisateur(Utilisateur toSave, String newNiveau, String newNom, String newPrenom){
        annuaire.saveUtilisateur(toSave, newNiveau, newNom, newPrenom);
        saveAnnuaire();
        notifier();
    }

    public void retirerUtilisateur(String ID) {
        annuaire.retirerUtilisateur(ID);
        saveAnnuaire();
        notifier();
    }

    public ArrayList<Client> getAllClients() {
        return annuaire.getAllClients();
    }

    public ArrayList<Utilisateur> getAllUsers() {
        return annuaire.getAllUsers();
    }

    public Client getClient(String ID) {
        return annuaire.getClient(ID);
    }

    public Utilisateur getUser(String ID) {
        return annuaire.getUser(ID);
    }
    
    public ArrayList<Client> findClients(String toSearch){
        return annuaire.findClients(toSearch);
    }
    
    public ArrayList<Utilisateur> findUsers(String toSearch){
        return annuaire.findUsers(toSearch);
    }
    
    public void saveAnnuaire() {
        DBManager.getInstance().saveAnnuaire(annuaire);
    }
}
