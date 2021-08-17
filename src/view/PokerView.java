package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.*;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Interface
 * 
 */
public class PokerView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static PokerController pokerController = null;
	private JButton btnNewGame;
	private JMenuBar menuBar;
	private static JTextField player1;
	private static JTextField player2;
	private JButton btnRoll;
	private static JLabel dice1;
	private static JLabel dice2;
	private static JLabel dice3;
	private static JLabel dice4;
	private static JLabel dice5;
	private static JCheckBox fdice1;
	private static JCheckBox fdice2;
	private static JCheckBox fdice3;
	private static JCheckBox fdice4;
	private static JCheckBox fdice5;
	private static JTextField fieldTry;
	private JTextPane textTry;
	private static JLabel p1_dice1;
	private static JLabel p1_dice5;
	private static JLabel p1_dice3;
	private static JLabel p1_dice2;
	private static JLabel p2_dice1;
	private static JLabel p2_dice4;
	private static JLabel p2_dice3;
	private static JLabel p2_dice2;
	private static JLabel p1_dice4;
	private static JLabel p2_dice5;
	private JTextPane textRollNow;
	private static JTextField fieldRollNow;
	private JButton btnSaveName1;
	private JButton btnSaveName2;
	private static JLabel imgWinner1;
	private static JLabel imgWinner2;
	private JTextField fclock;
	private JTextField textField;
	private Timer ClockTimer = new Timer(500, new Clock());
	
	public PokerView (){
		super("Dice Poker");
		
		pokerController = new PokerController();
		
		getContentPane().setMinimumSize(new Dimension(800, 600));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PokerView.class.getResource("/view/icon.png")));
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		 
		  ActionListener newGameListener = new ActionListener() {		  
		   public void actionPerformed(ActionEvent e) {
			   pokerController.NewGame();
		   }
		   };
		   
		  ActionListener rollListener = new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  if((pokerController.getAttempts() == 0) | ((pokerController.getAttempts() == 3))){
					  resetFlags();
				  }
				  pokerController.Roll();
			  }
		  };
		  
		  ActionListener saveListener1 = new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  pokerController.saveName(1,player1.getText());
				  fieldRollNow.setText(pokerController.getRollerName());
			  }
		  };
		  
		  ActionListener saveListener2 = new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  pokerController.saveName(2,player2.getText());
				  fieldRollNow.setText(pokerController.getRollerName());
			  }
		  };
		  
		  menuBar = new JMenuBar();
		  setJMenuBar(menuBar);
		  
		  btnNewGame = new JButton("New game");
		  btnNewGame.setToolTipText("Start new game");
		  menuBar.add(btnNewGame);
		  getContentPane().setLayout(null);
		  
		  player1 = new JTextField();
		  player1.setToolTipText("First player name");
		  player1.setBounds(43, 99, 86, 20);
		  getContentPane().add(player1);
		  player1.setColumns(10);
		  
		  player2 = new JTextField();
		  player2.setToolTipText("Second player name");
		  player2.setBounds(301, 99, 86, 20);
		  getContentPane().add(player2);
		  player2.setColumns(10);
		  
		  btnRoll = new JButton("Throw dices");
		  btnRoll.setBounds(638, 11, 136, 53);
		  getContentPane().add(btnRoll);
		  
		  dice1 = new JLabel("dice1");
		  dice1.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  dice1.setBounds(598, 132, 51, 53);
		  getContentPane().add(dice1);
		  
		  dice2 = new JLabel("dice2");
		  dice2.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  dice2.setBounds(598, 194, 51, 53);
		  getContentPane().add(dice2);
		  
		  dice3 = new JLabel("dice3");
		  dice3.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  dice3.setBounds(598, 258, 51, 53);
		  getContentPane().add(dice3);
		  
		  dice4 = new JLabel("dice4");
		  dice4.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  dice4.setBounds(598, 328, 51, 53);
		  getContentPane().add(dice4);
		  
		  dice5 = new JLabel("dice5");
		  dice5.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  dice5.setBounds(598, 394, 51, 53);
		  getContentPane().add(dice5);
		  
		  fdice1 = new JCheckBox("Dont throw");
		  fdice1.setBounds(677, 140, 97, 23);
		  getContentPane().add(fdice1);
		  
		  fdice2 = new JCheckBox("Dont throw");
		  fdice2.setBounds(677, 202, 97, 23);
		  getContentPane().add(fdice2);
		  
		  fdice3 = new JCheckBox("Dont throw");
		  fdice3.setBounds(677, 266, 97, 23);
		  getContentPane().add(fdice3);
		  
		  fdice4 = new JCheckBox("Dont throw");
		  fdice4.setBounds(677, 336, 97, 23);
		  getContentPane().add(fdice4);
		  
		  fdice5 = new JCheckBox("Dont throw");
		  fdice5.setBounds(674, 402, 97, 23);
		  getContentPane().add(fdice5);
		  
		  textTry = new JTextPane();
		  textTry.setEditable(false);
		  textTry.setText("Attempts:");
		  textTry.setBounds(528, 44, 51, 20);
		  getContentPane().add(textTry);
		  
		  fieldTry = new JTextField();
		  fieldTry.setToolTipText("Attempts number");
		  fieldTry.setEditable(false);
		  fieldTry.setBounds(589, 44, 39, 20);
		  getContentPane().add(fieldTry);
		  fieldTry.setColumns(10);
		  
		  p1_dice1 = new JLabel("dice1");
		  p1_dice1.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p1_dice1.setBounds(53, 132, 51, 53);
		  getContentPane().add(p1_dice1);
		  
		  p1_dice5 = new JLabel("dice5");
		  p1_dice5.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p1_dice5.setBounds(53, 394, 51, 53);
		  getContentPane().add(p1_dice5);
		  
		  p1_dice4 = new JLabel("dice4");
		  p1_dice4.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p1_dice4.setBounds(53, 328, 51, 53);
		  getContentPane().add(p1_dice4);
		  
		  p1_dice3 = new JLabel("dice3");
		  p1_dice3.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p1_dice3.setBounds(53, 258, 51, 53);
		  getContentPane().add(p1_dice3);
		  
		  p1_dice2 = new JLabel("dice2");
		  p1_dice2.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p1_dice2.setBounds(53, 194, 51, 53);
		  getContentPane().add(p1_dice2);
		  
		  p2_dice1 = new JLabel("dice1");
		  p2_dice1.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p2_dice1.setBounds(311, 132, 51, 53);
		  getContentPane().add(p2_dice1);
		  
		  p2_dice2 = new JLabel("dice2");
		  p2_dice2.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p2_dice2.setBounds(311, 194, 51, 53);
		  getContentPane().add(p2_dice2);
		  
		  p2_dice3 = new JLabel("dice3");
		  p2_dice3.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p2_dice3.setBounds(311, 258, 51, 53);
		  getContentPane().add(p2_dice3);
		  
		  p2_dice4 = new JLabel("dice4");
		  p2_dice4.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p2_dice4.setBounds(311, 328, 51, 53);
		  getContentPane().add(p2_dice4);
		  
		  p2_dice5 = new JLabel("dice5");
		  p2_dice5.setIcon(new ImageIcon(PokerView.class.getResource("/view/question.png")));
		  p2_dice5.setBounds(311, 394, 51, 53);
		  getContentPane().add(p2_dice5);
		  
		  textRollNow = new JTextPane();
		  textRollNow.setText("Now throws:");
		  textRollNow.setBounds(500, 75, 79, 20);
		  getContentPane().add(textRollNow);
		  
		  fieldRollNow = new JTextField();
		  fieldRollNow.setToolTipText("Player name that throw dices now");
		  fieldRollNow.setEditable(false);
		  fieldRollNow.setBounds(589, 75, 86, 20);
		  getContentPane().add(fieldRollNow);
		  fieldRollNow.setColumns(10);
		  
		  btnSaveName1 = new JButton("Save");
		  btnSaveName1.setToolTipText("Save first player name");
		  btnSaveName1.setBounds(139, 98, 97, 23);
		  getContentPane().add(btnSaveName1);
		  
		  btnSaveName2 = new JButton("Save");
		  btnSaveName2.setToolTipText("Save second player name");
		  btnSaveName2.setBounds(397, 98, 97, 23);
		  getContentPane().add(btnSaveName2);
		  
		  imgWinner1 = new JLabel("");
		  imgWinner1.setBounds(43, 44, 150, 37);
		  getContentPane().add(imgWinner1);
		  
		  imgWinner2 = new JLabel("");
		  imgWinner2.setBounds(301, 44, 150, 37);
		  getContentPane().add(imgWinner2);
		  
		  fclock = new JTextField();
		  fclock.setBounds(698, 515, 86, 20);
		  getContentPane().add(fclock);
		  fclock.setColumns(10);
		  
		  textField = new JTextField();
		  textField.setText("Time:");
		  textField.setBounds(663, 515, 31, 20);
		  getContentPane().add(textField);
		  textField.setColumns(10);
		  
		  JLabel imgBackground = new JLabel("");
		  imgBackground.setIcon(new ImageIcon(PokerView.class.getResource("/view/background.jpg")));
		  imgBackground.setBounds(0, 0, 794, 546);
		  getContentPane().add(imgBackground);
		  
		  btnNewGame.addActionListener(newGameListener);
		  btnRoll.addActionListener(rollListener);
		  btnSaveName1.addActionListener(saveListener1);
		  btnSaveName2.addActionListener(saveListener2);
		  ClockTimer.start();
		  pokerController.NewGame();
	}
		/**
		 * Update interface
		 */
	  public static void doAll(){
		  p1_dice1.setIcon(pokerController.getPlayerIcon(1));
		  p1_dice2.setIcon(pokerController.getPlayerIcon(2));
		  p1_dice3.setIcon(pokerController.getPlayerIcon(3));
		  p1_dice4.setIcon(pokerController.getPlayerIcon(4));
		  p1_dice5.setIcon(pokerController.getPlayerIcon(5));
		  p2_dice1.setIcon(pokerController.getPlayerIcon(6));
		  p2_dice2.setIcon(pokerController.getPlayerIcon(7));
		  p2_dice3.setIcon(pokerController.getPlayerIcon(8));
		  p2_dice4.setIcon(pokerController.getPlayerIcon(9));
		  p2_dice5.setIcon(pokerController.getPlayerIcon(10));
		  dice1.setIcon(pokerController.getIcon(1));
		  dice2.setIcon(pokerController.getIcon(2));
		  dice3.setIcon(pokerController.getIcon(3));
		  dice4.setIcon(pokerController.getIcon(4));
		  dice5.setIcon(pokerController.getIcon(5));
		  fieldTry.setText(Integer.toString(pokerController.getAttempts()));
		  fieldRollNow.setText(pokerController.getRollerName());
		  player1.setText(pokerController.getName(1));
		  player2.setText(pokerController.getName(2));
		  imgWinner1.setIcon(pokerController.getWinnerIcon(1));
		  imgWinner2.setIcon(pokerController.getWinnerIcon(2));
	  }
	  /**
	   * Check "dont throw" flags
	   */
	  public static void checkFlags(){
		  pokerController.getFlag(1,fdice1.isSelected());
		  pokerController.getFlag(2,fdice2.isSelected());
		  pokerController.getFlag(3,fdice3.isSelected());
		  pokerController.getFlag(4,fdice4.isSelected());
		  pokerController.getFlag(5,fdice5.isSelected());
	  }
	  
	  /**
	   * Reset "dont throw" flags
	   */
	  public static void resetFlags(){
		  if (fdice1.isSelected()) fdice1.doClick();
		  if (fdice2.isSelected()) fdice2.doClick();
		  if (fdice3.isSelected()) fdice3.doClick();
		  if (fdice4.isSelected()) fdice4.doClick();
		  if (fdice5.isSelected()) fdice5.doClick();
		  
	  }
	  
	  /**
	   * Set clock
	   *
	   */
	  class Clock implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            // *** For TIME : 22:33:22
	            DateFormat df = new SimpleDateFormat("HH:mm:ss");
	            Date time = Calendar.getInstance().getTime();
	            String reportDate = df.format(time);
	            fclock.setText(reportDate);
	        }
	    }
		 
}
