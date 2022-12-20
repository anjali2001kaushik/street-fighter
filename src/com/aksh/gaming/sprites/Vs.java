package com.aksh.gaming.sprites;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.aksh.gaming.Constants;

public class Vs extends Sprites implements Constants{
	public Vs() throws IOException {
		w=150;
		h=150;
		y=20;
		x=(BOARD_WIDTH-w)/2;
		bi=ImageIO.read(Vs.class.getResource("v_s.png"));
	}
}
