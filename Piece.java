import java.awt.Point;

import javax.swing.JButton;

public class Piece extends JButton{
	
	Point start = new Point();
	boolean isHorizontal = false;
	int piecelength = 0; 
	Point loc = new Point();
	boolean found = false; 
	
	
	
	public Piece(Point loc, boolean isHorizontal, int length) {
		
		this.isHorizontal = isHorizontal;
		piecelength = length;
		
		this.loc = new Point(loc.x, loc.y);
		
		}
	public Piece(int row, int col) {
		loc = new Point(row, col);
		

	}

		
	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	public int getPiecelength() {
		return piecelength;
	}

	public void setPiecelength(int piecelength) {
		this.piecelength = piecelength;
	}

	public Point getLoc() {
		return loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	
	public boolean getFound() {
		return found;
	}
	
	public void setStart (int x, int y) {
		start = new Point(x,y);
		
	}
	
	}
	
	//@Override
//	public String toString() {
//		return "Piece [isHorizontal=" + isHorizontal + ", piecelength=" + piecelength + ", loc=" + loc + ", found="
//				+ found + "]";
//	}


