package com.mygdx.bal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class FallDown extends AnimatedSprite
{
	//Fields
	private Lazarus lazarus;
	
	
	//Properties
	
	
	//Constructor
	public FallDown(Lazarus lazarus)
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
		if (this.lazarus.getPosition().y > 40f)
		{
			this.lazarus.getPosition().add(new Vector2(0f, -2f));
		}
		else
		{
			this.lazarus.setState(this.lazarus.getStand());
		}
		super.Update(delta);
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
