
public class client {

	public static void main(String[] args) {
		
		Piece matrix[][] = new Piece[10][10];
		
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col< matrix[0].length; col++){
				matrix[row][col] = new Piece(row, col);
			}
		}
		
		EnemyShips test = new EnemyShips(matrix);
		new GUI(test); 
		
		

	}

}
