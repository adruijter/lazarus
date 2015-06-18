package com.mygdx.lazarus.Boxes;

public class BoxMove implements IBox
{
	private Box box;
	private BoxManager boxManager;
	
	public BoxMove(Box box)
	{
		this.box = box;
		this.boxManager = new BoxManager(this.box.getGame(), this.box);
	}
	
	@Override
	public void Update(float delta) 
	{
		this.boxManager.Update(delta);
		
		if (this.box.getPosition().y > 4 * 40f)
		{
			this.box.getPosition().add(0f, -this.box.getSpeed());
		}
		else
		{
			this.box.setBoxState(this.box.getBoxIdle());
		}
	}

	@Override
	public void Draw(float delta) 
	{
		
	}
	
}
