/**
 * La classe JeuPrincipal va permettre de créer plusieurs méthodes utiles pour le fonctionnement du jeu comme :
 * Déterminer si il y a ou non la présence d'une victoire ;
 * Déterminer si il y a ou non si la partie est nulle (absence de victoire) ;
 * Déterminer la fin d'une partie ;
 * Si l'utilisateur veux rejouer.
 * @author Loic
 *
 */
public class JeuPrincipal {
	
	/**
	 * La constante qui permet de dire si les coordonnées sont corrects
	 */
	public final static int CHECK = 1;
	
	/**
	 * La constante qui permet de dire si les coordonnées sont incorrects
	 */
	public final static int FAIL = 0;
	
	/**
	 * La constante qui permet de dire un joueur est vainqueur
	 */
	public final static int VICTORY = 10;
	
	/**
	 * La constante qui permet de dire qu'il n'y a pas encore de vainqueur
	 */
	public final static int NOVICTORY = - VICTORY;
	
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
	public int verificationDuChoix(CoupleCoordonnees coordonneesAVerifier)
	{
		int checkValue = 0;
		
		if ((coordonneesAVerifier.obtenirPremiereCoordonnee() <= 4) && (coordonneesAVerifier.obtenirPremiereCoordonnee() > 1))
			checkValue = checkValue + 1;
		
		if ((coordonneesAVerifier.obtenirDeuxiemeCoordonnee() <= 4) && (coordonneesAVerifier.obtenirDeuxiemeCoordonnee() > 1))
			checkValue = checkValue + 1;
		
		if (checkValue == 2)
			return CHECK;
		else
			return FAIL;
	}
	
	/**
	 * Méthode qui permet de vérifier la disponibilité de la case sur le plateau de jeu en fonction du couple de coordonnées
	 * Si la case est disponible, on la modifie, sinon on retourne un code d'erreur (à savoir 0)
	 * @param unPlateau, le plateau sur lequel on joue
	 * @param unCouple, le couple de coordonnées choisi après une vérification antérieure
	 * @return 1 si la case est disponible, sinon 0
	 */
	public int verificationDisponibliteSurPlateauDeJeuEtModification(Joueurs unJoueur, int unPlateau[][], CoupleCoordonnees unCouple)
	{
		int firstValue = unCouple.obtenirPremiereCoordonnee();
		int secondValue = unCouple.obtenirDeuxiemeCoordonnee();
		
		if ((unPlateau[firstValue][secondValue]) == 0)
		{
			unPlateau[firstValue][secondValue] = unJoueur.obtenirSignature();
			return CHECK;
		}
		else
			return FAIL;
	}
	
	
	/**
	 * Méthode qui permet de vérifier une éventuelle victoire de la part d'un des joueurs
	 * @param unJoueur
	 * @param unPlateau, le plateau sur lequel on joue
	 * @return VICTORY si on détecte une victoire, sinon - VICTORY
	 */
	public int verificationDeLaVictoire(Joueurs unJoueur, int unPlateau[][])
	{
		int verification1, verification2, verification3, verification4, verification5, verification6, verification7, verification8;
		int VictorySignatureOfPlayer = 3 * unJoueur.obtenirSignature();
		
		verification1 = unPlateau[2][2] + unPlateau[2][3] + unPlateau[2][4];
		verification2 = unPlateau[3][2] + unPlateau[3][3] + unPlateau[3][4];
		verification3 = unPlateau[4][2] + unPlateau[4][3] + unPlateau[4][4];
		verification4 = unPlateau[2][2] + unPlateau[3][2] + unPlateau[4][2];
		verification5 = unPlateau[2][3] + unPlateau[3][3] + unPlateau[4][3];
		verification6 = unPlateau[2][4] + unPlateau[3][4] + unPlateau[4][4];
		verification7 = unPlateau[2][2] + unPlateau[3][3] + unPlateau[4][4];
		verification8 = unPlateau[2][4] + unPlateau[3][3] + unPlateau[4][2];
		
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
	
	/**
	 * Permet d'afficher la grille ligne par ligne en prenant en compte les retours à la ligne
	 * @param unPlateau, le plateau sur lequel on joue
	 */
	public void afficherPlateauDeJeu(PlateauJeu unPlateau[][])
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
					System.out.println(unPlateau [nombreDeLignes] [nombreDeColonnes]);
				}
				else
					System.out.print(unPlateau [nombreDeLignes] [nombreDeColonnes]);
			}
		}
	}

}
