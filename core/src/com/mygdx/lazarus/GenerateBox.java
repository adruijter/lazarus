package com.mygdx.lazarus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.lazarus.Boxes.Card;
import com.mygdx.lazarus.Boxes.Metal;
import com.mygdx.lazarus.Boxes.Stone;
import com.mygdx.lazarus.Boxes.Wood;

public class GenerateBox 
{
	// Fields
	private MyGdxLazarus game;
	//private bool oldKeyPressState
	
	//Properties
	
	
	// Constructor
	public GenerateBox(MyGdxLazarus game)
	{
		this.game  = game;
	}
	
	
	// Methods
	public void Update(float delta)
	{
		if (Gdx.input.isKeyJustPressed(Keys.NUM_1))
		{
			this.game.getSplashScreen().getLevel().setBoxes(new Card(this.game, new Vector2(4 * 40f, 12 * 40f)));
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.NUM_2))
		{
			this.game.getSplashScreen().getLevel().setBoxes(new Metal(this.game, new Vector2(4 * 40f, 12 * 40f)));			
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.NUM_3))
		{
			this.game.getSplashScreen().getLevel().setBoxes(new Stone(this.game, new Vector2(4 * 40f, 12 * 40f)));			
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.NUM_4))
		{			
			this.game.getSplashScreen().getLevel().setBoxes(new Wood(this.game, new Vector2(4 * 40f, 12 * 40f)));
		}		
	}
	
	public void Draw(float delta)
	{
		
	}
}
