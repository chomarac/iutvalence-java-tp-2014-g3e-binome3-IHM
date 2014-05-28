package fr.iutvalence.java.morpion.ihm;

/** Tache gerant l'IHM.
 * 
 * @author CHOMARAT & ANDRE
 * @version 1.0.0
 */

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import fr.iutvalence.java.morpion.modele.Joueur;

public class Fenetre implements Runnable, InterfaceIHM {
	
	private ControleurIHM controleur;
	
	private JButton[][] tab = new JButton[3][3];
	
	@Override
	public void run(){
		
		JFrame fenetre = new JFrame();
		
		/**On rentre les parametres de la fenetre.*/
		fenetre.setTitle("Morpion");
		fenetre.setSize(800,800);
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**Menu de la fenetre*/
		JMenuBar BarreMenu = new JMenuBar();
		
		/** Menu "Partie" */
		JMenu Partie = new JMenu("Partie");
		BarreMenu.add(Partie);

		JMenuItem NouvellePartie = new JMenuItem("Nouvelle Partie");
		Partie.add(NouvellePartie);

		JMenuItem Fermer = new JMenuItem("Fermer");
		Partie.add(Fermer);

		JMenu Aide = new JMenu("Aide");
		BarreMenu.add(Aide);

		JMenu APropos = new JMenu("A propos");
		BarreMenu.add(APropos);		

		fenetre.setJMenuBar(BarreMenu);
		
		JSplitPane JSplitPaneVertical = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		fenetre.getContentPane().add(JSplitPaneVertical);
		JSplitPaneVertical.setEnabled(false);
		JSplitPaneVertical.setBorder(null);
		JSplitPaneVertical.setDividerSize(1);
		JSplitPaneVertical.setResizeWeight(0.2);
		
		JSplitPane JSplitPaneGaucheHorizontal = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JSplitPaneGaucheHorizontal.setEnabled(false);
		JSplitPaneGaucheHorizontal.setBorder(null);
		JSplitPaneGaucheHorizontal.setDividerSize(1);
		JSplitPaneGaucheHorizontal.setResizeWeight(0.5);
		JSplitPaneVertical.add(JSplitPaneGaucheHorizontal);

		
		JSplitPane JSplitPaneDroiteHorizontal = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JSplitPaneDroiteHorizontal.setEnabled(false);
		JSplitPaneDroiteHorizontal.setBorder(null);
		JSplitPaneDroiteHorizontal.setDividerSize(1);
		JSplitPaneDroiteHorizontal.setResizeWeight(0.1);
		JSplitPaneVertical.add(JSplitPaneDroiteHorizontal);
			
	    Box BoxJoueur1 = Box.createHorizontalBox();
		JSplitPaneGaucheHorizontal.add(BoxJoueur1);
		BoxJoueur1.add(new JLabel("Joueur 1"));
		
		Box BoxJoueur2 = Box.createHorizontalBox();
		JSplitPaneGaucheHorizontal.add(BoxJoueur2);
		BoxJoueur2.add(new JLabel("Joueur 2"));
		
		JSplitPaneDroiteHorizontal.add(new JLabel("C'est à joueur x de jouer."));
		
	//	JSplitPaneDroiteHorizontal.setAlignmentX(SwingConstants.CENTER);
		
		JPanel morpion = new JPanel();
		morpion.setLayout(new GridLayout(3,3));
		JSplitPaneDroiteHorizontal.add(morpion);
		
		// XXX Changer l'affectation.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				morpion.add(new JButtonMorpion(i, j, this, this.controleur));
			}
		}		
	}

	@Override
	public void placerPion(int ligne, int colonne, Joueur joueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void victoire(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nul() {
		// TODO Auto-generated method stub
		
	}
}
