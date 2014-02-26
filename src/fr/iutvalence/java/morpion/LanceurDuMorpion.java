package fr.iutvalence.java.morpion;

/**
 * Modélisation de l'execution du jeu.
 */
public class LanceurDuMorpion {

	/**
     * Permet de lancer le jeu.
     */
	public static void main(String[] args) {
		
		//On execute le menu de choix des noms des joueurs
		GestionDesJoueurs menuDeChoix = new GestionDesJoueurs();
		menuDeChoix.StartMenu();
		
		//Création d'un plateau de jeu
		PlateauJeu test1 = new PlateauJeu();
		test1.afficherPlateauDeJeu();
		
		
	}
}
