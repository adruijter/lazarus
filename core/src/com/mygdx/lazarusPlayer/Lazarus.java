package com.mygdx.lazarusPlayer;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.lazarus.MyGdxLazarus;

public class Lazarus 
{
	//Fields
	private MyGdxLazarus game;
	private Vector2 position;
	private AnimatedSprite state;
	private Stand stand;
	private Jump_Right jump_right;
	private JumpLeft jumpLeft;
	private JumpLeftDown jumpLeftDown;
	private FallDown fallDown;
	private WalkLeft walkLeft;
	private WalkRight walkRight;
	
	//Properties
	public MyGdxLazarus getGame()
	{
		return this.game;
	}
	public Vector2 getPosition()
	{
		return this.position;
	}
	public AnimatedSprite getState()
	{
		return this.state;
	}
	public void setState(AnimatedSprite animation)
	{
		this.state = animation;
	}
	public void setPosition(Vector2 position)
	{
		this.position.add(position);
	}
	public Stand getStand()
	{
		return this.stand;
	}
	public Jump_Right getJump_right()
	{
		return this.jump_right;
	}
	public JumpLeft getJumpLeft()
	{
		return this.jumpLeft;
	}
	public JumpLeftDown getJumpLeftDown()
	{
		return this.jumpLeftDown;
	}
	public FallDown getFallDown()
	{
		return this.fallDown;
	}
	public WalkLeft getWalkLeft()
	{
		return this.walkLeft;
	}
	public WalkRight getWalkRight()
	{
		return this.walkRight;
	}
	
	//Constructor
	public Lazarus(MyGdxLazarus game, Vector2 position)
	{
		this.game = game;
		this.position = position;	
		this.stand = new Stand(this);
		this.jump_right = new Jump_Right(this);
		this.jumpLeft = new JumpLeft(this);
		this.jumpLeftDown = new JumpLeftDown(this);
		this.fallDown = new FallDown(this);
		this.walkLeft = new WalkLeft(this);
		this.walkRight = new WalkRight(this);
		this.state = this.stand;		
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
