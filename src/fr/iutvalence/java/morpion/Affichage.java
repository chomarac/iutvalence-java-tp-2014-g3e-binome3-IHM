package fr.iutvalence.java.morpion;

public class Affichage
{
	/**
	 * Affichage du plateau de jeu.
	 */
	public void afficherPlateauDeJeu()
	{
		int compteur = 0;
		
		for (int nombreDeLignes = 1 ; nombreDeLignes < 4; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 1 ; nombreDeColonnes < 4; nombreDeColonnes++)
			{
				compteur = compteur + 1;
				if (compteur == 3)
				{
					compteur = 0;
					System.out.println(" "+ this.plateauDeJeu [nombreDeLignes] [nombreDeColonnes] + " ");
				}
				else
					System.out.print(" " + this.plateauDeJeu [nombreDeLignes] [nombreDeColonnes] + " ");
			}
		}
	}

}
