package Recv;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;

public class Form extends JPanel {
	private JTextField xvalue;
	private JTextField yvalue;
	private JTextField vitesse;
	
	public JTextField getXvalue() {
		return xvalue;
	}
	public void setXvalue(JTextField xvalue) {
		this.xvalue = xvalue;
	}
	public JTextField getYvalue() {
		return yvalue;
	}
	public void setYvalue(JTextField yvalue) {
		this.yvalue = yvalue;
	}
	public JTextField getVitesse() {
		return vitesse;
	}
	public void setVitesse(JTextField vitesse) {
		this.vitesse = vitesse;
	}
	int id;
	private JTextField xdest;
	private JTextField ydest;
	private JTextField xinter;
	private JTextField yinter;
	public JTextField getXinter() {
		return xinter;
	}
	public JTextField getYinter() {
		return yinter;
	}
	public Form(int a) {
		this.setBackground(new Color(2, 52, 73));
		this.id=a;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_3 = new JLabel("Objet "+a);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 1;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("x :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		xvalue= new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 3;
		add(xvalue, gbc_textField_3);
		xvalue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("y :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		yvalue = new JTextField();
		GridBagConstraints gbc_textField_1_1 = new GridBagConstraints();
		gbc_textField_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1_1.gridx = 3;
		gbc_textField_1_1.gridy = 4;
		add(yvalue, gbc_textField_1_1);
		yvalue.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Vitesse :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		vitesse = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 5;
		add(vitesse, gbc_textField_2);
		vitesse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Xdestination :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		xdest = new JTextField();
		GridBagConstraints gbc_xdest = new GridBagConstraints();
		gbc_xdest.insets = new Insets(0, 0, 5, 5);
		gbc_xdest.fill = GridBagConstraints.HORIZONTAL;
		gbc_xdest.gridx = 3;
		gbc_xdest.gridy = 6;
		add(xdest, gbc_xdest);
		xdest.setColumns(10);
		
		JLabel l = new JLabel("Ydestination :");
		l.setForeground(Color.WHITE);
		l.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_l = new GridBagConstraints();
		gbc_l.anchor = GridBagConstraints.EAST;
		gbc_l.insets = new Insets(0, 0, 5, 5);
		gbc_l.gridx = 1;
		gbc_l.gridy = 7;
		add(l, gbc_l);
		
		ydest = new JTextField();
		GridBagConstraints gbc_ydest = new GridBagConstraints();
		gbc_ydest.insets = new Insets(0, 0, 5, 5);
		gbc_ydest.fill = GridBagConstraints.HORIZONTAL;
		gbc_ydest.gridx = 3;
		gbc_ydest.gridy = 7;
		add(ydest, gbc_ydest);
		ydest.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("X(case intermediaire):");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		xinter = new JTextField();
		GridBagConstraints gbc_xinter = new GridBagConstraints();
		gbc_xinter.insets = new Insets(0, 0, 5, 5);
		gbc_xinter.fill = GridBagConstraints.HORIZONTAL;
		gbc_xinter.gridx = 3;
		gbc_xinter.gridy = 8;
		add(xinter, gbc_xinter);
		xinter.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Y(case intermediaire):");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 9;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		yinter = new JTextField();
		GridBagConstraints gbc_yinter = new GridBagConstraints();
		gbc_yinter.insets = new Insets(0, 0, 0, 5);
		gbc_yinter.fill = GridBagConstraints.HORIZONTAL;
		gbc_yinter.gridx = 3;
		gbc_yinter.gridy = 9;
		add(yinter, gbc_yinter);
		yinter.setColumns(10);
		
	}
	public JTextField getYdest() {
		return ydest;
	}
	public void setYdest(JTextField ydest) {
		this.ydest = ydest;
	}
	public JTextField getXdest() {
		return xdest;
	}
	public void setXdest(JTextField xdest) {
		this.xdest = xdest;
	}

}
