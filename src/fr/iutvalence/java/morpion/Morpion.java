package fr.iutvalence.java.morpion;

/** Permet d'executer l'application.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 1.2.0 */
public class Morpion {
	
    /** Permet de lancer le jeu. */
    public static void main(String[] args) {
        Controleur controleur;
        do
        {
            controleur = new Controleur();
        } while (controleur.nouvellePartie());
        //new Fenetre();
    }
}
