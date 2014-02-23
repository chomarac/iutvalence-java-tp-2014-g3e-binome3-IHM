/**
 * La classe PlateauJeu permet de créer le plateau de jeu au sens propre du terme :
 * création d'un tableau de dimensions 2 pour stocker à la fois les choix des joueurs
 * mais également les résultats de calcul pour déterminer une victoire
 * @author Loic
 */
public class PlateauJeu {

	/**
	 * Constante du nombres de lignes
	 */
	public static final int NOMBRE_DE_COLONNES = 5;
	
	/**
	 * Constante du nombres de colonnes
	 */
	public static final int NOMBRE_DE_LIGNES = 5;
	
	/**
	 * Constructeur d'un plateau de jeu
	 */
	public PlateauJeu()
	{
		int plateauDeJeu [] [] = new int [NOMBRE_DE_LIGNES] [NOMBRE_DE_COLONNES];
		for (int nombreDeLignes = 0 ; nombreDeLignes < plateauDeJeu.length; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 0 ; nombreDeColonnes < plateauDeJeu.length; nombreDeColonnes++)
			{
				plateauDeJeu [nombreDeLignes] [nombreDeColonnes] = 0;
			}
		}
	}

}
