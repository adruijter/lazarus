package com.mygdx.lazarusPlayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class JumpLeft extends AnimatedSprite 
{
	//Fields
	private Lazarus lazarus;
	
	//Properties
	public int getMaxSpriteNumber()
	{
		return this.maxSpriteNumber;
	}
	
	//Constructor
	public JumpLeft(Lazarus lazarus)
	{
		super(lazarus);
		this.lazarus = lazarus;
		this.regions = new Array<AtlasRegion>();
		this.regions = this.lazarus.getGame().getAtlas().findRegions("spr_laz_jump_left");
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
			this.lazarus.setState(this.lazarus.getStand());
			this.lazarus.getPosition().add(new Vector2(0f, 40f));
			this.spriteNumber = 0;
		}
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
