package com.mygdx.bal;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class Idle extends AnimatedSprite
{
	//Fields
	private Lazarus lazarus;
	private Array<AtlasRegion> regions;

	
	//Properties
	
	
	//Constructor
	public Idle(Lazarus lazarus)
	{
		super(lazarus);
		this.lazarus = lazarus;
		this.regions = this.lazarus.getGame().getAtlas().findRegions("spr_laz_stand");
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
	}
	
	//Update
	public void Update(float delta)
	{
		super.Update(delta);
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
