package br.ufrpe.pixengine.mrnom;

import java.util.Random;

import br.ufrpe.pixengine.components.Collider;
import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.image.Image;

public class Enemy extends GameObject {
	private GameObject target = null;
	private Image imageStain1;
	private Image imageStain2;
	private Image imageStain3;

	public Enemy() {
		reset();
		addComponent(new Collider());
		this.imageStain1 = new Image("/mr.nom/stain1.png");
		this.imageStain2 = new Image("/mr.nom/stain2.png");
		this.imageStain3 = new Image("/mr.nom/stain3.png");
		w = (float) imageStain1.getWidth();
		h = (float) imageStain1.getHeight();
	}

	@Override
	public void update(GameContainer gc, float dt) {
		
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(imageStain1,(int) x, (int) y);
	}

	public void reset(){
		Random r = new Random();
		int randomNum = r.nextInt((300 - 20) + 1) + 20;
		this.x = randomNum;
		randomNum = r.nextInt((460 - 20) + 1) + 20;
		this.y = randomNum;
		this.setDead(false);
	}
	

	@Override
	public void componentEvent(String name, GameObject object) {
		if (name.equalsIgnoreCase("collider")) {
			((Player)object).increaseTailSize();
			this.setDead(true);
			reset();
		}

	}

	@Override
	public void dispose() {

	}

}
