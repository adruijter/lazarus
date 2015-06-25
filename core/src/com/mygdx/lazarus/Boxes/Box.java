package com.mygdx.lazarus.Boxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.lazarus.MyGdxLazarus;
import com.mygdx.lazarusPlayer.Lazarus;

public class Box
{
	//Fields
	private MyGdxLazarus game;
	private Vector2 position;
	private Array<AtlasRegion> regions;
	private int width;
	private int height;
	private int spriteNumber;
	private float speed = 3f;
	protected String boxType;
	private BoxMove boxMove;
	private BoxIdle boxIdle;
	private IBox boxState;
	private Rectangle collisionRect;
	
	
	//Properties
	public String getBoxType()
	{
		return this.boxType;
	}
	
	public Vector2 getPosition()
	{
		this.collisionRect.x = this.position.x;
		this.collisionRect.y = this.position.y;
		return this.position;
	}
	
	public Rectangle getCollisionRect()
	{
		return this.collisionRect;
	}
	
	public float getSpeed()
	{
		return this.speed;
	}
	
	public void setBoxState(IBox box)
	{
		this.boxState = box;
	}
	
	public BoxIdle getBoxIdle()
	{
		return this.boxIdle;
	}
	
	public BoxMove getBoxMove()
	{
		return this.boxMove;
	}
	
	public MyGdxLazarus getGame()
	{
		return this.game;
	}
	
	
	//Constructor
	public Box(MyGdxLazarus game, Vector2 position, String boxType)
	{
		this.game = game;
		this.position = position;
		this.boxType = boxType;
		this.regions = new Array<AtlasRegion>();
		this.regions = this.game.getAtlas().findRegions(boxType);
		
		this.width = this.regions.first().getRegionWidth();
		this.height = this.regions.first().getRegionHeight();
		this.collisionRect = new Rectangle(this.position.x,
										   this.position.y,
										   this.width,
										   this.height);
		this.boxMove = new BoxMove(this);
		this.boxIdle = new BoxIdle(this);
		this.boxState = this.boxMove;
	}
	
	//Update
	public void Update(float delta)
	{
		this.boxState.Update(delta);		
	}
	
	//Draw
	public void Draw(float delta)
	{
		this.game.getBatch().draw(this.regions.get(Math.abs(this.spriteNumber)),
	  			   this.position.x,
	  			   this.position.y,
	  			   this.width,
	  			   this.height);
	}
}
