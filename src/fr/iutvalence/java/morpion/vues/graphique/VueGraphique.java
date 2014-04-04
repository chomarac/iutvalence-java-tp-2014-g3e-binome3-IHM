package fr.iutvalence.java.morpion.vues.graphique;

import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonAProposDe;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonHistoriqueDesScores;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonJouer;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonQuitter;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonReglesDuJeu;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonVersion;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case1;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case2;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case3;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case4;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case5;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case6;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case7;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case8;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case9;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

/** Modélisation d'une fenêtre graphique
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 * */
public class VueGraphique extends JFrame
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

	/** Troisième sous-menu */
	private JMenuItem item1_2 = new JMenuItem("Quitter");

	/** Premier menu principal : Score */
	private JMenu menu2 = new JMenu("Score(s)");

	/** Premier sous-menu */
	private JMenuItem item2_1 = new JMenuItem("Historique des scores");
	
	/** Deuxième menu principal : Edition */
	private JMenu menu3 = new JMenu("Aide");

	/** Premier sous-menu de Actions disponibles */
	private JMenuItem item3_1 = new JMenuItem("Règles du jeu");

	/** Deuxième sous-menu de Actions disponibles */
	private JMenuItem item3_2 = new JMenuItem("Version");

	/** Troisième menu principal : A propos */
	private JMenuItem item3_3 = new JMenuItem("A propos de");
	

	/** Fenetre avec des composantes graphiques */
	public VueGraphique()
	{
		this.setTitle("Morpion");
		this.setSize(400, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Ajout des actions possibles dans le menu "Partie"
		this.menu1.add(this.item1_1);
		this.menu1.addSeparator();
		this.menu1.add(this.item1_2);

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
		this.item1_2.addActionListener(new BoutonQuitter());
		this.item2_1.addActionListener(new BoutonHistoriqueDesScores());
		this.item3_1.addActionListener(new BoutonReglesDuJeu());
		this.item3_2.addActionListener(new BoutonVersion());
		this.item3_3.addActionListener(new BoutonAProposDe());

		// On insère tous les menus dans la le menuBar
		this.barreDeMenu.add(this.menu1);
		this.barreDeMenu.add(this.menu2);
		this.barreDeMenu.add(this.menu3);

		// On l'ajoute à la fenêtre
		this.setJMenuBar(this.barreDeMenu);
		
		JButton Case1 = new JButton("1");
		JButton Case2 = new JButton("2");
		JButton Case3 = new JButton("3");
		JButton Case4 = new JButton("4");
		JButton Case5 = new JButton("5");
		JButton Case6 = new JButton("6");
		JButton Case7 = new JButton("7");
		JButton Case8 = new JButton("8");
		JButton Case9 = new JButton("9");
		
		Case1.addActionListener(new Case1());
		Case2.addActionListener(new Case2());
		Case3.addActionListener(new Case3());
		Case4.addActionListener(new Case4());
		Case5.addActionListener(new Case5());
		Case6.addActionListener(new Case6());
		Case7.addActionListener(new Case7());
		Case8.addActionListener(new Case8());
		Case9.addActionListener(new Case9());
		
		unTableau.setLayout(new GridLayout(3,3));
		unTableau.add(Case1);
		unTableau.add(Case2);
		unTableau.add(Case3);
		unTableau.add(Case4);
		unTableau.add(Case5);
		unTableau.add(Case6);
		unTableau.add(Case7);
		unTableau.add(Case8);
		unTableau.add(Case9);
		
		unTableau.setBackground(Color.WHITE);
		this.setContentPane(unTableau);
		this.setVisible(true);
	}

}
