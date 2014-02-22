/**
 * Classe PlateauJeu
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

    /* TODO Remarque générale : les outils comme Git sont là principalement pour éviter de faire des commentaires d'ancien bout de code qu'on reprendra plus tard. */
	/**
	 * Créé une nouvelle fenetre graphique avec des composantes prédéfinies
	 *//*
	public PlateauJeu()
	{
		this.setTitle("Morpion");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setVisible(true);	
	}*/
	
	/**
	 * Constructeur d'un plateau de jeu
	 */
	public PlateauJeu()
	{
        /* TODO Je me suis mal exprimé dans ma remarque précédente. Je voulais dire : "est-ce que la variable plateauDeJeu n'est pas un attribut ? */
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
