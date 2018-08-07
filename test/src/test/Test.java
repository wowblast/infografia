package test;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Test extends JFrame implements ActionListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Test t;
	 JButton pintar;
	 JLabel posicion_x;
	 JLabel posicion_y;
	 JLabel Titulo;
	 JButton borrar;
	 JButton pintar_alg1;
	 JLabel[][]  matriznumeros;
	 Border border;
	 JFrame ventana;
	 JPanel mainPanel;
	 JPanel cuadriculaPanel;
	 JTextField areax;
	 JTextField areay;
	 JTextField areaxa,areaya,areaxb,areayb;
	 JLabel p1,p2;
	 int[] numeros;
	 int count;
	 
	 
	 
	 
	public Test()
	{
		  count = 1;
		 numeros = new int[4];
		    for(int r=0;r<numeros.length;r++)
		    {
		    	numeros[r]=9999;
		    }
		    int n=100;
		
		
	        ventana = new JFrame("Cuadrícula");
	
	        ventana.setSize(1500,1000);
	        ventana.setResizable(false);
	        ventana.setLayout(null);
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        mainPanel = new JPanel();
	        
	        mainPanel.setBounds((1000), 0, (500), 1000);
	        mainPanel.setVisible(true);
	        mainPanel.setLayout(null);
	        mainPanel.setBackground(Color.CYAN);
	        ventana.add(mainPanel);
	        
	        cuadriculaPanel = new JPanel();
	        
	        cuadriculaPanel.setBounds(0, 0, 1000, 1000);
	        cuadriculaPanel.setVisible(true);
	        cuadriculaPanel.setLayout(null);
	        
	        ventana.add(cuadriculaPanel);
	        
	     
	        border = BorderFactory.createLineBorder(Color.black, 1);
	        Point punto=MouseInfo.getPointerInfo().getLocation();
	        int xx=punto.x;
	        int yy=punto.y;
	        
	        Titulo = new JLabel();
	        Titulo.setBounds(200, 0,100, 25);
	        Titulo.setText("MINI_PAINT");
	        //Titulo.
	        mainPanel.add(Titulo);
	        
	        posicion_x = new JLabel("Poscicion 1");
	        posicion_x.setBounds(0,500, 100, 25);
	        posicion_x.setText("Posición x:");
	        mainPanel.add(posicion_x);
	        
	        posicion_y = new JLabel("Poscicion 1");
	        posicion_y.setBounds(0,550, 100, 25);
	        posicion_y.setText("Posición y:");
	        mainPanel.add(posicion_y);
	        
	        
	        pintar = new JButton();
	        pintar.setText("Pintar");
	        pintar.setBounds(180, 200, 100, 25);
	        pintar.addActionListener(this);
	        mainPanel.add(pintar);
	        
	        borrar = new JButton();
	        borrar.setText("Borrar todo");
	        borrar.setBounds(300, 200, 100, 25);
	        borrar.addActionListener(this);
	        mainPanel.add(borrar);
	       
	        	        
	        pintar_alg1 = new JButton();
	        pintar_alg1.setText("Pintar_algoritmo 1");
	        pintar_alg1.setBounds(0, 200, 150, 25);
	        pintar_alg1.addActionListener(this);
	        mainPanel.add(pintar_alg1);
	        
	        areax = new JTextField();
	        areax.setText("0");
	        areax.setBounds(100, 500, 50, 25);
	        mainPanel.add(areax);

	        areay = new JTextField();
	        areay.setText("0");
	        areay.setBounds(100, 550, 50, 25);
	        mainPanel.add(areay);
	        
	        p1 = new JLabel();
	        p1.setBounds(220,270, 100, 25);
	        p1.setText("PUNTO 1");
	        mainPanel.add(p1);
	        
	        areaxa = new JTextField();
	        areaxa.setText("0");
	        areaxa.setBounds(200, 300, 25, 25);
	        mainPanel.add(areaxa);
	        
	        areaya = new JTextField();
	        areaya.setText("0");
	        areaya.setBounds(250, 300, 25, 25);
	        mainPanel.add(areaya);
	        
	        p2 = new JLabel();
	        p2.setBounds(220,370, 100, 25);
	        p2.setText("PUNTO 2");
	        mainPanel.add(p2);
	        
	        areaxb = new JTextField();
	        areaxb.setText("0");
	        areaxb.setBounds(200, 400, 25, 25);
	        mainPanel.add(areaxb);
	        
	        areayb = new JTextField();
	        areayb.setText("0");
	        areayb.setBounds(250, 400, 25, 25);
	        mainPanel.add(areayb);
	              


            matriznumeros = new JLabel[n][n];
            
            for(int x=0;x<matriznumeros.length;x++)
            {
            	for(int y=0;y<matriznumeros.length;y++)
            	{
            		matriznumeros[x][y]= new JLabel();
            		
            	}
            }
           formar_cuadricula_base();
           
           for(int a=0;a<matriznumeros.length;a++)
           {
        	   for(int b=0;b<matriznumeros.length;b++)
        	   {
        		   matriznumeros[a][b].addMouseListener(new MouseAdapter(){
        			@Override  
        			public void mouseClicked( MouseEvent ev) 
        			{
        				 for(int a1=0;a1<matriznumeros.length;a1++)
        		           {
        		        	   for(int b1=0;b1<matriznumeros.length;b1++)
        		        	   {
        		        	     if(matriznumeros[a1][b1]==ev.getSource())
        		        	     {
        		        	    	 posiciones(a1, b1);
        		        	    	 System.out.println("posicion x "+b1+" y "+a1);
        		        	     }
        		        	   }
        		           }
        			}
        		   });
        	   }
           }
          
	      
	      
        
          ventana.setVisible(true);
  	      


        
	}
	 public void actionPerformed(ActionEvent e) {
	        if (e.getSource()==borrar) {
	        	
	        	cuadriculaPanel.removeAll();
	        	cuadriculaPanel.revalidate();
	        	cuadriculaPanel.repaint();
	        	 formar_cuadricula_base();
	        	
	        	 
	        }
	        if(e.getSource()==pintar)
	        {
	        	 matriznumeros[Integer.parseInt((areax.getText()))][Integer.parseInt((areay.getText()))].setBackground(Color.GREEN);
	        	 System.out.println("asd");
	        }
	        if(e.getSource()==pintar_alg1)
	        {
	        	crear_algoritmo_1(Integer.parseInt((areaxa.getText())), Integer.parseInt((areaya.getText())), Integer.parseInt((areaxb.getText())), Integer.parseInt((areayb.getText())));
	        }
	    }
	 
	 public void formar_cuadricula_base()
	 {
		 
		 for(int x=0;x<matriznumeros.length;x++)
         {
         	for(int y=0;y<matriznumeros.length;y++)
         	{
         		
         		matriznumeros[x][y].setBackground(Color.WHITE);
         		matriznumeros[x][y].setBorder(border);
         		matriznumeros[x][y].setOpaque(true);
         		matriznumeros[x][y].setVisible(true);
         		matriznumeros[x][y].setBounds(x*10, y*10, 10, 10);
         		cuadriculaPanel.add(matriznumeros[x][y],0);
         		
         	}
         }
	 }
	 public void crear_algoritmo_1(int xa,int ya,int xb,int yb)
	 {
		 int dx = xb-xa;
		 int dy = yb-ya;
		 int steps,k;
		 float xincrement,yincrement,x,y;
		 x =xa;
		 y = ya;
		 
		 if(Math.abs(dx)> Math.abs(dy))
		 {
			 steps = Math.abs(dx);
		 }
		 else
		 {
			 steps= Math.abs(dy);
		 }
		 xincrement = dx/((float)steps);
		 yincrement = dy/((float)steps);
		  matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		 for(k=0;k<steps;k++)
		 {
			 x += xincrement;
			 y += yincrement;
			 matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		 }
	 }
	 public void posiciones(int x,int y)
	 {
		 
		 
		 if(count==1)
		 {
			 areaxa.setText(""+x);
			 areaya.setText(""+y);
			 count=2;
		 }
		 else 
		 {
			 areaxb.setText(""+x);
			 areayb.setText(""+y);
			 count=1;
			 System.out.println("dadsasd");
		 }
		 
		
		  
		 
	 }
    public static void main(String[] args){
    
         new Test();
    
    }  
}