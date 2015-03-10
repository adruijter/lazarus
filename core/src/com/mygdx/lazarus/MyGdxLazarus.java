package com.mygdx.lazarus;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxLazarus extends Game 
{
	// Fields	
	private SpriteBatch batch;
	private Screen splashScreen;
	
	// Properties
	public SpriteBatch getBatch()
	{
		return this.batch;
	}
		
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.splashScreen = new SplashScreen(this);
		setScreen(this.splashScreen);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}	
}
