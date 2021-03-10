package Recv;
import java.awt.Color;
import java.util.Random;
//Classe qui représente un objet point
public class Point {
	private int id;
private int x;
private int y;
//les cordonnées de la case intermediaire 
private int xi;
private int yi;
// vitesse du point
private int vitesse;
// couleur du point
private Color c;
//les cordonnées de la case destination 
private int xdest;
private int ydest;
//Constructeur de la classe point
public Point(int id, int x, int y,int xi,int yi,int vitesse, int xdest, int ydest) {
	super();
	//géneration d'une couleur alèatoire
	Random rand = new Random();
	   float r1 = rand.nextFloat();
	   float g1 = rand.nextFloat();
	   float b = rand.nextFloat();
	   c=new Color(r1,g1,b);
	this.id = id;
	this.x = x;
	this.y = y;
	this.xi=xi;
	this.yi=yi;
	this.vitesse = vitesse;
	this.xdest = xdest;
	this.ydest = ydest;
}
public int getXdest() {
	return xdest;
}
public void setXdest(int xdest) {
	this.xdest = xdest;
}
public int getYdest() {
	return ydest;
}
public void setYdest(int ydest) {
	this.ydest = ydest;
}
public Color getC() {
	return c;
}
public void setC(Color c) {
	this.c = c;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getVitesse() {
	return vitesse;
}
public void setVitesse(int vitesse) {
	this.vitesse = vitesse;
}
public Point(int id,int x, int y, int vitesse) {
	super();
	Random rand = new Random();
	   float r1 = rand.nextFloat();
	   float g1 = rand.nextFloat();
	   float b = rand.nextFloat();
	   c=new Color(r1,g1,b);
	this.id=id;
	this.x = x;
	this.y = y;
	this.vitesse = vitesse;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getXi() {
	return xi;
}
public void setXi(int xi) {
	this.xi = xi;
}
public int getYi() {
	return yi;
}
public void setYi(int yi) {
	this.yi = yi;
}
//Affichage d'un point
public String toString()
{
String desc="";
desc+="x : "+this.x+" y : "+this.y+" xi : "+this.xi+" yi : "+this.yi+" xf : "+this.xdest+" yf : "+this.ydest;
return desc;
}

}
