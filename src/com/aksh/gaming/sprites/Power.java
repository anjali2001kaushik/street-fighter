package com.aksh.gaming.sprites;

import java.awt.Color;
import java.awt.Graphics;

import com.aksh.gaming.Constants;

public class Power extends Sprites implements Constants {
	
	Color color;
	boolean isCollide=false;
	public boolean isCollide() {
		return isCollide;
	}
	public void setCollide(boolean isCollide) {
		this.isCollide = isCollide;
	}
	public Power(Color color,int x){
		this.x=x;
		y=40;
		w=200;
		h=30;
		this.color=color;
	}
	public void draw(Graphics pen) {
		if(isCollide) {
			if(color==Color.GREEN) {
				w=(w-10);
				
			}
			isCollide=false;
		}
		pen.setColor(color);
		pen.fillRect(x, y, w, h);
	}
}
