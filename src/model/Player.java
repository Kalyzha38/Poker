package model;
/**
 * Player name
 *
 */
public class Player{
	private String name;
	public Dice dice1;
	public Dice dice2;
	public Dice dice3;
	public Dice dice4;
	public Dice dice5;
	public int points;
	
	/**
	 * Player constructor
	 */
	public Player(){
		this.name = null;
		this.dice1 = new Dice();
		this.dice2 = new Dice();
		this.dice3 = new Dice();
		this.dice4 = new Dice();
		this.dice5 = new Dice();
		this.points = 0;
		this.setName("unknown");
	}
	
	/**
	 * Save player name
	 * @param n player name
	 */
	public void setName(String n){
		this.name = n;
	}
	
	/**
	 * Get player name
	 * @return player name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Set player dices
	 * @param die1 first dice
	 * @param die2 second dice
	 * @param die3 third dice
	 * @param die4 fourth dice
	 * @param die5 fifth dice
	 */
	public void setDice(Dice die1, Dice die2, Dice die3, Dice die4, Dice die5){
		this.dice1 = (Dice)die1.clone();
		this.dice2 = (Dice)die2.clone();
		this.dice3 = (Dice)die3.clone();
		this.dice4 = (Dice)die4.clone();
		this.dice5 = (Dice)die5.clone();
	}
	
	/**
	 * Reset player dices and points
	 */
	public void reset(){
		this.dice1.reset();
		this.dice2.reset();
		this.dice3.reset();
		this.dice4.reset();
		this.dice5.reset();
		this.points = 0;
	}
	
	/**
	 * Return player dice values
	 * @return player dice values
	 */
	public int[] getSides(){
		return new int[] 	{	this.dice1.getSide(),
								this.dice2.getSide(),
								this.dice3.getSide(),
								this.dice4.getSide(),
								this.dice5.getSide(),	
							};
	}
}
