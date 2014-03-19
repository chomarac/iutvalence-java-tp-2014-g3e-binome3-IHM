package fr.iutvalence.java.morpion.graphique;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/** Modélisation d'une fenêtre graphique
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 * */
public class Fenetre extends JFrame
{
	/** ??? */
	private static final long serialVersionUID = 1L;

	/** Un objet qui contiendra toutes les informations à afficher */
	public final static JPanel unTableau = new JPanel();

	/** Définition de la barre de menu */
	private JMenuBar barreDeMenu = new JMenuBar();

	/** Premier menu principal : Partie */
	private JMenu menu1 = new JMenu("Partie");

	/** Premier sous-menu */
	private JMenuItem item1_1 = new JMenuItem("Jouer");

	/** Deuxième sous-menu */
	private JMenuItem item1_2 = new JMenuItem("Rejouer");

	/** Troisième sous-menu */
	private JMenuItem item1_3 = new JMenuItem("Quitter");

	/** Premier menu principal : Score */
	private JMenu menu2 = new JMenu("Score(s)");

	/** Premier sous-menu */
	private JMenuItem item2_1 = new JMenuItem("Historique des scores");
	
	/** Deuxième menu principal : Edition */
	private JMenu menu3 = new JMenu("Aide");

	/** Premier sous-menu de Actions disponibles */
	private JMenuItem item3_1 = new JMenuItem("Règles du jeu");

	/** Deuxième sous-menu de Actions disponibles */
	private JMenuItem item3_2 = new JMenuItem("Documentation");

	/** Troisième menu principal : A propos */
	private JMenuItem item3_3 = new JMenu("A propos de");
	

	/** Fenetre avec des composantes graphiques */
	public Fenetre()
	{
		this.setTitle("Morpion");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Ajout des actions possibles dans le menu "Partie"
		this.menu1.add(this.item1_1);
		this.menu1.addSeparator();
		this.menu1.add(this.item1_2);
		this.menu1.addSeparator();
		this.menu1.add(this.item1_3);

		// Ajout des actions possibles dans le menu "Historique des scores"
		this.menu2.add(this.item2_1);
		
		// Ajout des actions possibles dans le menu "Aide"
		this.menu3.add(this.item3_1);
		this.menu3.addSeparator();
		this.menu3.add(this.item3_2);
		this.menu3.addSeparator();
		this.menu3.add(this.item3_3);

		// On ajoute les événements relatifs aux différents boutons
		this.item1_1.addActionListener(new BoutonJouer());
		this.item1_2.addActionListener(new BoutonRejouer());
		this.item1_3.addActionListener(new BoutonQuitter());
		this.item2_1.addActionListener(new BoutonHistoriqueDesScores());
		this.item3_1.addActionListener(new BoutonReglesDuJeu());
		this.item3_2.addActionListener(new BoutonDocumentation());
		this.item3_3.addActionListener(new BoutonAProposDe());

		// On insère tous les menus dans la le menuBar
		this.barreDeMenu.add(this.menu1);
		this.barreDeMenu.add(this.menu2);
		this.barreDeMenu.add(this.menu3);

		// On l'ajoute à la fenêtre
		this.setJMenuBar(this.barreDeMenu);

		unTableau.setBackground(Color.GRAY);
		this.setContentPane(unTableau);
		this.setVisible(true);
	}

}
