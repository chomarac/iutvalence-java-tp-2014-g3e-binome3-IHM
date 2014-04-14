package fr.iutvalence.java.morpion.modele;

import fr.iutvalence.java.morpion.modele.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.modele.erreur.MauvaiseCoordonneesException;

/** Modélisation d'un plateau du jeu.
 * <p>
 * Modélisation par une matrice contenant :
 * <ul>
 * <li>les pions des joueurs (lignes/colonnes 1 à 3)</li>
 * <li>les résultats de calcul pour déterminer une victoire (lignes/colonnes 0 à 1)</li>
 * </ul>
 * </p>
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public class PlateauJeu
{
	/** La signature unique du joueur 1. */
	public static final int SIGNATURE_JOUEUR_1 = 5;
	
	/** La signature unique du joueur 2. */
	public static final int SIGNATURE_JOUEUR_2 = -SIGNATURE_JOUEUR_1;
	
	/** Le symbole correspondant au joueur 1. */
	public static final String SYMBOLE_JOUEUR_1 = "X";
	
	/** Le symbole correspondant au joueur 2. */
	public static final String SYMBOLE_JOUEUR_2 = "O";
	
	/** Constante du nombres de lignes. */
	private static final int NOMBRE_DE_COLONNES = 5;
	
	/** Constante du nombres de colonnes. */
	private static final int NOMBRE_DE_LIGNES = 5;
	
	/** Le nombre de tour maximum pour une partie. */
	private static final int NOMBRE_MAX_DE_TOUR = 9;
	
	/** Plateau de jeu. */
	private final int[][] plateauDeJeu;
	
	/** Le nombre de tour actuel. */
	private int nombreDeTours;

	/** Constructeur d'un plateau de jeu. */
	public PlateauJeu()
	{
		// On retourne un nouveau plateau de jeu avec des composantes prédéfinies
		this.plateauDeJeu = new int[PlateauJeu.NOMBRE_DE_LIGNES][PlateauJeu.NOMBRE_DE_COLONNES];
		this.nombreDeTours = 0;
		
		for (int nombreDeLigne = 0; nombreDeLigne < NOMBRE_DE_LIGNES; nombreDeLigne++)
			for (int nombreDeColonne = 0; nombreDeColonne < NOMBRE_DE_COLONNES; nombreDeColonne++)
				this.plateauDeJeu[nombreDeLigne][nombreDeColonne] = 0;
	}

	/** Indique si la grille est remplie (et donc le match nul).
	 * 
	 * @return True si le coup est possible, false sinon. */
	public boolean coupPossible()
	{
		return this.nombreDeTours < NOMBRE_MAX_DE_TOUR;
	}

	/** Vérifier les coordonnées et la disponibilité.
	 * 
	 * @param x
	 *            La première coordonnée
	 * @param y
	 *            La deuxième coordonnée
	 * 
	 * @throws CoordonneesDejaPriseException
	 *             Si la case est déjà occupée
	 * @throws MauvaiseCoordonneesException
	 *             Si les coordonnées ne sont pas dans l'intervalle [1,3] */
	public void estCoupValide(int x, int y) throws CoordonneesDejaPriseException, MauvaiseCoordonneesException
	{
		// On soulève une exception si les valeurs saisies sont éronnées
		if ((x > 3) || (x < 1) || (y > 3) || (y < 1))
			throw new MauvaiseCoordonneesException();

		// On soulève une exception si la case est déjà occupée
		if (this.plateauDeJeu[x][y] != 0)
			throw new CoordonneesDejaPriseException();
	}

	/** Modifier le plateau de jeu si le coup joué est valide.
	 * 
	 * @param pion
	 *            Le pion à placer.
	 * @param x
	 *            La première coordonnée.
	 * @param y
	 *            La deuxième coordonnée.
	 * 
	 * @return true si un joueur gagne, false sinon */
	public boolean placerPion(int pion, int x, int y)
	{
		// On incrémente le nombre de tours.
		this.nombreDeTours++;

		// On récupère les données liées au joueur courant
		int victoire = 3 * pion;

		this.plateauDeJeu[x][y] = pion;

		// On calcul les lignes
		this.plateauDeJeu[x][0] += pion;
		this.plateauDeJeu[0][y] += pion;

		// On calcul la première diagonale
		if (x == y)
			this.plateauDeJeu[0][0] += pion;

		// On calcul la deuxième diagonale
		if ((x + y) == 4)
			this.plateauDeJeu[4][0] += pion;

		// On teste une éventuelle victoire
		return (this.plateauDeJeu[x][0] == victoire) || (this.plateauDeJeu[0][y] == victoire) || (this.plateauDeJeu[0][0] == victoire)
				|| (this.plateauDeJeu[4][0] == victoire);
	}

	/** Affichage du plateau de jeu par redéfinition d'une méthode existante.
	 * 
	 * @return Le plateau de jeu au format String */
	@Override
	public String toString()
	{
		StringBuilder plateauAsciiArt = new StringBuilder(30);

		for (int nombreDeLignes = 1; nombreDeLignes < 4; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 1; nombreDeColonnes < 4; nombreDeColonnes++)
			{
				switch (this.plateauDeJeu[nombreDeLignes][nombreDeColonnes])
				{
				case SIGNATURE_JOUEUR_1:
					plateauAsciiArt.append(PlateauJeu.SYMBOLE_JOUEUR_1).append(' ');
					break;
				case SIGNATURE_JOUEUR_2:
					plateauAsciiArt.append(PlateauJeu.SYMBOLE_JOUEUR_2).append(' ');
					break;
				default:
					plateauAsciiArt.append('.').append(' ');
					break;
				}
			}
			plateauAsciiArt.append('\n');
		}
		return plateauAsciiArt.toString();
	}
}
