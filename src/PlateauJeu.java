import javax.swing.JFrame;

/**
 * Classe PlateauJeu
 * @author Loic
 */
public class PlateauJeu extends JFrame {

	private static final long serialVersionUID = -5152197685260683938L;
	
	int plateauDeJeu [] [] = new int [5] [5];

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
	
}
