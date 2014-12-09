package genieprojet.aspects;

import javax.swing.JOptionPane;

import genieprojet.Session;
import genieprojet.gui.ConnexionUI;

public aspect Authentification {
		pointcut verificationPrepose():
			call(void genieprojet.controleurs.PortailControleur.authenticateVente()) ||
			call(void genieprojet.controleurs.PortailControleur.authenticateAnnuaire());
		
		pointcut verificationDirecteur():
			call(void genieprojet.controleurs.PortailControleur.authenticateUsers()) ||
			call(void genieprojet.controleurs.PortailControleur.authenticateCatalogue());
		
		
		void around(): verificationPrepose()
		{
			if (Session.getInstance().getNiveauAcces() < 1)
			{	
				System.out.println("Erreur, vous devez d'abord vous connecter au systeme.");
				ConnexionUI ui = new ConnexionUI();
				 ui.setVisible(true);
				return;	
			}		
			proceed();
		}
		
		void around(): verificationDirecteur()
		{
			int niveau = Session.getInstance().getNiveauAcces();
			if (niveau < 1)
			{	
				System.out.println("Erreur, vous devez d'abord vous connecter au systeme.");
				ConnexionUI ui = new ConnexionUI();
				ui.setVisible(true);
				return;	
			} else if(niveau == 1){
				JOptionPane.showMessageDialog(null, "Erreur, les preposes n'ont pas acces a cette fonctionnalite.", "Erreur",
	                    JOptionPane.ERROR_MESSAGE);
				return;
			}
			proceed();
		}
}
