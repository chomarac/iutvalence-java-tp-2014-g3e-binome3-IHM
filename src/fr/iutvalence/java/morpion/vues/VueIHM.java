package fr.iutvalence.java.morpion.vues;

import java.util.Scanner;

import javax.swing.JOptionPane;

import fr.iutvalence.java.morpion.Joueurs;
import fr.iutvalence.java.morpion.PlateauJeu;

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
		final Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = scanner.nextLine();

			if ("N".equals(choix))
				return JOUEURS_PAR_DEFAUT;

			if ("O".equals(choix))
			{
				while (true)
				{
					System.out.println("Veuillez entrer le nom du joueur 1 : ");
					String namePlayer1 = scanner.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2 : ");
					String namePlayer2 = scanner.nextLine();

					if (namePlayer1.equals(namePlayer2))
						System.out.println("Veuillez saisir des noms différents.\n");
					else
						return new String[]{namePlayer1, namePlayer2};
				}
			}
			System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	public void choixCoordonnees()
	{
		String choixCoordonnee1 = JOptionPane.showInputDialog(null, "ID de l'employé : ", "Consultation", JOptionPane.QUESTION_MESSAGE);
		String choixCoordonnee2 = JOptionPane.showInputDialog(null, "Nom de l'employé : ", "Consultation", JOptionPane.QUESTION_MESSAGE);
	}
	/** On affiche quel joueur doit jouer son coup.
	 * 
	 * @param unJoueur Un joueur. */
	public void debuterUnTour(Joueurs unJoueur)
	{
		System.out.printf("\nC'est à %s de jouer (pion : %s)%n", unJoueur.obtenirNomCourant(), unJoueur.obtenirSymboleJoueur());
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
		System.out.printf("La partie est remportée par %s%n", vainqueur);
	}
	
	/** Permet d'afficher une partie nulle. */
	public void afficherPartieNulle()
	{
		System.out.println("\nPartie nulle. Il n'y a pas de vainqueur.");
	}
}
