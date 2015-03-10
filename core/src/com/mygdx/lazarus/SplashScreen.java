package com.mygdx.lazarus;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

public class SplashScreen implements Screen
{
	// Fields
	private MyGdxLazarus game;
	private Image background, title;
	
	
	
	// Constructor
	public SplashScreen(MyGdxLazarus game)
	{
		this.game = game;
		this.background = new Image(this.game, "Background.bmp", Vector2.Zero);
		this.title = new Image(this.game, "Title.gif", new Vector2(120f, 70f));
		
	}
	
	@Override
	public void show() 
	{
	
		
	}

	@Override
	public void render(float delta) 
	{
		this.game.getBatch().begin();
		this.background.Draw(delta);
		this.title.Draw(delta);
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
