package com.aksh.gaming;

import java.io.File;

import jaco.mp3.player.MP3Player;

public class Sound {
	MP3Player mp1,mp2;
	String checkSound;
	Sound(){
		mp1=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\bgSound.mp3"));
		mp1.play();
	}
	public void playSound() {
		if (checkSound=="punch") {
			mp2=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\punch.mp3"));
			
		} 
		else if(checkSound=="kick") {
			mp2=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\punch.mp3"));
		}
		else if(checkSound=="jump"){
			mp2=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\jump.mp3"));
		}
		else if(checkSound=="finish") {
			mp2=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\jump.mp3"));
		}
		else if(checkSound=="hit") {
			mp2=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\hit.mp3"));
		}
		else if(checkSound=="victory") {
			mp2=new MP3Player(new File("src\\com\\aksh\\gaming\\sprites\\victory.mp3"));
		}
		mp2.play();
	}
	public String getCheckSound() {
		return checkSound;
	}
	public void setCheckSound(String checkSound) {
		this.checkSound = checkSound;
	}

}
