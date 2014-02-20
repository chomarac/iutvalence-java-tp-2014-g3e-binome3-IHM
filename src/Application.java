import java.util.Scanner;

import javax.swing.JFrame;

/**
 * Classe Application
 * @author Loic
 *
 */
public class Application {
	
	/**
	 * Le nom par défaut du joueur 1
	 */
	private static final String PLAYER1 = "Joueur 1";
	
	/**
	 * Le nom par défaut du joueur 2
	 */
	private static final String PLAYER2 = "Joueur 2";
	
	/**
	 * Le nom du joueur 1 choisi par l'utilisateur
	 */
	private static String namePlayer1;
	
	/**
	 * Le nom du joueur 2 choisi par l'utilisateur
	 */
	private static String namePlayer2;

	/**
	 * La signature par défaut du joueur 1
	 */
	private static final int SIGNATURE1 = 5;
	
	/**
	 * La signature par défaut du joueur 2
	 */
	private static final int SIGNATURE2 = - SIGNATURE1;
	
	/**
	 * Permet de vérifier les choix des noms des joueurs par l'utilisateur
	 */
	private static boolean choiceOfPlayer = false;
	
	private static Joueurs player1;
	
	private static Joueurs player2;

	
	/**
	 * Permet de lancer le jeu
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner recuperationInformation = new Scanner(System.in);
		//// Choix des noms ////
		do {
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = recuperationInformation.nextLine();
			
			if (choix.equals("N"))
			{
				player1 = new Joueurs(PLAYER1, SIGNATURE1);
				player2 = new Joueurs(PLAYER2, SIGNATURE2);
				choiceOfPlayer = true;
			}
			
			else
			{
				if (choix.equals("O"))
				{
					do {
						
						System.out.println("Veuillez entrer le nom du joueur 1 : ");
						String namePlayer1 = recuperationInformation.nextLine();
						System.out.println("Veuillez entrer le nom du joueur 2 : ");
						String namePlayer2 = recuperationInformation.nextLine();
						
						if (namePlayer1.equals(namePlayer2))
							System.out.println("Veuillez saisir des noms différents");
						else
							{
							player1 = new Joueurs(namePlayer1, SIGNATURE1);
							player2 = new Joueurs(namePlayer2, SIGNATURE2);
							choiceOfPlayer = true;
							}
					} while (choiceOfPlayer == false);
				}
				
				else
					System.out.println("Veuillez saisir une lettre valide");
			}
		} while (choiceOfPlayer == false);
		
		//// Fin choix des noms ////
		
		JFrame fenetre = new PlateauJeu();
	}

}
