/**
 * Classe PlateauJeu
 * @author Loic
 */
public class PlateauJeu {

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
	
	public PlateauJeu()
	{
		int plateauDeJeu [] [] = new int [5] [5];
		for (int nombreDeLignes = 0 ; nombreDeLignes < plateauDeJeu.length; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 0 ; nombreDeColonnes < plateauDeJeu.length; nombreDeColonnes++)
			{
				plateauDeJeu [nombreDeLignes] [nombreDeColonnes] = 0;
			}
		}
	}

}
