package com.mygdx.lazarus;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.lazarusPlayer.Lazarus;

public class SplashScreen implements Screen
{
	// Fields
	private MyGdxLazarus game;
	private Image background, title;
	private Wall wall0;
	private Array<Lazarus> spriteList;
	private Array<AtlasRegion> stone;
	private Level level;
	private OrthographicCamera cam;
	private float width;
	private float height;

	
	// Properties
	public Level getLevel()
	{
		return this.level;
	}
	
	
	// Constructor
	public SplashScreen(MyGdxLazarus game)
	{
		this.game = game;
	
		this.width = Gdx.graphics.getWidth();
		this.height = Gdx.graphics.getHeight();
		
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(false, this.width, this.height);
		
		this.background = new Image(this.game, "Background.bmp", Vector2.Zero);
		this.title = new Image(this.game, "Title.gif", new Vector2(120f, 70f));
		//this.stone = game.getAtlas().findRegions("spr_wall");
		this.spriteList = new Array<Lazarus>();
		this.spriteList.add(new Lazarus(this.game, new Vector2(2 * 40f, -0.5f * 40f)));
		//this.wall0 = new Wall(this.game, new Vector2(6*40f, 1*40f));
		try {
			this.level = new Level(this.game, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void show() 
	{
	
		
	}

	@Override
	public void render(float delta) 
	{
		//this.game.getBatch().setProjectionMatrix(this.cam.combined);
		// Update
		for (Lazarus lazarus : this.spriteList )
		{
			lazarus.Update(delta);
		}
		
		
		
		this.cam.update();
		
		this.level.Update(delta);
		
		// Draw
		
		this.game.getBatch().begin();
		
		this.background.Draw(delta);
		this.title.Draw(delta);
		this.level.Draw(delta);
		for (Lazarus lazarus : this.spriteList )
		{
			lazarus.Draw(delta);
		}
		//this.game.getBatch().draw(this.stone.get(0), 7 * 40f,  1 * 40f);
		//Teken de Wall via de Wall Class
		//this.wall0.Draw(delta);
		
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
