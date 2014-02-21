import javax.swing.JFrame;

/* TODO Vous devriez supprimer tous les usages de Swing pour le moment */
/**
 * Classe PlateauJeu
 * @author Loic
 */
public class PlateauJeu extends JFrame {

	/**
	 * Créé une nouvelle fenetre graphique avec des composantes prédéfinies
	 */
	public PlateauJeu()
	{
		this.setTitle("Morpion");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setVisible(true);	
	}

    /* TODO Pourquoi pas dans le constructeur ? */
	public void creationPlateauDeJeu()
	{

        /* TODO Est-ce que ce n'est pas un attribut du plateau de jeu ? */
		int plateauDeJeu [] [] = new int [5] [5];
		for (int i = 0 ; i < plateauDeJeu.length; i++)
		{
			for (int j = 0 ; j < plateauDeJeu.length; j++)
			{
				plateauDeJeu [i] [j] = 0;
				System.out.println(plateauDeJeu [i] [j]);
			}
		}
	}
}
