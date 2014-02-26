package fr.iutvalence.java.morpion;

import java.util.Scanner;

/**
 * Modélisation d'un dialogue avec l'utilisateur pour déterminer les noms des joueurs.
 */
public class GestionDesJoueurs
{
	/**
	 * Le nom par défaut du joueur 1
	 */
	private static final String PLAYER1 = "Joueur 1";
	
	/**
	 * Le nom par défaut du joueur 2
	 */
	private static final String PLAYER2 = "Joueur 2";
	
	/**
	 * La signature par défaut du joueur 1
	 */
	private static final int SIGNATURE1 = 5;
	
	/**
	 * La signature par défaut du joueur 2
	 */
	private static final int SIGNATURE2 = - SIGNATURE1;

	public GestionDesJoueurs() {
		// A terme mettre historique, etc...
	}
	
	/**
	 * Lance le menu qui permet de demander le choix de l'utilisateur concencernant le choix des joueurs
	 */
	public void demanderJoueurs()
	{
		Scanner recuperationInformation = new Scanner(System.in);

		Joueurs player1 = null;
		Joueurs player2 = null;
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = recuperationInformation.nextLine();

			if ("N".equals(choix))
			{
				player1 = new Joueurs(PLAYER1, SIGNATURE1);
				player2 = new Joueurs(PLAYER2, SIGNATURE2);
				break;
			}

			if ("O".equals(choix))
			{
				while (player1 == player2)
				{
					System.out.println("Veuillez entrer le nom du joueur 1 : ");
					String namePlayer1 = recuperationInformation.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2 : ");
					String namePlayer2 = recuperationInformation.nextLine();

					if (namePlayer1.equals(namePlayer2))
					{
						System.out.println("Veuillez saisir des noms différents");
					} else
					{
						player1 = new Joueurs(namePlayer1, SIGNATURE1);
						player2 = new Joueurs(namePlayer2, SIGNATURE2);
					}
				}
				break;
			}
			System.out.println("Veuillez saisir une lettre valide");
		}
	}
}