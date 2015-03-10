package com.mygdx.lazarus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Image 
{
	// Fields
	private MyGdxLazarus game;
	private Texture background;
	private Vector2 position;
	
	// Constructor
	public Image(MyGdxLazarus game, String name, Vector2 position)
	{
		this.game = game;
		this.background = new Texture(name);
		this.position = position;
	}
	
	public void Draw(float delta)
	{
		this.game.getBatch().draw(this.background, 
								  this.position.x,
								  this.position.y,
								  this.background.getWidth(),
								  this.background.getHeight());
	}
}
