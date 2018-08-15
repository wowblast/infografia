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


	public static void crear_algoritmo_1(int xa,int ya,int xb,int yb,int[]color)
	{
		aObject.add(new ArrayList<Integer>());

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

		Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
		aObject.get(0).add(new Integer(Math.round(x)));
		aObject.get(0).add(new Integer(Math.round(y)));
		aObject.get(0).add(new Integer(numeros_objeto));
		aObject.get(0).add(new Integer(color[0]));
		aObject.get(0).add(new Integer(color[1]));
		aObject.get(0).add(new Integer(color[2]));

		for(k=0;k<steps;k++)
		{
			x += xincrement;
			y += yincrement;

			Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
			aObject.add(new ArrayList<Integer>());
			aObject.get(k+1).add(new Integer(Math.round(x)));
			aObject.get(k+1).add(new Integer(Math.round(y)));
			aObject.get(k+1).add(new Integer(numeros_objeto));
			aObject.get(k+1).add(new Integer(color[0]));
			aObject.get(k+1).add(new Integer(color[1]));
			aObject.get(k+1).add(new Integer(color[2]));
		}
		numeros_objeto++;
	}

	public static void algoritmobresenham(int xa,int ya,int xb, int yb,int[] color)
	{
		int dx = Math.abs(xa-xb);
		int dy = Math.abs(ya-yb);
		int p = 2*dy-dx;
		int twoDY = 2*dy;
		int twoDYDX = 2*(dy-dx);
		int x,y,xend;
		if(xa>xb)
		{
			x=xb; 
			y=yb;
			xend=xa;

		}
		else 
		{
			x=xa;
			y=ya;
			xend=xb;
		}
		Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));


		int m = (yb-ya)/(xb-xa);
		while(x<xend)
		{
			x++;
			if(p<0)
			{
				p += twoDY;
			}
			else
			{
				if(m<0)
				{
					y--;
				}
				else
				{
					y++;
					p += twoDYDX; 
				}

			}
			Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));

			//Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		}
	}
	public static void posiciones(int x,int y)
	{


		if(count==1)
		{
			Test.areaxa.setText(""+x);
			Test.areaya.setText(""+y);
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
			System.out.println("dadsasd");
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


	}

	public static void ellipsePlotPoints (int xCenter, int yCenter, int x, int y,int[]color){




		Test.matriznumeros[xCenter+x][yCenter+y].setBackground(Color.BLUE);
		Test.matriznumeros[xCenter-x][yCenter+y].setBackground(Color.BLUE);
		Test.matriznumeros[xCenter+x][yCenter-y].setBackground(Color.BLUE);
		Test.matriznumeros[xCenter-x][yCenter-y].setBackground(Color.BLUE);

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
    	boolean obj=false;
    	int objeto=0;
    	while(!obj)
    	{
    		if((aObject.get(x).get(0)==x)&&(aObject.get(x).get(1)==y))
    		{
    			objeto=aObject.get(x).get(3);
    			obj=!obj;
    		}
    		
    	}
    	return objeto;
    	
    }
}

