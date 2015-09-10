package edu.jsu.mcis;

public class TicTacToe{
	public enum Mark {XMARK,OMARK,EMPTY};
	public enum GameState {XWIN,OWIN,DRAW,ONGOING}
	private Mark[][] board;
	private int moveCount;
	private GameState state;
	private boolean xturn;
	public TicTacToe(){
		board= new Mark [3][3];
		for(int row=0;row<3;row++){
			for (int col=0;col<3;col++){
				board[row][col]= Mark.EMPTY;
			}
		}
		moveCount =0;
		 state =GameState.ONGOING;
		 xturn=true;
	}
	public Mark getMark(int row, int col){
		return board[row][col];
		
	}
	
	 public void setMark(int row, int col){
		Mark mark =Mark.EMPTY;
		if(xturn)
			mark  = Mark.XMARK;
		else
			mark= Mark.OMARK;
		if(board[row][col] == mark.EMPTY){
			board[row][col] = mark;
			moveCount++;
			xturn=!xturn;
		}
		state = checkForVictory(row,col,mark);

	}
	private GameState checkForVictory(int row, int col, Mark m){
		
		boolean victory = false;
		victory = checkForWinHorizontally(row,m);
		if(!victory)
		victory = checkForWinVertically(col,m);
		
		

    	

    	
    	
    		if(!victory)
    		victory = checkForWinDiagonally(m);
    	
		
            if(!victory)
    	victory = checkForWinAntiDiagonally(m);
	if (victory){
		if(m==Mark.XMARK)
			return GameState.XWIN;
		else
			return GameState.OWIN;
		
		
	}

    	
    	if(moveCount == (board.length*board.length)){
    		return GameState.DRAW;
    	}
		
		return GameState.ONGOING;
	
    	
    }
	private boolean checkForWinHorizontally(int row, Mark m) {
		for(int i = 0; i < board.length; i++){
    		if(board[row][i] != m)
    			break;
    		if(i == board.length-1){
				return true;
    		 
    		}
    	}
		return false;
	}
	private boolean checkForWinVertically(int col,Mark m){
		
    	for(int i = 0; i < board.length; i++){
    		if(board[i][col] != m)
    			break;
    		if(i == board.length-1){
    			return true;
    		 
    		}
    	}
		return false;
		
	}
	private boolean checkForWinDiagonally(Mark m){
		for(int i = 0; i < board.length; i++){
    			if(board[i][i] != m)
    				break;
    			if(i == board.length-1){
    				return true;
    		 
    			}
    		}
			return false;
		
	}
	private boolean checkForWinAntiDiagonally(Mark m){
		for(int i = 0;i<board.length;i++){
    		if(board[i][(board.length-1)-i] != m)
    			break;
    		if(i == board.length-1){
    			return true;
    		 
    		}
    	}
		return false;
		
	}
	
	public GameState getState(){
		return state;
		
	}



	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		int row=0;
		int col=0;
		Scanner in = new Scanner(System.in);
		while(t.getState()==Mark.ONGOING){
			if(moveCounter%2=0)
				System.out.println("player X please enter the row and column");
			else 
				System.out.println("player O please enter the row and column");
			
			row = in.nextInt();
			col = in.nextInt();
			t.setMark(row,col);
		}
		if(t.state==Mark.XWIN)
			System.out.println("player X wins");
		else if(t.state==Mark.OWIN)
			System.out.println("player O wins");
		else
			System.out.println("Draw");
			
		
	}
}
