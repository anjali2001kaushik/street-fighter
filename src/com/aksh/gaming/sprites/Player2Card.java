package com.aksh.gaming.sprites;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.aksh.gaming.Constants;

public class Player2Card extends Sprites implements Constants {
	public Player2Card() throws IOException{
		x=BOARD_WIDTH-290;
		y=30;
		w=300;
		h=70;
		bi=ImageIO.read(Player1Card.class.getResource("kenp1.png"));
	}

}
