package fr.iutvalence.java.morpion.graphique;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author delormel
 *
 */
public class Fenetre extends JFrame
{
	/** ??? */
	private static final long serialVersionUID = 1L;

	/** Un objet qui contiendra toutes les informations à afficher */
	public final static JPanel unTableau = new JPanel();

	/** Définition de la barre de menu */
	private JMenuBar barreDeMenu = new JMenuBar();

	/** Premier menu principal : Connexion */
	private JMenu menu1 = new JMenu("Partie");

	/** Premier sous-menu */
	private JMenuItem item1_1 = new JMenuItem("Jouer");

	/** Deuxième sous-menu */
	private JMenuItem item1_2 = new JMenuItem("Rejouer");

	/** Troisième sous-menu */
	private JMenuItem item1_3 = new JMenuItem("Quitter");

	/** Deuxième menu principal : Edition */
	private JMenu menu2 = new JMenu("Aide");

	/** Premier sous-menu de Actions disponibles */
	private JMenuItem item2_1 = new JMenuItem("Règles du jeu");

	/** Deuxième sous-menu de Actions disponibles */
	private JMenuItem item2_2 = new JMenuItem("Documentation");

	/** Troisième menu principal : A propos */
	private JMenuItem item2_3 = new JMenu("A propos de");

	/**
	 * 
	 */
	public Fenetre()
	{
		this.setTitle("Morpion");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Ajout des actions possibles dans le menu "Connexion"
		this.menu1.add(this.item1_1);
		this.menu1.addSeparator();
		this.menu1.add(this.item1_2);
		this.menu1.addSeparator();
		this.menu1.add(this.item1_3);

		// Ajout des actions possibles dans le sous-menu "Actions Disponibles"
		this.menu2.add(this.item2_1);
		this.menu2.addSeparator();
		this.menu2.add(this.item2_2);
		this.menu2.addSeparator();
		this.menu2.add(this.item2_3);

		// On ajoute les événements relatifs aux différents boutons
		this.item1_1.addActionListener(new BoutonJouer());
		this.item1_2.addActionListener(new BoutonRejouer());
		this.item1_3.addActionListener(new BoutonQuitter());
		
		this.item2_1_1.addActionListener(new BoutonAjouter());
		this.item2_1_2.addActionListener(new BoutonModifier());
		this.item2_1_3.addActionListener(new BoutonSupprimer());
		this.item2_1_4.addActionListener(new BoutonConsulter());
		this.item2_1_5.addActionListener(new BoutonImprimer());
		this.item3_1.addActionListener(new BoutonDocumentation());
		this.item3_2.addActionListener(new BoutonFAQ());
		this.item3_3.addActionListener(new BoutonAuteurs());
		this.item3_4.addActionListener(new BoutonVersion());

		// On insère tous les menus dans la le menuBar
		this.barreDeMenu.add(this.menu1);
		this.barreDeMenu.add(this.menu2);

		// On l'ajoute à la fenêtre
		this.setJMenuBar(this.barreDeMenu);

		unTableau.setBackground(Color.GRAY);
		this.setContentPane(unTableau);
		this.setVisible(true);
	}

}
