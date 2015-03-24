package com.mygdx.lazarus;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxLazarus extends Game 
{
	// Fields	
	private SpriteBatch batch;
	private Screen splashScreen;
	private TextureAtlas atlas;
	
	//Properties
	public TextureAtlas getAtlas()
	{
		return this.atlas;
	}
	
	
	
	// Properties
	public SpriteBatch getBatch()
	{
		return this.batch;
	}
		
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.atlas = new TextureAtlas(Gdx.files.internal("lazarus.pack"));
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
