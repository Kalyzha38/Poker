package controller;

import javax.swing.ImageIcon;
import view.PokerView;
import model.PokerModel;
/**
 * Controller
 *
 */
public class PokerController{
	private static PokerModel pokerModel = null;
	
	/**
	 * Controller constuctor
	 */
	public PokerController(){
		pokerModel = new PokerModel();
	}
	
	/**
	 * send click NewGame button to model
	 */
	
	public void NewGame(){
		new Thread(new Runnable(){
			@Override
			public void run() {
		PokerView.resetFlags();
		pokerModel.NewGame();
		PokerView.doAll();
			}
	}).start();
	}
	
	
	/**
	 * send click RollDice button to model
	 * @throws InterruptedException 
	 */
	public void Roll(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				PokerView.checkFlags();
				pokerModel.roll();
				PokerView.doAll();
			}
	}).start();
	}
	
	/**
	 * Return icons for dices
	 * @param i dice number
	 * @return icon
	 */
	
	public ImageIcon getIcon(int i){
		return pokerModel.getIcon(i);
	}
	
	/**
	 * Return number of attempts
	 * @return number of attempts
	 */
	public int getAttempts(){
		return pokerModel.getAttempts();
	}

	
	/**
	 * Returns the name of the dice player
	 * @return
	 */
	public String getRollerName(){
		return pokerModel.getRollerName();
	}
	
	/**
	 * Takes the player's name from the model
	 * @param i player number
	 * @return player name
	 */
	public String getName(int i){
		String s = null;
		switch(i){
		case 1: s = pokerModel.getName(1); break;
		case 2: s = pokerModel.getName(2); break;
		}
		return s;
	}
	
	/**
	 * Send the player's number and name to the model
	 * @param i player number
	 * @param s player name
	 */
	public void saveName(int i, String s){
		switch (i){
		case 1 : pokerModel.saveName(1,s); break;
		case 2 : pokerModel.saveName(2,s); break;
		}
	}
	
	/**
	 * Returns the player dice icon
	 * @param k (player number)*(dice number)
	 * @return icon
	 */
	public ImageIcon getPlayerIcon(int k){
		ImageIcon icon = null;
		icon = pokerModel.getPlayerIcon(k);
		return icon;
	}
	
	/**
	 * Returns the ability to throw a dice from the interface to the model
	 * @param i dice number
	 * @param flag ability to throw
	 */
	public void getFlag(int i, boolean flag){
		switch (i){
		case 1 : pokerModel.setFlag(1,flag); break;
		case 2 : pokerModel.setFlag(2,flag); break;
		case 3 : pokerModel.setFlag(3,flag); break;
		case 4 : pokerModel.setFlag(4,flag); break;
		case 5 : pokerModel.setFlag(5,flag); break;
		}
	}
	
	/**
	 * Returns winner icon
	 * @param i player number
	 * @return icon
	 */
	public ImageIcon getWinnerIcon(int i){
		ImageIcon icon = null;
		switch(i){
		case 1: if (pokerModel.getWinner() == 1) icon = pokerModel.getWinnerIcon(); break;
		case 2: if (pokerModel.getWinner() == 2) icon = pokerModel.getWinnerIcon(); break;
		}
		return icon;
	}

}
