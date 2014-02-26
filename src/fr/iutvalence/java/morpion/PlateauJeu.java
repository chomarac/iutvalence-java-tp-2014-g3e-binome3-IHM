/* TODO Pensez à la forme de la JavaDoc (un point en fin de ligne). */
package fr.iutvalence.java.morpion;

/* TODO Très bien pour la description. Mais n'oubliez pas une version courte. Je vous fais une proposition pour l'exemple. */
/**
 * Modélisation d'un plateau du jeu.
 * <p/>
 * Modélisation par une matrice contenant :
 * <ul>
 * <li>les pions des joueurs (lignes/colonnes W à X)</li>
 * <li>les résultats de calcul pour déterminer une victoire (lignes/colonnes Y à Z)</li>
 * </ul>
 *
 * @author DELORME Loic
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
    public PlateauJeu() {
        /* TODO Est-ce réellement une variable locale ? */
        int plateauDeJeu[][] = new int[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
        for (int nombreDeLignes = 0; nombreDeLignes < plateauDeJeu.length; nombreDeLignes++) {
            for (int nombreDeColonnes = 0; nombreDeColonnes < plateauDeJeu.length; nombreDeColonnes++) {
                plateauDeJeu[nombreDeLignes][nombreDeColonnes] = 0;
            }
        }
    }

}
