package com.mygdx.bal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.lazarus.MyGdxLazarus;

public class Ball 
{
	//Fields
	private MyGdxLazarus game;
	private Vector2 position;
	private String name;
	private Array<AtlasRegion> regions;
	private float timer;
	private int spriteNumber = 0;
	private float timerMaximum = 10f/60f;
	private int width, height;
	
	//Constructor
	public Ball(MyGdxLazarus game, Vector2 position, String name, float timerMaximum)
	{
		this.game = game;
		this.position = position;
		this.name = name;
		this.timerMaximum = timerMaximum;
		
		this.regions = new Array<AtlasRegion>();
		
		this.regions = this.game.getAtlas().findRegions(name);
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
		
		
	}
	
	public void Update(float delta)
	{
		this.timer += delta;
		
		if ( this.timer > this.timerMaximum)
		{
			if ( this.spriteNumber < (this.regions.size - 1))
			{
				this.spriteNumber++;
				Gdx.app.log("arraysize", Integer.toString(this.regions.size));
			}
			else
			{
				this.spriteNumber = 0;
			}
			this.timer = 0f;
		}
	}
	
	public void Draw(float delta)
	{
		this.game.getBatch().draw(this.regions.get(this.spriteNumber),
								  this.position.x,
								  this.position.y,
								  this.width,
								  this.height);
	}
	

}
