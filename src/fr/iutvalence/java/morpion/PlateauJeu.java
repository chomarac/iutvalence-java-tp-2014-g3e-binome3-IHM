package fr.iutvalence.java.morpion;

/**
 * Modélisation d'un plateau du jeu.
 * <p>
 * Modélisation par une matrice contenant :
 * <ul>
 * <li>les pions des joueurs (lignes/colonnes W à X)</li>
 * <li>les résultats de calcul pour déterminer une victoire (lignes/colonnes Y à Z)</li>
 * </ul>
 * </p>
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
     * Nom du plateau de jeu
     */
    private int plateauDeJeu[][];
	
	/**
	 * La constante qui permet de dire un joueur est vainqueur
	 */
	public static final int VICTORY = 10;
	
	/**
	 * La constante qui permet de dire qu'il n'y a pas encore de vainqueur
	 */
	public static final int NOVICTORY = - VICTORY;
    
    /**
     * Constructeur d'un plateau de jeu
     */
    public PlateauJeu() {
    	
        this.plateauDeJeu = new int[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
        
        for (int nombreDeLignes = 0; nombreDeLignes < this.plateauDeJeu.length; nombreDeLignes++) {
            for (int nombreDeColonnes = 0; nombreDeColonnes < this.plateauDeJeu.length; nombreDeColonnes++) {
                this.plateauDeJeu[nombreDeLignes][nombreDeColonnes] = 0;
            }
        }
    }
	
	/**
	 * Retourne un nouvel objet de type CoupleCoordonnees qui contient les choix des valeurs1 et valeurs2
	 * @param valeur1, la  première coordonnée
	 * @param valeur2, la deuxième coordonnée
	 * @return
	 */
	public CoupleCoordonnees choixDuJoueur(int valeur1, int valeur2)
	{
		return (new CoupleCoordonnees(valeur1 + 1, valeur2 + 1));
	}
	
	/**
	 * Méthode qui permet de vérifier les coordonnées entrées par l'utilisateur
	 * @param coordonneesAVerifier, l'objet qui contient un couple de coordonnée
	 * @return 1 si les coordonnées sont corrects, sinon 0
	 */
	public void verificationDuChoix(CoupleCoordonnees lesCoordonnees) throws CoordonneesDejaPriseException, MauvaiseCoordonneesException
	{
		int firstValue = lesCoordonnees.obtenirPremiereCoordonnee();
		int secondValue = lesCoordonnees.obtenirDeuxiemeCoordonnee();
		
		if (!((firstValue <= 4) && (firstValue > 1) && (secondValue <= 4) && (secondValue > 1)))
			throw MauvaiseCoordonneesException;
		
		if (!((this.plateauDeJeu [firstValue] [secondValue]) == 0))
			throw CoordonneesDejaPriseException;	
	}
	
	/**
	 * Méthode qui permet de vérifier la disponibilité de la case sur le plateau de jeu en fonction du couple de coordonnées
	 * Si la case est disponible, on la modifie, sinon on retourne un code d'erreur (à savoir 0)
	 * @param unPlateau, le plateau sur lequel on joue
	 * @param unCouple, le couple de coordonnées choisi après une vérification antérieure
	 * @return 1 si la case est disponible, sinon 0
	 */
	public void ModificationDuPlateau(Joueurs unJoueur, CoupleCoordonnees unCouple)
	{
		int firstValue = unCouple.obtenirPremiereCoordonnee();
		int secondValue = unCouple.obtenirDeuxiemeCoordonnee();
		
		this.plateauDeJeu [firstValue] [secondValue] = unJoueur.obtenirSignature();
	}
	
	/**
	 * Méthode qui permet de vérifier une éventuelle victoire de la part d'un des joueurs
	 * @param unJoueur
	 * @param unPlateau, le plateau sur lequel on joue
	 * @return VICTORY si on détecte une victoire, sinon - VICTORY
	 */
	public int verificationDeLaVictoire(Joueurs unJoueur)
	{
		int verification1, verification2, verification3, verification4, verification5, verification6, verification7, verification8;
		int VictorySignatureOfPlayer = 3 * unJoueur.obtenirSignature();
		
		this.plateauDeJeu[1][2] = this.plateauDeJeu[2][2] + this.plateauDeJeu[2][3] + this.plateauDeJeu[2][4];
		this.plateauDeJeu[1][2] = this.plateauDeJeu[3][2] + this.plateauDeJeu[3][3] + this.plateauDeJeu[3][4];
		verification3 = this.plateauDeJeu[4][2] + this.plateauDeJeu[4][3] + this.plateauDeJeu[4][4];
		verification4 = this.plateauDeJeu[2][2] + this.plateauDeJeu[3][2] + this.plateauDeJeu[4][2];
		verification5 = this.plateauDeJeu[2][3] + this.plateauDeJeu[3][3] + this.plateauDeJeu[4][3];
		verification6 = this.plateauDeJeu[2][4] + this.plateauDeJeu[3][4] + this.plateauDeJeu[4][4];
		verification7 = this.plateauDeJeu[2][2] + this.plateauDeJeu[3][3] + this.plateauDeJeu[4][4];
		verification8 = this.plateauDeJeu[2][4] + this.plateauDeJeu[3][3] + this.plateauDeJeu[4][2];
		
		if ((verification1 == VictorySignatureOfPlayer)||(verification2 == VictorySignatureOfPlayer)||
			(verification3 == VictorySignatureOfPlayer)||(verification4 == VictorySignatureOfPlayer)||
			(verification5 == VictorySignatureOfPlayer)||(verification6 == VictorySignatureOfPlayer)||
			(verification7 == VictorySignatureOfPlayer)||(verification8 == VictorySignatureOfPlayer))
		{
			String winningOfPlayer = unJoueur.obtenirNom();
			System.out.println("-----------------------------------------------------------------------");
			System.out.println(" Félicitation !! Victoire du joueur : " + winningOfPlayer);
			System.out.println("-----------------------------------------------------------------------");
			return VICTORY;
		}
		else
			return NOVICTORY;
		
	}

}
