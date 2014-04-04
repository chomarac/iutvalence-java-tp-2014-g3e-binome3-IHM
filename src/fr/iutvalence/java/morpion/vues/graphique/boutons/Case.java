package fr.iutvalence.java.morpion.vues.graphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Case extends JButton implements ActionListener
{
	private final int x;
	private final int y;
	
	public Case(String nom, int x, int y)
	{
		this.x = x;
		this.y = y;
		new JButton(nom);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
