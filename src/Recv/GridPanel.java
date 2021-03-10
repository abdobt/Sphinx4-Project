package Recv;
import javax.swing.*;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.decoder.ResultListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

	public class GridPanel extends JPanel{

	    private static final long serialVersionUID = -5341480790176820445L;
//Le nombre des carrés (40*40)
	    private final int NUM_SQUARES = 1600;
	    //le coté de chaque carré 
	    private final int RECT_SIZE = 18;
	    //arraylist des carré de la grille
	    private ArrayList<Rectangle> grid = null;
	    //Arraylist des cercles
	    private ArrayList<Ellipse2D> circles = null;
	    private int id;
	    //Le point choisis par l'utilisateur
	    private int picked=-1;
	    private ArrayList<Point> am=new ArrayList<Point>();
	    private Color sc;
	    private Result result ;
	    boolean g=false;
	    private cs c;
	    String temp;
	    private boolean f=true;
	    Timer t2;
	    public boolean isF() {
			return f;
		}

		public void setF(boolean f) {
			this.f = f;
		}

		public ArrayList<Point> getAm() {
			return am;
		}

		public void setAm(ArrayList<Point> am) {
			this.am = am;
		}
	    public GridPanel(JButton j) {
	      super();
	      c=new cs(this);
	      //Si on clique sur le button commander
	        j.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		//Initialisation de la reconnaissance vocale
	      		HelloWorld hw=new HelloWorld();
		    	Recognizer recognizer = (Recognizer) hw.cm.lookup("recognizer");
		        recognizer.allocate();
		        // start the microphone or exit if the programm if this is not possible
		        Microphone microphone = (Microphone) hw.cm.lookup("microphone");
		        if (!microphone.startRecording()) {
		            System.out.println("Cannot start microphone.");
		            recognizer.deallocate();
		            System.exit(1);
		        }
		        System.out.println("Say: (left|right|up|down)");
		        temp="";
		        // loop the recognition until the programm exits
		        Thread thread = new Thread(){
		            public void run(){
		            	//Boucle infini 
		              while (true) {
				            System.out.println("Start speaking. Press Ctrl-C to quit.\n");
				            System.out.println("temp  : "+temp);
				            f=true;
				            //On ajoute l'objet qui écoute les actions de l'utilisateur
				          recognizer.addResultListener(c);
				           Callable<Void> callable1 = new Callable<Void>()
				            {
				               @Override
				               public Void call() throws Exception
				               {
				            	   result = recognizer.recognize();
				                  return null;
				               }
				            };
				            Callable<Void> callable2 = new Callable<Void>()
				            {
				               @Override
				               public Void call() throws Exception
				               {
				            	   //si l'utilisateur a déjà spécifier une direction
				                  while(f && !temp.equals("")) {
				                	  if(temp.compareTo("left")==0 && picked!=-1)
						                {
						                	try {
						    	        		Thread.sleep(200*(10-am.get(picked).getVitesse()));
						    				} catch (InterruptedException e1) {
						    					// TODO Auto-generated catch block
						    					e1.printStackTrace();
						    				}
						    	        	int a=am.get(picked).getX()-1;
						    	        	if(a<0)
						    	        	am.get(picked).setX(0);
						    	        		else
						    	        		{
						    	        			am.get(picked).setX(am.get(picked).getX()-1); 
						    	        		}
						                }
						                else if(temp.compareTo("right")==0 && picked!=-1)
						                {
						                	try {
						    	        		Thread.sleep(200*(10-am.get(picked).getVitesse()));
						    				} catch (InterruptedException e1) {
						    					// TODO Auto-generated catch block
						    					e1.printStackTrace();
						    				}
						    	        	int a=am.get(picked).getX()+1;
						    	        	if(a>39)
						    	        	am.get(picked).setX(39);
						    	        		else
						    	        		{
						    	            am.get(picked).setX(am.get(picked).getX()+1);
						    	            }
						                }
						                else if(temp.compareTo("up")==0 && picked!=-1)
						                {
						                
						                	int a=am.get(picked).getY()-1;
						    	        	try {
						    					Thread.sleep(200*(10-am.get(picked).getVitesse()));
						    				} catch (InterruptedException e1) {
						    					// TODO Auto-generated catch block
						    					e1.printStackTrace();
						    				}
						    	        	if(a<0)
						    	        		am.get(picked).setY(0);  
						    	        	else
						    	        	{
						    	            am.get(picked).setY(am.get(picked).getY()-1);
						    	            }  
						                }
						                else if(temp.compareTo("down")==0 && picked!=-1)
						                {
						                	int a=am.get(picked).getY()+1;
						    	        	try {
						    	        		Thread.sleep(200*(10-am.get(picked).getVitesse()));
						    				} catch (InterruptedException e1) {
						    					// TODO Auto-generated catch block
						    					e1.printStackTrace();
						    				}
						    	        	if(a>39)
						    	        		am.get(picked).setY(39);  
						    	        	else
						    	        	{
						    	            am.get(picked).setY(am.get(picked).getY()+1); 
						    	            }
						                }
				                	  //Mise à jour de la grille 
				                	  paintImmediately(getBounds());
				                  }
				                  return null;
				               }
				            };
				            List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
				            taskList.add(callable1);
				            taskList.add(callable2);

				            //create a pool executor with 3 threads
				            ExecutorService executor = Executors.newFixedThreadPool(2);

				            try
				            {
				               //start the threads and wait for them to finish
				               executor.invokeAll(taskList);
				            }
				            catch (InterruptedException ie)
				            {
				               System.out.println("hello error");
				            }
				            //si l'utilisateur a rien dit par exemple c'est le cas au début ou lorsque l'utilisateur a dit stop
				           if (result != null) {
				                String resultText = result.getBestFinalResultNoFiller();
				                System.out.println("You said: " + resultText + '\n');
				                //si l'utilisateur a dit left et on a déjà chosis un point
				                if(resultText.compareTo("left")==0 && picked!=-1)
				                {
				                	//stockage de la direction
				                	temp="left";
				                	try {
				                		//pour représenter la vitesse des points
				    	        		Thread.sleep(200*(10-am.get(picked).getVitesse()));
				    				} catch (InterruptedException e1) {
				    					// TODO Auto-generated catch block
				    					e1.printStackTrace();
				    				}
				    	        	int a=am.get(picked).getX()-1;
				    	        	//On test si on est arrivé à la frontière de la grille 
				    	        	if(a<0)
				    	        		//on reviens à zéro
				    	        	am.get(picked).setX(0);
				    	        		else
				    	        			//On change l'abscisse  du point
				    	            am.get(picked).setX(am.get(picked).getX()-1); 
				    	        	System.out.println("x : "+am.get(picked).getX());
				                }
				                else if(resultText.compareTo("right")==0 && picked!=-1)
				                {
				                	temp="right";
				                	try {
				    	        		Thread.sleep(200*(10-am.get(picked).getVitesse()));
				    				} catch (InterruptedException e1) {
				    					// TODO Auto-generated catch block
				    					e1.printStackTrace();
				    				}
				    	        	int a=am.get(picked).getX()+1;
				    	        	if(a>39)
				    	        	am.get(picked).setX(39);
				    	        		else
				    	            am.get(picked).setX(am.get(picked).getX()+1);
				                }
				                else if(resultText.compareTo("up")==0 && picked!=-1)
				                {
				                	temp="up";
				                	int a=am.get(picked).getY()-1;
				    	        	try {
				    					Thread.sleep(200*(10-am.get(picked).getVitesse()));
				    				} catch (InterruptedException e1) {
				    					// TODO Auto-generated catch block
				    					e1.printStackTrace();
				    				}
				    	        	if(a<0)
				    	        		am.get(picked).setY(0);  
				    	        	else
				    	            am.get(picked).setY(am.get(picked).getY()-1);  
				                }
				                else if(resultText.compareTo("down")==0 && picked!=-1)
				                {
				                	temp="down";
				                	int a=am.get(picked).getY()+1;
				    	        	try {
				    	        		Thread.sleep(200*(10-am.get(picked).getVitesse()));
				    				} catch (InterruptedException e1) {
				    					// TODO Auto-generated catch block
				    					e1.printStackTrace();
				    				}
				    	        	if(a>39)
				    	        		am.get(picked).setY(39);  
				    	        	else
				    	            am.get(picked).setY(am.get(picked).getY()+1); 
				                }
				                //selon l'objet choisis on affecte une nouvelle valeur à picked (qui représente l'objet choisis)
				                //si l'utilisateur a dit one et ainsi de suite
				                else if(resultText.compareTo("one")==0)
				                {
				                	picked=0;
				                }
				                else if(resultText.compareTo("two")==0 && am.size()>1)
				                {
				                	picked=1;
				                }
				                else if(resultText.compareTo("three")==0 && am.size()>2)
				                {
				                	picked=2;
				                }
				                else if(resultText.compareTo("four")==0 && am.size()>3)
				                {
				                	picked=3;
				                }
				                else if(resultText.compareTo("stop")==0) temp="";
				            } else {
				                System.out.println("I can't hear what you said.\n");
				            }
				           //Mise à jour de la grille
			  paintImmediately(getBounds());
				        }
	        }
       };
       thread.start();      		
	      	}
	      });
       grid = new ArrayList<Rectangle>( NUM_SQUARES );
       for( int y=0; y < 40; y++ ) {
           for( int x=0; x <40; x++ ) {
        	   //Création des carrés de la grille 
               Rectangle rect = new Rectangle( x * RECT_SIZE, y * RECT_SIZE, RECT_SIZE, RECT_SIZE );
               //On ajoute le carré crée à l'ensemble des carrés 
               grid.add( rect );
           }
       }
        }
	    //Sert à tester si un point existe dans l'ensemble des points saisis par l'utilisateur
        public boolean exist(Dimension a)
        { 
        	//on itére tout les points
        	for(int i=0;i<am.size();i++)
        	{
        		//on teste si les cordonnées des deux points sont égaux
        		if(am.get(i).getX()==a.width && am.get(i).getY()==a.height)
        		{
        			//on stock la couleur du point et son id 
        			sc=am.get(i).getC();
        			id=am.get(i).getId();
        			return true;
        		}
        	}
        	return false;
        }
      //Sert à tester si une dimension correspond à une case de destination
        public boolean destexist(Dimension a)
        {
        	for(int i=0;i<am.size();i++)
        	{ 
        		//on teste si les cordonnées des deux points sont égaux
        		//cette fois on se base sur les coordonnées de destination
        		if(am.get(i).getXdest()==a.width && am.get(i).getYdest()==a.height)
        		{
          			//on stock la couleur du point et son id 
        			sc=am.get(i).getC();
        			id=am.get(i).getId();
        			return true;
        		}
        	}
        	return false;
        }
        //Sert à tester si une dimension correspond à une case intérmediare
        public boolean interexist(Dimension a)
        {
        	for(int i=0;i<am.size();i++)
        	{
        		//on teste si les cordonnées des deux points sont égaux
        		//cette fois on se base sur les coordonnées de la case intermédiaire
        		if(am.get(i).getXi()==a.width && am.get(i).getYi()==a.height)
        		{
        			//on stock la couleur du point et son id 
        			sc=am.get(i).getC();
        			id=am.get(i).getId();
        			return true;
        		}
        	}
        	return false;
        }
	    @Override
	    protected void paintComponent(Graphics g) { 
	    	super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,    RenderingHints.VALUE_ANTIALIAS_ON);
	        for( Rectangle r : grid ) {
	        	 Dimension d=new Dimension(r.x/18,r.y/18);
	        	 //tester si le carré contient une case destination
	        	 if(destexist(d))
	        	 {
	        		 g2d.setColor(sc);
	        	  g2d.fillRect( r.x, r.y, r.width, r.height );	 
	        	  String Label=String.valueOf(id);
		            int labelWidth = g2d.getFontMetrics().stringWidth(Label);
			        int labelHeight = g2d.getFontMetrics().getHeight();
			        g2d.setColor(Color.white);
			        //On dessine le id des point
			        g2d.drawString(Label, r.x+7-labelWidth/2, r.y+7+labelHeight/4);
	        	 }
	        	 //tester si le carré contient une case intermediare
	        	 else if(interexist(d))
	        	 {
	        		 g2d.setColor(sc);
		        	  g2d.fillRect( r.x, r.y, r.width, r.height );	 
		        	  String Label="I";
			            int labelWidth = g2d.getFontMetrics().stringWidth(Label);
				        int labelHeight = g2d.getFontMetrics().getHeight();
				        g2d.setColor(Color.white);
				        g2d.drawString(Label, r.x+7-labelWidth/2, r.y+7+labelHeight/4); 
	        	 }
	        	 //sinon
	        	 else  
	        	 {
	        		 g2d.setColor(Color.black);
	            g2d.drawRect( r.x, r.y, r.width, r.height );
	        	 }
	        	 //Si le carré contient un point
	           if(exist(d))
	           {
	            g2d.setColor(sc);
	            if(r.y==0)
	            	g2d.fillOval(r.x, r.y, r.width-2, r.height-2);
	            else 
	            	g2d.fillOval(r.x, r.y, r.width-2, r.height-2);
	            g2d.setColor(Color.white);
	            String Label=String.valueOf(id);
	            int labelWidth = g2d.getFontMetrics().stringWidth(Label);
		        int labelHeight = g2d.getFontMetrics().getHeight();
		        g2d.drawString(Label, r.x+7-labelWidth/2, r.y+7+labelHeight/4);
	           }
	        }
	    }
}
