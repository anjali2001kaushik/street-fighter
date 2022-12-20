package com.aksh.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprites {
	int x;
	int y;
	int h;
	int w;
	int speed;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public BufferedImage getBi() {
		return bi;
	}
	public void setBi(BufferedImage bi) {
		this.bi = bi;
	}
	BufferedImage bi;
	public void draw(Graphics pen) {
		pen.drawImage(bi, x, y, w, h, null);
	}
}
