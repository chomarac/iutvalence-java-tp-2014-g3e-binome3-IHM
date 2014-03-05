package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

/**
 * Modélisation d'un plateau du jeu.
 * <p>
 * Modélisation par une matrice contenant :
 * <ul>
 * <li>les pions des joueurs (lignes/colonnes 1 à 3)</li>
 * <li>les résultats de calcul pour déterminer une victoire (lignes/colonnes 0 à 1)</li>
 * </ul>
 * </p>
 */
public class PlateauJeu {

    /** Constante du nombres de lignes. */
    public static final int NOMBRE_DE_COLONNES = 5;

    /** Constante du nombres de colonnes. */
    public static final int NOMBRE_DE_LIGNES = 5;

    /** Plateau de jeu. */
    private final int[][] plateauDeJeu;

    /** Constructeur d'un plateau de jeu. */
    public PlateauJeu()
    {
    	//On retourne un nouveau plateau de jeu avec des composantes prédéfinies
        this.plateauDeJeu = new int[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
    }

    /**
     * Méthode qui permet de vérifier les coordonnées et la disponibilité.
     *
     * @param x La première coordonnée
     * @param y La deuxième coordonnée
     * 
     * @throws CoordonneesDejaPriseException Si la case est déjà occupée
     * @throws MauvaiseCoordonneesException Si les coordonnées ne sont pas dans l'intervalle [1,3]
     */
    public void verificationDuChoix(int x, int y) throws CoordonneesDejaPriseException, MauvaiseCoordonneesException
	{

		//On soulève une exception si les valeurs saisies sont éronnées
		if ((x > 3) || (x < 1) || (y > 3) || (y < 1))
            throw new MauvaiseCoordonneesException();

		//On soulève une exception si la case est déjà occupée
		if (this.plateauDeJeu[x][y] != 0)
            throw new CoordonneesDejaPriseException();
	}

    /**
     * Méthode qui permet de modifier le plateau de jeu.
     *
     * @param unJoueur le joueur qui réalise l'action
     * @param x La première coordonnée
     * @param y La deuxième coordonnée
     *
     * @return true si un joueur gagne, false sinon
     */
    public boolean modificationDuPlateau(Joueurs unJoueur, int x, int y)
	{
		//On récupère les données liées au joueur courant
		int signature = unJoueur.obtenirSignature();
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
        return ((this.plateauDeJeu[x][0] == victoire) || (this.plateauDeJeu[0][y] == victoire) || (this.plateauDeJeu[0][0] == victoire) || (this.plateauDeJeu[4][0] == victoire));
	}

    /** Affichage du plateau de jeu par redéfinition d'une méthode existante. */
	@Override
    public String toString()
	{
        /* TODO À discuter en TP. */
		StringBuilder plateauAsciiArt = new StringBuilder(21);

		for (int nombreDeLignes = 1 ; nombreDeLignes < 4; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 1 ; nombreDeColonnes < 4; nombreDeColonnes++)
			{
				plateauAsciiArt.append(this.plateauDeJeu[nombreDeLignes][nombreDeColonnes]).append(' ');
			}
			plateauAsciiArt.append('\n');
		}

		return plateauAsciiArt.toString();
	}

}
