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
	private TexturePackImage walls[][];
	
	
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
		
		this.walls = new TexturePackImage[this.lineWidth][this.linesCount];
		
		for (int i = 0; i < this.linesCount; i++)
		{
			for(int j = 0; j < this.lineWidth; j++)
			{
				char characterInText  = this.lines.get(i).charAt(j);
				this.walls[j][i] = this.loadObject(characterInText, new Vector2(j * 40, i * 40));
			}
		}
		
		
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
	
	public void Draw(float delta)
	{
		for (int i = 0; i < this.linesCount; i++)
		{
			for(int j = 0; j < this.lineWidth; j++)
			{
				
				this.walls[j][i].Draw(delta);
			}
		}		
	}
	
}
