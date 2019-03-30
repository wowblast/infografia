package test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Algoritmos {

	static Border border =  BorderFactory.createLineBorder(Color.black, 1);
	static ArrayList<Integer> Puntos = new ArrayList<Integer>();
	static int count=1;
	static int k=0;

	static int numeros_objeto=1;
	static int []posicion= new int[6];
	//ArrayList<String>[][] list = new ArrayList[10][10];
	static ArrayList<ArrayList<Integer>> aObject = new ArrayList<ArrayList<Integer>>();


	public Algoritmos()
	{

	}

	public static void algoritmobresenham(int x,int y,int x2, int y2, int[] color) {
	    int w = x2 - x ;
	    int h = y2 - y ;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
	    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
	    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
	    int longest = Math.abs(w) ;
	    int shortest = Math.abs(h) ;
	    if (!(longest>shortest)) {
	        longest = Math.abs(h) ;
	        shortest = Math.abs(w) ;
	        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
	        dx2 = 0 ;            
	    }
	    int numerator = longest >> 1 ;
	    for (int i=0;i<=longest;i++) {
	        
	        Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
			aObject.add(new ArrayList<Integer>());
			aObject.get(k).add(new Integer(Math.round(x)));
			aObject.get(k).add(new Integer(Math.round(y)));
			aObject.get(k).add(new Integer(numeros_objeto));
			aObject.get(k).add(new Integer(color[0]));
			aObject.get(k).add(new Integer(color[1]));
			aObject.get(k).add(new Integer(color[2]));
			k++;
	        numerator += shortest ;
	        if (!(numerator<longest)) {
	            numerator -= longest ;
	            x += dx1 ;
	            y += dy1 ;
	        } else {
	            x += dx2 ;
	            y += dy2 ;
	        }
	    }
	    numeros_objeto++;
	}
	
	public static void crear_algoritmo_1(int xa,int ya,int xb,int yb,int[]color)
	{
		

		int dx = xb-xa;
		int dy = yb-ya;
		int steps,a;
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

		Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(Math.round(x)));
		aObject.get(k).add(new Integer(Math.round(y)));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;

		for(a=0;a<steps;a++)
		{
			x += xincrement;
			y += yincrement;

			Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
			aObject.add(new ArrayList<Integer>());
			aObject.get(k).add(new Integer(Math.round(x)));
			aObject.get(k).add(new Integer(Math.round(y)));
			aObject.get(k).add(new Integer(numeros_objeto));
			aObject.get(k).add(new Integer(color[0]));
			aObject.get(k).add(new Integer(color[1]));
			aObject.get(k).add(new Integer(color[2]));
			k++;
		}
		numeros_objeto++;
		int d=1;
		for(d=0;d<aObject.size();d++)
		{
			System.out.println(aObject.get(d).get(2));
		}
		d=0;

	}


	public static void posiciones(int x,int y)
	{


		if(count==1)
		{
			Test.areaxa.setText(""+x);
			Test.areaya.setText(""+y);
			Test.areax.setText(""+x);
			Test.areay.setText(""+y);
			count=2;
		}
		else if (count==2)
		{
			Test.areaxb.setText(""+x);
			Test.areayb.setText(""+y);
			count=3;
		}
		else 
		{
			Test.areaxc.setText(""+x);
			Test.areayc.setText(""+y);
			count=1;

		}




	}
	public static void pintarcirculo(int xcenter,int ycenter,int radius,int[]color)
	{

		int x=0;
		int y= radius;
		int p = 1-radius;
		pintarcirpuntos(xcenter, ycenter, x,y,color);

		while(x<y)
		{
			x++;
			if(p<0)
			{
				p +=2*(x)+1;
			}
			else
			{
				y--;
				p +=2*(x-y)+1;
			}
			pintarcirpuntos(xcenter, ycenter, x, y,color);
		}
		numeros_objeto++;
	}
	public static void pintarcirpuntos(int xcenter,int ycenter, int x, int y,int[]color)
	{
		Test.matriznumeros[xcenter+x][ycenter+y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter+x));
		aObject.get(k).add(new Integer(ycenter+y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter-x][ycenter+y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter-x));
		aObject.get(k).add(new Integer(ycenter+y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter+x][ycenter-y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter+x));
		aObject.get(k).add(new Integer(ycenter-y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter-x][ycenter-y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter-x));
		aObject.get(k).add(new Integer(ycenter-y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter+y][ycenter+x].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter+y));
		aObject.get(k).add(new Integer(ycenter+x));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter-y][ycenter+x].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter-y));
		aObject.get(k).add(new Integer(ycenter+x));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter+y][ycenter-x].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter+y));
		aObject.get(k).add(new Integer(ycenter-x));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xcenter-y][ycenter-x].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xcenter-y));
		aObject.get(k).add(new Integer(ycenter-x));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;


	}
	public static void ellipseMidpoint (int xCenter, int yCenter, int Rx, int Ry,int[]color)
	{
		int Rx2 = Rx*Rx;
		int Ry2 = Ry*Ry;
		int twoRx2 = 2*Rx2;
		int twoRy2 = 2*Ry2;
		int p;
		int x = 0;
		int y = Ry;
		int px = 0;
		int py = twoRx2*y;

		ellipsePlotPoints (xCenter, yCenter, x, y,color);

		p = (int) Math.round (Ry2 - (Rx2*Ry) + (0.25*Rx2));
		while (px < py) {
			x++;
			px += twoRy2;
			if (p < 0){
				p += Ry2 + px;
			}
			else {
				y--;
				py -= twoRx2;
				p += Ry2 + px - py;

				//
			}

			ellipsePlotPoints (xCenter, yCenter, x, y,color);
		}
		/* Region 2 */
		p = (int) Math.round (Ry2*(x+0.5)*(x+0.5) + Rx2*(y-1)*(y-1) - Rx2*Ry2);
		while (y > 0) 
		{
			y--;
			py -= twoRx2;
			if (p > 0)
			{
				p += Rx2 - py;
			}
			else {
				x++;
				px += twoRy2;
				p += Rx2 - py + px; 
			}
			ellipsePlotPoints (xCenter, yCenter, x, y,color);
		}

		numeros_objeto++;
	}

	public static void ellipsePlotPoints (int xCenter, int yCenter, int x, int y,int[]color){




		Test.matriznumeros[xCenter+x][yCenter+y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xCenter+x));
		aObject.get(k).add(new Integer(yCenter+y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xCenter-x][yCenter+y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xCenter-x));
		aObject.get(k).add(new Integer(yCenter+y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xCenter+x][yCenter-y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xCenter+x));
		aObject.get(k).add(new Integer(yCenter-y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;
		Test.matriznumeros[xCenter-x][yCenter-y].setBackground(new Color(color[0],color[1],color[2]));
		aObject.add(new ArrayList<Integer>());
		aObject.get(k).add(new Integer(xCenter-x));
		aObject.get(k).add(new Integer(yCenter-y));
		aObject.get(k).add(new Integer(numeros_objeto));
		aObject.get(k).add(new Integer(color[0]));
		aObject.get(k).add(new Integer(color[1]));
		aObject.get(k).add(new Integer(color[2]));
		k++;

	}
	public static void fill(int x, int y,int[]boundary)
	{
		int [] current = new int[3];
		int [] blanco = new int[3];
		current[0]=Test.matriznumeros[x][y].getBackground().getRed();
		current[1]=Test.matriznumeros[x][y].getBackground().getGreen();
		current[2]=Test.matriznumeros[x][y].getBackground().getBlue();
		blanco[0]=255;
		blanco[1]=255;
		blanco[2]=255;
		if(!Arrays.equals(blanco, current))
		{
			System.out.println("no es");
		}

		if (!Arrays.equals(current,boundary)&&Arrays.equals(blanco, current)){


			Test.matriznumeros[x][y].setBackground( new Color(boundary[0], boundary[1], boundary[2]) );

			// recursive call
			fill(x + 1, y,  boundary);
			fill(x - 1, y,  boundary);
			fill(x, y + 1,boundary);
			fill(x, y - 1,  boundary);
		}

	}
	public static  void mover(String direccion,int objeto)

	{
		switch(direccion)
		{
		case "up":
			try{
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)].setBackground(Color.WHITE);
					}
				}
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)-1].setBackground(new Color(aObject.get(x).get(3),aObject.get(x).get(4),aObject.get(x).get(5)));
						aObject.get(x).set(1, aObject.get(x).get(1)-1);
					}

				}
			}
			catch(Exception e)
			{

			}
			break;
		case "down":
			try{

				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)].setBackground(Color.WHITE);
					}
				}
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)+1].setBackground(new Color(aObject.get(x).get(3),aObject.get(x).get(4),aObject.get(x).get(5)));
						aObject.get(x).set(1, aObject.get(x).get(1)+1);
					}
				}
			}
			catch(Exception e)
			{

			}

			break;
		case "right":
			try{
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)].setBackground(Color.WHITE);
					}
				}
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0)+1)][aObject.get(x).get(1)].setBackground(new Color(aObject.get(x).get(3),aObject.get(x).get(4),aObject.get(x).get(5)));
						aObject.get(x).set(0,aObject.get(x).get(0)+1);
					}

				}
			}
			catch(Exception e)
			{

			}
			break;
		case "left":
			try{
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)].setBackground(Color.WHITE);
					}
				}
				for(int x=0;x<aObject.size();x++)
				{
					if(aObject.get(x).get(2)==objeto)
					{
						Test.matriznumeros[(aObject.get(x).get(0)-1)][aObject.get(x).get(1)].setBackground(new Color(aObject.get(x).get(3),aObject.get(x).get(4),aObject.get(x).get(5)));
						aObject.get(x).set(0,aObject.get(x).get(0)-1);
					}

				}
			}
			catch(Exception e)
			{

			}
			break;

		}
	}
	public static int obtener_objeto(int x,int y)
	{

		int x1=0;
		boolean obj=false;
		int objeto=0;
		while(!obj)
		{
			System.out.println("entra");
			if(x1>=aObject.size())
			{
				System.out.println("no hay");
				break;
			}
			if((aObject.get(x1).get(0)==x)&&(aObject.get(x1).get(1)==y))
			{
				objeto=aObject.get(x1).get(2);
				obj=!obj;
			}

			x1++;
		}
		System.out.println("objeto es "+objeto);
		return objeto;

	}
	public static void rotate(int xp,int yp,int objeto)
	{
		int i;
		int x1,y1=0;
		double angle= Math.toRadians(90);

		for(int x=0;x<aObject.size();x++)
		{
			if(aObject.get(x).get(2)==objeto)
			{
				Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)].setBackground(Color.WHITE);
			}

		}
		for(i=0;i<aObject.size();i++)
		{
			if(aObject.get(i).get(2)==objeto)
			{int x= aObject.get(i).get(0);
			int y= aObject.get(i).get(1);
			int x_origin= xp;
			int y_origin=yp;
			int new_x = (int) (((x - x_origin) * Math.cos(angle)) - ((y_origin - y) * Math.sin(angle)) + x_origin);
			int new_y = (int) (((y_origin - y) * Math.cos(angle)) - ((x - x_origin) * Math.sin(angle)) + y_origin);

			aObject.get(i).set(0,new_x);
			aObject.get(i).set(1,new_y);
			System.out.println(new_x+" "+new_y);
			}
		}

		for(int x=0;x<aObject.size();x++)
		{
			if(aObject.get(x).get(2)==objeto)
			{
				Test.matriznumeros[(aObject.get(x).get(0))][aObject.get(x).get(1)].setBackground(new Color(aObject.get(x).get(3),aObject.get(x).get(4),aObject.get(x).get(5)));

			}

		}
	}

}

