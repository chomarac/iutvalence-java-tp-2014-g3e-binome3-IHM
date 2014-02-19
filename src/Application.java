import java.util.Scanner;

public class Application {
	
	/** The Constant PLAYER1. */
	private static final String PLAYER1 = "Joueur 1";
	
	/** The Constant PLAYER2. */
	private static final String PLAYER2 = "Joueur 2";
	
	/** The Constant SIGNATURE1. */
	private static final int SIGNATURE1 = -1;
	
	/** The Constant SIGNATURE2. */
	private static final int SIGNATURE2 = -SIGNATURE1;
	
	/** The choix joueur. */
	private static boolean choixJoueur = false;

	public static void main(String[] args) {
		
		Scanner recuperationInformation = new Scanner(System.in);
		
		do{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = recuperationInformation.nextLine();
			
			if (choix.equals("N"))
			{
				Joueurs player1 = new Joueurs(PLAYER1, SIGNATURE1);
				Joueurs player2 = new Joueurs(PLAYER2, SIGNATURE2);
				choixJoueur = true;
			}
			else
			{
				if (choix.equals("O"))
				{
					System.out.println("Veuillez entrer le nom du joueur 1");
					String nomJ1 = recuperationInformation.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2");
					String nomJ2 = recuperationInformation.nextLine();
				}
			}
		} while (choixJoueur);

	}

}
