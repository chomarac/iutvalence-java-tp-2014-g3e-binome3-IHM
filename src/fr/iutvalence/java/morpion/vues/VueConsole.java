package fr.iutvalence.java.morpion.vues;

/** Interface de la vue console.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public interface VueConsole
{
	/** Demander aux utilisateurs si ils veulent changer le nom des joueurs.
	 * 
	 * @return Un tableau contenant les noms des joueurs. */
	String[] demanderNomsJoueurs();

	/** On affiche quel joueur doit jouer son coup.
	 * 
	 * @param nomJoueur
	 *            Le nom du joueur.
	 * @param symboleJoueur
	 *            Le symbole du joueur. */
	void debuterUnTour(String nomJoueur, String symboleJoueur);

	/** Afficher le plateau de jeu courant.
	 * 
	 * @param plateauAsciiArt
	 *            Le plateau courant au format texte. */
	void afficherPlateauCourant(String plateauAsciiArt);

	/** Permet de demander la première coordonnée au joueur courant.
	 * 
	 * @return Un tableau contenant les choix du joueur. */
	int[] demanderCoordonnees();

	/** Message à afficher lorsqu'il y a un vainqueur.
	 * 
	 * @param vainqueur
	 *            Contient le nom du vainqueur. */
	void afficherVainqueur(final String vainqueur);

	/** Permet d'afficher une partie nulle. */
	void afficherPartieNulle();

	/** Permet de demander aux joueurs si ils veulent rejouer une partie.
	 * 
	 * @return true si le joueur veut rejouer une partie, false sinon. */
	public boolean choixRejouer();

	/** Message à afficher lorsqu'on quitte l'application. */
	void quitter();

	/** Les coordonnées ne sont pas comprises entre 1 et 3. */
	void mauvaisesCoordonnees();	

	/** Les coordonnées sont déjà occupées. */
	void coordonneesDejaPrise();
}
