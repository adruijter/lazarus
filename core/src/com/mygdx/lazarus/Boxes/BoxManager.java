package com.mygdx.lazarus.Boxes;

import com.mygdx.lazarus.MyGdxLazarus;

public class BoxManager 
{
	// Fields
	private MyGdxLazarus game;
	private Box box;
	
	// Properties
	
	
	// Constructor
	public BoxManager(MyGdxLazarus game, Box box)
	{
		this.game = game;
		this.box = box;
	}
	
	// Methods
	public void Update(float delta)
	{
		for (Box box : this.game.getSplashScreen().getLevel().getBoxes())
		{
			if (this.box.getCollisionRect().overlaps(box.getCollisionRect()))
			{
				if (!this.box.equals(box))
				{
					//this.game.getSplashScreen().getLevel().getBoxes().remove(box);
					//break;
				}
			}
		}
	}
	
	public void Draw(float delta)
	{
		
	}
}
