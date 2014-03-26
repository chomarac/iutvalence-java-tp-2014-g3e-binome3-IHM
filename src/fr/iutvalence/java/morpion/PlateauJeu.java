package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

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
 * @version 1.0 */
public class PlateauJeu 
{

    /** Constante du nombres de lignes. */
    private static final int NOMBRE_DE_COLONNES = 5;

    /** Constante du nombres de colonnes. */
    private static final int NOMBRE_DE_LIGNES = 5;
    
	/** Le nombre de tour maximum pour une partie. */
    private final int NOMBREMAXDETOUR = 9;

    /** Plateau de jeu. */
    private final int[][] plateauDeJeu;
    
    /** Le nombre de tour maximum pour une partie de morpion. */
    private final int nombreDeTours;
    
    /** La signature unique du joueur 1. */
    public static final int SIGNATURE_JOUEUR1 = 5;
    
    /** La signature unique du joueur 2. */
    public static final int SIGNATURE_JOUEUR2 = - SIGNATURE_JOUEUR1;
    
    /** Le symbole correspondant au joueur 1. */
    public static final String SYMBOLE_JOUEUR_1 = "X";
    
    /** Le symbole correspondant au joueur 2. */
    public static final String SYMBOLE_JOUEUR_2 = "O";

    /** Constructeur d'un plateau de jeu. */
    public PlateauJeu()
    {
    	//On retourne un nouveau plateau de jeu avec des composantes prédéfinies
        this.plateauDeJeu = new int[PlateauJeu.NOMBRE_DE_LIGNES][PlateauJeu.NOMBRE_DE_COLONNES];
        this.nombreDeTours = this.NOMBREMAXDETOUR;
    }
    
    /** Obtenir le nombre maximum de tours pour une partie de morpion.
     * 
     * @return Le nombre de tours. */
    public int obtenirNombreDeToursMax()
    {
    	return this.nombreDeTours;
    }

    /** Vérifier les coordonnées et la disponibilité.
     *
     * @param x La première coordonnée
     * @param y La deuxième coordonnée
     * 
     * @throws CoordonneesDejaPriseException Si la case est déjà occupée
     * @throws MauvaiseCoordonneesException Si les coordonnées ne sont pas dans l'intervalle [1,3]
     */
    public void estCoupValide(int x, int y) throws CoordonneesDejaPriseException, MauvaiseCoordonneesException
	{
		//On soulève une exception si les valeurs saisies sont éronnées
		if ((x > 3) || (x < 1) || (y > 3) || (y < 1))
            throw new MauvaiseCoordonneesException();

		//On soulève une exception si la case est déjà occupée
		if (this.plateauDeJeu[x][y] != 0)
            throw new CoordonneesDejaPriseException();
	}

    /** Modifier le plateau de jeu si le coup joué est valide.
     *
     * @param signature La signature du joueur.
     * @param x La première coordonnée.
     * @param y La deuxième coordonnée.
     *
     * @return true si un joueur gagne, false sinon */
    public boolean placerPion(int signature, int x, int y)
	{
		//On récupère les données liées au joueur courant
		int victoire = 3 * signature;

		this.plateauDeJeu[x][y] = signature;

		//On calcul les lignes
		this.plateauDeJeu[x][0] += signature;
		this.plateauDeJeu[0][y] += signature;

		//On calcul la première diagonale
		if (x == y)
            this.plateauDeJeu[0][0] += signature;

		//On calcul la deuxième diagonale
		if ((x + y) == 4)
            this.plateauDeJeu[4][0] += signature;

        //On teste une éventuelle victoire
        return (this.plateauDeJeu[x][0] == victoire) || (this.plateauDeJeu[0][y] == victoire) || (this.plateauDeJeu[0][0] == victoire) || (this.plateauDeJeu[4][0] == victoire);
	}

    /** Affichage du plateau de jeu par redéfinition d'une méthode existante.
     * 
     * @return Le plateau de jeu au format String */
	@Override
    public String toString()
	{
		StringBuilder plateauAsciiArt = new StringBuilder(21);

		for (int nombreDeLignes = 1 ; nombreDeLignes < 4; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 1 ; nombreDeColonnes < 4; nombreDeColonnes++)
			{
				switch (this.plateauDeJeu[nombreDeLignes][nombreDeColonnes])
				{
				case SIGNATURE_JOUEUR1:
					plateauAsciiArt.append('X').append(' ');
					break;
				case SIGNATURE_JOUEUR2:
					plateauAsciiArt.append('O').append(' ');
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
