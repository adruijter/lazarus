package com.mygdx.lazarus.Boxes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.mygdx.lazarus.MyGdxLazarus;

public class BoxManager 
{
	// Fields
	private MyGdxLazarus game;
	private Box box;
	private ArrayList<Box> boxes;
	
	// Properties
	
	
	// Constructor
	public BoxManager(MyGdxLazarus game, Box box)
	{
		this.game = game;
		this.box = box;
		this.boxes = new ArrayList<Box>();
		
	}
	
	// Methods
	public void Update(float delta)
	{
		this.boxes = this.game.getSplashScreen().getLevel().getBoxes();
		for (int i = 0; i < this.boxes.size(); i++)
		{
			if (this.box.getCollisionRect().overlaps(this.boxes.get(i).getCollisionRect()))
			{
				Gdx.app.log("idleBlokje", this.boxes.get(i).getBoxType());
				if (!this.box.equals(this.boxes.get(i)))
				{
					Gdx.app.log("moveBlokje", this.box.getBoxType());
					if ( this.box.getBoxType() == "spr_box_card")
					 {						
						 this.game.getSplashScreen().getLevel().getBoxes().remove(this.boxes.get(i));
						 break;
					 }
				}
			}
		}
	}
	
	public void Draw(float delta)
	{
		
	}
}
