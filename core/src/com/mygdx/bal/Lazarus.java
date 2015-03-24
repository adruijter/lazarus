package com.mygdx.bal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.lazarus.MyGdxLazarus;

public class Lazarus 
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
	private AnimatedSprite state;
	private Idle idle;
	
	//Properties
	public MyGdxLazarus getGame()
	{
		return this.game;
	}
	public Array<AtlasRegion> getRegions()
	{
		return this.regions;
	}
	public Vector2 getPosition()
	{
		return this.position;
	}
	public AnimatedSprite State()
	{
		return this.state;
	}
	//Constructor
	public Lazarus(MyGdxLazarus game, Vector2 position, String name, float timerMaximum)
	{
		this.game = game;
		this.position = position;
		this.name = name;
		this.timerMaximum = timerMaximum;
		
		this.regions = new Array<AtlasRegion>();
		
		this.regions = this.game.getAtlas().findRegions(name);
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
		
		this.idle = new Idle(this);
		this.state = this.idle;		
	}
	
	public void Update(float delta)
	{
		this.state.Update(delta);
	}
	
	public void Draw(float delta)
	{
		this.state.Draw(delta);
	}
	

}
