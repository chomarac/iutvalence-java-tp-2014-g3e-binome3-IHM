package fr.iutvalence.java.morpion.vues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Modélisation d'une vue.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public class VueConsoleSimple implements VueConsole
{
	/** Noms par défaut des différents joueurs. */
	private static final String[] JOUEURS_PAR_DEFAUT = { "Joueur 1", "Joueur 2" };

	/** Flux d'entré au clavier dans la console. */
	private BufferedReader entreeConsole;

	/** Modélisation d'un flux d'entrée. */
	public VueConsoleSimple()
	{
		this.entreeConsole = new BufferedReader(new InputStreamReader(System.in));
	}

	public String[] demanderNomsJoueurs()
	{
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix;
			try
			{
				choix = this.entreeConsole.readLine();
				if ("N".equals(choix))
					return JOUEURS_PAR_DEFAUT;

				if ("O".equals(choix))
				{
					while (true)
					{
						String namePlayer2, namePlayer1;

						System.out.println("Veuillez entrer le nom du joueur 1 : ");
						namePlayer1 = this.entreeConsole.readLine();
						System.out.println("Veuillez entrer le nom du joueur 2 : ");
						namePlayer2 = this.entreeConsole.readLine();
						if (namePlayer1.equals(namePlayer2))
							System.out.println("Veuillez saisir des noms différents.\n");
						else
							return new String[] { namePlayer1, namePlayer2 };
					}
				}
				System.out.println("Veuillez saisir une lettre valide.\n");
			}
			catch (IOException e)
			{
				System.out.println("La lettre saisie n'est pas valide. \n");
			}
		}
	}

	public void debuterUnTour(String nomJoueur, String symboleJoueur)
	{
		System.out.printf("\nC'est à %s de jouer (pion : %s)%n", nomJoueur, symboleJoueur);
	}

	public void afficherPlateauCourant(String plateauAsciiArt)
	{
		System.out.println(plateauAsciiArt);
	}

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
				if (ligne == null)
					// Indique une fermeture de l'entrée standard. Sans doute une fin de partie brutale.
					throw new Exception("ligne == null");

				choix1 = Integer.parseInt(ligne);

				System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
				ligne = this.entreeConsole.readLine();
				if (ligne == null)
					// Indique une fermeture de l'entrée standard. Sans doute une fin de partie brutale.
					throw new Exception("ligne == null");

				choix2 = Integer.parseInt(ligne);
				break;
			}
			catch (Exception e)
			{
				System.out.println("Les valeurs saisies ne sont pas des entiers.\n");
			}
		}

		return new int[] { choix1, choix2 };
	}

	public void afficherVainqueur(final String vainqueur)
	{
		System.out.printf("La partie est remportée par %s%n", vainqueur);
	}

	public void afficherPartieNulle()
	{
		System.out.println("\nPartie nulle. Il n'y a pas de vainqueur.");
	}

	public boolean choixRejouer()
	{
		while (true)
		{
			try
			{
				System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
				String reponse = this.entreeConsole.readLine();

				if ("O".equals(reponse))
					return true;

				if ("N".equals(reponse))
				{
					quitter();
					return false;
				}
				System.out.println("Veuillez saisir une lettre valide.\n");
			}
			catch (Exception e)
			{
				System.out.println("La lettre saisie n'est pas valide. \n");
			}
		}
	}

	public void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}

	public void mauvaisesCoordonnees()
	{
		System.out.println("\nLes coordonnées ne sont pas comprises entre 1 et 3.");
	}

	public void coordonneesDejaPrise()
	{
		System.out.println("\nLes coordonnées saisies sont déjà prises, veuillez en saisir des différentes.");
	}
}
