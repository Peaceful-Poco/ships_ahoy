import java.lang.Math;

import javax.swing.JLabel;

import java.awt.Point;

public class EnemyShips {
	boolean canplace = false;
	boolean horiz; 
	int[][] enemyboard = new int[10][10];
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public boolean isCanplace() {
		return canplace;
	}

	public boolean isHoriz() {
		return horiz;
	}

	public int[][] getEnemyboard() {
		return enemyboard;
	}

	public Piece[][] getNavy() {
		return navy;
	}

	Piece [][]navy; 
	JLabel label = new JLabel("You have taken charge of the High Seas!");
	
	public EnemyShips(Piece[][]navy) {

		int rpos = 0;
		int cpos= 0;
		this.navy = navy;
		for(int length = 2; length< 7; length++) {
			canplace = false;

			int horizontal = (int)(Math.random()*2);

			if(horizontal == 0) {

				while(!canplace) {
					rpos = (int)(Math.random()* 10);
					cpos = (int)(Math.random()* 10);

					canplace = true;
					if(cpos + length< 10) {
						for(int col = cpos; col< cpos+length ; col++) {
							if(enemyboard[rpos][col]!= 0) {
								canplace = false;
							}

						}
					}
					else {
						canplace = false;
					}
				}
				for(int col = cpos; col< cpos+length; col++) {
					
					navy[rpos][col].setHorizontal(true);
					navy[rpos][col].setPiecelength(length);
					//TODO Show Answers 
					navy[rpos][col].setText(""+length);
					
					navy[rpos][col].setStart(rpos,cpos);
					enemyboard[rpos][col] = length;
				}

			}
			else {

				while(!canplace) {
					rpos = (int) (Math.random()* 10);
					
					cpos = (int)(Math.random()* 10);
					

					canplace = true;
					if(rpos + length< 10) {
						for(int row = rpos; row< rpos+length; row++) {
							if(enemyboard[row][cpos]!= 0) {
								canplace = false;
							}
						}
					}
					else {
						canplace = false;
					}
				}

				for(int row = rpos; row< rpos+length; row++) {
					enemyboard[row][cpos] = length;
					navy[row][cpos].setHorizontal(false);
					navy[row][cpos].setPiecelength(length);
					//TODO show Answers 
					navy[row][cpos].setText(""+length);
					navy[row][cpos].setStart(rpos,cpos);
				}
			}


		}



	}

//	public void printship() {
//		for(int i = 0; i< enemyboard.length;i++) {
//			for(int k = 0; k< enemyboard[0].length; k++) {
//				System.out.print(enemyboard[i][k]);
//			}
//			System.out.print("\n");
//		}
//	}
	public Piece[][] getMatrix(){
		return navy;
	}

	public boolean checkPiece(Piece check) {

		Point start = check.start;
		if(check.isHorizontal) {
			for(int begin = start.y; begin< start.y + check.getPiecelength() ; begin++) {
				if(navy[start.x][begin].getFound()!= true) {
					return false;
				}

			}
			return true;
		}

		else {
			for(int pbegin = start.x; pbegin< start.x + check.getPiecelength(); pbegin++) {
				if(navy[pbegin][start.y].getFound()!= true) {
					return false;
				}
			}
			return true;

		}
	}
}
//	if(isHorizontal == true) {
//		for(int col = loc.y; col< col + piecelength; col++) {
//			Point check = new Point(loc.x,col);
//			Piece checkShip = new Piece(check,true,piecelength);
//			if(checkShip.getFound()) {
//				sunk = true;
//			}
//		}
//	}else {
//		for(int row = loc.x; row< row + piecelength; row++) {
//			Point check = new Point(row, loc.y);
//			Piece checkShip = new Piece(check, true, piecelength);
//			if(checkShip.getFound()) {
//				sunk = true;
//			}
//		}

