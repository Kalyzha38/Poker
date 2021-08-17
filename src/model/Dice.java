package model;

import java.util.Random;

import javax.swing.ImageIcon;
/**
 * Dice class
 *
 */
public class Dice implements Cloneable{
	static int max = 6;
	private int side;
	private Random rnd;
	private ImageIcon icn;
	private boolean roll;
	private static ImageIcon d0 = new ImageIcon("src/view/question.png");
	private static ImageIcon d1 = new ImageIcon("src/view/1.png");
	private static ImageIcon d2 = new ImageIcon("src/view/2.png");
	private static ImageIcon d3 = new ImageIcon("src/view/3.png");
	private static ImageIcon d4 = new ImageIcon("src/view/4.png");
	private static ImageIcon d5 = new ImageIcon("src/view/5.png");
	private static ImageIcon d6 = new ImageIcon("src/view/6.png");
	
	/**
	 * Dice constuctor
	 */
	public Dice(){
		this.side = 0;
		this.roll = true;
		this.rnd = new Random();
		this.icn = d0;
	}
	
	/**
	 * Dice throw
	 */
	public void roll(){
		if(this.roll){
		this.side = this.rnd.nextInt(max)+1;
		this.show();
	}
	}
	
	/**
	 * Set dice icon
	 */
	public void show(){
		switch (this.side)
		{
		case 0 : this.icn = d0; break;
		case 1 : this.icn = d1; break;
		case 2 : this.icn = d2; break;
		case 3 : this.icn = d3; break;
		case 4 : this.icn = d4; break;
		case 5 : this.icn = d5; break;
		case 6 : this.icn = d6; break;
		}
	}
	
	/**
	 * Reset dice to default
	 */
	public void reset(){
		this.side = 0;
		this.roll = true;
		this.icn = d0;
		this.rnd = new Random();
		this.show();
	}
	
	/**
	 * Return dice value
	 * @return dice value
	 */
	public int getSide(){
		return this.side;
	}
	
	/**
	 * Check dice throw ability
	 * @return dice throw ability
	 */
	public boolean getFlag(){
		return (!this.roll);
	}
	
	/**
	 * Set dice throw ability
	 * @param flag dice throw ability
	 */
	public void setFlag(boolean flag){
		this.roll = !flag;
	}
	
	/**
	 * Get dice icon
	 * @return dice icon
	 */
	public ImageIcon getIcon(){
		return this.icn;
	}
	
	/**
	 * Clone dice method
	 */
	public Object clone(){
		try{
			return super.clone();
		}catch (CloneNotSupportedException e){
			throw new AssertionError("Cant clone dice");
		}
	}
}
