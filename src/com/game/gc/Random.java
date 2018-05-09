package com.game.gc;

public class Random extends Player {

	@Override
	public void start(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Roshambo generateRoshambo() {
		Roshambo roshambo = Roshambo.values()[(int)(Math.random()*Roshambo.values().length)];
      
		return roshambo;
	}

}
