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

    /* TODO Est-ce que la référence va changer en cours de partie ? */
    /** Nom du plateau de jeu. */
    private int plateauDeJeu[][];

    /** Constructeur d'un plateau de jeu. */
    public PlateauJeu()
    {
    	//On retourne un nouveau plateau de jeu avec des composantes prédéfinies
        this.plateauDeJeu = new int[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
    }

    /* TODO Pourquoi mettre cette méthode ici ? */
    /**
     * Retourne un nouvel objet de type CoupleCoordonnees qui contient les choix des valeurs1 et valeurs2.
     *
     * @param valeur1, la  première coordonnée
     * @param valeur2, la deuxième coordonnée
     */
    public CoupleCoordonnees choixDuJoueur(int valeur1, int valeur2)
	{
		//On retourne un nouveau couple de coordonnée avec les composantes suivantes : valeur1 et valeur2
		return new CoupleCoordonnees(valeur1, valeur2);
	}

    /**
     * Méthode qui permet de vérifier les coordonnées et la disponibilité.
     *
     * @param lesCoordonnees, un couple de coordonnées
     */
    public void verificationDuChoix(CoupleCoordonnees lesCoordonnees) throws CoordonneesDejaPriseException, MauvaiseCoordonneesException
	{
		//On récupère les données liées au joueur courant
		int x = lesCoordonnees.obtenirPremiereCoordonnee();
		int y = lesCoordonnees.obtenirDeuxiemeCoordonnee();

		//On soulève une exception si les valeurs saisies sont éronnées
		if ((x > 3) && (x < 1) && (y > 3) && (y < 1)) {
            /* TODO Est-ce que vous avez défini la méthode toString pour la classe CoupleCoordonnes */
            throw new MauvaiseCoordonneesException(lesCoordonnees.toString());
        }

		//On soulève une exception si la case est déjà occupée
		if (this.plateauDeJeu[x][y] != 0) {
            throw new CoordonneesDejaPriseException("Les coordonnées : " + Integer.toString(this.plateauDeJeu[x][y]) + "sont déjà occupées.");
        }
	}

    /* TODO Convention Java : méthodes commencent par des minuscules. */
    /**
     * Méthode qui permet de modifier le plateau de jeu.
     *
     * @param unJoueur,       le joueur qui réalise l'action
     * @param lesCoordonnees, un couple de coordonnées
     */
    public boolean ModificationDuPlateau(Joueurs unJoueur, CoupleCoordonnees lesCoordonnees)
	{
		//On récupère les données liées au joueur courant
		int x = lesCoordonnees.obtenirPremiereCoordonnee();
		int y = lesCoordonnees.obtenirDeuxiemeCoordonnee();
		int signature = unJoueur.obtenirSignature();
		int victoire = 3 * signature;

		this.plateauDeJeu[x][y] = signature;

		//On calcul les lignes
		this.plateauDeJeu[x][0] += signature;
		this.plateauDeJeu[0][y] += signature;

		//On calcul la première diagonale
		if (x == y) {
            this.plateauDeJeu[0][0] += signature;
        }

		//On calcul la deuxième diagonale
		if ((x + y) == 4) {
            this.plateauDeJeu[4][0] += signature;
        }

        /* TODO À SIMPLIFIER */
		//On teste une éventuelle victoire
		if ((this.plateauDeJeu[x][0] == victoire) || (this.plateauDeJeu[0][y] == victoire) || (this.plateauDeJeu[0][0] == victoire) || (this.plateauDeJeu[4][0] == victoire))
			return true;
		else
			return false;
	}

    /** Affichage du plateau de jeu par redéfinition d'une méthode existante. */
    @Override
	public String toString()
	{
        /* TODO Les concaténations de String sont une (très) mauvaise idée en Java. À discuter en TP. */
		String plateauAsciiArt = "";

		for (int nombreDeLignes = 1 ; nombreDeLignes < 4; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 1 ; nombreDeColonnes < 4; nombreDeColonnes++)
			{
				plateauAsciiArt += this.plateauDeJeu[nombreDeLignes][nombreDeColonnes] + " ";
			}
			plateauAsciiArt += "\n";
		}

		return plateauAsciiArt;
	}

}
