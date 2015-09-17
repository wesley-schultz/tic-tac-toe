package edu.jsu.mcis;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JOptionPane; 

public class TicTacToeGui implements ActionListener {
	public JFrame frame;
	private JPanel panel;
	private JButton[][] btn ;
	private TicTacToe t;
	private boolean xturn;
	TicTacToe.GameState state;
	
	
	public TicTacToeGui(){
		panel = new JPanel();
		frame = new JFrame("Tic Tac Toe");
		panel.setLayout(new GridLayout(3,3,3,3));
		btn = new JButton[3][3];
		t= new TicTacToe();
		for (int i = 0;i<3;i++)
			for (int j = 0;j<3;j++){
				btn[i][j]= new JButton();
				btn[i][j].setName("Location"+i+""+j);
				btn[i][j].addActionListener(this);
				panel.add(btn[i][j]);
				
			}
		panel.setPreferredSize(new Dimension (400,400));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		
		JButton src = (JButton) event.getSource();
		state=t.getState();
		TicTacToe.Mark mark = TicTacToe.Mark.EMPTY;
		if (state==TicTacToe.GameState.ONGOING)
			for (int i = 0;i<3;i++)
				for (int j = 0;j<3;j++){
					if(src==btn[i][j]){
						xturn = t.getTurn();
						mark=t.getMark(i,j);
						t.setMark(i,j);
						if(mark==TicTacToe.Mark.EMPTY){
							if(xturn){
								btn[i][j].setText("X");
							}
							else{
								btn[i][j].setText("O");
							}
					}
				}
	}
			state = t.getState();
			if(state==TicTacToe.GameState.XWIN)
				JOptionPane.showMessageDialog(frame,"the winner is x");
			else if(state==TicTacToe.GameState.OWIN)
				JOptionPane.showMessageDialog(frame,"the winner is o");
			else if (state==TicTacToe.GameState.DRAW)
				JOptionPane.showMessageDialog(frame,"the winner is tie");
	}
	
	
	public static void main (String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeGui();//.setVisible();
            }
        });
            
      
        }
	
	
	
	
	
	
	
}