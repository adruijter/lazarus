package com.mygdx.lazarus;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class TexturePackImage 
{	
	private Array<AtlasRegion> texturePackItem;
	private MyGdxLazarus game;
	private Vector2 position;
	
	public TexturePackImage(MyGdxLazarus game, String name, Vector2 position)
	{
		this.game = game;
		this.position = position;
		this.texturePackItem = game.getAtlas().findRegions(name);
	}
	
	public void Draw(float delta)
	{
		this.game.getBatch().draw(this.texturePackItem.get(0), this.position.x, this.position.y);
	}
}

