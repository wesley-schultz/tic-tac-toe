import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe t;
	public void startNewGame() {
		t = new TicTacToe();

	}
	
	public void markLocation(int row, int col) {
		t.setMark(row,col);
	}
	
	public String getMark(int row, int col) {
		String mark = "";
		TicTacToe.Mark m = t.getMark(row,col);
		if(m == TicTacToe.Mark.XMARK)
			mark="X";
		else if (m == TicTacToe.Mark.OMARK)
			mark="O";
		return mark;
	}
    
	public String getWinner() {
		String winner = "";
		TicTacToe.GameState s = t.getState();
		if(s==TicTacToe.GameState.XWIN)
			winner="X";
		else if (s== TicTacToe.GameState.OWIN)
			winner="O";
		else if (s == TicTacToe.GameState.DRAW)
			winner="TIE";
		return winner;
		
	}
}
