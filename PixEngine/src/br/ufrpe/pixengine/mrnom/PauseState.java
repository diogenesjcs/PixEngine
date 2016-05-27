package br.ufrpe.pixengine.mrnom;

import javafx.scene.input.KeyCode;
import br.ufrpe.pixengine.components.ObjectManager;
import br.ufrpe.pixengine.components.State;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class PauseState extends State {
	public PauseState() {
		manager.addObject(new SceneImage("background", "/mr.nom/background.png", 0, 0));
		manager.addObject(new SceneImage("title", "/mr.nom/pauseMenu.png", 80, 180));
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if (gc.getInput().isKeyPressed(KeyCode.ENTER.ordinal())){
			gc.getGame().pop();
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
