package com.mygdx.bal;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedSprite 
{
	//Fields
	private Lazarus lazarus;
	protected int width;
	protected int height;
	private float timer, timerMaximum;
	private int spriteNumber = 0;
	protected Array<AtlasRegion> regions;
	
	//Properties
	
	
	//constructor
	public AnimatedSprite(Lazarus lazarus)
	{
		this.lazarus = lazarus;
		this.timerMaximum = 10f/60f;
	}
	
	
	//Update
	public void Update(float delta)
	{
		this.timer += delta;
		
		if ( this.timer > this.timerMaximum)
		{
			if ( this.spriteNumber < (this.regions.size - 1))
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
		this.lazarus.getGame().getBatch().draw(this.regions.get(this.spriteNumber),
				  				  			   this.lazarus.getPosition().x,
				  				  			   this.lazarus.getPosition().y,
				  				  			   this.width,
				  				  			   this.height);
	}
	

}
