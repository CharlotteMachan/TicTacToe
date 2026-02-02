import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Components extends JFrame implements ActionListener{
    //Frame
    JFrame frame;
    //Panels
    JPanel Background, Top, game;
    //Buttons
    JButton btn1, btn2, btn3, btn4,btn5, btn6, btn7, btn8, btn9, btnNewGame;
    //Labels
    JLabel lblWins, lblLosses, lblTies;
    //Array
    int[][] Board = {{0,0,0},{0,0,0},{0,0,0}};
    
    int wins = 0;
    int loses = 0;
    int ties = 0;
    
    int userComp; //user v user if  == 0, user v comp if == 1
    int level; //easy == 0, hard == 1;
    
    public Components(int userComp, int level){
        this.userComp = userComp;
        this.level = level;
    }
    
    public void SetFrame(){
        //Frame
        frame= new JFrame("GridLayout Demo");
        
        //Panels
        Background = new JPanel(new BorderLayout());
        //Top
        Top = new JPanel();
        //Grid Tic Tac Toe
        GridLayout gridPattern = new GridLayout(3,3);
        game = new JPanel();
        game.setLayout(gridPattern);
        
        //Add panels to background
        Background.add(Top, BorderLayout.NORTH);
        Background.add(game, BorderLayout.CENTER);
        
        //Creating button objects
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnNewGame = new JButton("New Game");
        
        //Labels
        lblWins = new JLabel("   Wins: " + wins);
        lblLosses = new JLabel("   Losses: " + loses);
        lblTies = new JLabel("   Ties: " + ties);
        
        //Add to top panel
        Top.add(btnNewGame);
        Top.add(lblWins);
        Top.add(lblLosses);
        Top.add(lblTies);
        
        //Add btns to grid
        game.add(btn1);
        game.add(btn2);
        game.add(btn3);
        game.add(btn4);
        game.add(btn5);
        game.add(btn6);
        game.add(btn7);
        game.add(btn8);
        game.add(btn9);
        //Set game background
        game.setBackground(Color.black);
        //Set Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,400);
        frame.getContentPane().add(Background);
        //Add action listener
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnNewGame.addActionListener(this);
        
        //Make visible
        frame.setVisible(true);
    }
    
    public void NewGame(){
        //Reset buttons
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        
        //Reset array
        for ( int row=0; row < Board.length; row++ ) {
            for ( int col=0; col < Board[row].length; col++ ) {
                Board[row][col] = 0;
            }        
        }
    }
    
    public void UpdateButtons(){
        
        JButton[][] buttons = {{btn1, btn2, btn3},
                               {btn4, btn5, btn6},
                               {btn7, btn8, btn9}};
        
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                switch (Board[row][col]) {
                    case 1 -> buttons[row][col].setText("X");
                    case 10 -> buttons[row][col].setText("O");
                    default -> buttons[row][col].setText("");
                }
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == btnNewGame) {
            NewGame();
            UpdateButtons();
        } else {
            if (e.getSource () == btn1 && Board[0][0] == 0){
                Board[0][0] = 1;
            } else if (e.getSource () == btn2 && Board[0][1] == 0){
                Board[0][1] = 1;
            } else if (e.getSource () == btn3 && Board[0][2] == 0){
                Board[0][2] = 1;
            } else if (e.getSource () == btn4 && Board[1][0] == 0){
                Board[1][0] = 1;
            } else if (e.getSource () == btn5 && Board[1][1] == 0){
                Board[1][1] = 1;
            } else if (e.getSource () == btn6 && Board[1][2] == 0){
                Board[1][2] = 1;
            } else if (e.getSource () == btn7 && Board[2][0] == 0){
                Board[2][0] = 1;
            } else if (e.getSource () == btn8 && Board[2][1] == 0){
                Board[2][1] = 1;
            } else if (e.getSource () == btn9 && Board[2][2] == 0){
                Board[2][2] = 1;
            }
                UpdateButtons();
            
        }
        
        
    }
    
}