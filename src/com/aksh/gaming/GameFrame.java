package com.aksh.gaming;

import java.io.IOException;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements Constants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//constructor
	GameFrame() throws IOException {
		Board board=new Board();
		this.setSize(BOARD_WIDTH,BOARD_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Street Fighter");
		setLocationRelativeTo(null);
		setResizable(false);
		add(board);
		setVisible(true);
		
		
	}
	public static void main(String args[]) throws IOException {
		GameFrame obj=new GameFrame();
		
	}

}
