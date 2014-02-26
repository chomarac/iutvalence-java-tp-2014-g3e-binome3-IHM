package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

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
	 * Méthode qui permet de vérifier les coordonnées et la disponibilité.
	 * @param lesCoordonnees, un couple de coordonnées
	 */
	public void verificationDuChoix(CoupleCoordonnees lesCoordonnees) throws CoordonneesDejaPriseException, MauvaiseCoordonneesException
	{
		int firstValue = lesCoordonnees.obtenirPremiereCoordonnee();
		int secondValue = lesCoordonnees.obtenirDeuxiemeCoordonnee();
		
		if (!((firstValue <= 4) && (firstValue > 1) && (secondValue <= 4) && (secondValue > 1)))
			throw new MauvaiseCoordonneesException();
		
		if (!((this.plateauDeJeu [firstValue] [secondValue]) == 0))
			throw new CoordonneesDejaPriseException();	
	}
	
	/**
	 * Méthode qui permet de modifier le plateau de jeu.
	 * @param unJoueur, le joueur qui réalise l'action
	 * @param unCouple, un couple de coordonnées
	 */
	public void ModificationDuPlateau(Joueurs unJoueur, CoupleCoordonnees unCouple)
	{
		int firstValue = unCouple.obtenirPremiereCoordonnee();
		int secondValue = unCouple.obtenirDeuxiemeCoordonnee();
		
		this.plateauDeJeu [firstValue] [secondValue] = unJoueur.obtenirSignature();
	}
	
	/**
	 * Méthode qui permet de vérifier une éventuelle victoire de la part d'un des joueurs.
	 * @param unJoueur, le joueur courant
	 * @return VICTORY si on détecte une victoire, sinon - VICTORY
	 */
	public int verificationDeLaVictoire(Joueurs unJoueur)
	{
		int VictorySignatureOfPlayer = 3 * unJoueur.obtenirSignature();
		
		this.plateauDeJeu[0][1] = this.plateauDeJeu[1][1] + this.plateauDeJeu[2][1] + this.plateauDeJeu[3][1];
		this.plateauDeJeu[0][2] = this.plateauDeJeu[1][2] + this.plateauDeJeu[2][2] + this.plateauDeJeu[3][2];
		this.plateauDeJeu[0][3] = this.plateauDeJeu[1][3] + this.plateauDeJeu[2][3] + this.plateauDeJeu[3][3];
		this.plateauDeJeu[1][0] = this.plateauDeJeu[1][1] + this.plateauDeJeu[1][2] + this.plateauDeJeu[1][3];
		this.plateauDeJeu[2][0] = this.plateauDeJeu[2][1] + this.plateauDeJeu[2][2] + this.plateauDeJeu[2][3];
		this.plateauDeJeu[3][0] = this.plateauDeJeu[3][1] + this.plateauDeJeu[3][2] + this.plateauDeJeu[3][3];
		this.plateauDeJeu[0][0] = this.plateauDeJeu[1][1] + this.plateauDeJeu[2][2] + this.plateauDeJeu[3][3];
		this.plateauDeJeu[4][0] = this.plateauDeJeu[3][1] + this.plateauDeJeu[2][2] + this.plateauDeJeu[1][3];
		
		if ((this.plateauDeJeu[0][1] == VictorySignatureOfPlayer)||(this.plateauDeJeu[0][2] == VictorySignatureOfPlayer)||
			(this.plateauDeJeu[0][3] == VictorySignatureOfPlayer)||(this.plateauDeJeu[1][0] == VictorySignatureOfPlayer)||
			(this.plateauDeJeu[2][0] == VictorySignatureOfPlayer)||(this.plateauDeJeu[3][0] == VictorySignatureOfPlayer)||
			(this.plateauDeJeu[0][0] == VictorySignatureOfPlayer)||(this.plateauDeJeu[4][0] == VictorySignatureOfPlayer))
			
			return VICTORY;
		else
			return NOVICTORY;
	}

}
