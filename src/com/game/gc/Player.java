package com.game.gc;

public abstract class Player {
	private String name;
 
	
    
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	//abstract method
	public abstract void start(String name);
	public abstract Roshambo generateRoshambo();



	public void play(){
		start(name);
		generateRoshambo();


		
	}
    

	
	
}
