package model;

import java.util.Arrays;

import javax.swing.ImageIcon;
/**
 * Model
 */

public class PokerModel {
	private ImageIcon winnerIcon = new ImageIcon("src/view/winner.png");
	private int attempts;
	private Dice d1;
	private Dice d2;
	private Dice d3;
	private Dice d4;
	private Dice d5;
	private int turn;
	private Player p1;
	private Player p2;
	private int winner;
	
	/**
	 * Model constructor
	 */
	
	public PokerModel(){
		this.attempts = 3;
		this.d1 = new Dice();
		this.d2 = new Dice();
		this.d3 = new Dice();
		this.d4 = new Dice();
		this.d5 = new Dice();
		this.turn = 1;
		this.p1 = new Player();
		this.p2 = new Player();
		this.winner = 0;
	}
	
	/**
	 * Dice throw
	 * 
	 */
	public void roll(){
		if(this.turn == 3){
			this.turn = 3;
		} else{
		if(this.attempts == 0){
			this.changePlayer(turn);
		} else{
		this.d1.roll();
		this.d2.roll();
		this.d3.roll();
		this.d4.roll();
		this.d5.roll();
		this.attempts -=1;
		}
		}
	}
	
	/**
	 * Start new game
	 */
	
	public void NewGame(){
		this.turn = 1;
		this.attempts = 3;
		this.d1.reset();
		this.d2.reset();
		this.d3.reset();
		this.d4.reset();
		this.d5.reset();
		this.p1.reset();
		this.p2.reset();
		this.winner = 0;
	}
	
	/**
	 * Change player
	 * @param i - number of current player
	 */
	private void changePlayer(int i){
		switch(i){
		case 1: this.p1.setDice(d1, d2, d3, d4, d5); break;
		case 2:	this.p2.setDice(d1, d2, d3, d4, d5); this.checkWinner(); break;
		}
		turn +=1;
		this.attempts = 3;
		this.d1.reset();
		this.d2.reset();
		this.d3.reset();
		this.d4.reset();
		this.d5.reset();
	}
	
	/**
	 * Calculate player points
	 * @param p - current player
	 */
	private void checkPoints(Player p){
		int t[] = p.getSides();
		Arrays.sort(t);
		boolean flag = true;
		int temp = 0;
		
		for (int i = 1; i < t.length; i++) {
			if(t[i-1] == t[i])
				temp+=1;
		}
		
		if(temp==4){p.points = 100+t[0];
					flag = false;
					}
		
		
		if(flag & temp==3){
			if((t[2]!=t[3]) | (t[1]!=t[2])){
				p.points = 70+t[0]+t[4];
				flag = false;
			}
			
			if((t[0]==t[1]) & flag){
				p.points = 90+t[0];
				flag = false;
				}
			
			else{
				p.points = 90+t[4];
				flag = false;
			}
		}
		
		
		int l = 0;
		if(flag & temp==2){
			for (int i = 2; i < t.length; i++) {
				if((t[i-2] == t[i-1]) & (t[i-1] == t[i])){
				l=t[i];
				p.points = 50+l;
				flag = false;
				}	
			}
			if(((t[0]==t[1]) & (t[2]==t[3])) | ((t[0]==t[1]) & (t[3]==t[4])) | ((t[1]==t[2]) & (t[3]==t[4])) & flag){
				p.points = 30+t[2]+t[4];
				flag = false;
			}
		}
		
		
		if(flag & temp==1){
			for (int i = 1; i < t.length; i++) {
				if(t[i-1] == t[i])
				l=t[i];
			}
		p.points = 20+l;
		flag = false;	}
		
		temp=0;
		if(flag){
			for (int i = 1; i < t.length; i++) {
				if(t[i-1]==(t[i]-1))
				temp+=1;
			}
			if(temp==4){
				p.points = 60+t[0];
				flag = false;}
			
			else p.points = t[4];
		}
		}

	/**
	 * Check winner
 	 */

	private void checkWinner(){
		this.checkPoints(this.p1);
		this.checkPoints(this.p2);
		if(this.p1.points < this.p2.points){
			this.winner = 2;
		}
		if(this.p1.points > this.p2.points){
			this.winner = 1;
		}
		if(this.p1.points == this.p2.points){
			this.winner = 3;
		}
	}
	
	/**
	 *	Return dice icons
	 * @param i - dice number
	 * @return dice icon
	 */
	public ImageIcon getIcon (int i){
		ImageIcon icon = null;
		switch(i){
		case 1 : icon = this.d1.getIcon(); break;
		case 2 : icon = this.d2.getIcon(); break;
		case 3 : icon = this.d3.getIcon(); break;
		case 4 : icon = this.d4.getIcon(); break;
		case 5 : icon = this.d5.getIcon(); break;
		}
		return icon;
	}
	
	/**
	 *  
	 * @return number of attempts
	 */
	public int getAttempts(){
		return this.attempts;
	}

	 /**
	  * @return current player name
	  */
	public String getRollerName(){
		String s = null;
		switch(this.turn){
		case 1 : s = this.p1.getName(); break;
		case 2 : s = this.p2.getName(); break;
		case 3 : s = "Results"; break;
		}
		return s;
	}
	
	/**
	 * Return player names
	 * @param i player number
	 * @return player name
	 */
	public String getName(int i){
		String s = null;
		switch(i){
		case 1: s = this.p1.getName(); break;
		case 2: s = this.p2.getName(); break;
		}
		return s;
	}
	
	/**
	 * Save player names
	 * @param i player number
	 * @param s player name
	 */
	public void saveName(int i, String s){
		switch(i){
		case 1 : this.p1.setName(s); break;
		case 2 : this.p2.setName(s); break;
		}
	}
	
	/**
	 * Return player dice icons
	 * @param k (player number)*(dice number)
	 * @return dice icon
	 */
	public ImageIcon getPlayerIcon(int k){
		ImageIcon icon = null;
		switch(k){
		case 1 : icon = p1.dice1.getIcon(); break;
		case 2 : icon = p1.dice2.getIcon(); break;
		case 3 : icon = p1.dice3.getIcon(); break;
		case 4 : icon = p1.dice4.getIcon(); break;
		case 5 : icon = p1.dice5.getIcon(); break;
		case 6 : icon = p2.dice1.getIcon(); break; 
		case 7 : icon = p2.dice2.getIcon(); break;
		case 8 : icon = p2.dice3.getIcon(); break;
		case 9 : icon = p2.dice4.getIcon(); break;
		case 10 : icon = p2.dice5.getIcon(); break;
		}
		return icon;
	}
	
	/**
	 * Set ability to throw dice
	 * @param i dice number
	 * @param flag ability to throw
	 */
	public void setFlag(int i, boolean flag){
		switch (i){
		case 1 : this.d1.setFlag(flag); break;
		case 2 : this.d2.setFlag(flag); break;
		case 3 : this.d3.setFlag(flag); break;
		case 4 : this.d4.setFlag(flag); break;
		case 5 : this.d5.setFlag(flag); break;
		}
	}

	/**
	 * 
	 * @return winner number
	 */
	public int getWinner(){
		return this.winner;
	}
	
	public ImageIcon getWinnerIcon(){
		return this.winnerIcon;
	}
}
