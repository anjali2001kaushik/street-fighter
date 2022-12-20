package com.aksh.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.aksh.gaming.sprites.Player;
import com.aksh.gaming.sprites.Player1Card;
import com.aksh.gaming.sprites.Player2;
import com.aksh.gaming.sprites.Player2Card;
import com.aksh.gaming.sprites.Power;
import com.aksh.gaming.sprites.Sprites;
import com.aksh.gaming.sprites.Vs;


public class Board extends JPanel implements Constants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage bi,bi1,bi2;
	Player player1;
	Player2 player2;
	Sound sound;
	String gameMessage="Game Start";
	int count=0;
	Power red1;
	Power green1;
	Power red2;
	Power green2;
	Player1Card player1card;
	Player2Card player2card;
	Vs vs;
	
	public Board() throws IOException {
		vs=new Vs();
		red1=new Power(Color.RED,102);
		green1=new Power(Color.GREEN,102);
		red2=new Power(Color.RED,BOARD_WIDTH-290);
		green2=new Power(Color.GREEN,BOARD_WIDTH-290);
		player1card=new Player1Card();
		player2card=new Player2Card();
		player1=new Player();
		player2=new Player2();
		sound=new Sound();
		bi=ImageIO.read(Board.class.getResource("game_bg.jpg"));
		player1.setBi(bi1);
		player2.setBi(bi2);
//		System.out.println(count);
		setFocusable(true);
		bindEvents();
		gameLoop();
		
	}
	boolean isCollide(Sprites one, Sprites two)
	  {
		  int xDist=Math.abs(one.getX()-two.getX());
		  int yDist=Math.abs(one.getY()-two.getY());
		  int w=Math.max(one.getW(), two.getW());
		  int h=Math.max(one.getH(),two.getH() );
		return xDist<=w-10 && yDist<=h;
		  
	  }
	  void checkCollision() {
		   if(isCollide(player1,player2)) {
			   
			   if(player1.getPower()<=0 && player2.getPower()<=0) {
					gameMessage = "Game Draw";
					sound.setCheckSound("victory");
					sound.playSound();
					timer.stop();
					return ;
			   }
			   else if(player1.getPower()<=0) {
				   gameMessage="KEN wins";
				   sound.setCheckSound("victory");
					sound.playSound();
					timer.stop();
					return ;
			   }
			   else if(player2.getPower()<=0) {
				   gameMessage="RYU wins";
				   sound.setCheckSound("victory");
					sound.playSound();
					timer.stop();
					return ;
			   }
				
				  if(player1.getPosition2()=="stand" && player2.getPosition2()!="stand") {
					  player1.setPower();
					  green1.setCollide(true);
					  sound.setCheckSound("hit");
					   sound.playSound();
				  }
				  else if(player2.getPosition2()=="stand" && player1.getPosition2()!="stand") {
					  player2.setPower();
					  green2.setCollide(true);
					  sound.setCheckSound("hit");
					   sound.playSound();
				  }
//				  else {
//					  player1.setPower();
//					  player2.setPower();
//				  }
				  
			  }
		   player1.setPosition2("stand");
		   player2.setPosition2("stand");
		  }
	  
	  
	 
	  void bindEvents() {
		  this.addKeyListener(new KeyAdapter() {
			  @Override
			  public void keyPressed(KeyEvent e) {
				  //TODO Auto-generated method stub
				  if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					  player2.move("right"); 
					  player2.outofScreen();
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					  player2.move("left");
					  player2.outofScreen();
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_UP) {
//					  player2.move("Jump");
					  player2.setPosition("Jump");
					  sound.setCheckSound("jump");
					  sound.playSound();
				  }
				  	else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				  		
						  player2.setPosition("Punch");
						  sound.setCheckSound("punch");
						  sound.playSound();
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					 
					  player2.setPosition("Kick");
					  sound.setCheckSound("kick");
					  sound.playSound();
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_D) {
					  player1.move("right"); 
					  player1.outofScreen();
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_A) {
					  player1.move("left");
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_W) {
//					  player1.move("Jump");
					  player1.setPosition("Jump");
					  sound.setCheckSound("jump");
					  sound.playSound();
				  }
				  	else if(e.getKeyCode()==KeyEvent.VK_X) {
				  		
						  player1.setPosition("Punch");
						  sound.setCheckSound("punch");
						  sound.playSound();
				  }
				  else if(e.getKeyCode()==KeyEvent.VK_S) {
					 
					  player1.setPosition("Kick");
					  sound.setCheckSound("kick");
					  sound.playSound();
				  }
				  
				  
			  }  
		});
	  }
	  Timer timer;
	  void gameLoop() {
		  //Delay
		  timer=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Timer call");
	
				count++;
				if(count==10) {
					gameMessage="";
				}
//				System.out.println(count);
				repaint();
				checkCollision();
				
			}
		});
		  timer.start();
	  }
	  public void printMessage(Graphics pen) {
		  pen.setColor(Color.RED);
		  pen.setFont(new Font("times",Font.BOLD,BOARD_WIDTH/15));
		  pen.drawString(gameMessage,BOARD_WIDTH/3,BOARD_HEIGHT/2);
	  }
	@Override
	public void paintComponent(Graphics pen) {
		pen.drawImage(bi,0,0,BOARD_WIDTH,BOARD_HEIGHT,null);
		player1.draw(pen);
		player2.draw(pen);
		red1.draw(pen);
		red2.draw(pen);
		vs.draw(pen);
		green1.draw(pen);
		green2.draw(pen);
		player1card.draw(pen);
		player2card.draw(pen);
		if(gameMessage.length()>0) {
			printMessage(pen);
		}
	}

}
