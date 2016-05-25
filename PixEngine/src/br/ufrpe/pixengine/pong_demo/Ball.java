package br.ufrpe.pixengine.pong_demo;

import br.ufrpe.pixengine.components.Collider;
import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import br.ufrpe.pixengine.core.fx.SpriteAnimation;
import javafx.util.Duration;

public class Ball extends GameObject {
    private SpriteAnimation ballAnimatedImg;
    private boolean isRolling = false; 
	boolean left = true;
	float speedY = 0;

	public Ball(int x, int y) {
		setTag("ball");
		this.x = x;
		this.y = y;
		w = 16;
		h = 16;
		this.ballAnimatedImg = new SpriteAnimation("ball_sprite.png", Duration.millis(1000), 9, 2, 0, 0, 64, 64);
		addComponent(new Collider());
	}

	@Override
	public void update(GameContainer gc, float dt) {
//	    if (!isRolling) {
//	        Node n = this.ballAnimatedImg.getImageView();
//          gc.getWindow().addPaintableNodeToCanvas(n);
//          this.ballAnimatedImg.play();
//	        isRolling = true;
//        }
		if (left) {
			x -= dt * 50;
		} else {
			x += dt * 50;
		}

		y += speedY;

		if (y < 0) {
			y = 0;
			speedY *= -1;
		}

		if (y + h > gc.getHeight()) {
			y = gc.getHeight() - h;
			speedY *= -1;
		}

		this.ballAnimatedImg.getImageView().setX(x);
		this.ballAnimatedImg.getImageView().setX(y);
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawFillRect((int) x, (int) y, (int) w, (int) h, 0xff00ff00);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void componentEvent(String name, GameObject object) {
		if (name.equalsIgnoreCase("collider")) {
			if (object.getX() < x) {
				left = false;
			} else {
				left = true;
			}

			speedY = -((object.getY() + (object.getH() / 2)) - (y + (h / 2))) / (object.getH() / 2);
		}
	}

}
