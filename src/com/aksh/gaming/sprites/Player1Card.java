package com.aksh.gaming.sprites;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.aksh.gaming.Constants;

public class Player1Card extends Sprites implements Constants  {
	public Player1Card() throws IOException{
		x=7;
		y=28;
		w=300;
		h=70;
		bi=ImageIO.read(Player1Card.class.getResource("ryup1.png"));
	}
	
	
}
