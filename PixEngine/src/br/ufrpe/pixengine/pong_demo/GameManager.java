package br.ufrpe.pixengine.pong_demo;

import br.ufrpe.pixengine.core.AbstractGame;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class GameManager extends AbstractGame
{
	public GameManager()
	{
		push(new PlayState());
	}
	
	@Override
	public void update(GameContainer gc, float dt)
	{
		peek().update(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r)
	{
		peek().render(gc, r);
	}
	
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.setWidth(320);
		gc.setHeight(240);
		gc.setScale(3);
		gc.setTitle("My Pong!");
		gc.setClearScreen(true);
		gc.setLightEnable(false);
		gc.setDynamicLights(false);
		gc.start();
	}

	@Override
	public void init(GameContainer gc)
	{
		// TODO Auto-generated method stub
		
	}
}
