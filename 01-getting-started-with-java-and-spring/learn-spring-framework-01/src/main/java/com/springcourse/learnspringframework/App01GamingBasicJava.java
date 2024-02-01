package com.springcourse.learnspringframework;

import com.springcourse.learnspringframework.game.GameRunner;
import com.springcourse.learnspringframework.game.PackmanGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
//		MarioGame marioGame = new MarioGame();
//		SupercontraGame supercontraGame = new SupercontraGame();
		PackmanGame packmanGame = new PackmanGame();
		GameRunner gameRunner = new GameRunner(packmanGame);
		gameRunner.run();
	}

}
