package Recv;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Recv.Menu;

public class app {

	private JFrame frame;
	private JFrame frame1=new JFrame();
	Menu m;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
	pre();
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void pre()
	{
		String label = JOptionPane.showInputDialog("Donner le nombre d'objets (Max 10)");
		int nbre=Integer.parseInt(label);
		JButton jb=new JButton("Commencer");
		 m=new Menu(this,nbre,jb);
		 m.setBackground(new Color(2, 52, 73));
		 jb.setBackground(new Color(242, 125, 66));
		 JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		// sp.setBackground(new Color(2, 52, 73));
			sp.setResizeWeight(0.99);
			sp.setDividerSize(0);
			sp.add(m);
			JPanel jp=new JPanel();
			jp.setBackground(new Color(2, 52, 73));
			jp.add(jb);
			sp.add(jp);
		frame1.getContentPane().add(sp);
		frame1.setBounds(100, 100, 661, 640);
		frame1.setVisible(true);
	}
	public JFrame getFrame1() {
		return frame1;
	}

	public void setFrame1(JFrame frame1) {
		this.frame1 = frame1;
	}

	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 10, 738,798);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel j=new JPanel();
		j.setBackground(new Color(85, 189, 202));
		JButton Commander = new JButton("Commander");
		Commander.setBackground(new Color(242, 125, 66));
		j.add(Commander);
		GridPanel gp=new GridPanel(Commander);
		gp.setAm(m.getAp());
		JSplitPane panel_2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    panel_2.setResizeWeight(0.995);
		panel_2.setDividerSize(0);
		panel_2.add(gp);
		panel_2.add(j);
		frame.setContentPane(panel_2);
	}	
}
