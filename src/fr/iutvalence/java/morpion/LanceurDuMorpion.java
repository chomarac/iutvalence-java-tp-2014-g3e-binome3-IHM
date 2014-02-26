package fr.iutvalence.java.morpion;

/**
 * Modélisation de l'execution du jeu.
 */
public class LanceurDuMorpion {

	/**
     * Permet de lancer le jeu.
     */
	public static void main(String[] args)
	{
		//Des tests
		System.out.println("Coming soon !");
		PlateauJeu unPlateauJeu = new PlateauJeu();
		unPlateauJeu.afficherPlateauDeJeu();
		GestionDesJoueurs menuInitial = new GestionDesJoueurs();
		menuInitial.demanderJoueurs();
	}
}
