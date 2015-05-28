package com.mygdx.lazarusPlayer;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedSprite 
{
	//Fields
	private Lazarus lazarus;
	protected int width;
	protected int height;
	private float timer, timerMaximum;
	protected int spriteNumber = 0;
	protected Array<AtlasRegion> regions;
	protected int maxSpriteNumber;
	
	//Properties
	
	
	//constructor
	public AnimatedSprite(Lazarus lazarus)
	{
		this.lazarus = lazarus;
		this.timerMaximum = 2f/60f;
	}
	
	
	//Update
	public void Update(float delta)
	{
		this.timer += delta;
		
		if ( this.timer > this.timerMaximum)
		{
			if ( this.spriteNumber < this.maxSpriteNumber)
			{
				this.spriteNumber++;
				//Gdx.app.log("arraysize", Integer.toString(this.regions.size));
			}
			else
			{
				this.spriteNumber = 0;
			}
			this.timer = 0f;
		}
	}
	
	//Draw
	public void Draw(float delta)
	{
		this.lazarus.getGame().getBatch().draw(this.regions.get(Math.abs(this.spriteNumber)),
				  				  			   this.lazarus.getPosition().x,
				  				  			   this.lazarus.getPosition().y,
				  				  			   this.width,
				  				  			   this.height);
	}
	

}
