package com.aksh.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aksh.gaming.Constants;

public class Player2 extends Sprites implements Constants {
	int power;
	String position,position2;
	int w1,h1;
	String direction;
	public Player2() throws IOException{
		x=1000;
		w=158;
		h=302;
		w1=44;
		h1=84;
		
		y=BOARD_HEIGHT-h-FLOOR;
		speed=0;
		direction="neutral";
		position="Stand";
		position2=position;
		power=MAX_POWER;
		bi=ImageIO.read(Player2.class.getResource("kenSprite.jpg"));
		loadStand();
		loadWalk();
		loadKick();
		loadPunch();
		loadFall();
		loadJump();
		
	}
	public String getPosition2() {
		return position2;
	}

	public void setPosition2(String position2) {
		this.position2 = position2;
	}
	BufferedImage stand[] = new BufferedImage[4];
	BufferedImage walk[] = new BufferedImage[4];
	BufferedImage punch[] = new BufferedImage[4];
	BufferedImage kick[] = new BufferedImage[4];
	BufferedImage jump[] = new BufferedImage[4];
	BufferedImage fall[] = new BufferedImage[4];
	BufferedImage currentDraw[] = new BufferedImage[4];
	public void loadStand() {
		stand[0] = bi.getSubimage(1549,17,w1,h1);
		stand[1] = bi.getSubimage(1500,16,w1,h1);
		stand[2] = bi.getSubimage(1450,14,w1,h1);
		stand[3] = bi.getSubimage(1400,11,w1,h1);
	}
	
	public void loadWalk() {
		
		walk[0] = bi.getSubimage(1350,14, w1,h1);
		walk[1] = bi.getSubimage(1303,13,w1,h1);
		walk[2] = bi.getSubimage(1252,14, w1,h1);
		walk[3] = bi.getSubimage(1201,13, w1,h1);
	}
	
	public void loadPunch() {
		punch[0] = bi.getSubimage(541,128,w1,h1);
		punch[1] = bi.getSubimage(476,127,55,h1);
		punch[2] = bi.getSubimage(412,110,53,103);
		punch[3] = bi.getSubimage(350,126,55,88 );
	}
	
	public void loadKick() {
		kick[0] = bi.getSubimage(581,261,w1,h1);
		kick[1] = bi.getSubimage(495,251,59,93);
		kick[2] = bi.getSubimage(436,297,w1,110);
		kick[3] = bi.getSubimage( 353,248,56,96);
	}
	public void loadJump() {
		jump[0] = bi.getSubimage(1102,17,w1,h1);
		jump[1] = bi.getSubimage(1018,14,w1,h1);
		jump[2] = bi.getSubimage(942,12,w1,h1);
		jump[3] = bi.getSubimage(858,15,w1,h1);
	}
	public void loadFall() {
		fall[0] = bi.getSubimage(1039,777,49,h1);
		fall[1] = bi.getSubimage(985,775,49,h1);
		fall[2] = bi.getSubimage(907,781,75,h1);
		fall[3] = bi.getSubimage(826,793,79,71);
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
			currentDraw = walk;
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
//		x=x+10;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
		position2=position;
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


