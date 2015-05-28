package com.mygdx.lazarusPlayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Stand extends AnimatedSprite
{
	//Fields
	private Lazarus lazarus;
	
	
	//Properties
	
	
	//Constructor
	public Stand(Lazarus lazarus)
	{
		super(lazarus);
		this.lazarus = lazarus;
		this.regions = new Array<AtlasRegion>();
		this.regions = this.lazarus.getGame().getAtlas().findRegions("spr_laz_stand");
		this.maxSpriteNumber = this.regions.size -1;
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
	}
	
	//Update
	public void Update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			this.lazarus.setState(this.lazarus.getJump_right());
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.lazarus.setState(this.lazarus.getJumpLeft());
			this.lazarus.getPosition().add(new Vector2(-40f, 0f));
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.A))
		{
			this.lazarus.setState(this.lazarus.getJumpLeftDown());
			this.lazarus.getPosition().add(new Vector2(-40f, 0f));
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.Q))
		{			
			this.lazarus.setState(this.lazarus.getWalkLeft());
			this.lazarus.getPosition().add(new Vector2(-40f, 0f));
		}
		
		if (Gdx.input.isKeyPressed(Keys.W))
		{			
			this.lazarus.setState(this.lazarus.getWalkRight());
		}
		
		super.Update(delta);
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
