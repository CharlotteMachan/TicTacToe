
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameStart extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel, panelRB, panelB;
    JLabel titleLabel;
    JButton startButton, exitButton;
    JRadioButton userButton, compButton, easyButton, hardButton;
    ButtonGroup group;
    
    int userComp = 0;
    int level = 0;

    public GameStart() {
        // Create frame
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        
        frame.getContentPane().setBackground(new Color(237, 249, 255)); // light blue

        // Title label
        titleLabel = new JLabel("Tic Tac Toe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        //panel for radio buttons
        panelRB = new JPanel();
        panelRB.setLayout(new GridLayout(2, 2, 10, 0));
        panelRB.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        //Radio buttons
        userButton = new JRadioButton("User vs User");
        userButton.setSelected(true);
        compButton = new JRadioButton("User vs Computer");
        userButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        compButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        easyButton = new JRadioButton("Easy");
        easyButton.setSelected(true);
        easyButton.setVisible(false);
        hardButton = new JRadioButton("Hard");
        hardButton.setVisible(false);
        easyButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        hardButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        userButton.addActionListener(this);
        compButton.addActionListener(this);
        easyButton.addActionListener(this);
        hardButton.addActionListener(this);

        //Game mode Button group
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(userButton);
        modeGroup.add(compButton);

        //Game difficulty button group
        ButtonGroup diffGroup = new ButtonGroup();
        diffGroup.add(easyButton);
        diffGroup.add(hardButton);
        
        //Add radio btns to panel
        panelRB.add(userButton);
        panelRB.add(compButton);
        panelRB.add(easyButton);
        panelRB.add(hardButton);
        
        //Panel for all buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        //Panel for buttons
        panelB = new JPanel();
        panelB.setLayout(new GridLayout(1, 2, 20, 0));
        panelB.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Buttons
        startButton = new JButton("Start Game");
        startButton.setBackground(new Color(0, 153, 76));
        startButton.setForeground(Color.BLACK);
        startButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        startButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(204, 0, 0));
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        exitButton.addActionListener(this);

        // Add buttons to panel
        panel.add(panelRB, BorderLayout.NORTH);
        panelB.add(startButton);
        panelB.add(exitButton);
        panel.add(panelB, BorderLayout.SOUTH);

        // Add components to frame
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.SOUTH);

        // Center the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void gameDifficulty(int mode){
        if (mode == 0){
            easyButton.setVisible(false);
            hardButton.setVisible(false);
        } else {
            easyButton.setVisible(true);
            hardButton.setVisible(true);
        }

        panelRB.revalidate();
        panelRB.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == userButton){
            userComp = 0;
            gameDifficulty(userComp);
        } else if (e.getSource() == compButton){
            userComp = 1;
            gameDifficulty(userComp);
        } else if (e.getSource() == easyButton){
            level = 0;
        } else if (e.getSource() == hardButton){
            level = 1;
        }
        
        if (e.getSource() == startButton) {
            // Close start screen
            frame.dispose();

            // Open Tic Tac Toe game
            Components game = new Components(userComp, level);
            game.SetFrame();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}