package com.aksh.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aksh.gaming.Constants;

public class Player extends Sprites implements Constants {
	int power;
	String position,position2;
	int w1,h1;
	String direction;

	
	public Player() throws IOException{
		x=100;
		w=195;
		h=303;
		w1=65;
		h1=101;
		y=BOARD_HEIGHT-h-FLOOR;
		speed=0;
		direction="neutral";
		position="Stand";
		position2=position;
		power=MAX_POWER;
		bi=ImageIO.read(Player.class.getResource("ryuSprite.png"));
		loadStand();
		loadWalk();
		loadKick();
		loadPunch();
		loadFall();
		loadJump();
		
	}
	
	BufferedImage stand[] = new BufferedImage[4];
	BufferedImage walk[] = new BufferedImage[4];
	BufferedImage punch[] = new BufferedImage[4];
	BufferedImage kick[] = new BufferedImage[4];
	BufferedImage jump[] = new BufferedImage[4];
	BufferedImage fall[] = new BufferedImage[4];
	BufferedImage currentDraw[] = new BufferedImage[4];
	public void loadStand() {
		stand[0] = bi.getSubimage(5, 7, w1,h1);
		stand[1] = bi.getSubimage(73, 8, w1,h1);
		stand[2] = bi.getSubimage(141,5 , w1,h1);
		stand[3] = bi.getSubimage(204,5 , w1,h1);
	}
	
	public void loadWalk() {
		
		walk[0] = bi.getSubimage(74, 126, w1,h1);
		walk[1] = bi.getSubimage(152, 127,w1,h1);
		walk[2] = bi.getSubimage(228, 124, w1,h1);
		walk[3] = bi.getSubimage(299,122, w1,h1);
	}
	
	public void loadPunch() {
		punch[0] = bi.getSubimage(9,357, w1,h1);
		punch[1] = bi.getSubimage(97,356, 94,h1);
		punch[2] = bi.getSubimage(199,358,w1,h1);
		punch[3] = bi.getSubimage(276,356,w1,h1 );
	}
	
	public void loadKick() {
		kick[0] = bi.getSubimage(9,920,68,h1);
		kick[1] = bi.getSubimage(87,916,w1,h1);
		kick[2] = bi.getSubimage(162,918,116,h1);
		kick[3] = bi.getSubimage(282,918, w1,h1);
	}
	public void loadJump() {
		jump[0] = bi.getSubimage(4,256,w1,h1);
		jump[1] = bi.getSubimage(133,224,w1,h1);
		jump[2] = bi.getSubimage(250,221,w1,109);
		jump[3] = bi.getSubimage(369,245, w1,h1);
	}
	public void loadFall() {
		fall[0] = bi.getSubimage(238,2146,w1,h1);
		fall[1] = bi.getSubimage(634,2148,86,h1);
		fall[2] = bi.getSubimage(724,2154,105,h1);
		fall[3] = bi.getSubimage(454,2282,131,84);
	}
	
	int moveIndex = 0;
	public void frameImage() {
		moveIndex++;
		if(moveIndex>3) {
			moveIndex=0;
			position = "Stand";
		}
	}
	@Override
	public void draw(Graphics pen) {
		
		if(position == "Stand") {
			currentDraw = stand;
		}
		else
		if(position == "Walk") {
			currentDraw = stand;
		}
		else
			if(position == "Punch") {
				currentDraw = punch;
			}
			else
				if(position == "Kick") {
					currentDraw = kick;
				}
				else if(position=="Jump") {
					currentDraw=jump;
				}
		frameImage();
		pen.drawImage(currentDraw[moveIndex], x,y,w,h,null);
	}
	public int getPower() {
		return power;
	}
	public void setPower() {
		power = power-5;
//		x=x-10;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
		position2=position;
	}
	public String getPosition2() {
		return position2;
	}

	public void setPosition2(String position2) {
		this.position2 = position2;
	}

	public void move(String direction) {
		this.direction=direction;
		if(direction=="left") {
			speed=-5;
		}
		else if(direction=="right") {
			speed=5;
		}
		x+=speed;
		this.direction="neutral";
	}
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void outofScreen() {
		if(x<0) {
			x=0;
		}
		else if(x>BOARD_WIDTH-w) {
			x=BOARD_WIDTH-w;
		}
	}


	

}
