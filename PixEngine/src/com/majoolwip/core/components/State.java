package com.majoolwip.core.components;

import com.majoolwip.core.GameContainer;
import com.majoolwip.core.Renderer;

public abstract class State
{
	protected ObjectManager manager = new ObjectManager();
	public abstract void update(GameContainer gc, float dt);
	public abstract void render(GameContainer gc, Renderer r);
	public abstract void dipose();
	
	public ObjectManager getManager()
	{
		return manager;
	}
	public void setManager(ObjectManager manager)
	{
		this.manager = manager;
	}
}
