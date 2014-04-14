package fr.iutvalence.java.morpion.vues;

/** Modélisation d'une vue.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public class VueConsoleANSI extends VueConsoleSimple
{
	/** Modélisation d'un controleur avec vue terminale ANSI. */
	public VueConsoleANSI()
	{
		super();
	}

	/** Rédéfinition de la méthode afficherPlateauCourant() permettant de modifier la couleur des pions. */
	@Override
	public void afficherPlateauCourant(String plateauAsciiArt)
	{
		String finale = plateauAsciiArt.replaceAll("O", "\033[33;1mO\033[0;1m");
		finale = finale.replaceAll("X", "\033[36;1mX\033[0;1m");
		System.out.println(finale);
	}
}
