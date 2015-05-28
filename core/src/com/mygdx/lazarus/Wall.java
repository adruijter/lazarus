package com.mygdx.lazarus;

import com.badlogic.gdx.math.Vector2;

public class Wall extends TexturePackImage 
{
	
	public Wall(MyGdxLazarus game, Vector2 position) 
	{		
		super(game, "spr_wall", position);
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
