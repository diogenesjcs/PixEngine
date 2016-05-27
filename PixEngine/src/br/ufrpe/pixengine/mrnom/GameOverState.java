package br.ufrpe.pixengine.mrnom;

import javafx.scene.input.KeyCode;
import br.ufrpe.pixengine.components.ObjectManager;
import br.ufrpe.pixengine.components.State;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class GameOverState extends State {
	public int points;
	public GameOverState(int points) {
		this.points=points;
		manager.addObject(new SceneImage("background", "/mr.nom/background.png", 0, 0));
		manager.addObject(new SceneImage("title", "/mr.nom/gameover.png", 60, 180));
		manager.addObject(new Points("points1","/mr.nom/numbers.png",140,440));
		manager.addObject(new Points("points2","/mr.nom/numbers.png",160,440));
	}

	@Override
	public void update(GameContainer gc, float dt) {
		String formated = String.format("%02d", points);
		int points1 = Integer.parseInt(formated.substring(0,1));
		int points2 = Integer.parseInt(Character.toString(formated.charAt(1)));
		((Points)gc.getGame().peek().getManager().findObject("points1")).setNumber(points1);
		((Points)gc.getGame().peek().getManager().findObject("points2")).setNumber(points2);	
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
