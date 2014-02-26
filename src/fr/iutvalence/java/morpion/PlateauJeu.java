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

}
