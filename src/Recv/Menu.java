package Recv;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
//Page de remplissage des détails des points 
public class Menu extends JPanel {
	//un form correspond à un les champs d'un seul point
	ArrayList<Form> af=new ArrayList<Form>();
	//L'ensemble des points à spécifier ses détails 
	ArrayList<Point> ap=new ArrayList<Point>();
	JButton jb;
	app a;
	//Constructer de la classe menu
	public Menu(app ap1,int nbre,JButton jb) {
		super();
		this.jb=jb;
		this.a=ap1;
		this.setOpaque(true);
		paintImmediately(getBounds());
		this.setVisible(true);
		//création d'un grid layout selon le nombre de points saisi par l'utilisateur
		if(nbre%2==0)
		this.setLayout(new GridLayout(nbre/2,2));
		else this.setLayout(new GridLayout(nbre/2+1,2));
		for(int i=0;i<nbre;i++)
		{
			//Création d'un forme il prend comme argument l'id du point
			Form f=new Form(i+1);
			//L'ajout du forme au menu 
			this.add(f);
			//L'ajout du forme au arraylist des formes
			af.add(f);
		}
		//Action liée au button Commencer
		 jb.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		//Pour chaque form
	        		for(int i=0;i<af.size();i++)
	        		{
	        			//On récupere les valuers de champs 
	        			Float.parseFloat(af.get(i).getVitesse().getText());
	        			//On Créé un objet point avec les valuers spécifié par l'utilisateur
	        			Point p=new Point(af.get(i).id,Integer.parseInt(af.get(i).getXvalue().getText()),Integer.parseInt(af.get(i).getYvalue().getText()),Integer.parseInt(af.get(i).getXinter().getText()),Integer.parseInt(af.get(i).getYinter().getText()),Integer.parseInt(af.get(i).getVitesse().getText()),Integer.parseInt(af.get(i).getXdest().getText()),Integer.parseInt(af.get(i).getYdest().getText()));
	        			//Ajout du point au arraylist des points 
	        			ap.add(p);
	        		}
	        		//initialise la grille 
	        		a.initialize();
	        		//On ferme la fenetre du menu
	     	       a.getFrame1().setVisible(false);
	     	       a.getFrame1().dispose();
	        	}
	        });
	}
	public ArrayList<Point> getAp() {
		return ap;
	}
	public void setAp(ArrayList<Point> ap) {
		this.ap = ap;
	}
	@Override
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(new Color(2, 52, 73));
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
