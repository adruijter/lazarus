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
	public Lazarus(MyGdxLazarus game, Vector2 position)
	{
		this.game = game;
		this.position = position;
		//this.regions = new Array<AtlasRegion>();		
		//this.regions = this.game.getAtlas().findRegions(name);		
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
