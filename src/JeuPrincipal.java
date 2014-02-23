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
	
	
	public int verificationDeLaVictoireOuPartieNulle()
	{
		return 1;
	}
	
	public void afficherPlateauDeJeu()
	{
		
	}

}
