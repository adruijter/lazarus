package com.mygdx.lazarus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.lazarus.Boxes.Box;
import com.mygdx.lazarus.Boxes.Card;
import com.mygdx.lazarus.Boxes.Metal;
import com.mygdx.lazarus.Boxes.Stone;
import com.mygdx.lazarus.Boxes.Wood;
import com.mygdx.lazarusPlayer.Lazarus;

public class Level 
{
	private MyGdxLazarus game;
	private String levelPath;
	private ArrayList<String> lines;
	private int lineWidth;
	private int linesCount;
	private TexturePackImage walls[][];
	private Lazarus lazarus;
	private ArrayList<Box> boxes;
	private GenerateBox generateBoxes;
	
	public ArrayList<Box> getBoxes()
	{
		return this.boxes;
	}
	
	public void setBoxes(Box box)
	{
		this.boxes.add(box);
	}
	
	public Level(MyGdxLazarus game, int levelIndex) throws IOException
	{
		this.game = game;
		this.levelPath = String.format("%s.txt", levelIndex);
		Gdx.app.log("levelIndex", this.levelPath);
		this.generateBoxes = new GenerateBox(this.game);
		this.LoadAssets();
		
	}
	
	
	private void LoadAssets() throws IOException
	{
		this.lines = new ArrayList<String>();
		this.boxes = new ArrayList<Box>();
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
				this.walls[j][i] = this.loadObject(characterInText, new Vector2((j) * 40, (11 - i) * 40));
			}
		}
		
		
	}
	
	private TexturePackImage loadObject(char element, Vector2 position)
	{
		switch(element)
		{
			case 'w':
				return new Wall(this.game, position);
			case 'b':
				return new TexturePackImage(this.game, "spr_button", position);
			case 'c':
				this.boxes.add(new Card(this.game, position));
				return new TexturePackImage(this.game, "spr_empty", position);
			case 's':
				this.boxes.add(new Stone(this.game, position));
				return new TexturePackImage(this.game, "spr_empty", position);
			case 'm':
				this.boxes.add(new Metal(this.game, position));
				return new TexturePackImage(this.game, "spr_empty", position);
			case 'W':
				this.boxes.add(new Wood(this.game, position));
				return new TexturePackImage(this.game, "spr_empty", position);
			case 'L': 
				this.lazarus = new Lazarus(this.game, position);
				return new TexturePackImage(this.game, "spr_empty", position);				
			default:
				return new TexturePackImage(this.game, "spr_empty", position);
		}
	}
	
	public void Update(float delta)
	{
		this.lazarus.Update(delta);
		
		for (int i = 0; i < this.boxes.size(); i++)
		{
			this.boxes.get(i).Update(delta);
		}
		this.generateBoxes.Update(delta);
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
		
		this.lazarus.Draw(delta);
		
		for (int i = 0; i < this.boxes.size(); i++)
		{
			this.boxes.get(i).Draw(delta);
		}
	}
	
}
