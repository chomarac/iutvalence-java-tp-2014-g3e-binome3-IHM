package fr.iutvalence.java.morpion.ihm;

/** Tache gerant l'IHM.
 * 
 * @author CHOMARAT & ANDRE
 * @version 1.0.0
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre implements Runnable {

	/**Item Partie du menu.*/
	private JMenuItem menuPartie;
	
	/**Item Aide du menu.*/
	private JMenuItem menuAide;
	
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
		
		JMenu Partie = new JMenu("Partie");
		
		JMenu Aide = new JMenu("Aide");
		
		BarreMenu.add(Partie);
		
		fenetre.setJMenuBar(BarreMenu);
		
		
		
	}
}
