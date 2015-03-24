package com.mygdx.lazarus;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.bal.Lazarus;

public class SplashScreen implements Screen
{
	// Fields
	private MyGdxLazarus game;
	private Image background, title;
	private Array<Lazarus> spriteList;
	
	
	
	
	// Constructor
	public SplashScreen(MyGdxLazarus game)
	{
		this.game = game;
		this.background = new Image(this.game, "Background.bmp", Vector2.Zero);
		this.title = new Image(this.game, "Title.gif", new Vector2(120f, 70f));
		this.spriteList = new Array<Lazarus>();
		//this.spriteList.add(new Lazarus(this.game, new Vector2(300f, 380f), "spr_laz_jump_left", 5f/60f));
		//this.spriteList.add(new Lazarus(this.game, new Vector2(100f, 380f), "spr_laz_jump_right", 5f/60f));
		//this.spriteList.add(new Lazarus(this.game, new Vector2(20f, 380f), "spr_laz_left", 5f/60f));		
		//this.spriteList.add(new Lazarus(this.game, new Vector2(200f, 380f), "spr_laz_right", 5f/60f));
		//this.spriteList.add(new Lazarus(this.game, new Vector2(400f, 380f), "spr_laz_squished", 5f/60f));	
		//this.spriteList.add(new Lazarus(this.game, new Vector2(500f, 380f), "spr_laz_afraid", 5f/60f));
		this.spriteList.add(new Lazarus(this.game, new Vector2(350f, 380f)));
	}
	
	@Override
	public void show() 
	{
	
		
	}

	@Override
	public void render(float delta) 
	{
		// Update
		for (Lazarus lazarus : this.spriteList )
		{
			lazarus.Update(delta);
		}
		
		// Draw
		this.game.getBatch().begin();
		this.background.Draw(delta);
		this.title.Draw(delta);	
		for (Lazarus lazarus : this.spriteList )
		{
			lazarus.Draw(delta);
		}
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height) 
	{

	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
				
	}

	@Override
	public void hide() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}

	
}
