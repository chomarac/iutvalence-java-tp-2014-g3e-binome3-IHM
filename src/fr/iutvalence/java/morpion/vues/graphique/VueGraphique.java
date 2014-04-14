package fr.iutvalence.java.morpion.vues.graphique;

import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonAProposDe;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonHistoriqueDesScores;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonJouer;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonQuitter;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonReglesDuJeu;
import fr.iutvalence.java.morpion.vues.graphique.boutons.BoutonVersion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Modélisation d'une fenêtre graphique
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 * */
public class VueGraphique extends JFrame                                                                  
{
	/** Modélisation d'une case. */
	private final class Case extends JButton implements ActionListener
	{
		/** Utilisé pour sérialiser. */
		private static final long serialVersionUID = 1L;
		
		/** La coordonnée en x sur la grille. */
		private final int x;
		
		/** La coordonnée en y sur la grille. */
		private final int y;
		
		/**
		 * Modélisation d'une case avec plusieurs paramètres.
		 * 
		 * @param nom Le nom de la case.
		 * @param x La coordonnée en x sur la grille.
		 * @param y La coordonnée en y sur la grille.
		 */
		public Case(String nom, int x, int y)
		{
			super(nom);
			this.addActionListener(this);
			this.x = x;
			this.y = y;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			VueGraphique.this.unControleur.placerPion(this.x, this.y);
		}
	}

	/** Utilisé pour serialiser. */
	private static final long serialVersionUID = 1L;

	/** Un objet qui contiendra toutes les informations à afficher */
	public static final JPanel unTableau = new JPanel();

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
	
	/** Un controleur. */
	private ControleurGraphique unControleur;
	
	/** Modélisation de la fenêtre graphique. */
	public VueGraphique()
	{
		this.unControleur = new ControleurGraphique();
		
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
		
		unTableau.setLayout(new GridLayout(3,3));
		unTableau.add(new Case("1",1,1));
		unTableau.add(new Case("2",1,2));
		unTableau.add(new Case("3",1,3));
		unTableau.add(new Case("4",2,1));
		unTableau.add(new Case("5",2,2));
		unTableau.add(new Case("6",2,3));
		unTableau.add(new Case("7",3,1));
		unTableau.add(new Case("8",3,2));
		unTableau.add(new Case("9",1,1));
		
		unTableau.setBackground(Color.WHITE);
		this.setContentPane(unTableau);
		this.setVisible(true);
	}
}
