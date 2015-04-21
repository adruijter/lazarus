package com.mygdx.lazarus;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.bal.Lazarus;

public class SplashScreen implements Screen
{
	// Fields
	private MyGdxLazarus game;
	private Image background, title;
	private Array<Lazarus> spriteList;
	private Array<AtlasRegion> stone;

	
	
	
	
	// Constructor
	public SplashScreen(MyGdxLazarus game)
	{
		this.game = game;
		this.background = new Image(this.game, "Background.bmp", Vector2.Zero);
		this.title = new Image(this.game, "Title.gif", new Vector2(120f, 70f));
		this.stone = game.getAtlas().findRegions("spr_wall");
		this.spriteList = new Array<Lazarus>();
		this.spriteList.add(new Lazarus(this.game, new Vector2(7 * 40f, 1 * 40f)));
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
		this.game.getBatch().draw(this.stone.get(0), 8 * 40f,  1 * 40f);
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
