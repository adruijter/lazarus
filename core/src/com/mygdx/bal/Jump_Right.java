package com.mygdx.bal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Jump_Right extends AnimatedSprite 
{
	//Fields
	private Lazarus lazarus;
	
	//Properties
	public int getMaxSpriteNumber()
	{
		return this.maxSpriteNumber;
	}
	
	//Constructor
	public Jump_Right(Lazarus lazarus)
	{
		super(lazarus);
		this.lazarus = lazarus;
		this.regions = new Array<AtlasRegion>();
		this.regions = this.lazarus.getGame().getAtlas().findRegions("spr_laz_jump_right");
		this.maxSpriteNumber = this.regions.size -1;
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
	}
	
	//Update
	public void Update(float delta)
	{
		super.Update(delta);
		if ( this.spriteNumber == this.maxSpriteNumber)
		{
			//Gdx.app.log("maxsprite", Integer.toString(this.maxSpriteNumber));
			this.lazarus.setState(this.lazarus.getStand());
			this.lazarus.getPosition().add(new Vector2(40f, 40f));
			this.spriteNumber = 0;
		}
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
