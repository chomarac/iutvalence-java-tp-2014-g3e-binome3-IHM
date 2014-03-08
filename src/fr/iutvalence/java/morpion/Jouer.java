package fr.iutvalence.java.morpion;

/** Permet de gérer les actions relatives aux parties (jouer, rejouer, quitter)
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public class Jouer
{
	/** Permet jouer une partie */
	public void jouer()
	{
		PlateauJeu unPlateauJeu = new PlateauJeu();
		ActionDuJeu uneAction = new ActionDuJeu();
		uneAction.modificationNomsJoueurs();
		uneAction.choixJoueurDebutantPartie();
		uneAction.partie(unPlateauJeu);
	}
	
	/** Permet de lancer une nouvelle partie */
	public void rejouer()
	{
		this.jouer();
	}
	
	/** Permet de quitter l'application */
	public void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}
}
