package com.mygdx.bal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class JumpLeftDown extends AnimatedSprite 
{
	//Fields
	private Lazarus lazarus;
	
	//Properties
	public int getMaxSpriteNumber()
	{
		return this.maxSpriteNumber;
	}
	
	//Constructor
	public JumpLeftDown(Lazarus lazarus)
	{
		super(lazarus);
		this.lazarus = lazarus;
		this.regions = new Array<AtlasRegion>();
		this.regions = this.lazarus.getGame().getAtlas().findRegions("spr_laz_left");
		this.maxSpriteNumber = 6                      ;
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
		this.spriteNumber = 0;
	}
	
	//Update
	public void Update(float delta)
	{
		super.Update(delta);
		if ( this.spriteNumber == 6)
		{
			this.lazarus.setState(this.lazarus.getFallDown());
			this.lazarus.getPosition().add(new Vector2(0f, 0f));
			this.spriteNumber = 0;
		}
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
