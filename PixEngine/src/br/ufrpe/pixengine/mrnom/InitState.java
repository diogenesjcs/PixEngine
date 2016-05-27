package br.ufrpe.pixengine.mrnom;

import javafx.scene.input.KeyCode;
import br.ufrpe.pixengine.components.ObjectManager;
import br.ufrpe.pixengine.components.State;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class InitState extends State {
	public InitState() {
		manager.addObject(new SceneImage("background", "/mr.nom/background.png", 0, 0));
		manager.addObject(new SceneImage("title", "/mr.nom/ready.png", 50, 180));
		
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if (gc.getInput().isKeyPressed(KeyCode.ENTER.ordinal())){
			gc.getGame().pop();
			gc.getGame().push(new PlayState());
			gc.getGame().peek().getManager().findObject("player").setY(gc.getHeight()/2);
			gc.getGame().peek().getManager().findObject("player").setX(gc.getWidth()/2);
		}
		manager.updateObjects(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		manager.renderObjects(gc, r);
	}

	@Override
	public void dipose() {
		manager.diposeObjects();
	}

	public ObjectManager getManager() {
		return manager;
	}

	public void setManager(ObjectManager manager) {
		this.manager = manager;
	}

}
