import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameWindow extends JFrame implements ActionListener, KeyListener, MouseListener{
    
    private JButton start;
    private JButton pause;
    private JButton resume;
    private JButton exit;

    private boolean started;
    private boolean isJumping;
    private boolean won;
    private boolean lost;

    private Container c;

    private JPanel mainPanel;
    private GamePanel gamePanel;
    private JPanel infoPanel;

    private JLabel score;
    private JLabel instructionsLabel;

    @SuppressWarnings({"unchecked"})
    public GameWindow(){
        setTitle("Jumpy Monkey");
        setSize(700, 700);

        
		mainPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		mainPanel.setLayout(flowLayout);

        started = false;
		isJumping = false;
        lost = false;
        won= false;

        // add mainPanel to window surface

		c = getContentPane();
		c.add(mainPanel);

		// create the gamePanel for game entities

		gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(600, 600));
		gamePanel.createGameEntities();

        instructionsLabel = new JLabel("<html> Press Start to begin! <br> Press SPACE to make Baby Monkey jump. <br> Watch out for Mommy Monkey! <html>", SwingConstants.CENTER);
        instructionsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        // add gamePanel to mainPanel
        mainPanel.add(gamePanel);
        gamePanel.add(instructionsLabel);

        //make sure it focuses on space key
        mainPanel.addKeyListener(this);
        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();

        //create buttons
        start = new JButton("Start");
        pause = new JButton("Pause");
        resume = new JButton("Resume");
        exit = new JButton("Exit");

        //add action listeners to buttons
        start.addActionListener(this);
        pause.addActionListener(this);
        resume.addActionListener(this);
        exit.addActionListener(this);

        //create buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        //Label
        score = new JLabel();
        score.setText("Score: " + gamePanel.getSleepBarNumber());

        //create info panel
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        
        //add score to infopanel
        infoPanel.add(score);

        //add buttons to buttonPanel
        buttonPanel.add(start);
        buttonPanel.add(pause);
        buttonPanel.add(resume);
        buttonPanel.add(exit);

        // add mainPanel to window surface

		c = getContentPane();
		c.add(mainPanel);

        mainPanel.add(buttonPanel);
        mainPanel.add(infoPanel);

		// set properties of window

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == start){
            gamePanel.createGameEntities();
            gamePanel.drawGameEntities();
            mainPanel.requestFocus();
            gamePanel.setPause(false);
            gamePanel.runMommy();
            started = true;
            lost = false;
            won = false;
        }
        if (e.getSource() == pause){
            gamePanel.setPause(true);
            gamePanel.pauseGameEntities();
            score.setText("Score: " + gamePanel.getSleepBarNumber()+ " (Paused)");
            mainPanel.requestFocus();
        }

        if(e.getSource() == resume){
            if(!lost && !won){
            gamePanel.setPause(false);
            gamePanel.resumeGameEntities();
            score.setText("Score: " + gamePanel.getSleepBarNumber());    
            mainPanel.requestFocus();
            }
        }
        if(e.getSource()==exit){
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode()== KeyEvent.VK_SPACE && !isJumping && started){
            gamePanel.jump();
            score.setText("Score: " + gamePanel.getSleepBarNumber());

        if(!gamePanel.getPause())
            isJumping = true;

        if((isJumping && gamePanel.getInRoomStatus()) && !won){
            lost = true;
            gamePanel.caught(true);
            gamePanel.printLoss();
            gamePanel.setPause(true);
        }
        if((gamePanel.getSleepBarNumber()==150) && !lost){
            won = true;
            gamePanel.printWin();
            gamePanel.pauseGameEntities();
            gamePanel.setPause(true);
        }
        } 

       
    }

    public void keyReleased(KeyEvent e){
        
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            isJumping = false;
        }
        
    }

    public void keyTyped(KeyEvent e){
        
    }

    public void mouseClicked(MouseEvent e){
        
    }

    public void mouseEntered(MouseEvent e){
        
    }

    public void mouseExited(MouseEvent e){
        
    }

    public void mousePressed(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){
        
    }
}
