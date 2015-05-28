package com.mygdx.lazarus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;

public class Level 
{
	private MyGdxLazarus game;
	private String levelPath;
	private ArrayList<String> lines;
	private int lineWidth;
	private int linesCount;
	
	
	public Level(MyGdxLazarus game, int levelIndex) throws IOException
	{
		this.game = game;
		this.levelPath = String.format("%s.txt", levelIndex);
		Gdx.app.log("levelIndex", this.levelPath);
		this.LoadAssets();
		
	}
	
	
	private void LoadAssets() throws IOException
	{
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(handle.read()));
		String line =  reader.readLine();
		Gdx.app.log("eerste regel 0.txt", line);
		this.lineWidth = line.length();
		Gdx.app.log("breedte string", Integer.toString(this.lineWidth));
		
		while (line != null)
		{
			lines.add(line);
			line = reader.readLine();
			Gdx.app.log("regel", line);
		}
		
		this.linesCount = this.lines.size();
		Gdx.app.log("Aantal regels", Integer.toString(this.linesCount));
	}
	
	private TexturePackImage loadObject(char element, Vector2 position)
	{
		switch(element)
		{
			case 'w':
				return new Wall(this.game, position);
				
			default:
				return new TexturePackImage(this.game, "spr_empty", position);
		}
	}
	
}
