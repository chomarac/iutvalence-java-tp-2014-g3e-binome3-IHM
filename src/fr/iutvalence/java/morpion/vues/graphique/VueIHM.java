package fr.iutvalence.java.morpion.vues.graphique;

import javax.swing.JOptionPane;

import fr.iutvalence.java.morpion.modele.Joueurs;
import fr.iutvalence.java.morpion.modele.PlateauJeu;

/** Modélisation d'une vue.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0 */
public class VueIHM
{
	/** Noms par défaut des différents joueurs. */
    private static final String[] JOUEURS_PAR_DEFAUT = {"Joueur 1", "Joueur 2"};
	
	/** Demander aux utilisateurs si ils veulent changer le nom des joueurs.
	 *  
	 * @return Un tableau contenant les noms des joueurs. */
	public String[] demanderNomsJoueurs()
	{
		while (true)
		{
			String reponse = JOptionPane.showInputDialog(null, "Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)", "Modification nom des joueurs", JOptionPane.QUESTION_MESSAGE);
			if ("N".equals(reponse))
				return JOUEURS_PAR_DEFAUT;

			if ("O".equals(reponse))
			{
				while (true)
				{
					String joueur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le nom du joueur 1", "Modification nom des joueurs", JOptionPane.QUESTION_MESSAGE);
					String joueur2 = JOptionPane.showInputDialog(null, "Veuillez entrer le nom du joueur 2", "Modification nom des joueurs", JOptionPane.QUESTION_MESSAGE);

					if (joueur1.equals(joueur2))
						JOptionPane.showInputDialog(null, "Veuillez saisir des noms différents.", "Erreur", JOptionPane.ERROR_MESSAGE);
					else
						return new String[]{joueur1, joueur2};
				}
			}
			JOptionPane.showInputDialog(null, "Veuillez saisir une lettre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/** Demande des coordonnées au joueur.
	 * 
	 * @return Un tableau contenant les choix du joueur.*/
	public int[] choixCoordonnees()
	{
		String choixCoordonnee1, choixCoordonnee2;
		int coordonnee1, coordonnee2;
		
		while (true)
		{
			try
			{
				choixCoordonnee1 = JOptionPane.showInputDialog(null, "Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ", "Coordonnée 1", JOptionPane.QUESTION_MESSAGE);
				if (choixCoordonnee1 == null)
					throw new Exception();
				coordonnee1 = Integer.parseInt(choixCoordonnee1);
				
				choixCoordonnee2 = JOptionPane.showInputDialog(null, "Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ", "Coordonnée 2", JOptionPane.QUESTION_MESSAGE);
				if (choixCoordonnee2 == null)
					throw new Exception();
				coordonnee2 = Integer.parseInt(choixCoordonnee2);				
 				break;
			}
			catch (Exception e)
			{
				JOptionPane.showInputDialog(null, "Les valeurs saisies ne sont pas des entiers.", "Saisie invalide", JOptionPane.INFORMATION_MESSAGE);
			}
		}
        
        return new int[]{coordonnee1, coordonnee2};
	}
	
	/** On affiche quel joueur doit jouer son coup.
	 * 
	 * @param unJoueur Un joueur. */
	public void debuterUnTour(Joueurs unJoueur)
	{
		JOptionPane.showMessageDialog(null, "C'est à " + unJoueur.obtenirNomCourant() + " de jouer (pion : " + unJoueur.obtenirSymboleJoueur() + ")", "Joueur débutant", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** Afficher le plateau de jeu courant.
	 * 
	 * @param unPlateau Le plateau courant. */
	public void afficherPlateauCourant(PlateauJeu unPlateau)
	{
		System.out.println(unPlateau);
	}

    /** Message à afficher lorsqu'il y a un vainqueur.
	 * 
	 * @param vainqueur Contient le nom du vainqueur.*/
	public void afficherVainqueur(final String vainqueur)
	{
		JOptionPane.showMessageDialog(null, "La partie est remportée par " + vainqueur, "Victoire !", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** Permet d'afficher une partie nulle. */
	public void afficherPartieNulle()
	{
		JOptionPane.showInputDialog(null, "Partie nulle. Il n'y a pas de vainqueur.", "Partie nulle", JOptionPane.INFORMATION_MESSAGE);
	}
}
