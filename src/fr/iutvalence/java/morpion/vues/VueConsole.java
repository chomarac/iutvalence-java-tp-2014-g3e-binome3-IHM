package fr.iutvalence.java.morpion.vues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/** Modélisation d'une vue.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0 */
public class VueConsole
{
	/** Noms par défaut des différents joueurs. */
    private static final String[] JOUEURS_PAR_DEFAUT = {"Joueur 1", "Joueur 2"};

    /** Flux d'entré au clavier dans la console. */
    private BufferedReader entreeConsole;

    /** Modélisation d'un flux d'entrée. */
    public VueConsole()
    {
        this.entreeConsole = new BufferedReader(new InputStreamReader(System.in));
    }

    /** Demander aux utilisateurs si ils veulent changer le nom des joueurs.
     *
     * @return Un tableau contenant les noms des joueurs. */
    public String[] demanderNomsJoueurs()
    {
        // TODO Scanner -> entreeConsole
        final Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
            String choix = scanner.nextLine();

            if ("N".equals(choix)) return JOUEURS_PAR_DEFAUT;

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

	/** On affiche quel joueur doit jouer son coup.
	 * 
	 * @param nomJoueur Le nom du joueur.
	 * @param symboleJoueur Le symbole du joueur. */
	public void debuterUnTour(String nomJoueur, String symboleJoueur)
	{
		System.out.printf("\nC'est à %s de jouer (pion : %s)%n", nomJoueur, symboleJoueur);
	}

	/** Afficher le plateau de jeu courant.
	 * 
	 * @param plateauAsciiArt Le plateau courant au format texte. */
	public void afficherPlateauCourant(String plateauAsciiArt)
	{
		System.out.println(plateauAsciiArt);
	}

    /** Permet de demander la première coordonnée au joueur courant.
     * 
     * @return Un tableau contenant les choix du joueur. */
	public int[] demanderCoordonnees()
	{
		int choix1, choix2;
		String ligne = null;
		while (true)
		{
			try
			{
				System.out.print("Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ");
				ligne = this.entreeConsole.readLine();
				if (ligne == null) {
                    // Indique une fermeture de l'entrée standard. Sans doute une fin de partie brutale.
                    throw new IOException("ligne == null");
                }
				choix1 = Integer.parseInt(ligne);

				System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
				ligne = this.entreeConsole.readLine();
                if (ligne == null) {
                    // Indique une fermeture de l'entrée standard. Sans doute une fin de partie brutale.
                    throw new IOException("ligne == null");
                }
                choix2 = Integer.parseInt(ligne);
 				break;
			}
            catch (NumberFormatException e) {
				System.out.println("Les valeurs saisies ne sont pas des entiers.\n\n");
			}
            catch (IOException e) {
                /* TODO À reprendre mieux. Peut-être propager au dessus pour que le contrôleur ferme tout correctement. */
                System.out.println("Fin de la partie demandée…");
                System.exit(-1);
            }
        }

        return new int[]{choix1, choix2};
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
	
	/** Permet de demander aux joueurs si ils veulent rejouer une partie.
	 * 
	 * @return true si le joueur veut rejouer une partie, false sinon. */
	public boolean choixRejouer()
	{
        /* TODO Scanner -> entreeConsole */
        Scanner choixDePoursuite = new Scanner(System.in);
        while (true)
		{		
			System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
			String reponse = choixDePoursuite.nextLine();

			if ("O".equals(reponse))
				return true;

            if ("N".equals(reponse))
			{
			    VueConsole.quitter();
				return false;
			}

			System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}

	/** Message à afficher lorsqu'on quitte l'application. */
	private static void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}
}
